package SparseBinaryDecomposition;

public class SparseBinaryDecomposition {
    public static void main(String args[]) {
        int count=solution(26);
        System.out.println(count);
    }

    private static int solution(int N) {
        if (N <= 2)
           return N;
        for (int i = (N/2); i > 0; i--) {
            if(isSpare(i)){
                if(isSpare(N-i)){
                    return i;
                }
            }
        }
        return -1;
    }

    // private static boolean isSpare(int number){
    //     return Integer.toBinaryString(number).indexOf("11")==-1;
    // }
//     public static void toBinary(int decimal){    
//         List<Integer> result = new ArrayList<>();   
//         while(decimal > 0){    
//           result.add(decimal%2);    
//           decimal = decimal/2;    
//         }    
//    }    

   public static boolean isSpare(int decimal){    
    int binary[] = new int[32];    
    int index = 0;    
    while(decimal > 0 ){    
      binary[index] = decimal%2;
      if(index>1){
        if(binary[index-1]==1 && binary[index]==1){
            return false;
          }
      }    
      index++;
      decimal = decimal/2;    
    }
    return true;    
  }    
}
