public class Main {
    public static void main(String[] args) {



        ChessGameExecuter chessGameExecuter = new ChessGameExecuter();
        String board[][] = {
                {"WR", "WH", "WB", "WQ", "WK", "WB", "WH", "WR"},
                {"WP", "WP", "WP", "WP", "WP", "WP", "WP", "WP"},
                {"", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", ""},
                {"BP", "BP", "BP", "BP", "BP", "BP", "BP", "BP"},
                {"BR", "BH", "BB", "BQ", "BK", "BB", "BH", "BR"}
        };
        ChessBoard.setChessBoard(board);

        chessGameExecuter.move(1, 5, 2, 5);
        System.out.println(chessGameExecuter.getNextTurn());
        System.out.println(chessGameExecuter.getGameStatus());

        System.out.println("-----------------------");

        chessGameExecuter.move(6, 6, 5, 6);
        System.out.println(chessGameExecuter.getNextTurn());
        System.out.println(chessGameExecuter.getGameStatus());

        System.out.println("-----------------------");

        chessGameExecuter.move(2, 5, 3, 5);
        System.out.println(chessGameExecuter.getNextTurn());
        System.out.println(chessGameExecuter.getGameStatus());

        System.out.println("-----------------------");

        chessGameExecuter.move(6, 2, 5, 2);
        System.out.println(chessGameExecuter.getNextTurn());
        System.out.println(chessGameExecuter.getGameStatus());

        System.out.println("-----------------------");

        chessGameExecuter.move(0, 1, 2, 2);
        System.out.println(chessGameExecuter.getNextTurn());
        System.out.println(chessGameExecuter.getGameStatus());

        System.out.println("-----------------------");

        chessGameExecuter.move(6, 4, 5, 4);
        System.out.println(chessGameExecuter.getNextTurn());
        System.out.println(chessGameExecuter.getGameStatus());

        System.out.println("-----------------------");

        chessGameExecuter.move(1, 7, 2, 7);
        System.out.println(chessGameExecuter.getNextTurn());
        System.out.println(chessGameExecuter.getGameStatus());

        System.out.println("-----------------------");

       //move(7, 6, 5, 7)
        chessGameExecuter.move(7, 6, 5, 7);
        System.out.println(chessGameExecuter.getNextTurn());
        System.out.println(chessGameExecuter.getGameStatus());

        System.out.println("-----------------------");

        chessGameExecuter.move(2, 2, 3, 4);
        System.out.println(chessGameExecuter.getNextTurn());
        System.out.println(chessGameExecuter.getGameStatus());

        System.out.println("-----------------------");

        chessGameExecuter.move(6, 5, 5, 5);
        System.out.println(chessGameExecuter.getNextTurn());
        System.out.println(chessGameExecuter.getGameStatus());

        System.out.println("-----------------------");

        chessGameExecuter.move(3, 4, 5, 5);
        System.out.println(chessGameExecuter.getNextTurn());
        System.out.println(chessGameExecuter.getGameStatus());

        System.out.println("-----------------------");

        chessGameExecuter.move(6, 0, 5, 0);
        System.out.println(chessGameExecuter.getNextTurn());
        System.out.println(chessGameExecuter.getGameStatus());

        System.out.println("-----------------------");

        chessGameExecuter.move(5, 5, 7, 4);
        System.out.println(chessGameExecuter.getNextTurn());
        System.out.println(chessGameExecuter.getGameStatus());

    }
}