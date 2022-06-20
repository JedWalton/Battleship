package battleship;

import battleship.board.Board;
import battleship.utils.GameUtils;


public class GameInstance {

    Board board;

    public GameInstance() {
        startGame();
    }

    public void startGame() {
        this.board = new Board();
        GameUtils.placeAllShipsOnBoard(this.board);
        startGameLoop(board);
    }

    public void startGameLoop(Board board) {
        System.out.println("\n\nThe game starts!");
        boolean isGameOver = false;
        while (!isGameOver) {
            GameUtils.takeAShot(board);
            board.displayBoard();
        }
    }
}
