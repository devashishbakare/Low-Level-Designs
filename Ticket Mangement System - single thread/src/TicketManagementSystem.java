import java.util.*;
public class TicketManagementSystem {
    private Map<String, Issue> issueIdToIssueMapper;
    private Map<String, Agent> agentIdToAgentMapper;

    private List<String> issueTypes;

    public TicketManagementSystem(){
        issueIdToIssueMapper = new HashMap<>();
        agentIdToAgentMapper = new HashMap<>();
        issueTypes = new ArrayList<>();
    }

    public void init(List<String> issueTypes){
        this.issueTypes = issueTypes;
    }


    public String addAgent(String agentId, List<Integer> expertise){
        if(agentIdToAgentMapper.containsKey(agentId)) return "agent already exists";
        Agent agent = new Agent(agentId, expertise);
        agentIdToAgentMapper.put(agentId, agent);
        return "success";
    }

    public String createIssue(String issueId, String orderId, int issueType, String description){
        if(issueIdToIssueMapper.containsKey(issueId)) return "issue already exist";
        if(issueType >= issueTypes.size()) return "invalid issue type";
        Issue issue = new Issue(issueId, issueType, orderId, description);
        issueIdToIssueMapper.put(issueId, issue);
        issue.setTicketStatus(TicketStatus.OPEN);
        return "issue created";
    }
    public String assignIssue(String issueId, int assignStrategy){

        AssignStrategyFactory assignStrategyFactory = new AssignStrategyFactory();
        AssignStrategy strategy = assignStrategyFactory.getStrategy(assignStrategy);
        if(strategy == null) return "invalid strategy number";

        return strategy.getAgent(new ArrayList<>(agentIdToAgentMapper.values()), issueIdToIssueMapper.get(issueId));
    }

    public void resolveIssue(String issueId, String resolution){
        Issue issue = issueIdToIssueMapper.get(issueId);
        issue.setTicketStatus(TicketStatus.RESOLVED);
        Agent agent = agentIdToAgentMapper.get(issue.getAgentId());
        agent.workingIssueList.remove(issue);
        agent.history.add(issue);
    }

    public List<String> getAgentHistory(String agentId){
        Agent agent = agentIdToAgentMapper.get(agentId);
        List<String> resolvedIssue = new ArrayList<>();
        for(Issue issue : agent.history){
            resolvedIssue.add(issue.issueId);
        }
        return resolvedIssue;
    }


}
