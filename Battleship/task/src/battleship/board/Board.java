package battleship.board;

public class Board {

    public String[][] board;
    public String[][] opponentsFogOfWarBoard;

    public Board() {
        initBoard();
    }

    public void initBoard() {
        this.board = new String[10][10];
        this.opponentsFogOfWarBoard = new String[10][10];
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                this.board[i][j] = "~";
                this.opponentsFogOfWarBoard[i][j] = "~";
            }
        }
    }

    public void displayBoardWithShips() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < this.board.length; i++) {
            if (i != 0) {
                System.out.println();
            }
            for (int j = 0; j < this.board.length; j++) {
                if (j == 0) {
                    System.out.print((char) (i + 65));
                }
                System.out.print(" " + board[j][i]);
            }
        }
    }

    public void displayBoardWithFogOfWar() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < this.opponentsFogOfWarBoard.length; i++) {
            if (i != 0) {
                System.out.println();
            }
            for (int j = 0; j < this.opponentsFogOfWarBoard.length; j++) {
                if (j == 0) {
                    System.out.print((char) (i + 65));
                }
                if(!this.opponentsFogOfWarBoard[j][i].equals("O")) {
                    System.out.print(" " + this.opponentsFogOfWarBoard[j][i]);
                } else  {
                    System.out.print(" ~");
                }
            }
        }
    }

    public void displayInGameView() {
        displayBoardWithFogOfWar();
        System.out.println("\n---------------------");
        displayBoardWithShips();
        System.out.println();
    }
}
