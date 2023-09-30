import api.touchbase.activity.member.CreateMemberActivity;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.InvalidInputException;
import api.touchbase.exceptions.UsernameTakenException;
import api.touchbase.models.requests.member.CreateMemberRequest;
import api.touchbase.models.results.member.CreateMemberResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.*;

public class CreateMemberActivityTest {

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

    }
    @Test
    public void handleRequest_validRequest_createsMember() {
        // GIVEN
        CreateMemberRequest request = new CreateMemberRequest().builder()
                .withName("Test Name")
                .withMemberPassword("TestPassword1")
                .build();

        when(memberDao.saveMember(any())).thenReturn(testMember);

        try {
            // WHEN
            CreateMemberResult result = createMemberActivity.handleRequest(request, null);

            // THEN
            verify(memberDao, atMostOnce()).saveMember(any());
            assertEquals("Expected response to contain a welcome notification", result.getMember().getNotifications().size(), 1);
        } catch (Exception e) {
            fail("Valid input should not throw any exception");
        }
    }
    @Test
    public void handleRequest_preexistingUsername_ThrowsUsernameTakenException() {
        // GIVEN
        CreateMemberRequest request = new CreateMemberRequest().builder()
                .withName("Test Name")
                .withMemberPassword("TestPassword1")
                .build();
        when(memberDao.usernameExists(any())).thenReturn(true);

        // WHEN + THEN
        assertThrows(UsernameTakenException.class, () -> {
            createMemberActivity.handleRequest(request, null);
        });
        verify(memberDao).usernameExists(any());
    }
    @Test
    public void handleRequest_invalidName_throwsInvalidInputException() {
        // GIVEN
        CreateMemberRequest requestWithBlankName = new CreateMemberRequest().builder()
                .withName("")
                .withMemberPassword("TestPassword1")
                .build();
        CreateMemberRequest requestWithNullName = new CreateMemberRequest().builder()
                .withName(null)
                .withMemberPassword("TestPassword1")
                .build();

        // WHEN + THEN
        assertThrows(InvalidInputException.class, () -> {
            createMemberActivity.handleRequest(requestWithBlankName, null);
        });
        assertThrows(InvalidInputException.class, () -> {
            createMemberActivity.handleRequest(requestWithNullName, null);
        });
    }
//    @Test
//    public void handleRequest_invalidPassword_throwsInvalidPasswordException() {
//        // GIVEN
//        CreateMemberRequest requestWithSpacesInPassword = new CreateMemberRequest().builder()
//                .withName("Test Name")
//                .withMemberPassword("Test Password1")
//                .build();
//        CreateMemberRequest requestWithNoNumberInPassword = new CreateMemberRequest().builder()
//                .withName("Test Name")
//                .withMemberPassword("TestPassword")
//                .build();
//        CreateMemberRequest requestWithNoCapitalLettersInPassword = new CreateMemberRequest().builder()
//                .withName("Test Name")
//                .withMemberPassword("testpassword1")
//                .build();
//        CreateMemberRequest requestWithPasswordThatIsTooShort = new CreateMemberRequest().builder()
//                .withName("Test Name")
//                .withMemberPassword("Pas1")
//                .build();
//
//        // WHEN + THEN
//        assertThrows(InvalidInputException.class, () -> {
//            createMemberActivity.handleRequest(requestWithSpacesInPassword, null);
//        });
//        assertThrows(InvalidInputException.class, () -> {
//            createMemberActivity.handleRequest(requestWithNoCapitalLettersInPassword, null);
//        });
//        assertThrows(InvalidInputException.class, () -> {
//            createMemberActivity.handleRequest(requestWithNoNumberInPassword, null);
//        });
//        assertThrows(InvalidInputException.class, () -> {
//            createMemberActivity.handleRequest(requestWithPasswordThatIsTooShort, null);
//        });
//    }

}
