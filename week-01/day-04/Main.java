public class Main {

    public static void main(String args[]){
       Employee e1 = new Developer("Manish", 10000, "Java");
       Employee e2 = new Manager("Rahul", 100000, 5);

       e1.work();
       e2.work();

       //e1.writeCode();
    }
}
