package Split;

import User.User;

public class PercentageSplit extends Split {

    private double percentage;

    public PercentageSplit(User user, double amount, double percentage) {
        super(user, amount, SplitType.PERCENTAGE);
        this.percentage = percentage;
    }

    @Override
    public double getShare() {
        return this.percentage;
    }
}
