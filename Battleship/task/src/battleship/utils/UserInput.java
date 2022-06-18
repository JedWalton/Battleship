package battleship.utils;

import battleship.board.Board;

import javax.management.relation.RoleNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class UserInput {
    private UserInput() {
    }

    public static int[] getValidUserInput(Board board, int shipLength) throws RoleNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] inputTokensUnprocessed = tokenizeTheInput(input);
        String[] inputTokens = trimWhitespace(inputTokensUnprocessed);
        String[] inputTokensInX1Y1X2Y2 = swapXandY(inputTokens);
        System.out.println(Arrays.toString(inputTokensInX1Y1X2Y2));
//        if (tokensAreValid(inputTokens)) {
//            int[] BoardCoordsX1Y1X2Y2 = convertValidTokensToBoardCoordsX1Y1X2Y2(inputTokens);
//            return BoardCoordsX1Y1X2Y2;
//            if(ShipPlacementValidation.isValidShipPlacement(inputTokens, board, shipLength)) {
//
//            }
//        } else {
//            getValidUserInput(board, shipLength);
//        }
//        int[] BoardCoordinatesCalculatedFromUserInputX1Y1X2Y2 = trimWhitespace(input);

        throw new RoleNotFoundException("Something went seriously wrong in your input validation method: getValidUserInput");
//        return BoardCoordinatesCalculatedFromUserInputX1Y1X2Y2;
    }

    private static String[] swapXandY(String[] inputTokens) {
        String[] inputTokensInX1Y1X2Y2 = new String[4];
        inputTokensInX1Y1X2Y2[0] = inputTokens[1];
        inputTokensInX1Y1X2Y2[1] = inputTokens[0];
        inputTokensInX1Y1X2Y2[2] = inputTokens[3];
        inputTokensInX1Y1X2Y2[3] = inputTokens[2];
        return inputTokensInX1Y1X2Y2;
    }

    private static int[] convertValidTokensToBoardCoordsX1Y1X2Y2(String[] inputTokens) {
        int[] boardCoords = new int[inputTokens.length];


        int Y1 = inputTokens[0].charAt(0) - 65;
        int Y2 = inputTokens[2].charAt(0) - 65;


        int X1;
        int X2;
        if (Objects.equals(inputTokens[1], "10")) {
            X1 = 9;
        } else {
            X1 = inputTokens[1].charAt(0) - 49;
        }

        if (Objects.equals(inputTokens[3], "10")) {
            X2 = 9;
        } else {
            X2 = inputTokens[3].charAt(0) - 49;
        }

        boardCoords[0] = X1;
        boardCoords[1] = Y1;
        boardCoords[2] = X2;
        boardCoords[3] = Y2;

        return boardCoords;
    }

    private static boolean tokensAreValid(String[] inputTokens) {
        String[] setOfValidInputsX = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] setOfValidInputsY = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        System.out.println(Arrays.toString(inputTokens));

        if (!Arrays.asList(setOfValidInputsY).contains(inputTokens[0])) {
            return false;
        } else if (!Arrays.asList(setOfValidInputsY).contains(inputTokens[2])) {
            return false;
        } else if (!Arrays.asList(setOfValidInputsX).contains(inputTokens[1])) {
            return false;
        } else return Arrays.asList(setOfValidInputsX).contains(inputTokens[3]);
    }

    private static String[] tokenizeTheInput(String input) {
        return input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)+");
    }

    private static String[] trimWhitespace(String[] input) {
        String[] trimmedArray = new String[4];
        /* deal with inputs of length 2 */
        for (int i = 0; i < input.length; i++) {
            trimmedArray[i] = input[i].trim();
        }
        return trimmedArray;
    }

//    public boolean validateUserInput(){}


//    private static int[] convertInputToBoardCoords(String input) {
//        String[] inputs = input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)+");
//        String[] trimmedArray = new String[4];
//
//        String[] setOfValidInputsX = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
//        String[] setOfValidInputsY = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
//
//        /* deal with inputs of length 2 */
//        for (int i = 0; i < inputs.length; i++) {
//            trimmedArray[i] = inputs[i].trim();
//        }
//
//
//        if (!Arrays.asList(setOfValidInputsY).contains(trimmedArray[0])) {
//            System.out.println("invalid y1 user input. Try again");
//            getValidUserInput();
//        } else if (!Arrays.asList(setOfValidInputsY).contains(trimmedArray[2])) {
//            System.out.println("invalid y2");
//            getValidUserInput();
//        } else if (!Arrays.asList(setOfValidInputsX).contains(trimmedArray[1])) {
//            System.out.println("invalid x1");
//            getValidUserInput();
//        } else if (!Arrays.asList(setOfValidInputsX).contains(trimmedArray[3])) {
//            System.out.println("invalid x2");
//            getValidUserInput();
//        }
//
//
//        System.out.println(trimmedArray[0]);
//        System.out.println(trimmedArray[2]);
//
//        System.out.println(trimmedArray[1]);
//        System.out.println(trimmedArray[3]);
//
//        int[] boardCoords = new int[trimmedArray.length];
//
//
//        int Y1 = trimmedArray[0].charAt(0) - 65;
//        int Y2 = trimmedArray[2].charAt(0) - 65;
//
//
//        int X1;
//        int X2;
//        if (Objects.equals(trimmedArray[1], "10")) {
//            X1 = 9;
//        } else {
//            X1 = trimmedArray[1].charAt(0) - 49;
//        }
//
//        if (Objects.equals(trimmedArray[3], "10")) {
//            X2 = 9;
//        } else {
//            X2 = trimmedArray[3].charAt(0) - 49;
//        }
//
//        boardCoords[0] = X1;
//        boardCoords[1] = Y1;
//        boardCoords[2] = X2;
//        boardCoords[3] = Y2;
//
//        System.out.println("boardCoords");
//        System.out.println();
//        for (int boardCoord : boardCoords) {
//            System.out.print(boardCoord + " ");
//        }
//        System.out.println();
//
//        return boardCoords;
//    }
}
