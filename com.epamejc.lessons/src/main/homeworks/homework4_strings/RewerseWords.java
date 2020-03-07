package homeworks.homework4_strings;

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
                sb.append(string.charAt(i));
            }
        }
        return sb.toString();
    }
    private String reverse(String word){
        StringBuilder sb = new StringBuilder();
        for(int i = word.length()-1; i >= 0;i--){
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }

}

