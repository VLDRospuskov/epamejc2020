package main.homework2.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeWord {
    public static void main(String[] args) throws IOException {
        MakeWord makeWord = new MakeWord();
        makeWord.go();
    }
    public void go() throws IOException {

        String start = "Введите слово";

        String exit = "exit";

        String next = "next";

        String writeIndex = "Введите индекс. Для выхода введи \"exit\"";

        String result = "";

        String indexAlert1 = "Введенное число вне диапазона";

        String indexAlert2 = "Некорректные данные";

        System.out.println(start);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String word = reader.readLine();

            boolean stop = false;

            if (word.length()>0){
                while(!stop){
                    System.out.println(writeIndex);
                    String str = reader.readLine();

                    if (str.equals(exit)){
                        stop = true;
                    }else if(str.equals(next)){
                        System.out.println(start);
                        result = "";
                        word = reader.readLine();
                    }else{
                        try {
                            int index = Integer.parseInt(str);
                            if (0 <= index && index < word.length()){
                                result += word.charAt(index);
                                System.out.println(result);
                            } else{
                                System.out.println(indexAlert1);
                            }
                        } catch (Exception ex){
                            System.out.println(indexAlert2);
                        }
                    }
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            reader.close();
        }

    }

}
