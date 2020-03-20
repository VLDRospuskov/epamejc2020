package seabattle;

import java.util.Arrays;

public class View {
    
    private String[][] textView = new String[10][10];
    private String[] names = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    //private String[][] opponentsTextView = new String[10][10];
    
    public View() {
        for (String[] strings : textView) {
            Arrays.fill(strings, GameObjectView.EMPTY.getState());
        }
    }
    
    public void printField(Field field) {
        eraseData();
        updateFieldView(field);
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

//    public void printOpponentsField(Field field){
//        System.out.print("\t");
//        for (int i = 0; i < names.length; i++) {
//            System.out.print(names[i] + "\t");
//        }
//        System.out.println();
//        for (int i = 0; i < opponentsTextView.length; i++) {
//            System.out.print((i + 1) + "\t");
//            for (int j = 0; j < opponentsTextView[i].length; j++) {
//                System.out.print(opponentsTextView[i][j] + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println("\n\n");
//    }
    
    public void updateFieldView(Field field) {
        updateShipView(field);
        updateAssistantView(field);
        updateShotsView(field);
        updateMissesView(field);
        //update();
        //printField(field);
    }
    
    public void eraseData() {
        for (String[] strings : textView) {
            Arrays.fill(strings, GameObjectView.EMPTY.getState());
        }
    }
    
    private void updateMissesView(Field field) {
        for (Miss miss : field.getMisses()) {
            textView[miss.getCoordinate()
                         .getY()][miss.getCoordinate()
                                      .getX()] = GameObjectView.MISS.getState();
            
        }
    }

//    public void updateOpponentsFieldView(Field field){
//        updateAssistantView(field);
//        updateShotsView(field);
//    }
    
    private void updateShipView(Field field) {
        for (Ship ship :
                field.getShips()) {
            for (Coordinate coordinate :
                    ship.getShipParts()) {
                textView[coordinate.getY()][coordinate.getX()] = GameObjectView.UNBROKEN.getState();
            }
        }
    }
    
    private void updateAssistantView(Field field) {
        for (Assist assist : field.getAssistSet()) {
            textView[assist.getAssistPoint()
                           .getY()][assist.getAssistPoint()
                                          .getX()] = GameObjectView.IMPOSSIBLE.getState();
            
        }
    }
    
    private void updateShotsView(Field field) {
        for (Shot shot :
                field.getShots()) {
            textView[shot.coordinate.getY()][shot.coordinate.getX()] = GameObjectView.BROKEN.getState();
        }
    }
    
}
