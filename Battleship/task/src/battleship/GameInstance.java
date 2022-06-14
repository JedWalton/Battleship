package battleship;

import battleship.board.Board;
import battleship.utils.GameUtils;

public class GameInstance {

    Board board;

    public GameInstance() {
    }

    public Board getBoard() {
        return board;
    }

    public void placePiecesOnBoard() {
        GameUtils.placeShipsOnBoard();

    }

    public void main() {
        while (true) {
            board.displayBoard();
            placePiecesOnBoard();
            break;
        }
    }
}
