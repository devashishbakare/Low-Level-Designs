import java.util.*;
public class Building {
    public int noOfFloors;
    public int noOfLifts;
    public Map<Integer, Lift> liftIdToLiftMapper;
    void init(int noOfFloor, int noOfLifts){
        liftIdToLiftMapper = new HashMap();
        this.noOfFloors = noOfFloor;
        this.noOfLifts = noOfLifts;
        for(int liftNo = 0; liftNo < noOfLifts; liftNo++){
            State liftState = new Ideal();
            liftState.setState("ideal");
            Lift lift = new Lift(0, liftState, liftNo);
            liftIdToLiftMapper.put(liftNo, lift);
        }
    }
    public int requestLift(int startFloor, int destinationFloor){

        if(startFloor == destinationFloor) return -1;

        int minDiff = Integer.MAX_VALUE;
        int minLiftId = Integer.MAX_VALUE;


        //lift coming down -> startFloor <= floorNo;
        //lift going up -> startFloor >= floorNo;
        //lift is ideal state now -> you can assign directly

        int diff = destinationFloor-startFloor;
        String direction = (diff > 0 ? "up" : "down");
        for(int liftId : liftIdToLiftMapper.keySet()){
            Lift lift = liftIdToLiftMapper.get(liftId);
            if(lift.liftState.getState().equals("ideal")){
                minLiftId = lift.liftId;
                break;
            }else if(direction.equals("up") && lift.liftState.getState().equals("up") && lift.servingRequest.size() < 10){
                if(lift.floorNo > startFloor) continue;
                int distanceBetweenFloorAndLift = startFloor-lift.floorNo;
                if(distanceBetweenFloorAndLift < minDiff){
                    minDiff = distanceBetweenFloorAndLift;
                    minLiftId = lift.liftId;
                }else{
                    minLiftId = Math.min(minLiftId, lift.liftId);
                }

            }else if(direction.equals("down") && lift.liftState.getState().equals("down") && lift.servingRequest.size() < 10){
                if(startFloor > lift.floorNo){
                    continue;
                }
                int distanceBetweenFloorAndLift = lift.floorNo-startFloor;
                if(distanceBetweenFloorAndLift < minDiff){
                    minDiff = distanceBetweenFloorAndLift;
                    minLiftId = lift.liftId;
                }else{
                    minLiftId = Math.min(minLiftId, lift.liftId);
                }
            }
        }

        if(minLiftId == Integer.MAX_VALUE){
            return -1;
        }

        Lift lift = liftIdToLiftMapper.get(minLiftId);
        lift.addServingPassenger(new int[]{startFloor, destinationFloor});
        return lift.liftId;
    }
    public void tick(){

        for(int liftId : liftIdToLiftMapper.keySet()){

            Lift lift = liftIdToLiftMapper.get(liftId);
            if(lift.liftState.getState().equals("ideal") && lift.servingRequest.size() != 0){
                State up = new Up();
                up.setState("up");
                lift.liftState = up;
                lift.floorNo += 1;
            }else if(lift.liftState.getState().equals("ideal") && lift.servingRequest.size() == 0){
                continue;
            }
            else if(lift.liftState.getState().equals("up")){
                lift.floorNo = lift.floorNo + 1;
                if(lift.floorNo == noOfFloors){
                    State down = new Down();
                    down.setState("down");
                    lift.liftState = down;
                }else if(lift.floorNo == 0){
                    State up = new Up();
                    up.setState("up");
                    lift.liftState = up;
                }
            }else{
                lift.floorNo = lift.floorNo - 1;
                if(lift.floorNo == noOfFloors){
                    State down = new Down();
                    down.setState("down");
                    lift.liftState = down;
                }else if(lift.floorNo == 0){
                    State up = new Up();
                    up.setState("up");
                    lift.liftState = up;
                }
            }
            List<int[]> newDestinations = new ArrayList<>();
            for(int[] destination : lift.servingRequest){
                int destinationFloor = destination[1];
                if(destinationFloor != lift.floorNo){
                    newDestinations.add(destination);
                }
            }
            lift.servingRequest = newDestinations;
        }
    }

    public String[] getLiftStates() {
        String liftStatus[] = new String[noOfLifts];
        for(int liftId : liftIdToLiftMapper.keySet()){
            String liftDirection = liftIdToLiftMapper.get(liftId).liftState.getState();
            char direction = 'I';
            if(liftDirection.charAt(0) == 'u'){
                direction = 'U';
            }else{
                direction = 'D';
            }
            liftStatus[liftId] = liftId + "-" + direction;
        }
        return liftStatus;
    }

    public int getNumberOfPeopleOnLift(int liftId){
        return liftIdToLiftMapper.get(liftId).servingRequest.size();
    }

    public List<Integer> getLiftsStoppingOnFloor(int floor, char moveDirection){

        List<Integer> listOfLiftId = new ArrayList<>();
        String direction = moveDirection == 'U' ? "up" : (moveDirection == 'D' ? "down" : "ideal");
        for(int liftId : liftIdToLiftMapper.keySet()){
            Lift lift = liftIdToLiftMapper.get(liftId);
            if(lift.liftState.equals(direction) && lift.floorNo == floor){
                listOfLiftId.add(liftId);
            }
        }
        return listOfLiftId;
    }
    public void printMap(){
        for(int liftId : liftIdToLiftMapper.keySet()){
            Lift lift = liftIdToLiftMapper.get(liftId);
            String str =  "liftId " + liftId + " lift state " +  lift.liftState.getState() + " floor No: " + lift.floorNo + " --";
            System.out.println(str);
            for(int[] temp : lift.servingRequest){
                System.out.println("[ " + temp[0] + " , " +temp[1] + " ]");
            }
        }
    }
}
