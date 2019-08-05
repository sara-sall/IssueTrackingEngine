import java.util.ArrayList;
import java.util.UUID;

public class User {

    private String userId;
    private String userName;

    public User(String userName) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
