package homeworks.homework2.strings;

import homeworks.control.exeption.IllegalDataException;
import homeworks.control.services.ServiceImpl;

public class SwitchChar extends ServiceImpl {
    /**
     *
     * @param userRequest must be like "something int indOne intTwo"
     *
     * @return String, where chars with indexes one and two or switched
     *
     * @throws IllegalDataException if data is not valid, there is information in message why
     */

    @Override
    public String getResult(String userRequest)  {
        String[] splitRequest = getSplitRequest(userRequest);
        Integer[] indexes = chekArray(splitRequest[splitRequest.length-2] + " "
                + splitRequest[splitRequest.length-1]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitRequest.length - 2; i++){
            sb.append(splitRequest[i]);
            sb.append(" ");
        }
        int indOne = indexes[0];
        int indTwo = indexes[1];
        return getString(sb.toString(),indOne,indTwo);

    }

    private String[] getSplitRequest (String request)throws IllegalDataException {
        String[] splitRequest = request.split("\\s+");
        if (splitRequest.length >= 3){
            return splitRequest;
        }else {
            throw new IllegalDataException(request + " must have \"body\" and two indexes");
        }
    }
    private String getString(String word, int ind1, int ind2){
        String first = chekIndex(word,ind1);
        String second = chekIndex(word,ind2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++){
            if(i == ind1){
                sb.append(second);
            } else if(i == ind2){
                sb.append(first);
            } else {
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }
    private String chekIndex(String word, int ind) throws IllegalDataException {
        if (word.length() > ind && ind >= 0){
            return word.substring(ind,ind+1);
        } else {
            throw new IllegalDataException(String.format("%s does not have index %d",word,ind));
        }
    }
}
