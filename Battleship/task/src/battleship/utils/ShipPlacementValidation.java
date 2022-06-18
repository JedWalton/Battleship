package battleship.utils;

import battleship.board.Board;
import battleship.enums.ShipDirection;

public class ShipPlacementValidation {
    private ShipPlacementValidation() {
    }

    public static boolean isValidShipPlacement(int[] userInputBoardCoordinatesX1Y1X2Y2, Board board, int shipLength) {
        if (ValidShipLengthAndDirection(userInputBoardCoordinatesX1Y1X2Y2, board, shipLength)) {
            if (ShipPlacementIsNotOutOfBounds(userInputBoardCoordinatesX1Y1X2Y2)) {
                return true;
            }
        }
        return false;
    }
    private static boolean ShipPlacementIsNotOutOfBounds(int[] userInputBoardCoordinatesX1Y1X2Y2) {
        for (int j : userInputBoardCoordinatesX1Y1X2Y2) {
            if (j > 9 || j < 0) {
                System.out.println("OOB");
                return false;
            }
        }
        return true;
    }



    private static boolean ValidShipLengthAndDirection(int[] userInput, Board board, int shipLength) {

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


    public static ShipDirection calculateShipDirection(int[] userInput, int shipLength) {
        if (userInput[0] == userInput[2] - (shipLength - 1) && (userInput[1] == userInput[3])) {
            return ShipDirection.East;
        } else if (userInput[0] == userInput[2] + (shipLength - 1) && (userInput[1] == userInput[3])) {
            return ShipDirection.West;
        } else if (userInput[0] == userInput[2] && (userInput[1] == userInput[3] + (shipLength - 1))) {
            return ShipDirection.North;
        } else if (userInput[0] == userInput[2] && (userInput[1] == userInput[3] - (shipLength - 1))) {
            return ShipDirection.South;
        } else if (userInput[0] == userInput[2] - (shipLength - 1) && (userInput[1] == userInput[3] - (shipLength - 1))) {
            return ShipDirection.SouthEast;
        } else if (userInput[0] == userInput[2] + (shipLength - 1) && (userInput[1] == userInput[3] - (shipLength - 1))) {
            return ShipDirection.SouthWest;
        } else if (userInput[0] == userInput[2] - (shipLength - 1) && (userInput[1] == userInput[3] + (shipLength - 1))) {
            return ShipDirection.NorthEast;
        } else if (userInput[0] == userInput[2] + (shipLength - 1) && (userInput[1] == userInput[3] + (shipLength - 1))) {
            return ShipDirection.NorthWest;
        }
        throw new RuntimeException("We only see this if we accept invalid direction.");
    }
}
