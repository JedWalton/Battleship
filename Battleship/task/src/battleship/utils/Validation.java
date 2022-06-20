package battleship.utils;

import battleship.board.Board;
import battleship.enums.ShipDirection;

import java.util.Arrays;

public class Validation {
    private Validation() {
    }


    public static boolean isValidShipPlacement(int[] UserInputBoardCoordsX1Y1X2Y2, Board board, int shipLength, String shipName) {

        if (!validShipDirection(UserInputBoardCoordsX1Y1X2Y2)) {
            System.out.println("Error! Wrong ship location! Try again:\n");
            return false;
        }
        if (!validShipLength(UserInputBoardCoordsX1Y1X2Y2, shipLength)) {
            System.out.println("Error! Wrong length of the " + shipName + "! Try again:\n");
            return false;
        }
        if (!shipIsInBounds(UserInputBoardCoordsX1Y1X2Y2)) {
            System.out.println("Error! Wrong ship location! Try again:\n");
            return false;
        }
        if (!ValidNotTooCloseToAnotherShip(UserInputBoardCoordsX1Y1X2Y2, board, shipLength)) {
            System.out.println("Error! You placed it too close to another one. Try again:\n");
            return false;
        }

        return true;
    }


    private static boolean ValidNotTooCloseToAnotherShip(int[] UserInputBoardCoordsX1Y1X2Y2, Board board, int shipLength) {
        ShipDirection shipDirection = Validation.calculateShipDirection(UserInputBoardCoordsX1Y1X2Y2);
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
        for (int j : userInputBoardCoordinatesX1Y1X2Y2) {
            if (j > 9 || j < 0) {
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

    public static boolean isValidShot(int[] userShotCoordsX1Y1, Board board) {
        if (board.board[userShotCoordsX1Y1[0]][userShotCoordsX1Y1[1]].equals("X")) {
            System.out.println("This tile has already been hit!");
            return false;
        } else if (board.board[userShotCoordsX1Y1[0]][userShotCoordsX1Y1[1]].equals("M")) {
            System.out.println("This tile has already missed the ship");
            return false;
        }
        return true;
    }
}
