package seabattle;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<User> Users = new ArrayList<>();
        Users.add(new User());
        Users.add(new User());
        //add ships
        boolean allShipsDelivered = false;
        int queue = 0;
        while (!allShipsDelivered) {
            System.out.println("Enter type:");
            int type = new readCom().readCom();
            System.out.println("Enter x1:");
            int x1 = new readCom().readCom();
            System.out.println("Enter y1:");
            int y1 = new readCom().readCom();
            System.out.println("Enter x2:");
            int x2 = new readCom().readCom();
            System.out.println("Enter y2:");
            int y2 = new readCom().readCom();
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
        //game start
        boolean allShipsDead = false;
        queue = 0;
        while (!allShipsDead) {
            int enemy = Math.abs(queue - 1);
            System.out.println("Player move number: " + (queue + 1));
            System.out.println("Enter x:");
            int x = new readCom().readCom();
            System.out.println("Enter y:");
            int y = new readCom().readCom();
            if ((Users.get(queue).inPole(x,y))&&(Users.get(enemy).isHit(x, y))) {
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
            System.out.println("Player's"+(enemy+1)+ " field.");
            Users.get(queue).printEnemyPole();
        }
    }

}
class readCom{
    // todo сделать проверку введены целые цифры в диапозоне действия инта
    public  int readCom() {
        Scanner in = new Scanner(System.in);
       
        return Integer.parseInt(in.nextLine());
    }
    void parsCommand(){}//todo Сделать метод который будет парсть команды !!!!мб не надо!!!
}

