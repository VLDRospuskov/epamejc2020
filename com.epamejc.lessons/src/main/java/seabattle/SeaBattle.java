package seabattle;

import java.util.ArrayList;

public class SeaBattle {
    private ArrayList<User> Users = new ArrayList<>();

    public void run() {
        Users.add(new User());
        Users.add(new User());
        addShips();
        startGame();
    }

    private void startGame() {
        boolean allShipsDead = false;
        int queue = 0;
        while (!allShipsDead) {
            int enemy = Math.abs(queue - 1);
            System.out.println("Player move number: " + (queue + 1));
            int x = new ReadCommands().readCom("Enter x:");
            int y = new ReadCommands().readCom("Enter y:");

            if ((Users.get(queue).inPole(x, y)) && (Users.get(enemy).isHit(x, y))) {
                System.out.println("Hit!");
                Users.get(queue).addEnemyPartShipToPole(x, y);
                if (Users.get(enemy).isDead(x, y)) {
                    Users.get(queue).addEnemyShipToPole(Users.get(enemy).getShipCoordinates(x, y));
                    System.out.println("Ship Dead");
                    if (Users.get(enemy).isEnemyWin()) {
                        System.out.println("User" + (queue + 1) + " WIN!");
                        allShipsDead = true;
                    }
                }
            } else {
                Users.get(queue).hitPass(x, y);
                System.out.println("Hit Pass");
                queue = enemy;
            }
            System.out.println("Player's" + (enemy + 1) + " field.");
            Users.get(queue).printEnemyPole();
        }

    }

    private void addShips() {
        boolean allShipsDelivered = false;
        int queue = 0;
        while (!allShipsDelivered) {
            int type = new ReadCommands().readCom("Enter type:");
            int x1 = new ReadCommands().readCom("Enter x1:");
            int y1 = new ReadCommands().readCom("Enter y1:");
            int x2 = new ReadCommands().readCom("Enter x2:");
            int y2 = new ReadCommands().readCom("Enter y2:");

            if (Users.get(queue).addShip(type, x1, y1, x2, y2)) {
                Users.get(queue).ShipSet(type);
                System.out.println("Ship Added!");
                if (Users.get(queue).isAllShipOnDesk()) {
                    if (queue == 0) {
                        queue++;
                        System.out.println("Player move number: " + (queue + 1));
                    } else {
                        allShipsDelivered = true;
                    }
                }
            } else {
                System.out.println("err");
            }
        }
    }
}
