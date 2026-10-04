import java.util.ArrayList;
import java.util.HashSet;

class Solution {
  public static ArrayList<Employee> findEmployeesByDepartment(
      ArrayList<Employee> employees,
      String department) {
    ArrayList<Employee> filteredEmployees = new ArrayList<Employee>();
    for(Employee employee: employees){
      if(employee.getDepartment())
    }

    return filteredEmployees;
  }

  public static int getFirstBrute(int[] a, int b[]){

    for(int elem: b){
      for(int child: a){
        if(elem == child) return elem;
      }
    }

    return -1;
  }

  public static int getFirstOptimize(int[] a, int b[]){
     HashSet<Integer> aSet = new HashSet<>();
    for(int elem: a){
      aSet.add(elem);
    }

    for(int elem: b){
      if(aSet.contains(elem)) return elem;
    }
    return -1;
  }
}

public class Main {
  public static void main(String args[]) {

    // 1. Company Object
    Company company = new Company();

    // //2. Engineering dapartment Object
    Department engineering = new Department("Engineering");
    Department sales = new Department("Sales");
    Department testing = new Department("Testing");


    //3. Creating 3 new employees
    Employee e101 = new Developer(101, "Manish", 100000, "Java");
    Employee e102 = new Developer(102, "Amit", 200000, "Angular");
    Employee e103 = new Manager(103, "Rahul", 300000, 5);
    Tester e104 = new Tester(104, "Raj", 100000, "Jest");
    Employee e105 = new Developer(105, "Aadi", 50000, "React");
   

    //4. Adding all the created employees to the company
    company.addEmployee(e101);
    company.addEmployee(e102);
    company.addEmployee(e103);

    engineering.addEmployee(e101);
    engineering.addEmployee(e102);
    sales.addEmployee(e103);
    testing.addEmployee(e104);
    engineering.addEmployee(e105);

    ArrayList<Employee> list = new ArrayList<>();

    list.add(e101);
    list.add(e102);
    list.add(e103);
    list.add(e104);
    list.add(e105);

    ArrayList<Employee> filter = new ArrayList<>();
    filter = Solution.findEmployeesByDepartment(list, "Engineering");

    try{
      company.giveRaiseToEmployee(101, 10);
    }
    catch(IllegalArgumentException e){
      System.out.println("For employee 101" + e.getMessage());
    }

    try{
      company.giveRaiseToEmployee(999, 10);
    }
    catch(IllegalArgumentException e){
      System.out.println("For employee 999" +e.getMessage());
    }

    try{
      company.giveRaiseToEmployee(102, 70);
    }
    catch(IllegalArgumentException e){
      System.out.println("For employee 102" +e.getMessage());
    }
  }
}
