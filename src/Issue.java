import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.UUID;

public class Issue {
    private String issueID;
    private String issue;
    private LocalDate creationDate;
    private String issueState;
    private ArrayList<String> stateList;
    private ArrayList<String> commentList;
    private String user;


    public Issue(String issue) {
        this.issueID = UUID.randomUUID().toString();
        this.issue = issue;
        this.creationDate = LocalDate.now();
        this.stateList = new ArrayList<>();
        this.commentList = new ArrayList<>();
        this.user = "Not assigned";

        setIssueState("To do", null);

    }

    public String getIssue() {
        return issue;
    }


    public ArrayList<String> getStateList() {
        return stateList;
    }

    public String getIssueID() {
        return issueID;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }


    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }


    public String getIssueState() {
        return issueState;
    }

    public void setIssueState(String issueState, String comment) {
        this.issueState = issueState;

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        if(comment!= null){
            stateList.add("\n" + date.toString() +  " "+ time + ": " + issueState + "\tComment: " + comment);
        }else{
            stateList.add("\n" + date.toString() +  " "+ time + ": " + issueState);
        }

    }

    public ArrayList<String> getCommentList() {
        return commentList;
    }

    public void addComment(String comment){
        commentList.add(comment);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String u) {
        user = u;
    }
}
