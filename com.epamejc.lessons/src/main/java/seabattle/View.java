package seabattle;

import java.util.Arrays;

public class View {
    
    private String[][] textView = new String[10][10];
    private String[] names = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    
    public View() {
        for (String[] strings : textView) {
            Arrays.fill(strings, GameObjectView.EMPTY.getState());
        }
    }
    
    public void printField(Field field) {
        eraseData();
        updateFieldView(field);
        System.out.print("\t");
        for (String name : names) {
            System.out.print(name + "\t");
        }
        System.out.println();
        for (int i = 0; i < textView.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < textView[i].length; j++) {
                System.out.print(textView[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }
    
    public void updateFieldView(Field field) {
        updateShipView(field);
        updateAssistantView(field);
        updateShotsView(field);
        updateMissesView(field);
        //update();
        //printField(field);
    }
    
    private void eraseData() {
        for (String[] strings : textView) {
            Arrays.fill(strings, GameObjectView.EMPTY.getState());
        }
    }
    
    private void updateMissesView(Field field) {
        for (Miss miss : field.misses) {
            textView[miss.getCoordinate()
                         .getY()][miss.getCoordinate()
                                      .getX()] = GameObjectView.MISS.getState();
            
        }
    }
    
    private void updateShipView(Field field) {
        for (Ship ship :
                field.ships) {
            for (Coordinate coordinate :
                    ship.getShipParts()) {
                textView[coordinate.getY()][coordinate.getX()] = GameObjectView.UNBROKEN.getState();
            }
        }
    }
    
    private void updateAssistantView(Field field) {
        for (Assist assist : field.assistSet) {
            textView[assist.getAssistPoint()
                           .getY()][assist.getAssistPoint()
                                          .getX()] = GameObjectView.IMPOSSIBLE.getState();
            
        }
    }
    
    private void updateShotsView(Field field) {
        for (Shot shot :
                field.shots) {
            textView[shot.getCoordinate()
                         .getY()][shot.getCoordinate()
                                      .getX()] = GameObjectView.BROKEN.getState();
        }
    }
    
}
