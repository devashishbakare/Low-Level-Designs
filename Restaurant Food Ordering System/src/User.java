import java.util.*;
public class User {
    private String userId;
    private String name;
    private String address;
    private List<Integer> orders;

    public User(String userId) {
        this.userId = userId;
        orders = new ArrayList<>();
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
