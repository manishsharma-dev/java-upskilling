import java.util.ArrayList;

public class Main {
  public static void main(String args[]) {

    // 1. Company Object
    Company company = new Company();

    // //2. Engineering dapartment Object
    // Department department = new Department("Engineering");

    // //3. Creating 3 new employees
    // Employee e101 = new Developer(101, "Manish", 100000, "Java");
    // Employee e102 = new Developer(102, "Amit", 200000, "Angular");
    // Employee e103 = new Manager(103, "Rahul", 300000, 5);

    // //4. Adding all the created employees to the company
    // company.addEmployee(e101);
    // company.addEmployee(e102);
    // company.addEmployee(e103);

    // //5. Adding all the created employees to the same department
    // department.addEmployee(e101);
    // department.addEmployee(e102);
    // department.addEmployee(e103);
    // department.addEmployee(new Tester(201, "Raj", 50000, "Selenium"));

    // //6. Find E102 FROM THE COMPANY using employeeId
    // Employee employeeById = company.findEmployeeById(102);
    // System.out.println(employeeById.getDetails());

    // //7. Print all employees belonging to the Department
    // department.printAllEmployees();

    // //8. Call work() for every employee in the Department
    // department.startWork();

    // // 9. Remove one employee FROM THE DEPARTMENT
    // department.removeEmployee(101);

    // // 10. Print Department employees again
    // department.printAllEmployees();

    // // 11. Verify that the employee you removed from the Department
    // Employee e1 = company.findEmployeeById(101);
    // System.out.println(e1.work());

    // company.addEmployee(new Developer(105, "Aadi", 100000, "React"));

    // System.out.println(company.giveRaiseToEmployee(105, 10));
    // System.out.println(company.giveRaiseToEmployee(105, 0));
    // System.out.println(company.giveRaiseToEmployee(105, 60));
    // System.out.println(company.giveRaiseToEmployee(999, 10));

    ArrayList<Reportable> reportGenerators = new ArrayList<>();

    Reportable manager = new Manager(103, "Rahul", 300000, 5);
    Reportable tester = new Tester(201, "Raj", 50000, "Selenium");

    reportGenerators.add(manager);
    reportGenerators.add(tester);

    for (Reportable reportable : reportGenerators) {
      System.out.println(reportable.generateReport());
    }

    //Developer did not implement Reportable interface so we can't add it to the ArrayList.

  }
}
