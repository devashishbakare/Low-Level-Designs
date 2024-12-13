package Split;

import Split.Split;
import User.User;

public class EqualSplit extends Split {

    public EqualSplit(User user, double amount) {
        super(user, amount, SplitType.EQUAL);
    }

    @Override
    public double getShare() {
       return getAmount();
    }
}

