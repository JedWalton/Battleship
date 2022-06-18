package battleship;

import battleship.board.Board;
import battleship.utils.GameSetupUtils;

import javax.management.relation.RoleNotFoundException;

public class GameInstance {

    Board board;

    public GameInstance() {
    }

    public void startGame() throws RoleNotFoundException {
        this.board = new Board();
        GameSetupUtils.placeAllShipsOnBoard(this.board);
    }
}
