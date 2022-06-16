package battleship.utils.gamesetup.ships;

import battleship.board.Board;
import battleship.utils.UserInput;

import java.util.Arrays;

public class AircraftCarrier implements PlacementOfShips {

    public static Board placeShipOnBoard(Board board) {
        int AircraftCarrierLength = 5;
        int[] userInput = UserInput.getUserInput();
//        if (isValidAircraftCarrierPlacement(userIn, board)) {
//            return fillInGapsBetweenAircraftCarrier(userIn, board);
//        } else {
//            return board;
//        }
        int userInputAircraftCarrierShipLength = ShipUtils.getLengthOfShip();
        shipDirection shipDir = ShipUtils.whichWayIsBoatFacing(userInput);
        return board;
    }

    private static boolean isValidAircraftCarrierPlacement(int[] userInput, Board board) {
        System.out.println(Arrays.toString(Arrays.stream(userInput).toArray()));


        if (userInput[0] - userInput[2] == userInput[1] - userInput[3]) {
            System.out.println("Diag");
            return true;
        } else {
            System.out.println("NOT DIAG");
            if (userInput[0] == userInput[2]) {
                if (userInput[1] == userInput[3] + 4) {
                    return true;
                } else if (userInput[1] == userInput[3] - 4) {
                    return true;
                } else {
                    System.out.println("not correct distance apart horizontal");
                    return false;
                }
            } else if (userInput[1] == userInput[3]) {
                if (userInput[0] == userInput[2] + 4) {
                    return true;
                } else if (userInput[0] == userInput[2] - 4) {
                    return true;
                } else {
                    System.out.println("not correct distance apart vertical");
                    return false;
                }
            } else {
                return false;
            }
        }
    }


    private static boolean isBoatLengthValid(int[] userInput, Board board) {
        return true;
    }


    private static Board drawHorizontal(int[] userInput, Board board) {
        if (userInput[1] + 3 < 9) {
            if(userInput[0] <= 9) {
                board.board[userInput[0]][userInput[1]] = "0";
                board.board[userInput[2]][userInput[3]] = "0";
                board.board[userInput[0]][userInput[1] + 1] = "0";
                board.board[userInput[0]][userInput[1] + 2] = "0";
                board.board[userInput[0]][userInput[1] + 3] = "0";
            }
        } else {
            System.out.println("Boat not placed.");
        }
        return board;
    }

    private static Board drawVertical(int[] userInput, Board board) {
        if (userInput[0] + 3 < 9) {
            board.board[userInput[0]][userInput[1]] = "0";
            board.board[userInput[2]][userInput[3]] = "0";
            board.board[userInput[0] + 1][userInput[1]] = "0";
            board.board[userInput[0] + 2][userInput[1]] = "0";
            board.board[userInput[0] + 3][userInput[1]] = "0";
        } else {
            System.out.println("Boat not placed.");
        }
        return board;
    }

    private static Board drawDiagonal(int[] userInput, Board board) {
        return board;
    }


    private static Board fillInGapsBetweenAircraftCarrier(int[] userIn, Board board) {
        board.board[userIn[0]][userIn[1]] = "0";
        board.board[userIn[2]][userIn[3]] = "0";

        /* function to fill the intermediate tiles */
        // Needs expanding for diagonal boat placement.
        // is boat horizontal or vertical ?
        if (userIn[2] == userIn[0]) {
            System.out.println("making horizontal " +
                    "aircraft carrier whether you like it or not");
            // if boat is vertical which direction is it facing? Which 0 is spawned first?
            if (userIn[1] + 3 < 9) {
                board.board[userIn[0]][userIn[1] + 1] = "0";
                board.board[userIn[0]][userIn[1] + 2] = "0";
                board.board[userIn[0]][userIn[1] + 3] = "0";
            }
        } else {
            System.out.println("making vertical aircraft carrier whether you like it or not");
            if (userIn[0] + 3 < 9) {
                board.board[userIn[0] + 1][userIn[1]] = "0";
                board.board[userIn[0] + 2][userIn[1]] = "0";
                board.board[userIn[0] + 3][userIn[1]] = "0";
            }
        }
        return board;
    }
}
