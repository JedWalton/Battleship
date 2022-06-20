package battleship;

import battleship.board.Board;
import battleship.utils.GameUtils;



public class GameInstance {

    Board player1Board;
    Board player2Board;

    public GameInstance() {
        startGame();
    }

    public void startGame() {
        System.out.println("Player 1, place your ships on the game field\n");
        this.player1Board= new Board();
        GameUtils.placeAllShipsOnBoard(this.player1Board);

        GameUtils.passTurnToOtherPlayer();

        System.out.println("Player 2, place your ships on the game field\n");
        this.player2Board= new Board();
        GameUtils.placeAllShipsOnBoard(this.player2Board);

        GameUtils.passTurnToOtherPlayer();

        startGameLoop();
    }

    public void startGameLoop() {
        System.out.println("\n\nThe game starts!");
        boolean isGameOver = false;
        while (!isGameOver) {
            System.out.println();
//            player1Board.displayBoardWithFogOfWar();
            this.player1Board.displayInGameView();
            System.out.println("\nPlayer 1, it's your turn:\n");
            GameUtils.takeAShot(this.player2Board, this.player1Board);
            if (GameUtils.hasUserWon(this.player2Board)) {
                isGameOver = true;
                /* winner = player 1 */
            }

            GameUtils.passTurnToOtherPlayer();

            this.player2Board.displayInGameView();
            System.out.println("\nPlayer 2, it's your turn:\n");
            GameUtils.takeAShot(this.player1Board, this.player2Board);
            if (GameUtils.hasUserWon(player1Board)) {
                isGameOver = true;
                /* winner = player 2 */
            }

            GameUtils.passTurnToOtherPlayer();
        }
    }
}
