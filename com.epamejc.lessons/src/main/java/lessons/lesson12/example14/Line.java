package lessons.lesson12.example14;

public class Line implements java.io.Serializable {
    
    private Point point1;
    private Point point2;
    private int index;
    
    public Line() {
        System.out.println("Constructing empty line");
    }
    
    Line(Point p1, Point p2, int index) {
        System.out.println("Constructing line: "
                           + index);
        this.point1 = p1;
        this.point2 = p2;
        this.index = index;
    }
    
    public int getIndex() {
        return index;
    }
    
    public void setIndex(int newIndex) {
        index = newIndex;
    }
    
    public void printInfo() {
        System.out.println("Line: " + index);
        System.out.println(" Object reference: "
                           + super.toString());
        System.out.println(" from point "
                           + point1);
        System.out.println(" to point "
                           + point2);
    }
    
}
