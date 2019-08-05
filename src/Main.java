import com.sun.xml.internal.bind.v2.TODO;

import java.time.*;

public class Main {
    private static String IN_PROGRESS = "In progress";
    private static String TO_DO = "To do";
    private static String DONE = "Solved";
    private static IssuesList issues = new IssuesList();
    private static UsersList users = new UsersList();
    private static String id1;
    private static String id2;
    private static String id3;
    private static String id4;
    private static String user1;
    private static String user2;

    public static void main(String[] args) {

        addIssues();
        addUsers();

        testComment();
        testIssueState();
        testRemoveIssue();

        testGetIssues();
        testGetUsers();




    }

    public static void addIssues(){
        id1 = issues.addIssue("App crashes");
        id2 = issues.addIssue("Phone not working");
        id3 = issues.addIssue("Page not responding");
        id4 = issues.addIssue("Computer broken");

        System.out.println("ADD ISSUES: \n------------------------------------------");
        System.out.println(issues.getIssue(id1) + issues.getIssue(id2) + issues.getIssue(id3));
    }

    public static void addUsers(){
        user1 = users.addUser("Daniel");
        user2 = users.addUser("David");

        System.out.println("USERS: \n------------------------------------------");
        System.out.println("User 1: " + user1 + "\nUser 2: " + user2 +"\n\n");
    }



    public static void testComment(){

        issues.assignUser(id1, user1);
        issues.addIssueComment(id1, "I'm working on a solution");
        issues.addIssueComment(id1, "I'm having problems");

        System.out.println("TEST COMMENT: \n------------------------------------------");
        System.out.println(issues.getIssue(id1));
    }

    public static void testRemoveIssue(){
        issues.removeIssue(id3);
        System.out.println("TEST REMOVE ISSUE: \n------------------------------------------");
        System.out.println(issues.getIssue(id3));
    }

    public static void testIssueState(){
        issues.assignUser(id2, user2);
        issues.setIssueState(id2, IN_PROGRESS, "Starting work");
        issues.setIssueState(id2, DONE, null);
        issues.setIssueState(id2, IN_PROGRESS, "Discovered bugs");
        issues.setIssueState(id2, DONE, null);

        System.out.println("TEST ISSUE STATE: \n------------------------------------------");
        System.out.println(issues.getIssue(id2));

    }

    public static void testGetIssues(){
        issues.setDates(id4, LocalDate.of(2019, 7,5));

        System.out.println("FILTERED ISSUES: \n------------------------------------------");
        System.out.println( issues.getIssues(null, null, null, null));
    }

    public static void testGetUsers(){

        System.out.println("GET USERS: \n------------------------------------------");
        System.out.println(users.getUser(user1));

        System.out.println(users.getUserList());
    }

}
