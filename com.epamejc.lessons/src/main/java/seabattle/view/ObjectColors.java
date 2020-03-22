package seabattle.view;

public enum ObjectColors {
    UNBROKEN_SYMBOL("■"),
    BROKEN_SYMBOL("⃝"),
    MISS_SYMBOL("x"),
    ANSI_YELLOW_UNBROKEN("\u001B[33m"),
    ANSI_RED_BROKEN("\u001B[31m"),
    ANSI_PURPLE_MISS("\u001B[35m"),
    ANSI_RESET("\u001B[0m");
    
    private String state;
    
    ObjectColors(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
}
