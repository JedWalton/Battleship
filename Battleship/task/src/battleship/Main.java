package battleship;


import javax.management.relation.RoleNotFoundException;

public class Main {

    public static void main(String[] args) {
        GameInstance battleship = new GameInstance();
        battleship.startGame();
    }
}
