public class ChessBoard {
    private static String chessBoard[][];
    public static void setChessBoard(String[][] chessBoard){
        if(ChessBoard.chessBoard == null){
            ChessBoard.chessBoard = chessBoard;
        }
    }
    public static String[][] getChessBoard(){
        return chessBoard;
    }
}
