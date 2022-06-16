package battleship.utils.gamesetup.ships;

import battleship.board.Board;

import java.util.Optional;

public class ShipPlacementValidation {
    private ShipPlacementValidation() {
    }

    public static boolean isValidShipPlacement(int[] userInput, Board board, int shipLength) {
        return true;
    }

    private static boolean isBoatLengthValid(int[] userInput, Board board, int shipLength) {
        ShipDirection shipDir = ShipUtils.calculateShipDirection(userInput);
        return false;
    }

    private static boolean isBoatDirectionValid(int[] userInput, Board board) {
        return false;
    }

    private static boolean isBoatPlacementPathTaken(int[] userInput, Board board, int shipLength) {
        return false;
    }

    private static boolean isBoatPlacementOutOfBounds(int[] userInput, Board board, int shipLength) {
        return false;
    }

    private static boolean isValidDirection(int[] userInput, Board board, int shipLength) {
        return false;
    }
}
