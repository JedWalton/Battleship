package battleship.utils;

import battleship.board.Board;
import battleship.enums.ShipDirection;

public class ShipPlacementValidation {
    private ShipPlacementValidation() {
    }

    public static boolean isValidShipPlacement(int[] UserInputBoardCoordsX1Y1X2Y2, Board board, int shipLength) {

//        if (!ValidShipLengthAndDirection(UserInputBoardCoordsX1Y1X2Y2, board, shipLength)) {
//            System.out.println("Error! Wrong ship location! Try again:\n");
//            return false;
//        }
//        System.out.println("val placement call");

        /* Valid ship direction */
        if (!validShipDirection(UserInputBoardCoordsX1Y1X2Y2)) {
            System.out.println("wrong direction of ship");
            return false;
        }
//        /* Valid ship length */
        if (!validShipLength(UserInputBoardCoordsX1Y1X2Y2, shipLength)) {
            System.out.println("not valid length");
            return false;
        }
//
//        /* in bounds */
        if (!shipIsInBounds(UserInputBoardCoordsX1Y1X2Y2)) {
            System.out.println("Error! Wrong ship location! Try again:\n");
            return false;
        }
        /* not obstructed */
        if (!ValidNotTooCloseToAnotherShip(UserInputBoardCoordsX1Y1X2Y2, board, shipLength)) {
            System.out.println("Error! You placed it too close to another one. Try again:\n");
            return false;
        }

        return true;
    }


    private static boolean ValidNotTooCloseToAnotherShip(int[] UserInputBoardCoordsX1Y1X2Y2, Board board, int shipLength) {
        ShipDirection shipDirection = ShipPlacementValidation.calculateShipDirection(UserInputBoardCoordsX1Y1X2Y2);
        int x;
        int y;

        for (int i = 0; i < shipLength; i++) {
            if (shipDirection.equals(ShipDirection.East)) {
                x = UserInputBoardCoordsX1Y1X2Y2[0] + i;
                y = UserInputBoardCoordsX1Y1X2Y2[1];
                if (!board.board[x][y].equals("~")) {
                    return false;
                } else if (doesSurroundingTilesContainAnotherShip(x, y, board)) {
                    return false;
                }
            } else if (shipDirection.equals(ShipDirection.West)) {
                x = UserInputBoardCoordsX1Y1X2Y2[0] - i;
                y = UserInputBoardCoordsX1Y1X2Y2[1];
                if (!board.board[x][y].equals("~")) {
                    return false;
                } else if (doesSurroundingTilesContainAnotherShip(x, y, board)) {
                    return false;
                }
            } else if (shipDirection.equals(ShipDirection.North)) {
                x = UserInputBoardCoordsX1Y1X2Y2[0];
                y = UserInputBoardCoordsX1Y1X2Y2[1] - i;
                if (!board.board[x][y].equals("~")) {
                    return false;
                } else if (doesSurroundingTilesContainAnotherShip(x, y, board)) {
                    return false;
                }
            } else if (shipDirection.equals(ShipDirection.South)) {
                x = UserInputBoardCoordsX1Y1X2Y2[0];
                y = UserInputBoardCoordsX1Y1X2Y2[1] + i;
                if (!board.board[x][y].equals("~")) {
                    return false;
                } else if (doesSurroundingTilesContainAnotherShip(x, y, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean doesSurroundingTilesContainAnotherShip(int x, int y, Board board) {

        if (x + 1 < 10) {
            if (board.board[x + 1][y].equals("O")) {
                return true;
            }
        }
        if (y + 1 < 10) {
            if (board.board[x][y + 1].equals("O")) {
                return true;
            }
        }
        if (x - 1 > 0) {
            if (board.board[x - 1][y].equals("O")) {
                return true;
            }
        }
        if (y - 1 > 0) {
            if (board.board[x][y - 1].equals("O")) {
                return true;
            }
        }
        if (x + 1 < 10 && y + 1 < 10) {
            if (board.board[x + 1][y + 1].equals("O")) {
                return true;
            }
        }
        if (x + 1 < 10 && y - 1 > 0) {
            if (board.board[x + 1][y - 1].equals("O")) {
                return true;
            }
        }
        if (x - 1 > 0 && y + 1 < 10) {
            if (board.board[x - 1][y + 1].equals("O")) {
                return true;
            }
        }
        if (x - 1 > 0 && y - 1 > 0) {
            if (board.board[x - 1][y - 1].equals("O")) {
                return true;
            }
        }
        return false;
    }

    private static boolean shipIsInBounds(int[] userInputBoardCoordinatesX1Y1X2Y2) {
        for (int i = 0; i < userInputBoardCoordinatesX1Y1X2Y2.length; i++) {
            if (userInputBoardCoordinatesX1Y1X2Y2[i] > 9 || userInputBoardCoordinatesX1Y1X2Y2[i] < 0) {
                System.out.println("Ship not in bounds");
                return false;
            }
        }
        return true;
    }

    private static boolean validShipLength(int[] userInput, int shipLength) {
        ShipDirection shipDirection = calculateShipDirection(userInput);

        if (shipDirection.equals(ShipDirection.East)) {
            if (userInput[0] == userInput[2] - shipLength + 1) {
                return true;
            }
        }
        if (shipDirection.equals(ShipDirection.West)) {
            if (userInput[2] == userInput[0] - shipLength + 1) {
                return true;
            }
        }
        if (shipDirection.equals(ShipDirection.North)) {
            if (userInput[3] == userInput[1] - shipLength + 1) {
                return true;
            }
        }
        if (shipDirection.equals(ShipDirection.South)) {
            return userInput[1] == userInput[3] - shipLength + 1;
        }

        return false;
    }

    private static boolean validShipDirection(int[] userInput) {
        return !calculateShipDirection(userInput).equals(ShipDirection.Invalid);
    }


    public static ShipDirection calculateShipDirection(int[] userInput) {
        /* shipLength is a helper function */
        if (userInput[0] < userInput[2] && (userInput[1] == userInput[3])) {
            return ShipDirection.East;
        } else if (userInput[0] > userInput[2] && (userInput[1] == userInput[3])) {
            return ShipDirection.West;
        } else if (userInput[0] == userInput[2] && (userInput[1] > userInput[3])) {
            return ShipDirection.North;
        } else if (userInput[0] == userInput[2] && (userInput[1] < userInput[3])) {
            return ShipDirection.South;
        }

        return ShipDirection.Invalid;
    }

}
