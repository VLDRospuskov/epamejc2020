package seabattle;

import static seabattle.ObjectColors.*;

public enum GameObjectView {
    UNBROKEN(ANSI_YELLOW_UNBROKEN.getState() + UNBROKEN_SYMBOL.getState() + ANSI_RESET.getState()),
    BROKEN(ANSI_RED_BROKEN.getState() + BROKEN_SYMBOL.getState() + ANSI_RESET.getState()),
    MISS(ANSI_PURPLE_MISS.getState() + MISS_SYMBOL.getState() + ANSI_RESET.getState()),
    IMPOSSIBLE("▪"),
    EMPTY("☐");
    
    private String state;
    
    GameObjectView(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
    
}
