public class AssignStrategyFactory {
    public AssignStrategy getStrategy(int strategyNumber){
        if(strategyNumber == 0){
            return new assignStrategy0();
        }else if(strategyNumber == 1){
            return new assignStrategy1();
        }else if(strategyNumber == 2){
            return new assignStrategy2();
        }else{
            return null;
        }
    }
}
