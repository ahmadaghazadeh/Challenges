package com.sevensky.web.controllers;

import com.sevensky.web.models.CurrencyModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class TestController {

    private final List<CurrencyModel> currencies=new ArrayList<CurrencyModel>();

    private final List<CurrencyModel> currenciesDefault = Arrays.asList(new CurrencyModel("Rial",1,1.5f),
            new CurrencyModel("Toman",2,1.5f),
            new CurrencyModel("Toman",1,1.6f));
    @GetMapping("/currencies/{currencyId}")
    public ResponseEntity<CurrencyModel> getLastExchangeRate(@PathVariable("currencyId") int currencyId) {
        CurrencyModel result=currencies.stream().
                filter(currency -> currencyId==currency.getCurrencyId())
                .findFirst()
                .orElse(null);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/currencies")
    public ResponseEntity<List<CurrencyModel>> getCurrencies() {
        var newList=currencies.stream()
                .sorted(
                        Comparator.comparing(CurrencyModel::getCurrencyId)
                                .thenComparing(CurrencyModel::getRate)
                ).toList();

        return ResponseEntity.status(HttpStatus.OK).body(newList);
    }

    @GetMapping("/currencies/{currencyId}/best")
    public ResponseEntity<CurrencyModel> getBestRate(@PathVariable("currencyId") int currencyId) {
        var result=currencies.stream()
                .filter(currency -> currencyId==currency.getCurrencyId())
                .max(Comparator.comparing(CurrencyModel::getRate))
                .orElse(null);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/currencies")
    public ResponseEntity<Integer> saveCurrency(@ModelAttribute("currency") CurrencyModel model){
        currencies.add(model);
        return ResponseEntity.status(HttpStatus.OK).body(currencies.size());
    }

    @PutMapping("/currencies/{currencyId}")
    public ResponseEntity<String> updateCurrency(@PathVariable("currencyId") int currencyId,@ModelAttribute("currencyModel") CurrencyModel model){

        CurrencyModel result=currencies.stream().
                filter(currency -> currencyId==currency.getCurrencyId())
                .findFirst()
                .orElse(null);

        int index= currencies.indexOf(result);
        currencies.set(index,model);
        return ResponseEntity.status(HttpStatus.OK).body("Ok");
    }

    @GetMapping("/findAllCurrencySortByRate")
    public ResponseEntity<String> findAllCurrencySortByRate() {
        currenciesDefault.stream().
                filter(currency -> 1==currency.getCurrencyId())
                .sorted(Comparator.comparing(CurrencyModel::getCurrencyName))
                .forEach(currency -> System.out.println(currency.getRate()));
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @GetMapping("/testSuperClass")
    public ResponseEntity<String> testSuperClass() {
        SuperC c=new SubCla();
        c.methodToOverride1();
        c.methodToOverride2();
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @GetMapping("/parentChild")
    public ResponseEntity<String> parentChild() {
        Parent parent = new Child();
        //Will this below line compile
        parent.foo();
        //Will this below line compile
        //parent.bar();
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @GetMapping("/countOfEachItem")
    public ResponseEntity<Map<String,Long>> countOfEachItem() {
        Employee emp1 = new Employee(1,"Ajay",100);
        Employee emp2 = new Employee(1,"name",100);
        Employee emp3 = new Employee(1,"Ajay",100);
        Employee emp4 = new Employee(1,"name",100);
        Employee emp5 = new Employee(1,"Ajay",100);

        List<Employee> empList = Arrays.asList(emp1,emp2,emp3,emp4,emp5,emp1,emp2,emp3,emp4,emp5);

        Map<String,Long> answer=empList.stream()
                .collect(Collectors.groupingBy(Employee::getName,Collectors.counting()));

        return ResponseEntity.status(HttpStatus.OK).body(answer);
    }


    @GetMapping("/HashSetTEst")
    public ResponseEntity<String> HashSetTEst() {
        // We can add duplicate item into HashSet
        HashSet<Employee> student = new HashSet();
        student.add(new Employee(1,"Ajay",100));
        student.add(new Employee(1,"Ajay",100));
        student.add(new Employee(1,"Ajay",100));
        System.out.println("sizze of hashset : "+student.size());

        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @GetMapping("/HashMapTEst")
    public ResponseEntity<String> HashMapTEst() {
        // We cant add duplicate item into HashSet
        HashMap<String,Employee> student = new HashMap();
        student.put("Ajay",new Employee(1,"Ajay",100));
        student.put("Ajay",new Employee(1,"Ajay",100));
        student.put("Ajay",new Employee(1,"Ajay",100));
        System.out.println("sizze of hashset : "+student.size());
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @GetMapping("/findDuplicateNumbers")
    public ResponseEntity<String> findDuplicateNumbers() {
        List<Integer> numbers=Arrays.asList(1,2,3,4,1,4);
        Set<Integer> set=new HashSet<>();
        numbers.stream()
                .filter(n -> !set.add(n))
                .forEach(d -> System.out.println(d));

        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @GetMapping("/findMaxValue")
    public ResponseEntity<String> findMaxValue() {
        List<Integer> numbers=Arrays.asList(1,22,3,4,1,4);

        var max=numbers.stream()
                .max(Integer::compare)
                .get();

        return ResponseEntity.status(HttpStatus.OK).body(max.toString());
    }

    @GetMapping("/firstNonRepeatedChar")
    public ResponseEntity<String> firstNonRepeatedChar() {
        String input = "Java articles are Awesome";
        Set<Character> characters=new HashSet<>();

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


        return ResponseEntity.status(HttpStatus.OK).body(result.toString());
    }

    @GetMapping("/firstRepeatedChar")
    public ResponseEntity<String> firstRepeatedChar() {
        String input = "Java articles are Awesome";
        Set<Character> characters=new HashSet<>();

        var result=  input.chars()
                .mapToObj(c -> Character.toLowerCase(Character.valueOf((char)c)))
                .toList()
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue()>=2L)
                .map(e-> e.getKey())
                .findFirst()
                .get();

        return ResponseEntity.status(HttpStatus.OK).body(result.toString());
    }

    @GetMapping("/hasDuplicateNumbers")
    public ResponseEntity<String> hasDuplicateNumbers() {
        List<Integer> numbers=Arrays.asList(1,2,3,4);
        Set<Integer> set=new HashSet<>();
        var result= numbers.stream()
                .filter(n -> !set.add(n))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body((result.size() >1)? "true":"false" );
    }

    @GetMapping("/countOfEachChar")
    public ResponseEntity<String> countOfEachChar() {
        String sampleString="Ahmad Aghazadeh";
        var result= Arrays.stream(sampleString.split(""))
                .map(c -> c.toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        return ResponseEntity.status(HttpStatus.OK).body(result.toString() );
    }

    @GetMapping("/finbonanchi")
    public ResponseEntity<String> fibonanchi() {

        return ResponseEntity.status(HttpStatus.OK).body(""+calcFibo(19));
    }

    @GetMapping("/rotateArray")
    public ResponseEntity<String> rotateArray() {

        int[] A=new int[]{1,2,3,4,5,6};

        List<Integer> newList=new ArrayList<>();
        newList.add(1);
        int[] newArray= newList.toArray(Integer[]::new);
        return ResponseEntity.status(HttpStatus.OK).body(""+calcFibo(19));
    }

    @GetMapping("/findUnpairedItem")
    public ResponseEntity<String> findUnpairedItem() {

        int[] A=new int[]{9, 3, 9, 3, 9, 7, 9};

        List<Integer> listA=Arrays.stream(A).boxed().collect(Collectors.toList());
        // Implement your solution here
        int item= listA.stream().collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap<Integer,Long>::new,Collectors.counting()))       .entrySet()
                .stream().filter(a -> a.getValue()==1)
                .findFirst()
                .get().getKey();

        return ResponseEntity.status(HttpStatus.OK).body(""+item);
    }

    @GetMapping("/maxCounters")
    public ResponseEntity<String> maxCounters() {

        int[] A=new int[]{3,4,4,6,1,4,4};

        List<Integer> listA=Arrays.stream(A).boxed().collect(Collectors.toList());
        // Implement your solution here
        int item= listA.stream().collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap<Integer,Long>::new,Collectors.counting()))       .entrySet()
                .stream().filter(a -> a.getValue()==1)
                .findFirst()
                .get().getKey();

        return ResponseEntity.status(HttpStatus.OK).body(""+item);
    }

    @GetMapping("/getTwoSum")
    public ResponseEntity<String> getTwoSum() {

        int[] numbers=new int[]{-2,3,7,6,8};
        int target=6;
        int[] result=getTwoSum1(numbers,target);
        return ResponseEntity.status(HttpStatus.OK).body(result[0]+1+"  "+(result[1]+1) );
    }

    public static int[] getTwoSum1(int[] numbers,int target) {
        Map<Integer,Integer> visitedNumbers=new HashMap<>();

        for(int i=0; i< numbers.length; i++){
            int delta= target - numbers[i];
            if(visitedNumbers.containsKey(delta)){
                return new int[]{i,visitedNumbers.get(delta)};
            }
            visitedNumbers.put(numbers[i],i);
        }
        return new int[]{-1,-1};
    }

    public int calcFibo(int number){
        if(number==0)
            return 0;
        if(number==1)
            return 1;
        return calcFibo(number-1)+calcFibo(number-2);
    }


}

class Employee{
    private int Id;
    private String name;
    private int score;

    public Employee(int id,String name, int score){
        this.Id=id;
        this.name=name;
        this.score=score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
class SuperC {
    public void methodToOverride1(){
        System.out.println("in methodToOverride1");
    }
    public  void methodToOverride2(){
        System.out.println("in methodToOverride2");
    }
}
class SubCla extends SuperC{
    public void methodToOverride1(){
        System.out.println("in methodToOverride1-sub");
    }
    public void methodToOverride2(){
        System.out.println("in methodToOverride2-sub");
    }
}

class Parent {

    public void foo() {
        System.out.println("Parent :: foo()");
    }
}

class Child extends Parent {

    @Override
    public void foo() {
        System.out.println("Child :: foo()");
    }

    public void bar() {
        System.out.println("Child :: bar()");
    }
}