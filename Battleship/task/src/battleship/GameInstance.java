package battleship;

import battleship.board.Board;
import battleship.utils.gamesetup.GameSetupUtils;

public class GameInstance {

    Board board;

    public GameInstance() {
    }

    public void startGame() {
        this.board = new Board();
        this.board.displayBoard();
        this.board = GameSetupUtils.placeAllShipsOnBoard(this.board);
        this.board.displayBoard();
    }
}
