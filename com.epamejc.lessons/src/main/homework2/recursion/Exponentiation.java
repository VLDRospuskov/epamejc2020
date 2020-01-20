package main.homework2.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exponentiation {

    public static void main(String[] args) throws IOException {
        Exponentiation exp = new Exponentiation();
        exp.go();
    }
    public void go() throws IOException {
        String inputNum = "Введите число. Для выхода введите exit.";

        String inputPow = "Введите число. Для выхода введите exit.";

        String dataAlert = "Некорректные данные";

        boolean isStop = false;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while(!isStop){
                System.out.println(inputNum);
                String number = reader.readLine();

                isStop = isStoped(number);
                if (isStop){
                    break;
                }

                System.out.println(inputPow);
                String exp = reader.readLine();

                isStop = isStoped(number);

                if (!isStop){
                    try{

                        double num = Double.parseDouble(number);
                        int pow = Integer.parseInt(exp);

                        if (pow > 0){
                            System.out.println(exponent(num,pow));
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
    private double exponent(double num,int pow){
        if(pow == 1){

            return num;

        } else{
            double result = 0;

            result = num + exponent(num,pow-1);

            return result;
        }
    }
}
