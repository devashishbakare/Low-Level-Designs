package User;
import User.User;
import java.util.*;
import Exception.UserNotFound;
public class UserService {
    private final Map<String, User> userIdToUserMapper = new HashMap<>();
    private static UserService userService = null;

    private UserService(){}
    public static UserService getInstance(){
        if(userService == null){
            userService = new UserService();
        }
        return userService;
    }

    public User createUser(String userId, String userName){
        if(userIdToUserMapper.containsKey(userId)) return null;
        User user = new User(userName, userId);
        userIdToUserMapper.put(userId, user);
        return user;
    }

    public String deleteUser(String userId) throws UserNotFound {
        if(userIdToUserMapper.containsKey(userId) == false) throw new UserNotFound("User Not Found");
        userIdToUserMapper.remove(userId);
        return "User has been deleted successfully";
    }

    public String showUserInfo(User user) throws UserNotFound{
        if(userIdToUserMapper.containsKey(user) == false) throw new UserNotFound("User Not Found");
        return user.toString();
    }

    public void showUserExpenseHistory(User user){
        if(userIdToUserMapper.containsKey(user) == false) return;
        //throw exception here
        user.getExpenseList();
    }

    public void addBalance(User user, double amount){

    }

}
