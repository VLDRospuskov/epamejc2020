package homework1;
public class TrafficLight {
    private enum Color{
        GREEN,
        YELLOW,
        RED
    }
    Color lightColor=Color.RED;
    public void setColor(int color) throws IllegalArgumentException{
        if (color<0 ||color>10 ) throw new IllegalArgumentException();
        if (color<=3){
            lightColor=Color.GREEN;
        } else if ( color<=5){
            lightColor=Color.YELLOW;
        } else {
            lightColor=Color.RED;
        }
    }
    public String getColor(){
        return lightColor.name();
    }
}