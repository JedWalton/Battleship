package battleship.utils;

import java.util.Arrays;
import java.util.Scanner;

public class UserInput {
    private UserInput() {
    }

    public static int[] getUserInput() {
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

        int[] boardCoords = new int[trimmedArray.length];


        int Y1 = trimmedArray[0].charAt(0) - 65;
        int X1 = trimmedArray[1].charAt(0) - 49;
        int Y2 = trimmedArray[2].charAt(0) - 65;
        int X2 = trimmedArray[3].charAt(0) - 49;

        System.out.println(Y1);
        System.out.println(X1);
        System.out.println(Y2);
        System.out.println(X1);

        boardCoords[0] = X1;
        boardCoords[1] = Y1;
        boardCoords[2] = X2;
        boardCoords[3] = Y2;

        System.out.println(Arrays.toString(boardCoords));
        return boardCoords;
    }
}
