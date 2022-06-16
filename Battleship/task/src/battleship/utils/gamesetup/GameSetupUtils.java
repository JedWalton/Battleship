package battleship.utils.gamesetup;

import battleship.board.Board;
import battleship.utils.gamesetup.ships.*;

public class GameSetupUtils {
    private GameSetupUtils() {

    }

    public static Board placeAllShipsOnBoard(Board board) {
        Board outputBoard = board;
        outputBoard = Ship.placeShipOnBoard(board, 5);
//        outputBoard = placeBattleship(board);
//        outputBoard = placeSubmarine(board);
//        outputBoard = placeCruiser(board);
//        outputBoard = placeDestroyer(board);
        return outputBoard;
    }
}
