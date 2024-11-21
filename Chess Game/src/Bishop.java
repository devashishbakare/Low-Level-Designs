public class Bishop implements MovingStrategy{
    @Override
    public boolean checkPossibility(int startRow, int startCol, int endRow, int endCol) {

        if(startRow == endRow && endCol == startCol){
            return false;
        }

        BoardTravel boardTravel = new BoardTravel();

        if(endRow < startRow){
            if(endCol < startCol){
                if(boardTravel.checkDiaUpLeft(startRow, startCol, endRow, endCol)) return true;
            }else{
                if(boardTravel.checkDiaUpRight(startRow, startCol, endRow, endCol)) return true;
            }
        }else{
            if(endCol < startCol){
                if(boardTravel.checkDiaDownLeft(startRow, startCol, endRow, endCol)) return true;
            }else{
                if(boardTravel.checkDiaDownRight(startRow, startCol, endRow, endCol)) return true;
            }
        }

        return false;
    }


}
