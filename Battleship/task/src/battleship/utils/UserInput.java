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

        if (tokensAreValid(inputTokens)) {
            return convertValidTokensToBoardCoordsX1Y1X2Y2(inputTokens);
        }

        throw new RoleNotFoundException("Something went seriously wrong in your input validation method: getValidUserInput");
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
}
