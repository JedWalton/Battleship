package battleship;

import battleship.board.Board;
import battleship.utils.GameSetupUtils;

public class GameInstance {

    Board board;

    public GameInstance() {
    }

    public void startGame() {
        this.board = new Board();
        this.board = GameSetupUtils.placeShipsOnBoard(this.board);
        this.board.displayBoard();
    }
}
