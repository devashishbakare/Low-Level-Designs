public class Knight implements MovingStrategy{
    @Override
    public boolean checkPossibility(int startRow, int startCol, int endRow, int endCol) {

        if(endRow < 0 || endRow > 7 || endCol < 0 || endCol > 7) return false;

        if(startRow == endRow && endCol == startCol){
            return false;
        }
        int rowDiff = Math.abs(startRow - endRow);
        int colDiff = Math.abs(startCol - endCol);
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);

    }

}
