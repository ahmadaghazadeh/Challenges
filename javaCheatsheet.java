import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public void testMethod(){

        CurrencyModel result=currencies.stream().
                filter(currency -> currencyId==currency.getCurrencyId())
                .findFirst()
                .orElse(null);
        
        var newList=currencies.stream()
                .sorted(
                        Comparator.comparing(CurrencyModel::getCurrencyId)
                                .thenComparing(CurrencyModel::getRate)
                ).toList();

        Employee emp1 = new Employee(1,"Ajay",100);
        Employee emp2 = new Employee(1,"name",100);
        Employee emp3 = new Employee(1,"Ajay",100);
        Employee emp4 = new Employee(1,"name",100);
        Employee emp5 = new Employee(1,"Ajay",100);

        List<Employee> empList = Arrays.asList(emp1,emp2,emp3,emp4,emp5,emp1,emp2,emp3,emp4,emp5);

        Map<String,Long> answer=empList.stream()
        .collect(Collectors.groupingBy(Employee::getName,LinkedHashMap<String,Long>::new,Collectors.counting()));


        var result=  input.chars()
        .mapToObj(c -> Character.toLowerCase(Character.valueOf((char)c)))
        .toList()
        .stream()
        .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue()==1L)
        .map(e-> e.getKey())
        .findFirst()
        .get();

        int[] A=new int[]{1,2,3,4,5,6};

        List<Integer> newList=new ArrayList<>();
        newList.add(1);
        Integer[] newArray= newList.toArray(Integer[]::new);


        int number=1;

        String binaryString=Integer.toBinaryString(number);
    
        int index=0;
        while(index< 10){
            index++;
        }
    
        if(numberOne>numberTwo){
    
        }
    
        for(int i=0;i<10;i++){
    
        }
    }
}

