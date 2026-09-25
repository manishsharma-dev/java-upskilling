class Calc {
 
  public int add(int a, int b){
    return a+b;
  }

  public double calculatePercentage(double value, double percentage){
     return value + (value * percentage/100);
  }

  public boolean isAdult(int age){
    return age >=18 ? true : false;
  }

  public void printGreeting(String name){
    System.out.println("Hello " + name);
  }
}

public class MethodPractice {
    public static void main(String args[]){
            Calc obj =  new Calc();
            System.out.println(obj.add(5,7));
            System.out.println(obj.calculatePercentage(50000, 10));
            System.out.println(obj.isAdult(31));
            obj.printGreeting("Manish");
    }
}