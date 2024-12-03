import java.util.List;

public class assignStrategy2 implements AssignStrategy{
    @Override
    public String getAgent(List<Agent> agents, Issue issue) {
        int minOpenWorkingIssueCount = Integer.MAX_VALUE;
        Agent storeAgent = null;
        for(Agent agent : agents){
            if(agent.expertise.contains(issue.issueType)){

                List<Issue> agentOpenIssue = agent.workingIssueList;
                int count = 0;
                for(Issue workingIssue : agentOpenIssue){
                    if(workingIssue.issueType == issue.issueType){
                        count++;
                    }
                }
                if(count < minOpenWorkingIssueCount){
                    minOpenWorkingIssueCount = count;
                    storeAgent = agent;
                }
            }
        }

        if(storeAgent == null) return "agent with expertise doesn't exist";

        storeAgent.workingIssueList.add(issue);
        issue.setAgentId(storeAgent.agentId);

        return storeAgent.agentId;

    }
}