package battleship.utils;

import battleship.board.Board;

import javax.management.relation.RoleNotFoundException;
import java.util.Arrays;

public class GameSetupUtils {
    private GameSetupUtils() {

    }

    public static Board placeAllShipsOnBoard(Board board) throws RoleNotFoundException {
        board.displayBoard();
        placeAircraftCarrierMessage();
        board = setupShip(board, 5);
//        board.displayBoard();
//        placeBattleshipMessage();
//        Ship.placeShipOnBoard(board, 4);
//        board.displayBoard();
//        placeSubmarineMessage();
//        Ship.placeShipOnBoard(board, 3);
//        board.displayBoard();
//        placeCruiserMessage();
//        Ship.placeShipOnBoard(board, 2);
//        board.displayBoard();
//        placeDestroyerMessage();
//        Ship.placeShipOnBoard(board, 2);
        return board;
    }

    private static Board setupShip(Board board, int i) throws RoleNotFoundException {
        int[] BoardCoordsX1Y1X2Y2 = UserInput.getValidUserInput(board, i);
        System.out.println(Arrays.toString(BoardCoordsX1Y1X2Y2));
        return board;
    }

    private static void placeAircraftCarrierMessage() {
        System.out.println();
        System.out.println();
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
    }

    private static void placeBattleshipMessage() {
        System.out.println();
        System.out.println();
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
    }

    private static void placeSubmarineMessage() {
        System.out.println();
        System.out.println();
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
    }

    private static void placeCruiserMessage() {
        System.out.println();
        System.out.println();
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
    }

    private static void placeDestroyerMessage() {
        System.out.println();
        System.out.println();
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
    }}
