import java.util.ArrayList;

public class UsersList {
    private ArrayList<User> userList;

    public UsersList() {
        this.userList = new ArrayList<>();
    }

    public String addUser(String userName){
        User user = new User(userName);
        userList.add(user);
        return user.getUserId();
    }

    public String getUser(String userId){
        for(User u: userList){
            if(u.getUserId().equals(userId)){
                return "Id: " + u.getUserId() + "\n" +
                        "Name: " + u.getUserName() + "\n";
            }
        }
        return null;
    }

    public ArrayList<User> getUserList() {
        ArrayList users = new ArrayList();
        for(User u: userList){
            users.add("User ID: " + u.getUserId() + "\nUser name: " + u.getUserName() + "\n\n");
        }
        return users;
    }
}
