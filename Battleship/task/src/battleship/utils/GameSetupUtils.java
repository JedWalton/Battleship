package battleship.utils;

import battleship.board.Board;

public class GameSetupUtils {
    private GameSetupUtils() {

    }

    public static Board placeAllShipsOnBoard(Board board) {
        board.displayBoard();
        placeAircraftCarrierMessage();
        board = initShip(board, 5);
        board.displayBoard();
        placeBattleshipMessage();
        board = initShip(board, 4);
        board.displayBoard();
        placeSubmarineMessage();
        board = initShip(board, 3);
        board.displayBoard();
        placeCruiserMessage();
        board = initShip(board, 3);
        board.displayBoard();
        placeDestroyerMessage();
        board = initShip(board, 2);
        board.displayBoard();

        return board;
    }

    private static Board initShip(Board board, int shipLength) {

        int[] userInput = UserInput.getValidUserInput();

        if (!ShipPlacementValidation.isValidShipPlacement(userInput, board, shipLength)) {
            initShip(board, shipLength);
        }

        ShipPlacer.placeShipOnBoard(userInput, board, shipLength);

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
}
