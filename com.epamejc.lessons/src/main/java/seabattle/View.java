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
        System.out.print("\t");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + "\t");
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
        //printField(field);
    }
    
    public void updateShipView(Field field) {
        for (Ship ship :
                field.getShips()) {
            for (Coordinate coordinate :
                    ship.getShipParts()) {
                textView[coordinate.getY()][coordinate.getX()] = GameObjectView.UNBROKEN.getState();
            }
        }
    }
    
    public void updateAssistantView(Field field) {
        for (Assist assist : field.getAssistSet()) {
            textView[assist.getAssistPoint()
                           .getY()][assist.getAssistPoint()
                                          .getX()] = GameObjectView.IMPOSSIBLE.getState();
            
        }
    }
    
    public void updateShotsView(Field field) {
        // TODO: 16-Mar-20 Отображение выстрелов на поле
    }
    
}
