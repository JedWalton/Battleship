package battleship.utils.gamesetup.ships.helpers;

import java.util.Arrays;

public class ShipUtils {
    private ShipUtils() {
    }


    static ShipDirection calculateShipDirection(int[] userInput, int shipLength) {
        if (userInput[0] == userInput[2] - (shipLength - 1) && (userInput[1] == userInput[3])) {
            return ShipDirection.East;
        } else if (userInput[0] == userInput[2] + (shipLength - 1) && (userInput[1] == userInput[3])) {
            return ShipDirection.West;
        } else if (userInput[0] == userInput[2] && (userInput[1] == userInput[3] + (shipLength - 1))) {
            return ShipDirection.North;
        } else if (userInput[0] == userInput[2] && (userInput[1] == userInput[3] - (shipLength - 1))) {
            return ShipDirection.South;
        } else if (userInput[0] == userInput[2] - (shipLength - 1) && (userInput[1] == userInput[3] - (shipLength - 1))) {
            return ShipDirection.SouthEast;
        } else if (userInput[0] == userInput[2] + (shipLength - 1) && (userInput[1] == userInput[3] - (shipLength - 1))) {
            return ShipDirection.SouthWest;
        } else if (userInput[0] == userInput[2] - (shipLength - 1) && (userInput[1] == userInput[3] + (shipLength - 1))) {
            return ShipDirection.NorthEast;
        } else if (userInput[0] == userInput[2] + (shipLength - 1) && (userInput[1] == userInput[3] + (shipLength - 1))) {
            return ShipDirection.NorthWest;
        }
        throw new RuntimeException("You probably want to validate the input bounds first.");
    }

}
