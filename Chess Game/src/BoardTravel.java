public class BoardTravel {
    String chessBoard[][] = ChessBoard.getChessBoard();
    public boolean checkDiaUpLeft(int startRow, int startCol, int endRow, int endCol){
        while(startRow > 0 && startCol > 0){
            startRow--;
            startCol--;
            if(startRow == endRow && endCol == startCol){
                return true;
            }
            if(chessBoard[startRow][startCol] != ""){
                return false;
            }

        }
        return false;
    }

    public boolean checkDiaUpRight(int startRow, int startCol, int endRow, int endCol){
        while(startRow > 0 && startCol < 7){
            startRow--;
            startCol++;
            if(startRow == endRow && endCol == startCol){
                return true;
            }
            if(chessBoard[startRow][startCol] != ""){
                return false;
            }
        }
        return false;
    }

    public boolean checkDiaDownRight(int startRow, int startCol, int endRow, int endCol){
        while(startRow < 7 && startCol < 7){
            startRow++;
            startCol++;
            if(startRow == endRow && endCol == startCol){
                return true;
            }
            if(chessBoard[startRow][startCol] != ""){
                return false;
            }
        }
        return false;
    }

    public boolean checkDiaDownLeft(int startRow, int startCol, int endRow, int endCol){
        while(startRow < 7 && startCol > 0){
            startRow++;
            startCol--;
            if(startRow == endRow && endCol == startCol){
                return true;
            }
            if(chessBoard[startRow][startCol] != ""){
                return false;
            }
        }
        return false;
    }
    public boolean checkLeft(int startRow, int startCol, int endRow, int endCol){
        while(startCol > 0){
            startCol--;
            if(startRow == endRow && endCol == startCol){
                return true;
            }
            if(chessBoard[startRow][startCol] != ""){
                return false;
            }
        }
        return false;
    }
    public boolean checkRight(int startRow, int startCol, int endRow, int endCol){
        while(startCol < 7){
            startCol++;
            if(startRow == endRow && endCol == startCol){
                return true;
            }
            if(chessBoard[startRow][startCol] != ""){
                return false;
            }
        }
        return false;
    }

    public boolean checkUp(int startRow, int startCol, int endRow, int endCol){
        while(startRow > 0){
            startRow--;
            if(startRow == endRow && endCol == startCol){
                return true;
            }
            if(chessBoard[startRow][startCol] != ""){
                return false;
            }
        }
        return false;
    }

    public boolean checkDown(int startRow, int startCol, int endRow, int endCol){
        while(startRow < 7){
            startRow++;
            if(startRow == endRow && endCol == startCol){
                return true;
            }
            if(chessBoard[startRow][startCol] != ""){
                return false;
            }
        }
        return false;
    }

    public boolean checkEndCellForSamePiece(int startRow, int startCol, int endRow, int endCol){

        String startCellPiece = chessBoard[startRow][startCol];
        String endCellPiece = chessBoard[endRow][endCol];

        if(startCellPiece.startsWith("B") && endCellPiece.startsWith("B")) return true;
        if(startCellPiece.startsWith("W") && endCellPiece.startsWith("W")) return true;

        return false;
    }

    public void commitMove(int startRow, int startCol, int endRow, int endCol){

        if(chessBoard[endRow][endCol] == "WK"){
            ChessGameExecuter.winnerUpdate[0] = "Killed";
            ChessGameExecuter.winnerUpdate[1] = "Black";
        }
        if(chessBoard[endRow][endCol] == "BK"){
            ChessGameExecuter.winnerUpdate[0] = "Killed";
            ChessGameExecuter.winnerUpdate[1] = "White";
        }
        chessBoard[endRow][endCol] = chessBoard[startRow][startCol];
        chessBoard[startRow][startCol] = "";
    }
}
