public class Test3 {
    public static void main(String args[]) {
        String count=solution("2016-11-30",14);
        System.out.println(count);
    }

    public static String solution( today, limit) {
        var count=0;
        var d = new Date("2016-11-30");
        d.setDate(d.getDate()+14);
       var rows = document.getElementsByTagName("table")[0].rows;
       for (let row of rows) {
           var day=new Date(row.cells[1]);
           var flag=day<d;
             console.log(flag,day,d);
           if(row.style.backgroundColor='red' && flag ){
               count++
           }
       }
       console.log(count);
    }

}

