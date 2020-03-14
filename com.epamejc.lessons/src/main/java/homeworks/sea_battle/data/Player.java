package homeworks.sea_battle.data;

import homeworks.sea_battle.commands.PlayerShootingCommands;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Data
public class Player {

    private String name;

    private Field playerField;

    private ArrayList<Ship> playerShips;

    private PlayerShootingCommands shootingCommands;

    private Set<Coordinates> madeShots;

    private boolean isWin;

    private Field opponentField;

    private Coordinates prevHit;

    private Ship lastHitShip;

    public Player(String name, PlayerShootingCommands shootingCommands) {
        this.name = name;
        this.shootingCommands = shootingCommands;
        this.playerField = new Field();
        this.playerShips = new ArrayList<>();
        this.madeShots = new HashSet<>();
        this.isWin = false;
        this.opponentField = new Field();
    }

}
