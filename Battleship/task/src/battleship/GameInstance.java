package battleship;

import battleship.board.Board;
import battleship.utils.GameUtils;
import battleship.utils.UserInput;

import static battleship.utils.GameUtils.takeAShot;


public class GameInstance {

    Board board;
    int numberOfHits;

    public GameInstance() {
        numberOfHits = 0;
        startGame();
    }

    public void startGame() {
        this.board = new Board();
        GameUtils.placeAllShipsOnBoard(this.board);
        startGameLoop(board);
    }


    public void startGameLoop(Board board) {
        System.out.println("\n\nThe game starts!");
        int numberOfHits = 0;
        boolean isGameOver = false;
        while (!isGameOver) {
            board = GameUtils.takeAShot(board);
            board.displayBoard();
        }
    }
}
