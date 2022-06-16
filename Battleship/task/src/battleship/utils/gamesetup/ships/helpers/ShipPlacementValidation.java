package battleship.utils.gamesetup.ships.helpers;

import battleship.board.Board;

public class ShipPlacementValidation {
    private ShipPlacementValidation() {
    }

    public static boolean isValidShipPlacement(int[] userInput, Board board, int shipLength) {
        if (ShipLengthAndDirectionIsValid(userInput, board, shipLength)) {
            if (ShipPlacementIsNotOutOfBounds(userInput, board, shipLength)) {

            }
        }
        return true;
    }

    /* ENSURE EACH IF STATEMENT CANNOT GO OUT OF BOUNDS */
    private static boolean ShipLengthAndDirectionAndBoundsIsValid(int[] userInput, Board board, int shipLength) {

        if (userInput[0] == userInput[2] - (shipLength - 1) && (userInput[1] == userInput[3])) {
            System.out.println("East");
            return true;
        } else if (userInput[0] == userInput[2] + (shipLength - 1) && (userInput[1] == userInput[3])) {
            System.out.println("West");
            return true;
        } else if (userInput[0] == userInput[2] && (userInput[1] == userInput[3] + (shipLength - 1))) {
            System.out.println("North");
            return true;
        } else if (userInput[0] == userInput[2] && (userInput[1] == userInput[3] - (shipLength - 1))) {
            System.out.println("South");
            return true;
        } else if (userInput[0] == userInput[2] - (shipLength - 1) && (userInput[1] == userInput[3] - (shipLength - 1))) {
            System.out.println("SouthEast");
            return true;
        } else if (userInput[0] == userInput[2] + (shipLength - 1) && (userInput[1] == userInput[3] - (shipLength - 1))) {
            System.out.println("SouthWest");
            return true;
        } else if (userInput[0] == userInput[2] - (shipLength - 1) && (userInput[1] == userInput[3] + (shipLength - 1))) {
            System.out.println("NorthEast");
            return true;
        } else if (userInput[0] == userInput[2] + (shipLength - 1) && (userInput[1] == userInput[3] + (shipLength - 1))) {
            System.out.println("NorthWest");
            return true;
        }
        return false;
    }

    private static boolean isShipPlacementPathTaken(int[] userInput, Board board, int shipLength) {
        return false;
    }








    private static boolean ShipPlacementIsNotOutOfBounds(int[] userInput, Board board, int shipLength) {
//        for (int i = 0; i < userInput.length; i++) {
//            if (userInput[i] > 9 || userInput[i] < 0) {
//                System.out.println("OOB");
//                return false;
//            }
//        }
        return true;
    }

}
