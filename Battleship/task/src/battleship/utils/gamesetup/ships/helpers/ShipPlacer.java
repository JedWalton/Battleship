package battleship.utils.gamesetup.ships.helpers;

import battleship.board.Board;

public class ShipPlacer {
    private ShipPlacer() {
    }


    /* This method is only called once we move is validated. */
    public static Board placeShip(int[] userInput, Board board, int shipLength) {
        ShipDirection shipDir = ShipUtils.calculateShipDirection(userInput, shipLength);

        /* Board is Y X and NOT X Y */
//        board.board[userInput[1]][userInput[0]]="0";


        if (shipDir.equals(ShipDirection.North)) {
            placeShipNorth(userInput, board, shipLength);
        } else if (shipDir.equals(ShipDirection.NorthEast)) {
        } else if (shipDir.equals(ShipDirection.East)) {
//            ShipPlacer.placeShip(userInput,board,shipLength);
        } else if (shipDir.equals(ShipDirection.SouthEast)) {
        } else if (shipDir.equals(ShipDirection.South)) {
        } else if (shipDir.equals(ShipDirection.SouthWest)) {
        } else if (shipDir.equals(ShipDirection.West)) {
        } else if (shipDir.equals(ShipDirection.NorthWest)) {
        }
        return board;
    }

    private static Board placeShipNorth(int[] userInput, Board board, int shipLength) {
        for (int i = 0; i < shipLength; i++) {
            if (!board.board[userInput[1] - i][userInput[0]].equals("~")) {
                return board;
            }
        }
        for (int i = 0; i < shipLength; i++) {
            board.board[userInput[1] - i][userInput[0]] = "0";
        }
//        board.displayBoard();
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
