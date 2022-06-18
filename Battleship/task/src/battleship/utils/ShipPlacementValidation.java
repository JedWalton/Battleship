package battleship.utils;

import battleship.board.Board;
import battleship.enums.ShipDirection;

public class ShipPlacementValidation {
    private ShipPlacementValidation() {
    }

    public static boolean isValidShipPlacement(int[] UserInputBoardCoordsX1Y1X2Y2, Board board, int shipLength) {

        if (!ValidShipLengthAndDirection(UserInputBoardCoordsX1Y1X2Y2, board, shipLength)) {
            System.out.println("Error! Wrong ship location! Try again:\n");
            return false;
        }
        if (!ShipIsInBounds(UserInputBoardCoordsX1Y1X2Y2, board, shipLength)) {
            System.out.println("Error! Wrong ship location! Try again:\n");
            return false;
        }
        if (!ValidShipNotObstructedByExistingShip(UserInputBoardCoordsX1Y1X2Y2, board, shipLength)) {
            System.out.println("Error! You placed it too close to another one. Try again:\n");
            return false;
        }
        return true;
    }

    private static boolean ValidShipNotObstructedByExistingShip(int[] UserInputBoardCoordsX1Y1X2Y2, Board board, int shipLength) {
        ShipDirection shipDirection = ShipPlacementValidation.calculateShipDirection(UserInputBoardCoordsX1Y1X2Y2, shipLength);


        for (int i = 0; i < shipLength; i++) {
            if (shipDirection.equals(ShipDirection.East)) {
                if (!board.board[UserInputBoardCoordsX1Y1X2Y2[0] + i][UserInputBoardCoordsX1Y1X2Y2[1]].equals("~")) {
                    return false;
                }
            } else if (shipDirection.equals(ShipDirection.West)) {
                if (!board.board[UserInputBoardCoordsX1Y1X2Y2[0] - i][UserInputBoardCoordsX1Y1X2Y2[1]].equals("~")) {
                    return false;
                }
            } else if (shipDirection.equals(ShipDirection.North)) {
                if (!board.board[UserInputBoardCoordsX1Y1X2Y2[0]][UserInputBoardCoordsX1Y1X2Y2[1] - i].equals("~")) {
                    return false;
                }
            } else if (shipDirection.equals(ShipDirection.South)) {
                if (!board.board[UserInputBoardCoordsX1Y1X2Y2[0]][UserInputBoardCoordsX1Y1X2Y2[1] + i].equals("~")) {
                    return false;
                }
            } else if (shipDirection.equals(ShipDirection.NorthEast)) {
                if (!board.board[UserInputBoardCoordsX1Y1X2Y2[0] + i][UserInputBoardCoordsX1Y1X2Y2[1] - i].equals("~")) {
                    return false;
                }
            } else if (shipDirection.equals(ShipDirection.NorthWest)) {
                if (!board.board[UserInputBoardCoordsX1Y1X2Y2[0] - i][UserInputBoardCoordsX1Y1X2Y2[1] - i].equals("~")) {
                    return false;
                }
            } else if (shipDirection.equals(ShipDirection.SouthEast)) {
                if (!board.board[UserInputBoardCoordsX1Y1X2Y2[0] + i][UserInputBoardCoordsX1Y1X2Y2[1] + i].equals("~")) {
                    return false;
                }
            } else if (shipDirection.equals(ShipDirection.SouthWest)) {
                if (!board.board[UserInputBoardCoordsX1Y1X2Y2[0] - i][UserInputBoardCoordsX1Y1X2Y2[1] + i].equals("~")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean ShipIsInBounds(int[] userInputBoardCoordinatesX1Y1X2Y2, Board board, int shipLength) {
        for (int i = 0; i < userInputBoardCoordinatesX1Y1X2Y2.length; i++) {
            if (userInputBoardCoordinatesX1Y1X2Y2[i] > 9 || userInputBoardCoordinatesX1Y1X2Y2[i] < 0) {
                System.out.println("Ship not in bounds");
                return false;
            }
        }
        return true;
    }

    private static boolean ValidShipLengthAndDirection(int[] userInput, Board board, int shipLength) {

        if (userInput[0] == userInput[2] - (shipLength - 1) && (userInput[1] == userInput[3])) {
            return true;
        } else if (userInput[0] == userInput[2] + (shipLength - 1) && (userInput[1] == userInput[3])) {
            return true;
        } else if (userInput[0] == userInput[2] && (userInput[1] == userInput[3] + (shipLength - 1))) {
            return true;
        } else if (userInput[0] == userInput[2] && (userInput[1] == userInput[3] - (shipLength - 1))) {
            return true;
        } else if (userInput[0] == userInput[2] - (shipLength - 1) && (userInput[1] == userInput[3] - (shipLength - 1))) {
            return true;
        } else if (userInput[0] == userInput[2] + (shipLength - 1) && (userInput[1] == userInput[3] - (shipLength - 1))) {
            return true;
        } else if (userInput[0] == userInput[2] - (shipLength - 1) && (userInput[1] == userInput[3] + (shipLength - 1))) {
            return true;
        } else if (userInput[0] == userInput[2] + (shipLength - 1) && (userInput[1] == userInput[3] + (shipLength - 1))) {
            return true;
        }
        return false;
    }


    public static ShipDirection calculateShipDirection(int[] userInput, int shipLength) {
        /* shipLength is a helper function */
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
        return ShipDirection.Invalid;
    }

}
