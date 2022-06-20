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
        System.out.println("\n\nThe game starts!\n");
        boolean isGameOver = false;
        while (!isGameOver) {
            System.out.println();
            board.displayBoardWithFogOfWar();
            GameUtils.takeAShot(board);
            System.out.println();
            board.displayBoardWithShips();
        }
    }
}
