package homeworks.homework2.strings;

import homeworks.control.services.ServiceImpl;

public class RewerseWords extends ServiceImpl {

    @Override
    public String getResult(String userRequest){
        return changeStr(userRequest);
    }

    private String changeStr(String string){
        StringBuilder sb = new StringBuilder();
        String str = string.replaceAll("[^\\p{L}]", " ");
        String[] temp = str.split("\\s+");
        int j = 0;
        for (int i = 0; i < string.length(); i++){
            if(j < temp.length && temp[j].length() + i <= string.length() &&
                    string.substring(i,i+temp[j].length()).equals(temp[j])){

                sb.append(reverse(temp[j]));
                i += temp[j].length()-1;
                j++;
            } else {
                sb.append(string.substring(i,i+1));
            }
        }
        return sb.toString();
    }
    private String reverse(String word){
        String result = "";
        for(int i = word.length()-1; i >= 0;i--){
            result += word.charAt(i);
        }
        return result;
    }

}

