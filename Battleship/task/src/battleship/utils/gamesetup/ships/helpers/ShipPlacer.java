package battleship.utils.gamesetup.ships;

import battleship.board.Board;

public class ShipPlacer {
    private ShipPlacer() {
    }


    public static Board placeShip(int[] userInput, Board board, int shipLength) {
        ShipDirection shipDir = ShipUtils.calculateShipDirection(userInput);
        if (shipDir.equals(ShipDirection.North)) {
        } else if (shipDir.equals(ShipDirection.NorthEast)) {
        } else if (shipDir.equals(ShipDirection.East)) {
        } else if (shipDir.equals(ShipDirection.SouthEast)) {
        } else if (shipDir.equals(ShipDirection.South)) {
        } else if (shipDir.equals(ShipDirection.SouthWest)) {
        } else if (shipDir.equals(ShipDirection.West)) {
        } else if (shipDir.equals(ShipDirection.NorthWest)) {
        }
        return board;
    }

    private Board addNorthEastShipDirOfShipLength(int[] userInput, Board board, int shipLength) {
        return board;
    }

}

//    private static Board drawHorizontal(int[] userInput, Board board, int shipLength) {
//        if (userInput[1] + 3 < 9) {
//            if(userInput[0] <= 9) {
//                board.board[userInput[0]][userInput[1]] = "0";
//                board.board[userInput[2]][userInput[3]] = "0";
//                board.board[userInput[0]][userInput[1] + 1] = "0";
//                board.board[userInput[0]][userInput[1] + 2] = "0";
//                board.board[userInput[0]][userInput[1] + 3] = "0";
//}
//        } else {
//            System.out.println("Boat not placed.");
//        }
//        return board;
//    }
//
//    private static Board drawVertical(int[] userInput, Board board, int shipLength) {
//        ShipDirection shipDir = ShipUtils.calculateShipDirection(userInput);
//        if (userInput[0] + 3 < 9) {
//            board.board[userInput[0]][userInput[1]] = "0";
//            board.board[userInput[2]][userInput[3]] = "0";
//            board.board[userInput[0] + 1][userInput[1]] = "0";
//            board.board[userInput[0] + 2][userInput[1]] = "0";
//            board.board[userInput[0] + 3][userInput[1]] = "0";
//        } else {
//            System.out.println("Boat not placed.");
//        }
//        return board;
//    }
//
//    private static Board drawDiagonal(int[] userInput, Board board, int shipLength) {
//        ShipDirection shipDir = ShipUtils.calculateShipDirection(userInput);
//        return board;
//    }
//}
