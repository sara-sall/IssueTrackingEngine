import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class IssuesList {
    private ArrayList<Issue> issueList;

    public IssuesList() {
        this.issueList = new ArrayList<>();
    }


    public String addIssue(String issue){
        Issue i = new Issue(issue);

        issueList.add(i);
        return i.getIssueID();
    }

    public void removeIssue(String id){
        issueList.remove(findIssue(id));
    }

    public void setIssueState(String id, String state, String comment){
        findIssue(id).setIssueState(state, comment);
    }

    public void addIssueComment(String id, String comment){
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        findIssue(id).addComment("\nDate: " + date.toString() + " " + time + "\nUser: " + findIssue(id).getUser() + "\nComment: " + comment + "\n");

    }

    private Issue findIssue(String id){
           for(Issue i:issueList){
               if(id.equals(i.getIssueID())){
                   return i;
               }
           }
        return null;
    }

    public String getIssue(String id){
        Issue issue= findIssue(id);
        if (issue == null){
            return "Issue does not exist\n\n";
        }else{
            String issueInfo = "Id: " + issue.getIssueID() + "\n" +
                    "Creation date: " + issue.getCreationDate() + "\n" +
                    "Issue: " + issue.getIssue() + "\n" +
                    "User: " + issue.getUser() + "\n" +
                    "Current state: " + issue.getIssueState() + "\n\n" +
                    "State changes: " + issue.getStateList() + "\n\n" +
                    "Comments: " + issue.getCommentList() + "\n\n";
            return issueInfo;
        }


    }

    private String getIssueDetails(String id){
        Issue i = findIssue(id);
        return "Id: " + i.getIssueID() + "\n" +
                "Creation date: " + i.getCreationDate() + "\n" +
                "Issue: " + i.getIssue() + "\n" +
                "User: " + i.getUser() + "\n" +
                "Current state: " + i.getIssueState() + "\n\n";

    }

    public void assignUser(String id, String userId){
        findIssue(id).setUser(userId);
    }

    private boolean filterUser(Issue i, String user){
        if(i.getUser().equals(user)){
            return true;
        }else{
            return false;
        }
    }

    private boolean filterDate(Issue i, LocalDate startDate, LocalDate endDate){

            if (startDate != null && endDate == null) {
                if (i.getCreationDate().isEqual(startDate) || i.getCreationDate().isAfter(startDate)) {
                    return true;
                }
            } else if (startDate == null && endDate != null) {

                if (i.getCreationDate().isEqual(endDate) || i.getCreationDate().isBefore(endDate)) {
                    return true;
                }
            } else if (startDate != null && endDate != null) {
                if ((i.getCreationDate().isEqual(startDate) || i.getCreationDate().isAfter(startDate)) && (i.getCreationDate().isEqual(endDate) || i.getCreationDate().isBefore(endDate))) {
                    return true;
                }
            }

            return false;

    }

    private boolean filterIssues(Issue i, String user, LocalDate startDate, LocalDate endDate){

        if(user != null && filterUser(i, user)){

            if((startDate != null || endDate !=null) && filterDate(i, startDate, endDate)){
                return true;
            }
            else if(startDate == null && endDate == null){
                return true;
            }
        }else if(user == null){
            if((startDate != null || endDate !=null) && filterDate(i, startDate, endDate)){
                return true;
            }else if(startDate == null && endDate == null){
                return true;
            }
        }
        return false;
    }

    public ArrayList getIssues(String state, String user, LocalDate startDate, LocalDate endDate){
        ArrayList<Issue> issues = new ArrayList();

        ArrayList filteredIssues = new ArrayList();

        for(Issue i:issueList){
            if(i.getIssueState().equals(state)){
                issues.add(i);
            }
        }

        if(!issues.isEmpty()){
            for(Issue i:issues){
                if(filterIssues(i, user, startDate, endDate)){
                    filteredIssues.add(getIssueDetails(i.getIssueID()));
                }
            }
        }else{
            for(Issue i:issueList){
                if(filterIssues(i, user, startDate, endDate)){
                    filteredIssues.add(getIssueDetails(i.getIssueID()));
                }
            }
        }


        return filteredIssues;
    }

    public void setDates(String id, LocalDate startDate){
        findIssue(id).setCreationDate(startDate);
    }
}
