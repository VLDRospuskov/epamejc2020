package main.homework2.Prog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class Programm implements Strings{
    public void go() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String FirstInput = null;
        String SecondInput = null;
        String result = null;
        Set<String> Alerts = makeAlert();

        int input = inputtimes();
        if (input == 2){
            System.out.println(ALERTEXIT);
            System.out.println(ALERTNEXT + "\n");
        } else {
            System.out.println(ALERTEXIT + "\n");
        }
        while (true){

            if (FirstInput == null){
                System.out.println(startString());
                FirstInput = getUserInput(reader);
                if(isStoped(FirstInput)){
                    break;
                } else if(input ==2 && isNext(FirstInput)){
                    FirstInput = null;
                }
            }
            if(input == 2){
                System.out.println(seondInputString());
                SecondInput = getUserInput(reader);
                if(isStoped(SecondInput)){
                    break;
                } else if(isNext(SecondInput)){
                    FirstInput = null;
                }
            }
            if (FirstInput != null){
                result = makeResult(FirstInput,SecondInput);
                if (result != null ){
                    System.out.println("\n"+RESULT);
                    System.out.println(result+"\n");
                }
            }
            if (Alerts.contains(result)){
                FirstInput = null;
                SecondInput = null;
            } else if (SecondInput == null && FirstInput != null){
                FirstInput = null;
            } else if (SecondInput != null && FirstInput != null ){
                SecondInput = null;
            }
        }
        reader.close();
    }
    public Set<String> makeAlert(){
        Set<String> Alerts = new HashSet<>();
        Alerts.add(ALERTDATA);
        Alerts.add(ALERTPOW);
        Alerts.add(ALERTNUM);
        return Alerts;
    }
    public boolean isStoped(String str){
        return str.equals(EXIT);
    }
    public boolean isNext(String str){
        return str.equals(NEXT);
    }

    public String getUserInput(BufferedReader reader){
        String result = null;
       try{
           result = reader.readLine();
       }catch (IOException ex){
           ex.printStackTrace();
       }
       return result;
    }

    public Integer chekInt(String string){
        Integer result;
        try{
            result = Integer.parseInt(string);
        } catch (Exception ex){
            result = null;
        }
        return result;
    }

    public Double chekDouble(String string){
        Double result;
        try{
            result = Double.parseDouble(string);
        } catch (Exception ex){
            result = null;
        }
        return result;
    }

    public Integer[] chekArray(String string){
        Integer[] array = new Integer[2];
        String[] temp = string.split("[\\s+]");
        int i = 0;
        if (temp.length == 2){
            for (String str : temp){
                array[i] = chekInt(str);
                i++;
            }
        }
        if (array[0] == null || array[1] == null){
            array = null;
        }
        return array;
    }

    public char makeRandomChar(){

        Random r = new Random();

        char ab = (char)(r.nextInt(26) + 'a');

        return ab;
    }
    public String chekEvenOdd(String string){
        String badresult = null;
        if (EVEN.equals(string)){
            return EVEN;
        } else if(ODD.equals(string)){
            return ODD;
        } else {
            return badresult;
        }
    }
    public abstract String startString();
    public abstract String seondInputString();
    public abstract int inputtimes();
    public abstract String makeResult(String Finput, String Sinput);
}
