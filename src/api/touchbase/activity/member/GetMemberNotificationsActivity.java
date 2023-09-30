package api.touchbase.activity.member;

import api.touchbase.dynamodb.models.Notification;
import api.touchbase.converters.ModelConverter;
import api.touchbase.dynamodb.MemberDao;
import api.touchbase.dynamodb.models.Member;
import api.touchbase.models.objects.NotificationModel;
import api.touchbase.models.requests.member.GetMemberNotificationsRequest;
import api.touchbase.models.results.member.GetMemberNotificationsResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GetMemberNotificationsActivity implements RequestHandler<GetMemberNotificationsRequest, GetMemberNotificationsResult> {
    private final MemberDao memberDao;

    @Inject
    public GetMemberNotificationsActivity(MemberDao memberDao) {
        this.memberDao = memberDao;
    }


    @Override
    public GetMemberNotificationsResult handleRequest(final GetMemberNotificationsRequest getMemberNotificationsRequest, Context context) {
        Member member = memberDao.getMember(getMemberNotificationsRequest.getMemberId());

        List<NotificationModel> notificationModels = new ArrayList<>();
        member.getMemberNotifications().forEach(n -> notificationModels.add(ModelConverter.toNotificationModel(n)));

        return GetMemberNotificationsResult.builder()
                .withNotifications(notificationModels)
                .build();
    }
}
