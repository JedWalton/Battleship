package battleship;

import battleship.board.Board;
import battleship.utils.GameSetupUtils;


public class GameInstance {

    Board board;

    public GameInstance() {
    }

    public void startGame() {
        this.board = new Board();
        GameSetupUtils.placeAllShipsOnBoard(this.board);
    }
}
