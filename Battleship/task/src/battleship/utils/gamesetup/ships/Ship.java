package battleship.utils.gamesetup.ships;

import battleship.board.Board;
import battleship.utils.UserInput;
import battleship.utils.gamesetup.ships.helpers.ShipPlacementValidation;
import battleship.utils.gamesetup.ships.helpers.ShipPlacer;

public class Ship implements PlacementOfShips {


    /* Method to check get user input and check if it is valid.
    If valid, place on the board. If not sout error message and retry */
    public static Board placeShipOnBoard(Board board, int shipLength) {

        int[] userInput = UserInput.getUserInput();

        if(ShipPlacementValidation.isValidShipPlacement(userInput, board, shipLength)) {
            ShipPlacer.placeShip(userInput, board, shipLength);
        }
        
        return board;
    }

}
