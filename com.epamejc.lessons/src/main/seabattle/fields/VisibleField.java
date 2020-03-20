package main.seabattle.fields;

public class VisibleField extends Field {

    public void attackClear(int i, int j, boolean hit) {
        if (hit) {
            arr[i][j] = got;
        } else arr[i][j] = away;
    }

}
