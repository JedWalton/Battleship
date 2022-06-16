package battleship.utils;

import battleship.board.Board;
import battleship.utils.placeshiputils.isValidPlacement;

import java.util.Arrays;

public class GameSetupUtils {
    private GameSetupUtils() {

    }

    public static Board placeShipsOnBoard(Board board) {
        Board outputBoard = board;
        outputBoard = placeAircraftCarrier(board);
//        outputBoard = placeBattleship(board);
//        outputBoard = placeSubmarine(board);
//        outputBoard = placeCruiser(board);
//        outputBoard = placeDestroyer(board);
        return outputBoard;
    }

    private static Board placeAircraftCarrier(Board board) {
        int[] userIn = UserInput.getUserInput();
        if (isValidPlacement.isValidAircraftCarrierPlacement(userIn, board)) {
            return fillInGapsBetweenAircraftCarrier(userIn, board);
        } else {
            return board;
        }
    }

    private static Board fillInGapsBetweenAircraftCarrier(int[] userIn, Board board) {
        Board outputBoard = board;
        outputBoard.board[userIn[0]][userIn[1]] = "0";
        outputBoard.board[userIn[2]][userIn[3]] = "0";

        /* function to fill the intermediate tiles */
        // Needs expanding for diagonal boat placement.
        // is boat horizontal or vertical ?
        if (userIn[2] == userIn[0]) {
            System.out.println("making horizontal " +
                    "aircraft carrier whether you like it or not");
            // if boat is vertical which direction is it facing? Which 0 is spawned first?
            if (userIn[1] + 3 < 9) {
                outputBoard.board[userIn[0]][userIn[1] + 1] = "0";
                outputBoard.board[userIn[0]][userIn[1] + 2] = "0";
                outputBoard.board[userIn[0]][userIn[1] + 3] = "0";
            }
        } else {
            System.out.println("making vertical aircraft carrier whether you like it or not");
            if (userIn[0] + 3 < 9) {
                outputBoard.board[userIn[0] + 1][userIn[1]] = "0";
                outputBoard.board[userIn[0] + 2][userIn[1]] = "0";
                outputBoard.board[userIn[0] + 3][userIn[1]] = "0";
            }
        }
        return outputBoard;
    }




    private static void placeBattleship(Board board) {

    }

    private static void placeSubmarine(Board board) {

    }

    private static void placeCruiser(Board board) {

    }

    private static void placeDestroyer(Board board) {

    }

}
