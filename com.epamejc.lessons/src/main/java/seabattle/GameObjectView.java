package seabattle;

public enum GameObjectView {
    UNBROKEN("■"),
    BROKEN("♯"),
    MISS("x"),
    IMPOSSIBLE("▪"),
    EMPTY("☐");
    
    private String state;
    
    GameObjectView(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
}
