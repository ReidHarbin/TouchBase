import api.touchbase.activity.member.CreateMemberActivity;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.dynamodb.models.Notification;
import api.touchbase.utils.NotificationCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class DeleteMemberNotificationActivityTest {
    @Mock
    private MemberDao memberDao;

    @InjectMocks
    private CreateMemberActivity createMemberActivity;

    Member testMember;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        testMember = new Member();
        testMember.setId("TestId123");
        testMember.setSalt("TestSalt123");
        testMember.setPassword("TestPassword1");
        testMember.setName("Test Name");
        List<Notification> notifications = new ArrayList<>();
        notifications.add(Notification.builder()
                .withId("id")
                .withDate("01/01/2023")
                .withDescription("Description")
                .withSenderName("Sender Name")
                .build());
        testMember.setMemberNotifications(notifications);
    }

    @Test
    public void handleRequest_ValidNotificationId_DeletesRequest() {

    }
}
