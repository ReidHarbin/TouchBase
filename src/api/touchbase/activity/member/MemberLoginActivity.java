package api.touchbase.activity.member;

import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.InvalidInputException;
import api.touchbase.exceptions.InvalidPasswordException;
import api.touchbase.models.requests.member.MemberLoginRequest;
import api.touchbase.models.results.member.MemberLoginResult;
import api.touchbase.utils.TouchBasePasswordAuthentication;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;

public class MemberLoginActivity implements RequestHandler<MemberLoginRequest, MemberLoginResult> {
    private final MemberDao memberDao;

    @Inject
    public MemberLoginActivity(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public MemberLoginResult handleRequest(final MemberLoginRequest memberLoginRequest, Context context) {
        String providedName = memberLoginRequest.getMemberName();
        String providedPassword = memberLoginRequest.getMemberPassword();

        if (providedName == null || providedName.isBlank()) {
            throw new InvalidInputException("You must provide a username");
        }
        if (providedPassword == null || providedPassword.isBlank()) {
            throw new InvalidInputException("You must provide a password");
        }

        Member member = memberDao.queryMemberNames(providedName).get(0);
        if (!TouchBasePasswordAuthentication.isMatchingPassword(member.getSalt(),
                providedPassword, member.getPassword())) {
            throw new InvalidPasswordException("Incorrect password");
        }

        return  MemberLoginResult.builder()
                .withMemberId(member.getId())
                .withMemberFamilyId(member.getFamilyId())
                .build();
    }
}
