package battleship.utils;

import battleship.board.Board;

public class GameUtils {
    private GameUtils() {

    }

    public static void placeAllShipsOnBoard(Board board) {
        board.displayBoardWithShips();
        placeAircraftCarrierMessage();
        initShip(board, 5, "Aircraft Carrier");
        board.displayBoardWithShips();
        placeBattleshipMessage();
        initShip(board, 4, "Battleship");
        board.displayBoardWithShips();
        placeSubmarineMessage();
        initShip(board, 3, "Submarine");
        board.displayBoardWithShips();
        placeCruiserMessage();
        initShip(board, 3, "Cruiser");
        board.displayBoardWithShips();
        placeDestroyerMessage();
        initShip(board, 2, "Destroyer");
        board.displayBoardWithShips();

    }

    private static void initShip(Board board, int shipLength, String shipName) {

        int[] userInput = UserInput.getValidUserInput();

        while (!Validation.isValidShipPlacement(userInput, board, shipLength, shipName)) {
            userInput = UserInput.getValidUserInput();
        }

        ShipAndShotsUtils.placeShipOnBoard(userInput, board, shipLength);

    }

    private static void placeAircraftCarrierMessage() {
        System.out.println("\n\nEnter the coordinates of the Aircraft Carrier (5 cells):\n");
    }

    private static void placeBattleshipMessage() {
        System.out.println("\n\nEnter the coordinates of the Battleship (4 cells):\n");
    }

    private static void placeSubmarineMessage() {
        System.out.println("\n\nEnter the coordinates of the Submarine (3 cells):\n");
    }

    private static void placeCruiserMessage() {
        System.out.println("\n\nEnter the coordinates of the Cruiser (3 cells):\n");
    }

    private static void placeDestroyerMessage() {
        System.out.println("\n\nEnter the coordinates of the Destroyer (2 cells):\n");
    }

    public static void takeAShot(Board board) {
        System.out.println("\nTake a shot!\n");

        int[] userShotCoordsX1Y1 = UserInput.getTakeAShotInput();


        while (!Validation.isValidShot(userShotCoordsX1Y1, board)) {
            userShotCoordsX1Y1 = UserInput.getTakeAShotInput();
        }
        ShipAndShotsUtils.takeShot(userShotCoordsX1Y1, board);

    }

    public static boolean hasUserWon(Board board) {
        int totalHitCount = 0;
        for (int i = 0; i < board.board.length; i++) {
            for (int j = 0; j < board.board.length; j++) {
                if(board.board[j][i].equals("X")){
                    totalHitCount += 1;
                }
            }
        }
        if(totalHitCount == 17) {
            return true;
        } else {
            return false;
        }
    }
}
