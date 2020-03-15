package Seabattle;

class HardAIPlayer extends AbstractAIPlayer {
    @Override
    public void requestPlayerName() {
        setName("HardAIPlayer");
    }

    @Override
    protected CellCoordinates cellToShot() {
        CellCoordinates cc;
        do {
            cc = GameField.getRandomCellCoordinates();
        } while (visibleEnemyGameField.getCellState(cc) != CellState.EMPTY);
        return cc;
    }
}