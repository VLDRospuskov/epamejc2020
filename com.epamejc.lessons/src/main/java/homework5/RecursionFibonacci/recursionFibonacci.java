package homework5.RecursionFibonacci;

public class recursionFibonacci {

    public int feb(int col) {
        if (col == 0){
            return 0;
        }
        if (col == 1){
            return 1;
        }
        else{
            return feb(col - 1) + feb(col - 2);
        }
    }
}
