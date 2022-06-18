package battleship.utils;

import battleship.board.Board;
import battleship.enums.ShipDirection;

import java.util.Arrays;

public class ShipPlacer {
    private ShipPlacer() {
    }

    public static Board placeShipOnBoard(int[] userInputBoardCoordsX1Y1X2Y2, Board board, int shipLength) {
        ShipDirection shipDirection = ShipPlacementValidation.calculateShipDirection(userInputBoardCoordsX1Y1X2Y2, shipLength);

        System.out.println(Arrays.toString(userInputBoardCoordsX1Y1X2Y2));

        for (int i = 0; i < shipLength; i++) {
            if (shipDirection.equals(ShipDirection.East)) {
                board.board[userInputBoardCoordsX1Y1X2Y2[0] + i][userInputBoardCoordsX1Y1X2Y2[1]] = "0";
            } else if (shipDirection.equals(ShipDirection.West)) {
                board.board[userInputBoardCoordsX1Y1X2Y2[0] - i][userInputBoardCoordsX1Y1X2Y2[1]] = "0";
            } else if (shipDirection.equals(ShipDirection.North)) {
                board.board[userInputBoardCoordsX1Y1X2Y2[0]][userInputBoardCoordsX1Y1X2Y2[1] - i] = "0";
            } else if (shipDirection.equals(ShipDirection.South)) {
                board.board[userInputBoardCoordsX1Y1X2Y2[0]][userInputBoardCoordsX1Y1X2Y2[1] + i] = "0";
            } else if (shipDirection.equals(ShipDirection.NorthEast)) {
                board.board[userInputBoardCoordsX1Y1X2Y2[0] + i][userInputBoardCoordsX1Y1X2Y2[1] - i] = "0";
            } else if (shipDirection.equals(ShipDirection.NorthWest)) {
                board.board[userInputBoardCoordsX1Y1X2Y2[0] - i][userInputBoardCoordsX1Y1X2Y2[1] - i] = "0";
            } else if (shipDirection.equals(ShipDirection.SouthEast)) {
                board.board[userInputBoardCoordsX1Y1X2Y2[0] + i][userInputBoardCoordsX1Y1X2Y2[1] + i] = "0";
            } else if (shipDirection.equals(ShipDirection.SouthWest)) {
                board.board[userInputBoardCoordsX1Y1X2Y2[0] - i][userInputBoardCoordsX1Y1X2Y2[1] + i] = "0";
            }
        }
        return board;
    }
}
