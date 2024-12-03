import java.util.List;

public class assignStrategy0 implements AssignStrategy{
    @Override
    public String getAgent(List<Agent> agents, Issue issue) {
        int minOpenCount = Integer.MAX_VALUE;
        Agent storeAgent = null;
        for(Agent agent : agents){
            if(agent.expertise.contains(issue.issueType)){
                if(agent.workingIssueList.size() < minOpenCount){
                    minOpenCount = agent.workingIssueList.size();
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


