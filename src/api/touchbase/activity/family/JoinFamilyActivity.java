package api.touchbase.activity.family;

import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.FamilyDao;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Family;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.InvalidInputException;
import api.touchbase.exceptions.InvalidPasswordException;
import api.touchbase.exceptions.MemberHasFamilyException;
import api.touchbase.models.requests.family.JoinFamilyRequest;
import api.touchbase.models.results.family.JoinFamilyResult;
import api.touchbase.utils.NotificationCreator;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;
import java.util.Map;

public class JoinFamilyActivity implements RequestHandler<JoinFamilyRequest, JoinFamilyResult> {
    private final MemberDao memberDao;
    private final FamilyDao familyDao;
    private NotificationCreator notificationCreator;
    @Inject
    public JoinFamilyActivity(MemberDao memberDao, FamilyDao familyDao) {
        this.memberDao = memberDao;
        this.familyDao = familyDao;
        notificationCreator = new NotificationCreator();
    }

    @Override
    public JoinFamilyResult handleRequest(final JoinFamilyRequest joinFamilyRequest, Context context) {
        String requestMemberId = joinFamilyRequest.getMemberId();
        String requestFamilyName = joinFamilyRequest.getFamilyName();
        String requestAccessCode = joinFamilyRequest.getAccessCode();

        Member member = memberDao.getMember(requestMemberId);

        if (requestAccessCode == null || requestAccessCode.isBlank()) {
            throw new InvalidPasswordException("You must provide a valid password");
        }
        if (requestFamilyName == null || requestFamilyName.isBlank()) {
            throw new InvalidInputException("You must provide a a family name");
        }
        if (member.getFamilyId() != null) {
            throw new MemberHasFamilyException("You must leave your current family before you can join a new one");
        }

        Family family = familyDao.queryFamiliesForJoining(requestFamilyName, requestAccessCode).get(0);

        member.setFamilyId(family.getId());
        memberDao.saveMember(member);

        Map<String, String> memberNamesToIds = family.getNamesToMemberIds();

        memberNamesToIds.keySet().stream().forEach(name -> {
            Member memberToNotify = memberDao.getMember(memberNamesToIds.get(name));

            memberToNotify.getMemberNotifications()
                    .add(0, notificationCreator.newFamilyMemberNotification(member.getName()));

            memberDao.saveMember(memberToNotify);
        });

        memberNamesToIds.put(member.getName(), requestMemberId);
        family.setNamesToMemberIds(memberNamesToIds);

        familyDao.save(family);
        return JoinFamilyResult.builder()
                .withFamilyModel(ModelConverter.toFamilyModel(family))
                .build();
    }
}
