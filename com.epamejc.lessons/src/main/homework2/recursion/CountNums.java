package main.homework2.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CountNums {
    public static void main(String[] args) throws IOException {
        CountNums countNums = new CountNums();
        countNums.go();
    }
    public void go() throws IOException {
        String inputNum = "Введите число. Для выхода введите exit.";

        String dataAlert = "Некорректные данные";

        boolean isStop = false;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while(!isStop){
                System.out.println(inputNum);
                String number = reader.readLine();
                isStop = isStoped(number);
                if (!isStop){
                    try{
                        int num = Integer.parseInt(number);
                        num = Math.abs(num);
                        if (num > 0){
                            System.out.println(count(num));
                        } else{
                            System.out.println(dataAlert);
                        }
                    } catch ( Exception ex){
                        System.out.println(dataAlert);
                    }
                }

            }
        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            reader.close();
        }
    }
    private boolean isStoped(String str){
        return str.equals("exit");
    }

    private int count (int num){
        if(num < 10){
            return 1;
        }else{
            return 1 + count(num/10);
        }
    }
}
