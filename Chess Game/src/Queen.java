public class Queen implements MovingStrategy{

    @Override
    public boolean checkPossibility(int startRow, int startCol, int endRow, int endCol) {

        if(endRow < 0 || endRow > 7 || endCol < 0 || endCol > 7) return false;

        if(startRow == endRow && endCol == startCol){
            return false;
        }

        BoardTravel boardTravel = new BoardTravel();

        if(startRow == endRow){
            if(endCol < startCol){
                if(boardTravel.checkLeft(startRow, startCol, endRow, endCol)) return true;
            }else{
                if(boardTravel.checkRight(startRow, startCol, endRow, endCol)) return true;
            }
        }else if(endRow < startRow){
            if(endCol < startCol){
                if(boardTravel.checkDiaUpLeft(startRow, startCol, endRow, endCol)) return true;
            }else{
                if(boardTravel.checkDiaUpRight(startRow, startCol, endRow, endCol)) return true;
            }
        }else if(endRow > startRow){
            if(endCol < startCol){
                if(boardTravel.checkDiaDownLeft(startRow, startCol, endRow, endCol)) return true;
            }else{
                if(boardTravel.checkDiaDownRight(startRow, startCol, endRow, endCol)) return true;
            }
        }else{
            if(endRow < startRow){
                if(boardTravel.checkUp(startRow, startCol, endRow, endCol)) return true;
            }else{
                if(boardTravel.checkDown(startRow, startCol, endRow, endCol)) return true;
            }
        }
        return false;
    }


}
