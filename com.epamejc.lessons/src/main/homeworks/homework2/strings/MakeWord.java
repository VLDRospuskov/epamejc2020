package homeworks.homework2.strings;

import homeworks.control.exeption.IllegalDataException;
import homeworks.control.services.ServiceImpl;

public class MakeWord extends ServiceImpl {
    @Override
    public String getResult(String userRequest) {

        String[] temp = userRequest.split("\\s+");
        StringBuilder sb = new StringBuilder();
        if (temp.length >= 2){
            for (int i = 1; i< temp.length; i++){
                try {
                    int index = chekInt(temp[i]);
                    sb.append(makeWord(temp[0],index));
                } catch (IllegalDataException e){
                    e.getMessage();
                }
            }
            return sb.toString();
        } else {
            throw new IllegalDataException(userRequest + " must contain word(s) and one or more integers(indexes)");
        }
    }
    private String makeWord(String string, int exit){
        if (exit >= string.length()){
            throw new IllegalDataException(String.format("%s does not have index %s",string,exit));
        }
        return string.substring(exit,exit+1);
    }

}
