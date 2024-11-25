
public class Ideal implements State{
    public String liftState;
    @Override
    public void setState(String liftState) {
        this.liftState = liftState;
    }

    @Override
    public String getState() {
        return liftState;
    }
}
