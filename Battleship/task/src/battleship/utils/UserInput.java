package battleship.utils;

import java.util.Arrays;
import java.util.Scanner;

public class UserInput {
    private UserInput() {
    }

    static int[] getUserInput() {
        System.out.println("ENTER INPUT");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] moveToBoardCoords = convertInputToBoardCoords(input);
        System.out.println(Arrays.toString(moveToBoardCoords));
        return moveToBoardCoords;
    }

    private static int[] convertInputToBoardCoords(String input) {
        String[] inputs = input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        String[] trimmedArray = new String[4];
        for (int i = 0; i < inputs.length; i++) {
            trimmedArray[i] = inputs[i].trim();
        }

        int[] boardcoordsx1y1x2y2 = new int[trimmedArray.length];

        for (int i = 0; i < trimmedArray.length; i++) {
            if (trimmedArray[i].length() == 1) {
                int ascii = trimmedArray[i].charAt(0);
                if (ascii > 48 && ascii < 58) {
                    boardcoordsx1y1x2y2[i] = trimmedArray[i].charAt(0) - 49;
                } else if (ascii >= 65 && ascii <= 90) {
                    boardcoordsx1y1x2y2[i] = trimmedArray[i].charAt(0) - 65;
                }
            } else {
                boardcoordsx1y1x2y2[i] = 10;
            }
        }
        return boardcoordsx1y1x2y2;
    }
}
