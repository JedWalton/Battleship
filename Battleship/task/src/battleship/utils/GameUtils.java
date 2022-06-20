package battleship.utils;

import battleship.board.Board;

public class GameUtils {
    private GameUtils() {

    }

    public static Board placeAllShipsOnBoard(Board board) {
        board.displayBoard();
        placeAircraftCarrierMessage();
        initShip(board, 5);
        board.displayBoard();
        placeBattleshipMessage();
        initShip(board, 4);
        board.displayBoard();
        placeSubmarineMessage();
        initShip(board, 3);
        board.displayBoard();
        placeCruiserMessage();
        initShip(board, 3);
        board.displayBoard();
        placeDestroyerMessage();
        initShip(board, 2);
        board.displayBoard();

        return board;
    }

    private static Board initShip(Board board, int shipLength) {

        int[] userInput = UserInput.getValidUserInput();

        while (!Validation.isValidShipPlacement(userInput, board, shipLength)) {
            userInput = UserInput.getValidUserInput();
        }

        ShipAndShotsUtils.placeShipOnBoard(userInput, board, shipLength);

        return board;
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

    public static Board takeAShot(Board board) {
        System.out.println("\nTake a shot!\n");

        int[] userShotCoordsX1Y1 = UserInput.getTakeAShotInput();

        while(!Validation.isValidShot(userShotCoordsX1Y1, board)) {
            userShotCoordsX1Y1 = UserInput.getTakeAShotInput();
        }

        ShipAndShotsUtils.takeShot(userShotCoordsX1Y1, board);

        return board;
    }


}
