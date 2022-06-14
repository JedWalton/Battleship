package battleship.board;

public class board {

    String[][] board;

    public board() {
        initBoard();
    }

    public String[][] initBoard() {
        this.board = new String[10][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = "~";
            }
        }
        return board;
    }

    public void displayBoard() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < this.board.length; i++) {
            if (i != 0) {
                System.out.println();
            }
            for (int j = 0; j < this.board.length; j++) {
                if (j == 0) {
                    System.out.print((char) (i + 65));
                }
                System.out.print(" " + board[i][j]);
            }
        }
    }

    public void placeAircraftCarrier(String aircraftCarrierPosition) {

    }

    public void placeBattleship() {

    }

    public void placeSubmarine() {

    }

    public void placeCruiser() {

    }

    public void placeDestroyer() {

    }

    public void isConsecutive() {

    }


}
