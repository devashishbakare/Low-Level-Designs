package Group;
import User.User;
import Exception.GroupNotFound;
import java.util.*;
public class GroupService {
    private final Map<String, Group> groupIdToGroupMapper = new HashMap<>();
    private static GroupService groupService = null;

    private GroupService(){}

    public static GroupService getInstance(){
        if(groupService == null){
            groupService = new GroupService();
        }
        return groupService;
    }

    public Group createGroup(String groupName, String groupId, String description, User createdBy){
        if(groupIdToGroupMapper.containsKey(groupId)) return null;
        Group group = new Group(groupName, groupId, description, createdBy);
        groupIdToGroupMapper.put(groupId, group);
        return group;
    }

    public String addMemberToGroup(String groupId, User user) throws GroupNotFound {
        if(groupIdToGroupMapper.containsKey(groupId) == false){
           throw new GroupNotFound("Group Not Found");
        }
        Group group = groupIdToGroupMapper.get(groupId);
        return group.addToGroupMembers(user);
    }

    public String removeMemberFromGroup(String groupId, User user) throws GroupNotFound{
        if(groupIdToGroupMapper.containsKey(groupId) == false){
            //add exception here
            throw new GroupNotFound("Group Not Found");
        }
        Group group = groupIdToGroupMapper.get(groupId);
        return group.removeMemberFromGroup(user);
    }

}
