package battleship.utils;

import battleship.board.Board;

public class GameSetupUtils {
    private GameSetupUtils() {

    }

    public static Board placeShipsOnBoard(Board board) {
        Board outputBoard = board;
        outputBoard = placeAircraftCarrier(board);
//        outputBoard = placeBattleship(board);
//        outputBoard = placeSubmarine(board);
//        outputBoard = placeCruiser(board);
//        outputBoard = plAceDestroyer(board);
        return outputBoard;
    }

    private static Board placeAircraftCarrier(Board board) {
        int[] userIn = UserInput.getUserInput();
        if (isValidAircraftCarrierPlacement(userIn, board)) {
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
            System.out.println("boat horizontal");
            // if boat is vertical which direction is it facing? Which 0 is spawned first?
            if (userIn[1] + 3 < 9) {
                outputBoard.board[userIn[0]][userIn[1] + 1] = "0";
                outputBoard.board[userIn[0]][userIn[1] + 2] = "0";
                outputBoard.board[userIn[0]][userIn[1] + 3] = "0";
            }
        } else {
            System.out.println("boat vertical");
            if (userIn[0] + 3 < 9) {
                outputBoard.board[userIn[0] + 1][userIn[1]] = "0";
                outputBoard.board[userIn[0] + 2][userIn[1]] = "0";
                outputBoard.board[userIn[0] + 3][userIn[1]] = "0";
            }
        }

        return outputBoard;
    }

    private static boolean isValidAircraftCarrierPlacement(int[] userInput, Board board) {
        if (userInput[0] == userInput[2]) {
            if (userInput[1] == userInput[3] + 4) {
                return true;
            } else if (userInput[1] == userInput[3] - 4) {
                return true;
            } else {
                System.out.println("not correct distance apart");
                return false;
            }
        } else if (userInput[1] == userInput[3]) {
            System.out.println("valid2");
            if (userInput[0] == userInput[2] + 4) {
                return true;
            } else if (userInput[0] == userInput[2] - 4) {
                return true;
            } else {
                System.out.println("not correct distance apart");
                return false;
            }
        } else {
            return false;
        }
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
