package battleship;

import battleship.board.Board;
import battleship.utils.GameUtils;
import battleship.utils.UserInput;


public class GameInstance {

    Board board;

    public GameInstance() {
    }

    public void startGame() {
        this.board = new Board();
        GameUtils.placeAllShipsOnBoard(this.board);
        gameloop();
    }

    private void gameloop() {
        System.out.println("\n\nThe game starts!\n\n");


        while (true) {
            board.displayBoard();
//            GameUtils.takeAShot(board);
            System.out.println("\n\nTake a shot!\n");
            int[] userShotCoordsX1Y1 = UserInput.getTakeAShotInput();

        }
    }
}
