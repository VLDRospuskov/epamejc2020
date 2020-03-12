package homeworks.java.seabattle.field;

public class Field {

    public final int width = 10;
    public final int height = 10;

    private char[][] cells;

    public int coordinateX = 1;
    public char coordinateY = 'A';

    public Field(){
        cells = new char[height][width];
        draw();
    }

    public void draw(){

        System.out.print("   ");
        for(int i = 0; i < 10; i++){
            System.out.print(coordinateY++ + " ");
        }
        System.out.println();

        for(int y = 0; y < height; y++){
            if(coordinateX < height) {
                System.out.print(coordinateX++ + " |");
            } else {
                System.out.print(coordinateX++ + "|");
            }
            for(int x = 0; x < width; x++){
                cells[x][y] = '_';
                System.out.print(cells[x][y]);
                System.out.print('|');
            }
            System.out.println();
        }
    }
}
