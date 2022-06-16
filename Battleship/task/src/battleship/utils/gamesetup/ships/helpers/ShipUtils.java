package battleship.utils.gamesetup.ships;

import java.util.Arrays;
import java.util.Optional;

public class ShipUtils {
    private ShipUtils() {
    }


    static ShipDirection calculateShipDirection(int[] userInput) {
        System.out.println(Arrays.toString(Arrays.stream(userInput).toArray()));
        if(userInput[0] < userInput[2]) {
            return ShipDirection.East;
        }
        return ShipDirection.North;
    }

    static int calculateShipLengthOfUsersInput(int[] userInput) {
        /* horizontal */

        /* vertical */

        /* diagonal */

        return 0;
    }
}
