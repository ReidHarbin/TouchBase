package api.touchbase.dynamodb;

import api.touchbase.dynamodb.models.Member;
import api.touchbase.exceptions.MemberNotFoundException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
    private final DynamoDBMapper mapper;

    @Inject
    public MemberDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public Member getMember(String id) {
        Member member = this.mapper.load(Member.class, id);
        if (member == null) {
            throw new MemberNotFoundException(String.format("Could not find member for id { %s }", id));
        }
        return member;
    }

    public Member saveMember(Member member) {
        mapper.save(member);
        return member;
    }

    public void deleteMember(Member memberToDelete) {
        mapper.delete(memberToDelete);
    }

    public PaginatedQueryList<Member> queryMemberNames(String name) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":name", new AttributeValue().withS(name));
        DynamoDBQueryExpression<Member> queryExpression = new DynamoDBQueryExpression<Member>()
                .withIndexName("MemberNameIndex")
                .withConsistentRead(false)
                .withKeyConditionExpression("name = :name")
                .withExpressionAttributeValues(valueMap);

        PaginatedQueryList<Member> memberPaginatedQueryList = mapper.query(Member.class, queryExpression);
        if (memberPaginatedQueryList == null || memberPaginatedQueryList.isEmpty()) {
            throw new MemberNotFoundException(String.format("Could not find account with username %s", name));
        }

        return memberPaginatedQueryList;
    }

    public boolean usernameExists(String name) {
        try {
            this.queryMemberNames(name);
            return true;
        } catch (MemberNotFoundException e) {
            return false;
        }
    }

}
