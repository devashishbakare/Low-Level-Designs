public class King implements MovingStrategy{
    @Override
    public boolean checkPossibility(int startRow, int startCol, int endRow, int endCol) {

        if(endRow < 0 || endRow > 7 || endCol < 0 || endCol > 7) return false;

        if(startRow == endRow && endCol == startCol){
            return false;
        }

        BoardTravel boardTravel = new BoardTravel();

        //checking left
        if(startRow == endRow && boardTravel.checkLeft(startRow, startCol, startRow, startCol-1)) return true;
        //if(startRow == endRow && --startCol == endCol) return true;

        //checking right
        if(startRow == endRow && boardTravel.checkRight(startRow, startCol, startRow, startCol+1)) return true;
        //if(startRow == endRow && ++startCol == endCol) return true;

        //checking diaDown left
        if(startRow+1 == endRow && boardTravel.checkDiaDownLeft(startRow, startCol, startRow+1, startCol-1)) return true;
        //if(startRow+1 == endRow && startCol-1 == endCol) return true;

        //checking diaDown right
        if(startRow+1 == endRow && boardTravel.checkDiaDownRight(startRow, startCol, startRow+1, startCol+1)) return true;
        //if(startRow+1 == endRow && startCol+1 == endCol) return true;

        //checking diaUp left
        if(startRow-1 == endRow && boardTravel.checkDiaUpLeft(startRow, startCol, startRow-1, startCol-1)) return true;
        //if(startRow-1 == endRow && startCol-1 == endCol) return true;

        //checking diaUp right
        if(startRow-1 == endRow && boardTravel.checkDiaUpRight(startRow, startCol, startRow-1, startCol+1)) return true;
        //if(startRow-1 == endRow && startCol+1 == endCol) return true;

        return false;
    }


}
