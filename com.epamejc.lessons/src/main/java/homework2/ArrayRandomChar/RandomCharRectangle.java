package homework2.ArrayRandomChar;

import java.util.Random;

public class RandomCharRectangle {
    public String buildRectangle(int height,int width) {
        Random r = new Random();
        StringBuilder out = new StringBuilder();
        char[][] arr = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = (char) (r.nextInt(94) + 33);
                out.append(arr[i][j]).append(" ");
            }
            out = new StringBuilder("\r\n");
        }
        return out.toString();

    }
}
