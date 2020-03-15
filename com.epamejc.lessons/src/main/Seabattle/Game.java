package Seabattle;

import java.io.BufferedReader;
import java.io.IOException;

import static Seabattle.OutputFormatter.printColored;

public class Game {

    enum Difficulty {
        EASYPEASY, NORMAL
    }

    enum Mode {
        PVP, PVE
    }

    private Difficulty difficulty;

    void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    Difficulty getDifficulty() {
        return difficulty;
    }

    private Mode mode;

    Mode getMode() {
        return mode;
    }

    void setMode(Mode mode) {
        this.mode = mode;
    }

    public void start(BufferedReader reader) throws IOException {
        UI ui = new UI(reader);
        ui.clearConsole();
        ui.setMode();

        Player player1 = new HoomanPlayer(ui.userInput);
        Player player2;

        switch (mode) {
            case PVP:
                player2 = new HoomanPlayer(ui.userInput);
                break;
            default:
                ui.setDifficulty();
                switch (difficulty) {
                    case EASYPEASY:
                        player2 = new EasyAIPlayer();
                        break;
                    case NORMAL:
                        player2 = new NormalAIPlayer();
                        break;
//                    case HARD:
//                        player2 = new HardAIPlayer();
//                        break;
                    default:
                        player2 = new EasyAIPlayer();
                }
                break;
        }

        player1.setEnemy(player2);
        player2.setEnemy(player1);

        player1.requestPlayerName();
        player1.placeAllShips();

        ui.clearConsole();

        player2.requestPlayerName();
        player2.placeAllShips();

        ui.clearConsole();

        try {
            while (true) {
                if (mode == Mode.PVP) ui.clearConsole();
                player1.turn();
                ui.clearConsole();
                player2.turn();
            }
        } catch (SurrenderedException e) {
            player1.printGameField();
            player2.printGameField();
            printColored(String.format("Игрок %s сдался!", e.player.getName()), OutputFormatter.TextColor.RED);
        } catch (HoomanPlayer.WonException e) {
            player1.printGameField();
            player2.printGameField();
            printColored(String.format("Игрок %s выиграл!", e.player.getName()), OutputFormatter.TextColor.RED);
        }
    }

    private class UI {

        UserInput userInput;

        UI(BufferedReader reader) {
            this.userInput = new UserInput(reader);
        }

        private void setMode() throws IOException {
            printColored("Играть с компьютером?", OutputFormatter.TextColor.YELLOW);
            if (userInput.yes()) Game.this.setMode(Game.Mode.PVE); else Game.this.setMode(Game.Mode.PVP);
        }

        private void setDifficulty() throws IOException {
            printColored("Выберите уровень сложности (easy, normal): ", OutputFormatter.TextColor.YELLOW);
            while(!userInput.gameDifficulty(Game.this));
        }

        private void clearConsole() throws IOException {
            final String os = System.getProperty("os.name");
            try {
                if (os.contains("Windows")) new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                else Runtime.getRuntime().exec("clear");
            } catch (InterruptedException e) {
                throw new Error("Unexpected InterruptedException while cleaning console");
            }
        }
    }
}
