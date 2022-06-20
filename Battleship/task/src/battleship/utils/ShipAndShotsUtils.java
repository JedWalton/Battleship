package battleship.utils;

import battleship.board.Board;
import battleship.enums.ShipDirection;

public class ShipAndShotsUtils {
    private ShipAndShotsUtils() {
    }

    public static void placeShipOnBoard(int[] userInputBoardCoordsX1Y1X2Y2, Board board, int shipLength) {
        ShipDirection shipDirection = Validation.calculateShipDirection(userInputBoardCoordsX1Y1X2Y2);

        for (int i = 0; i < shipLength; i++) {
            if (shipDirection.equals(ShipDirection.East)) {
                board.board[userInputBoardCoordsX1Y1X2Y2[0] + i][userInputBoardCoordsX1Y1X2Y2[1]] = "O";
            } else if (shipDirection.equals(ShipDirection.West)) {
                board.board[userInputBoardCoordsX1Y1X2Y2[0] - i][userInputBoardCoordsX1Y1X2Y2[1]] = "O";
            } else if (shipDirection.equals(ShipDirection.North)) {
                board.board[userInputBoardCoordsX1Y1X2Y2[0]][userInputBoardCoordsX1Y1X2Y2[1] - i] = "O";
            } else if (shipDirection.equals(ShipDirection.South)) {
                board.board[userInputBoardCoordsX1Y1X2Y2[0]][userInputBoardCoordsX1Y1X2Y2[1] + i] = "O";
            }
        }
    }

    public static void takeShot(int[] userShotCoordsX1Y1, Board board) {
        if (board.board[userShotCoordsX1Y1[0]][userShotCoordsX1Y1[1]].equals("~")) {
            board.board[userShotCoordsX1Y1[0]][userShotCoordsX1Y1[1]] = "M";
            System.out.println("\nYou missed! Try again:\n");
        } else if (board.board[userShotCoordsX1Y1[0]][userShotCoordsX1Y1[1]].equals("O")) {
            board.board[userShotCoordsX1Y1[0]][userShotCoordsX1Y1[1]] = "X";
            if (didShipGetSunk(userShotCoordsX1Y1, board)) {
                if (GameUtils.hasUserWon(board)) {
                    board.displayBoardWithFogOfWar(board);
                    System.out.println("\n\nYou sank the last ship. You won. Congratulations!");
                } else {
                    System.out.println("You sank a ship! Specify a new target");
                }
            } else {
                System.out.println("\nYou hit a ship! Try again:");
            }
        }
    }

    /* Check all squares around this tile. IF only surrounded by X, M or ~ then ship must be sunk */

    /* Modify the placement validation methods. */
    private static boolean didShipGetSunk(int[] userShotCoordsX1Y1, Board board) {
        /*loop through the length of the ship*/
        // check up, check down, check left, check right.
        if (!checkSurroundingTilesForO(userShotCoordsX1Y1[0], userShotCoordsX1Y1[1], board)) {
            return true;
        }
        return false;
    }

    private static boolean checkSurroundingTilesForO(int x, int y, Board board) {
        /* if does not contain at least "O" in its immediate surrounding then it must be invalid */
        /* As all ships are spaced out by at least one */
        boolean[] trueIfZeroPresent = new boolean[4];
        if (x + 1 < 10) {
            if (board.board[x + 1][y].equals("O")) {
                trueIfZeroPresent[0] = true;
            }
        }
        if (y + 1 < 10) {
            if (board.board[x][y + 1].equals("O")) {
                trueIfZeroPresent[1] = true;
            }
        }
        if (x - 1 > 0) {
            if (board.board[x - 1][y].equals("O")) {
                trueIfZeroPresent[2] = true;
            }
        }
        if (y - 1 > 0) {
            if (board.board[x][y - 1].equals("O")) {
                trueIfZeroPresent[3] = true;
            }
        }
        for (boolean side : trueIfZeroPresent) {
            if (side) {
                return true;
            }
        }
        return false;
    }
}
