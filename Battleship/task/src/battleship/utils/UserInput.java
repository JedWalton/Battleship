package battleship.utils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class UserInput {
    private UserInput() {
    }

    public static int[] getValidUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println();
        String[] inputTokensUnprocessed = TokenizeTheInputForShipPlacement(input);
        String[] inputTokens = trimWhitespaceForShipPlacement(inputTokensUnprocessed);

        if (!shipPlacementTokensAreValid(inputTokens)) {
            System.out.println("Error");
            getValidUserInput();
        }


        return convertValidTokensToBoardCoordsX1Y1X2Y2(inputTokens);

    }

    public static int[] getTakeAShotInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println();
        String[] inputTokensUnprocessed = tokenizeTheInputForTakeAShot(input);
        String[] inputTokens = trimWhitespaceForTakeAShot(inputTokensUnprocessed);

        while (!takeAShotTokensValid(inputTokens)) {
            System.out.println("Error! You entered the wrong coordinates! Try again:\n\n");
            input = scanner.nextLine();
            System.out.println();
            inputTokensUnprocessed = tokenizeTheInputForTakeAShot(input);
            inputTokens = trimWhitespaceForTakeAShot(inputTokensUnprocessed);

        }

        return convertValidTokensToBoardCoordsX1Y1(inputTokens);

    }


    private static int[] convertValidTokensToBoardCoordsX1Y1(String[] inputTokens) {
        int[] boardCoords = new int[inputTokens.length];
        int Y1 = inputTokens[0].charAt(0) - 65;
        int X1;
        if (Objects.equals(inputTokens[1], "10")) {
            X1 = 9;
        } else {
            X1 = inputTokens[1].charAt(0) - 49;
        }
        boardCoords[0] = X1;
        boardCoords[1] = Y1;


        return boardCoords;
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

    private static boolean shipPlacementTokensAreValid(String[] inputTokens) {
        String[] setOfValidInputsX = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] setOfValidInputsY = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        if (!Arrays.asList(setOfValidInputsY).contains(inputTokens[0])) {
            return false;
        } else if (!Arrays.asList(setOfValidInputsY).contains(inputTokens[2])) {
            return false;
        } else if (!Arrays.asList(setOfValidInputsX).contains(inputTokens[1])) {
            return false;
        } else return Arrays.asList(setOfValidInputsX).contains(inputTokens[3]);
    }

    private static boolean takeAShotTokensValid(String[] inputTokens) {
        String[] setOfValidInputsX = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] setOfValidInputsY = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        if (!Arrays.asList(setOfValidInputsY).contains(inputTokens[0])) {
            return false;
        } else return Arrays.asList(setOfValidInputsX).contains(inputTokens[1]);
    }

    private static String[] TokenizeTheInputForShipPlacement(String input) {
        return input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)+");
    }

    private static String[] tokenizeTheInputForTakeAShot(String input) {
        return input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)+");
    }

    private static String[] trimWhitespaceForShipPlacement(String[] input) {
        String[] trimmedArray = new String[4];
        /* deal with inputs of length 2 */
        for (int i = 0; i < input.length; i++) {
            trimmedArray[i] = input[i].trim();
        }
        return trimmedArray;
    }

    private static String[] trimWhitespaceForTakeAShot(String[] input) {
        String[] trimmedArray = new String[2];
        /* deal with inputs of length 2 */
        for (int i = 0; i < input.length; i++) {
            trimmedArray[i] = input[i].trim();
        }
        return trimmedArray;
    }
}

