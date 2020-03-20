package homeworks.seabatle.controller;


import homeworks.seabatle.exception.IncorrectRequestException;
import homeworks.seabatle.model.board.Field;
import homeworks.seabatle.model.board.GameBoard;
import homeworks.seabatle.model.board.PlayerShipsRepository;
import homeworks.seabatle.model.board.ShipsRepository;
import homeworks.seabatle.model.players.Computer;
import homeworks.seabatle.model.players.Player;
import homeworks.seabatle.model.players.User;
import homeworks.seabatle.model.ship.Ship;
import homeworks.seabatle.myenum.GameMode;
import homeworks.seabatle.myenum.ShipType;
import homeworks.seabatle.myenum.StrikeResult;
import homeworks.seabatle.servises.factories.ShipAutoGenerator;
import homeworks.seabatle.servises.factories.ShipFactory;
import homeworks.seabatle.servises.locationservice.LocationService;
import homeworks.seabatle.servises.locationservice.LocationServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

import static homeworks.seabatle.myenum.GameMode.MULTIPLAYER;
import static homeworks.seabatle.myenum.GameMode.SINGLEPLAYER;

public class GameController {
    private Player playerOne;
    private Player playerTwo;
    private GameBoard gameBoard;
    private GameMode gameMode;
    private static final String AUTO = "auto";
    private static final String MANUAL = "manual";

    /**
     * method that get user request, parse them and if the request is valid sets game mode
     *
     * @param reader input stream
     * @return information , about what mode was chosen
     */
    public String chooseMode(BufferedReader reader) {
        System.out.println("Choose mode singleplayer/multiplayer");
        boolean isAllrite = false;
        String result = "";
        while (!isAllrite) {
            try {
                result = reader.readLine();
                if (result.equals(SINGLEPLAYER.toString().toLowerCase())) {
                    gameMode = SINGLEPLAYER;
                    isAllrite = true;
                } else if (result.equals(MULTIPLAYER.toString().toLowerCase())) {
                    gameMode = MULTIPLAYER;
                    isAllrite = true;
                } else {
                    System.out.println("There is no such mode");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IncorrectRequestException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return String.format("You chose %s mode", result);
    }

    /**
     * method sets players names. Default name for Computer is "Computer"
     *
     * @param reader input stream
     * @return
     */
    public String nameUsers(BufferedReader reader) {
        playerOne = new User();
        playerTwo = getPlayerTwo();
        playerOne.setName(chooseName(reader));
        if (playerTwo instanceof User) {
            playerTwo.setName(chooseName(reader));
        }
        return String.format("Hello %s! Hello %s!", playerOne.getName(), playerTwo.getName());
    }

    /**
     * method creates GameBoard from two players and there fields
     *
     * @param reader input stream
     * @return visual information of board creation
     */
    public String createGameBoard(BufferedReader reader) {
        ShipsRepository pOneShipsRep = generateField(playerOne, reader);
        ShipsRepository pTwoShipsRep = generateField(playerTwo, reader);
        Field playerOneField = new Field(pOneShipsRep);
        playerOne.setField(playerOneField);
        Field playerTwoField = new Field(pTwoShipsRep);
        playerTwo.setField(playerTwoField);
        gameBoard = new GameBoard(playerOne, playerTwo);
        return "Game Board is created!";
    }

    /**
     * @return visual information of GameBoard condition
     */
    public String printBattleField() {
        return gameBoard.printBattlefield();
    }

    /**
     * @param reader input stream
     * @param speed  contains time that thread need to sleep. For tests time = 0, for game time = 1000. param is made
     *               for comfortable visualisation, when computer wounds ship twice or more
     * @return result of the game
     */
    public String runBattle(BufferedReader reader, int speed) {
        boolean pOneWin = false;
        boolean pTwoWin = false;
        while (!pOneWin && !pTwoWin) {
            pOneWin = shoot(playerOne, playerTwo, reader, speed);
            if (!pOneWin) {
                pTwoWin = shoot(playerTwo, playerOne, reader, speed);
            }
        }
        if (pOneWin) {
            return declareResult(playerOne.getName());
        } else {
            return declareResult(playerTwo.getName());
        }
    }

    /**
     * @return instance of second player depends of chosen game mode
     */
    private Player getPlayerTwo() {
        Player player = null;
        switch (gameMode) {
            case SINGLEPLAYER:
                player = new Computer();
                break;
            case MULTIPLAYER:
                player = new User();
                break;
        }
        return player;
    }

    /**
     * @param reader input stream
     * @return players name
     */
    private String chooseName(BufferedReader reader) {
        boolean isAlright = false;
        String name = null;
        while (!isAlright) {
            try {
                System.out.println("Write your name");
                name = reader.readLine();
                if (!name.equals("") && name.equals("Computer")) {
                    System.out.println("You can't take this name. Only me can be Computer");
                } else if (!name.equals("")) {
                    isAlright = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IncorrectRequestException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return name;
    }

    /**
     * method that choose strategy of ship placement depends on user choice
     *
     * @param player instance of Player
     * @param reader input stream
     * @return created ships repository
     */
    private ShipsRepository generateField(Player player, BufferedReader reader) {
        ShipsRepository repository;
        System.out.println(String.format("%s now let's generate your field", player.getName()));
        ShipAutoGenerator generator = new ShipAutoGenerator();
        if (player instanceof Computer) {
            repository = generator.getGeneratedRepository();
        } else {
            String regime = chooseGenerateType(reader);
            if (regime.equals(AUTO)) {
                repository = generator.getGeneratedRepository();
            } else {
                repository = getRepository(reader);
            }
        }
        return repository;
    }

    /**
     * depends on user choice method choose ships placement strategy
     *
     * @param reader input stream
     * @return strategy
     */
    private String chooseGenerateType(BufferedReader reader) {
        System.out.println("Choose factories regime auto/manual");
        boolean isAllrite = false;
        String mode = "";
        while (!isAllrite) {
            try {
                mode = reader.readLine();
                if (mode.equals(AUTO) || mode.equals(MANUAL)) {
                    isAllrite = true;
                } else {
                    System.out.println("there is no such mode");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format("You chose %s mode", mode));
        return mode;
    }

    /**
     * if user chose manual strategy this method creates ship repository
     *
     * @param reader input stream
     * @return instance of ShipsRepository
     */
    private ShipsRepository getRepository(BufferedReader reader) {
        ShipsRepository repository = new PlayerShipsRepository();
        System.out.println("From north to south field coordinates are from \"A\" to \"J\"");
        System.out.println("From west to east field coordinates are from \"1\" to \"10\"");
        for (ShipType type : ShipType.values()) {
            for (int i = 0; i < type.ordinal() + 1; i++) {
                addShip(type, repository, reader);
            }
        }
        return repository;
    }

    /**
     * method get user request, parse it in location service and try to add ship to repository,
     * if repository contains ship, that in zone of created in method, all the steps are repeated
     *
     * @param type       enum type of Ship
     * @param repository ship add to this repository
     * @param reader     input stream
     */
    private void addShip(ShipType type, ShipsRepository repository, BufferedReader reader) {
        boolean isLocated = false;
        ShipFactory factory = new ShipFactory();
        Ship ship = factory.getShip(type);
        while (!isLocated) {
            printShipAdvice(type);
            try {
                LocationService service = new LocationServiceImpl();
                ship.setCoords(service.getCoordinates(reader.readLine()));
                System.out.println(repository.addShip(ship));
                isLocated = true;
            } catch (IncorrectRequestException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * alert, shown to player before the ship creation
     *
     * @param type enum ShipType
     */
    private void printShipAdvice(ShipType type) {
        System.out.println(String.format("%s is creating", type));
        String form = "Please write coordinates in format";
        String size = "ship length =";
        switch (type){
            case BOAT:
                System.out.printf("%s \"A1 or J10\", %s 1 \n",form,size);
                break;
            case DESTROYER:
                System.out.printf("%s \"A1 A2\" or \"D5 E5\", %s 2 \n", form,size);
                break;
            case CRUISER:
                System.out.printf("%s \"A1 A3\" or \"E5 G5\", %s 3 \n", form,size);
                break;
            case BATTLESHIP:
                System.out.printf("%s \"A1 A4\" or \"E5 H5\", %s 4 \n", form,size);
                break;
        }
    }

    /**
     * @param name - name of the winner
     * @return end game message
     */
    private String declareResult(String name) {
        return String.format("Game Over \n%s is a winner!!! Congratulations, admiral!", name);
    }

    /**
     * @param player   - player, who make strike
     * @param defender - player, who defends
     * @param reader   - input stream
     * @param speed    - contains time that thread need to sleep. For tests time = 0, for game time = 1000. param is made
     *                 * for comfortable visualisation, when computer wounds ship twice or more
     * @return if player kills the last ship of the defender returns true in other case return false
     */
    private boolean shoot(Player player, Player defender, BufferedReader reader, int speed) {
        boolean shooting = true;
        StrikeResult strikeResult1 = null;
        while (shooting) {
            System.out.println(String.format("%s write your choice", player.getName()));
            try {
                if (player instanceof User) {
                    strikeResult1 = gameBoard.getPlayerStrikeResult(reader.readLine(), defender);
                } else {
                    strikeResult1 = gameBoard.getPlayerStrikeResult(((Computer) player).shoot(), defender);
                    ((Computer) player).notifyShootResult(strikeResult1);
                    Thread.sleep(speed);
                }
                System.out.print(String.format("%s\n", strikeResult1.getDescription()));
                Thread.sleep(speed);
                System.out.println(gameBoard.printBattlefield());
                shooting = strikeResult1.equals(StrikeResult.WOUND) || strikeResult1.equals(StrikeResult.KILL)
                        || strikeResult1.equals(StrikeResult.SHOOT);
            } catch (IncorrectRequestException e) {
                System.out.println(e.getMessage());
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
        return strikeResult1.equals(StrikeResult.LOSE);
    }

}
