public class ChessGameExecuter {
    private String playerTurn;
    public static String[] winnerUpdate;

    public ChessGameExecuter(){
        this.playerTurn = "White";
        //Oth Represent is King Killed
        //1st Represent who is winner
        this.winnerUpdate = new String[]{"No-One", "No-One"};
    }

    public String move(int startRow, int startCol, int endRow, int endCol){

        String chessBoard[][] = ChessBoard.getChessBoard();
        BoardTravel boardTravel = new BoardTravel();
        if(boardTravel.checkEndCellForSamePiece(startRow, startCol, endRow, endCol)) return "invalid";

        String piece = chessBoard[startRow][startCol];
        System.out.println(piece + " -> " + chessBoard[endRow][endCol]);

        if(piece.equals("WR") || piece.equals("BR")){
            System.out.println("Rook");
            MovingStrategy rook = new Rook();
            if(rook.checkPossibility(startRow, startCol, endRow, endCol)){
                boardTravel.commitMove(startRow, startCol, endRow, endCol);
                playerTurn = (playerTurn == "White" ? "Black" : "White");
                return "";
            }
        }

        if(piece.equals("WH") || piece.equals("BH")){
            System.out.println("Knight");
            MovingStrategy knight = new Knight();
            if(knight.checkPossibility(startRow, startCol, endRow, endCol)){
                boardTravel.commitMove(startRow, startCol, endRow, endCol);
                playerTurn = (playerTurn == "White" ? "Black" : "White");
                return "";
            }
        }

        if(piece.equals("WB") || piece.equals("BB")){
            System.out.println("Bishop");
            MovingStrategy bishop = new Bishop();
            if(bishop.checkPossibility(startRow, startCol, endRow, endCol)){
                boardTravel.commitMove(startRow, startCol, endRow, endCol);
                playerTurn = (playerTurn == "White" ? "Black" : "White");
                return "";
            }
        }

        if(piece.equals("WQ") || piece.equals("BQ")){
            System.out.println("Queen");
            MovingStrategy queen = new Queen();
            if(queen.checkPossibility(startRow, startCol, endRow, endCol)){
                boardTravel.commitMove(startRow, startCol, endRow, endCol);
                playerTurn = (playerTurn == "White" ? "Black" : "White");
                return "";
            }
        }

        if(piece.equals("WK") || piece.equals("BK")){
            System.out.println("King");
            MovingStrategy king = new King();
            if(king.checkPossibility(startRow, startCol, endRow, endCol)){
                boardTravel.commitMove(startRow, startCol, endRow, endCol);
                playerTurn = (playerTurn == "White" ? "Black" : "White");
                return "";
            }
        }
        if(piece.equals("WP") || piece.equals("BP")){
            System.out.println("Pawn");
            MovingStrategy pawn = new Pawn();
            if(pawn.checkPossibility(startRow, startCol, endRow, endCol)){
                boardTravel.commitMove(startRow, startCol, endRow, endCol);
                playerTurn = (playerTurn == "White" ? "Black" : "White");
                return "";
            }
        }

        System.out.println("Returning Invalid");
        return "invalid";
    }

    public int getGameStatus(){
        if(winnerUpdate[0].equals("No-One")) return 0;
        else if(winnerUpdate[1].equals("White")) return 1;
        else return 2;
    }

    public int getNextTurn(){
        System.out.println(winnerUpdate[0] + " -- " + winnerUpdate[1]);
        if(winnerUpdate[0].equals("Killed")) return -1;
        else if(playerTurn == "Black") return 1;
        else return 0;
    }

}

