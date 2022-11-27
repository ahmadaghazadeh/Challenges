package Leetcode.RemoveDuplicates;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String args[]) {
        String givenString="abbaca";
        String output=solution(givenString);
        System.out.println(output);
    }

    public static String solution(String s) {
         // base case
        if (s == null) {
            return null;
        }
         
        List<Character> chars = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            chars.add(ch);
        }

        int index=0;
        while(index<chars.size()){
            if( index>1 && chars.get(index)==chars.get(index-1)){
                chars.remove(index);
                chars.remove(index);
                if(index>0){
                    index--;
                }
                
            }else if( index <chars.size()-1 && chars.get(index)==chars.get(index+1)){
                chars.remove(index);
                chars.remove(index);
                if(index>0){
                    index--;
                }
                
            }else{
                index++;
            }
        }
      
        
        String str="";
        for (Character character : chars) {
            str+=character;
        }

        return str;
    }
}

