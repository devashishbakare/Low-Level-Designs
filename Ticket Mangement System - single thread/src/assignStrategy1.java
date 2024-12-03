import java.util.List;

public class assignStrategy1 implements AssignStrategy{

    @Override
    public String getAgent(List<Agent> agents, Issue issue) {
        int maxResolvedCount = -1;
        Agent storeAgent = null;
        boolean resolvedIssueHistoryExist = false;
        for(Agent agent : agents){
            if(agent.expertise.contains(issue.issueType)){
                List<Issue> agentResolvedHistory = agent.history;
                int countResolvedWithIssueType = 0;

                for(Issue resolvedIssue : agentResolvedHistory){
                    if(resolvedIssue.issueType == issue.issueType){
                        countResolvedWithIssueType++;
                    }
                }
                if(maxResolvedCount < countResolvedWithIssueType){
                    maxResolvedCount = countResolvedWithIssueType;
                    storeAgent = agent;
                }
            }
        }
        if(storeAgent == null){
            return "agent with expertise doesn't exist";
        }
        storeAgent.workingIssueList.add(issue);
        issue.setAgentId(storeAgent.agentId);
        return storeAgent.agentId;
    }
}
