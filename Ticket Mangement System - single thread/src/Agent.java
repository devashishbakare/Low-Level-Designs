import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Agent {
    public String agentId;
    public Set<Integer> expertise;
    public List<Issue> workingIssueList;
    public List<Issue> history;

    public Agent(String agentId, List<Integer> expertise){
        this.agentId = agentId;
        this.expertise = new HashSet<>(expertise);
        workingIssueList = new ArrayList<>();
        history = new ArrayList<>();
    }

}
