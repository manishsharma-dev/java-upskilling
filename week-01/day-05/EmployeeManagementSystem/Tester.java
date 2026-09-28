public class Tester extends Employee {
    private String testingTool;

    public Tester(int employeeId, String name,double salary, String testingTool){
            super(employeeId, name, salary);
            this.testingTool = testingTool;
    }

    @Override
      public String work(){
       return getEmployeeId() + " : " + getName() + " : " + getSalary() + " : " + this.testingTool;
    }
}
