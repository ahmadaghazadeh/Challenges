package CountriesCount;

public class CountriesCount{
    public static void main(String args[]){  
        int[][] givenArray=new int[][]{{5, 4, 4},
        {4, 3, 4},
        {3, 2, 4},
        {2, 2, 2}, 
        {3, 3, 4}, 
        {1, 4, 4}, 
        {4, 1, 1}
        };
        System.out.println(solution(givenArray));  
    }  

    public static int solution(int[][] A) {
        int[][] countries=new int[A.length][A[0].length];
        int countryNumber=1;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if(checkCountry(A,countries,i,j,countryNumber)==1){
                    countryNumber++;
                }
            }
        }
        return countryNumber-1;
    }
    private static int checkCountry(int[][] A,int[][] countries,int i, int j,int countryNumber){
        System.out.println(i+" , "+j + " A :" + A[i][j] +"  c : "+countryNumber ); 
        if(countries[i][j]!=0){
            return 0;
        }       
         
        if(countries[i][j]==0){
            countries[i][j]=countryNumber;
            if(i<A.length-1){
                if(A[i][j]==A[i+1][j]){
                    checkCountry(A,countries,i+1, j,countryNumber);
                }
            }
            if(j>0){
                if(A[i][j]==A[i][j-1]){
                    checkCountry(A,countries,i, j-1,countryNumber);
                }
            }
            if(i>0){
                if(A[i][j]==A[i-1][j]){
                    checkCountry(A,countries,i-1, j,countryNumber);
                }
            }
            if(j<A[0].length-1){
                if(A[i][j]==A[i][j+1]){
                    checkCountry(A,countries,i, j+1,countryNumber);
                }
                
            }

        }
        return 1;
    }
}