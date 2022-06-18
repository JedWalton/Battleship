package battleship.utils;

import battleship.board.Board;

public class ShipPlacer {
    private ShipPlacer() {
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
