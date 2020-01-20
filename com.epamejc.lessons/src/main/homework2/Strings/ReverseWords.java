package main.homework2.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWords {
    public static void main(String[] args) throws IOException {
        ReverseWords reverseWords = new ReverseWords();
        reverseWords.go();
    }
    public void go() throws IOException {
        String start = "Введите строку. Для выхода введите exit";

        String ind = "Введите номер(от 1) слова, которое хотите отразить зеркально. Чтобы ввести строку заново введите next, для выхода exit";

        String indexalert = "Некорректные данные";

        String exit = "exit";

        String next = "next";

        String index ="";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isStop = false;
        try {
            System.out.println(start);
            String str = reader.readLine();

            while(!isStop){
                if (str.equals(exit)){
                    isStop = true;
                } else if(str.equals(next)){
                    System.out.println(start);
                    str = reader.readLine();
                }
                if (index.equals(exit)){
                    isStop = true;
                } else if(index.equals(next)){
                    System.out.println(start);
                    str = reader.readLine();
                } else {

                    try{
                        index = reader.readLine();
                        int num = Integer.parseInt(index);
                        str = changeStr(str,num);
                        System.out.println(str);
                    } catch (Exception ex) {
                        System.out.println(indexalert);
                    }
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            reader.close();
        }

    }
    public String changeStr(String string, int index){
        String result ="";
        String word = "";
        String alert = "Слова под таким номером нет";
        String str = string.replaceAll("[^\\p{L}]", " ");
        String[] temp = str.split("\\s+");
        index = index - 1;
        if (0 <= index && index < temp.length){
            for (int i = 0; i < temp.length; i++){
                if (i == index){
                    word += temp[i];
                }
            }
        } else {
            System.out.println(alert);
            return string;
        }
        for (int i = 0; i < string.length(); i++){
            if(word.length() + i <= string.length() && string.substring(i,i+word.length()).equals(word)){
                result += reverse(word);
                i += word.length()-1;
            } else {
                result += string.substring(i,i+1);
            }
        }
        return result;
    }
    public String reverse(String word){
        String result = "";
        for(int i = word.length()-1; i >= 0;i--){
            result += word.charAt(i);
        }
        return result;
    }
}
