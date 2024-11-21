public class Pawn implements MovingStrategy{
    @Override
    public boolean checkPossibility(int startRow, int startCol, int endRow, int endCol) {

        if(endRow < 0 || endRow > 7 || endCol < 0 || endCol > 7) return false;

        if(startRow == endRow && endCol == startCol){
            return false;
        }
        // 6 6 5 6
        if(endRow == startRow + 1){
            if(endCol == startCol){
                return true;
            }else if(endCol == startCol+1){
                return true;
            }else if(endCol == startCol-1){
                return true;
            }
        }
        if(endRow == startRow - 1){
            if(endCol == startCol){
                return true;
            }else if(endCol == startCol+1){
                return true;
            }else if(endCol == startCol-1){
                return true;
            }
        }
        return false;
    }


}
