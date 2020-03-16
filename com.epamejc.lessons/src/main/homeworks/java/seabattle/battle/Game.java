package homeworks.java.seabattle.battle;

import homeworks.java.seabattle.input.GameState;
import homeworks.java.seabattle.player.BasePlayer;
import homeworks.java.seabattle.player.Player;

public class Game {

    private GameState gameState;
    private BasePlayer[] players;
    private int currentIndex;
    private boolean gameOver;

    public Game(){
        this.gameState = GameState.SETUP;
        this.players = new BasePlayer[2];
        this.players[0] = new Player(this);
        this.players[1] = new BasePlayer(this); //BotPlayer
        this.currentIndex = 0;
        this.gameOver = false;
    }

    public void setGameOverTrue(){
        this.gameOver = true;
    }

    public GameState getState(){
        return gameState;
    }

    public BasePlayer getBasePlayer() {
        return players[1];
    }

    public BasePlayer getPlayer() {
        return players[0];
    }

    private void nextStep(){
        currentIndex++;

        if(currentIndex >= players.length){
            currentIndex = 0;
        }
    }

    public void process(){
        if(gameState != GameState.BATTLE &&
                players[0].isFieldFilled() &&
                players[1].isFieldFilled()){
            gameState = GameState.BATTLE;
        }
        players[currentIndex].process(currentIndex);
        nextStep();
    }

    public boolean isGameOver(){
        return gameOver;
    }
}
