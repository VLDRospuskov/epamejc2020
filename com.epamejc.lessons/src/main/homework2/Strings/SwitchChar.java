package main.homework2.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwitchChar {
    private String word = null;

    public static void main(String[] args) throws IOException{
        SwitchChar switchChar = new SwitchChar();
        switchChar.work();
    }

    public void work() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String start = "Введите слово";

        String exit = "exit";

        String next = "next";

        String writeIndex1 = "Введите индекс1";

        String writeIndex2 = "Введите индекс2. Для выхода введи \"exit\" . Чтобы сменить слово введи \"next\"";

        String indexAlert2 = "Некорректные данные";

        String indexAlert1 = "Индексы вне диапазона";

        boolean stop = false;

        try {
            System.out.println(start);
            word = reader.readLine();
            if(word.length()>0){
              while (!stop){
                  System.out.println(writeIndex1);
                  String ind1Str = reader.readLine();
                  System.out.println(writeIndex2);
                  String ind2Str = reader.readLine();
                  if(ind2Str.equals(exit)){
                     stop = true;
                  } else if (ind2Str.equals(next)){
                      System.out.println(start);
                      word = reader.readLine();
                  } else {
                      try{
                          int index1 = Integer.parseInt(ind1Str);
                          int index2 = Integer.parseInt(ind2Str);
                          if (0 <= index1 && index1 < word.length() && 0 <= index2 && index2 < word.length()) {
                              System.out.println(changeWords(index1,index2));
                          } else {
                              System.out.println(indexAlert1);
                          }
                      }catch (Exception ex){
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
    public String changeWords(int index1, int index2){
        String first = word.substring(index1,index1+1);
        String second = word.substring(index2,index2+1);
        String result = "";
        for (int i = 0; i < word.length(); i++){
            if(i == index1){
                result += second;
            } else if(i == index2){
                result += first;
            } else {
                result += word.substring(i,i+1);
            }
        }

        return result;
    }
}

