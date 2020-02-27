package homework.Annotations;

public class Main {
    public static void main(String[] args){
        try {
            Annotated annotated = new Annotated();
            System.out.println(annotated);
        } catch (NoSuchMethodException e){
            System.err.println(e.getMessage());
        }
    }
}
