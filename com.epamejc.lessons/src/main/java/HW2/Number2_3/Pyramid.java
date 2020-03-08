package HW2.Number2_3;

public class Pyramid {

    StringBuilder builder = new StringBuilder();

    public String pir(int h) {

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h; j++) {

                if (j < h - i) {

                    builder.append('X');
                }
            }
            builder.append(System.getProperty("line.separator"));
        }
        return builder.toString();
    }
}