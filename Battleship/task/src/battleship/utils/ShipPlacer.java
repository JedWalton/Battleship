package battleship.utils;

import battleship.board.Board;
import battleship.enums.ShipDirection;

import java.util.Arrays;

public class ShipPlacer {
    private ShipPlacer() {
    }

    public static Board placeShipOnBoard(int[] userInputBoardCoordsX1Y1X2Y2, Board board, int shipLength) {
        ShipDirection shipDirection = ShipPlacementValidation.calculateShipDirection(userInputBoardCoordsX1Y1X2Y2);


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
        return board;
    }
}
