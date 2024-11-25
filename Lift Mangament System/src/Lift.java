import java.util.*;
public class Lift {
    public int floorNo;
    public State liftState;
    public int liftId;
    public List<int[]> servingRequest;

    public Lift(int floorNo, State liftState, int liftId) {
        this.floorNo = floorNo;
        this.liftState = liftState;
        this.liftId = liftId;
        servingRequest = new ArrayList<>();
    }

    public void addServingPassenger(int details[]){
        servingRequest.add(details);
    }
}
