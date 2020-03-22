package seabattle.players;


import java.util.Set;

class Ship {

    Set<Integer[][]> navy;

    Integer[][] fourDeckShip = new Integer[4][2];
    Integer[][] threeDeckShip1 = new Integer[3][2];
    Integer[][] threeDeckShip2 = new Integer[3][2];
    Integer[][] twoDeckShip1 = new Integer[2][2];
    Integer[][] twoDeckShip2 = new Integer[2][2];
    Integer[][] twoDeckShip3 = new Integer[2][2];
    Integer[][] oneDeckShip1 = new Integer[1][2];
    Integer[][] oneDeckShip2 = new Integer[1][2];
    Integer[][] oneDeckShip3 = new Integer[1][2];
    Integer[][] oneDeckShip4 = new Integer[1][2];

    public Ship(Set<Integer[][]> navy) {
        this.navy = navy;
        createNavy();
    }

    void createNavy() {
        navy.add(fourDeckShip);
        navy.add(threeDeckShip1);
        navy.add(threeDeckShip2);
        navy.add(twoDeckShip1);
        navy.add(twoDeckShip2);
        navy.add(twoDeckShip3);
        navy.add(oneDeckShip1);
        navy.add(oneDeckShip2);
        navy.add(oneDeckShip3);
        navy.add(oneDeckShip4);
    }


    static boolean putShipCheck(Integer[][] ship, String route) {
        int border;

        switch (route) {
            case "up":
                border = ship[0][0] - ship.length;
                break;
            case "down":
                border = ship[0][0] + ship.length;
                break;
            case "right":
                border = ship[0][1] + ship.length;
                break;
            case "left":
                border = ship[0][1] - ship.length;
                break;
            default:
                return false;
        }
        return (border >= 0 && border <= 10);
    }


    static Integer[][] createShip(Integer[][] ship, String route) {
        if (route.equals("up")) {
            for (int i = 1; i < ship.length; i++) {
                ship[i][0] = ship[0][0] - i;
                ship[i][1] = ship[0][1];
            }
        }
        if (route.equals("down")) {
            for (int i = 1; i < ship.length; i++) {
                ship[i][0] = ship[0][0] + i;
                ship[i][1] = ship[0][1];
            }
        }
        if (route.equals("right")) {
            for (int i = 1; i < ship.length; i++) {
                ship[i][0] = ship[0][0];
                ship[i][1] = ship[0][1] + i;
            }
        }
        if (route.equals("left")) {
            for (int i = 1; i < ship.length; i++) {
                ship[i][0] = ship[0][0];
                ship[i][1] = ship[0][1] - i;
            }
        }
        return ship;
    }
}

