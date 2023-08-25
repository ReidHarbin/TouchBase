package api.touchbase.activity.member;

import api.touchbase.dynamodb.models.Notification;import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.InvalidInputException;
import api.touchbase.exceptions.InvalidPasswordException;
import api.touchbase.exceptions.UsernameTakenException;
import api.touchbase.models.objects.MemberModel;
import api.touchbase.models.requests.member.CreateMemberRequest;
import api.touchbase.models.results.member.CreateMemberResult;
import api.touchbase.utils.TouchBaseIdGenerator;
import api.touchbase.utils.InputStringValidator;
import api.touchbase.utils.NotificationCreator;
import api.touchbase.utils.TouchBasePasswordAuthentication;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the CreateMemberActivity for the TouchBase API
 *
 * This API allows the user to create their Member profile
 */
public class CreateMemberActivity implements RequestHandler<CreateMemberRequest, CreateMemberResult> {
    private final Logger log = LogManager.getLogger();
    private final MemberDao memberDao;
    private NotificationCreator notificationCreator;

    @Inject
    public CreateMemberActivity(MemberDao memberDao) {
        this.memberDao = memberDao;
        this.notificationCreator = new NotificationCreator();
    }

    /**
     * This method handles the incoming request by persisting a new member with the
     * provided member name, password,and birthday from the request
     * <p>
     * It then returns the new user
     * <p>
     *
     * If the provided name or password contain invalid characters, throws an InvalidAttributeException
     *
     * @param createMemberRequest Request object containing the member's name, password, and birthday associated
     *                            with it.
     * @return createMemberResult result object containing the API defined {@link MemberModel}
     */
    @Override
    public CreateMemberResult handleRequest(final CreateMemberRequest createMemberRequest, Context context) {

        log.info("Received CreateMemberRequest {}", createMemberRequest);
        String password = createMemberRequest.getPassword();
        String name = createMemberRequest.getName();

        if (name == null || name.isBlank()) {
            throw new InvalidInputException("You must provide a username");
        }
        if (password == null || password.isBlank()) {
            throw new InvalidInputException("You must provide a password");
        }
        if (!InputStringValidator.isValidPassword(password)) {
            throw new InvalidPasswordException(
                    String.format("The password provided {%s} did not follow the required format", password));
        }
        if (memberDao.usernameExists(name)) {
            throw new UsernameTakenException("Username is tak");
        }

        List<Notification> notifications = new ArrayList<>();
        notifications.add(notificationCreator.touchbaseNewMemberNotification());

        Member memberToCreate = new Member();
        memberToCreate.setId(TouchBaseIdGenerator.generateId());
        memberToCreate.setName(name);
        memberToCreate.setSalt(TouchBasePasswordAuthentication.getRandomSalt());
        memberToCreate.setPassword(TouchBasePasswordAuthentication.hashPassword(memberToCreate.getSalt()).concat(password));
        memberToCreate.setMemberNotifications(notifications);

        memberDao.saveMember(memberToCreate);

        return CreateMemberResult.builder()
                .withMember(ModelConverter.toMemberModel(memberToCreate))
                .build();

    }
}
