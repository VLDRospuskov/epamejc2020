package homeworks.control.services;

import homeworks.control.exeption.IllegalDataException;


import java.util.Random;

public abstract class ServiceImpl implements Service {

    public Integer chekInt(String string){
        Integer result;
        try{
            result = Integer.parseInt(string);
            return result;
        } catch (Exception ex){
            throw new IllegalDataException(string + " is not Integer.");
        }

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
            return array;
        } else {
            throw new IllegalDataException(string + " is not Integer[] or it's length != 2.");
        }

    }

    public char makeRandomChar(){
        Random r = new Random();
        char ab = (char)(r.nextInt(26) + 'a');
        return ab;
    }
    public boolean isEvenOdd(String string){
        if (EVEN.equals(string) || ODD.equals(string)){
            return true;
        }  else {
           return false;
        }
    }
}
