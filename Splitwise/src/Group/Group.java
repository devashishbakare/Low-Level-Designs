package Group;

import Expense.Expense;
import User.User;
import Utils.Utils;
import java.util.*;
public class Group {
    private String groupName;
    private String groupId;
    private String description;
    private List<User> groupMembers;
    private List<Expense> history;

    private User createdBy;

    public Group(String groupName, String groupId, String description, User createdBy) {
        this.groupName = groupName;
        this.groupId = groupId;
        this.description = description;
        this.createdBy = createdBy;
        this.groupMembers = new ArrayList<>();
        this.history = new ArrayList<>();
        addToGroupMembers(createdBy);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String addToGroupMembers(User user){
        if(!Utils.checkGroupMemberPresent(this.groupMembers, user)){
            groupMembers.add(user);
            return  user.getName() + " User Has Been Added As Member";
        }
        //throw exception here
        return "User already exist";
    }

    public String removeMemberFromGroup(User user){
        if(Utils.checkGroupMemberPresent(this.groupMembers, user)){
            this.groupMembers.remove(user);
            return user.getName() + " is Removed from Group.Group";
        }
        //return exception here : user does not exist in a group
        return "User already exist";
    }

    @Override
    public String toString() {
        return "Group.Group{" +
                "groupName='" + groupName + '\'' +
                ", groupId='" + groupId + '\'' +
                ", description='" + description + '\'' +
                ", groupMembers=" + groupMembers +
                ", history=" + history +
                '}';
    }

    public void addExpenses(Expense expense){
        this.history.add(expense);
    }

    public void showHistory(){
        for(Expense expense : this.history){
            expense.toString();
        }
    }

}
