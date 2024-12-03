public class Issue {
    public String issueId;
    public int issueType;
    private String orderId;
    private String description;
    public TicketStatus ticketStatus;
    private String agentId;

    public Issue(String issueId, int issueType, String orderId, String description) {
        this.issueId = issueId;
        this.issueType = issueType;
        this.orderId = orderId;
        this.description = description;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}
