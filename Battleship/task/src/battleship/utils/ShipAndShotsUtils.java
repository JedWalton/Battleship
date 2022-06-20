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
            System.out.println("You missed!\n");
        } else if (board.board[userShotCoordsX1Y1[0]][userShotCoordsX1Y1[1]].equals("O")) {
            board.board[userShotCoordsX1Y1[0]][userShotCoordsX1Y1[1]] = "X";
            System.out.println("You hit a ship!");
        }
    }
}
