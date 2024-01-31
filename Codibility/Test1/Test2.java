package Codibility.Test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test2 {
    public static void main(String args[]) {
        String count=solution("ab?ac?");
        System.out.println(count);
    }

    public static String solution( String S) {
        List<Character> chars = new ArrayList<>();
        for (char ch : S.toCharArray()) {
            chars.add(ch);
        }
        for (int i = 0; i < chars.size(); i++) {
            if(chars.get(i)=='?'){
                Random rnd = new Random();
                char c = (char) ('a' + rnd.nextInt(26));
                while(true){
                    c = (char) ('a' + rnd.nextInt(26));
                    if(i>0){
                        if(chars.get(i-1)==c){
                           continue;
                        }
                    }
                    if(i<chars.size()-1){
                        if(chars.get(i+1)==c){
                            continue;
                        }
                    }
                    break;
                }
                chars.set(i, c);
            }
        }       
        
        String str="";
        for (Character character : chars) {
            str+=character;
        }

         
        return str;
    }


}

