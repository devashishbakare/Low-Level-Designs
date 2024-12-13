package Split;

import Split.Split;
import User.User;

public class ExactSplit extends Split {

    public ExactSplit(User user, double amount) {
        super(user, amount, SplitType.EXACT);
    }

    @Override
    public double getShare() {
        return getAmount();
    }
}
