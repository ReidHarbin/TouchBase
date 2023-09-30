import api.touchbase.activity.member.GetMemberActivity;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.models.requests.member.GetMemberRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class GetMemberActivityTest {
    @Mock
    private MemberDao memberDao;

    @InjectMocks
    private GetMemberActivity getMemberActivity;

    Member testMember;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        testMember = new Member();
        testMember.setId("TestId123");
        testMember.setSalt("TestSalt123");
        testMember.setPassword("TestPassword1");
        testMember.setName("Test Name");
        testMember.setMemberNotifications(new ArrayList<>());

    }

    @Test
    public void handleRequest_request_MakesCallToDatabase() {
        GetMemberRequest request = new GetMemberRequest().builder()
                .withMemberId("TestId")
                .build();
        when(memberDao.getMember(any())).thenReturn(testMember);

        getMemberActivity.handleRequest(request, null);
        verify(memberDao).getMember(any());
    }
}
