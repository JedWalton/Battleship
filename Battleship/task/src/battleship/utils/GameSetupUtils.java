package battleship.utils;

import java.util.Scanner;

public class GameSetupUtils {
    private GameSetupUtils() {

    }

    private static String getShipCoordinatesFromUser() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    private static void placeAircraftCarrier() {
        getShipCoordinatesFromUser();
    }

    private static void placeBattleship() {
    }

    private static void placeSubmarine() {
    }

    private static void placeCruiser() {

    }

    private static void placeDestroyer() {

    }

    public static void placeShipsOnBoard() {
        placeAircraftCarrier();
        placeBattleship();
        placeSubmarine();
        placeCruiser();
        placeDestroyer();
    }
}
