package Utils;
import User.User;
import java.util.List;
public class Utils {
    public static boolean checkGroupMemberPresent(List<User> groupMembers, User user){
        for(User member : groupMembers){
            if(member.getUserId() == user.getUserId()) return true;
        }
        return false;
    }
}
