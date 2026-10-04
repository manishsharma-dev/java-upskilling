public class Tester extends Employee implements Reportable {
    private String testingTool;

    public Tester(int employeeId, String name,double salary, String testingTool){
            super(employeeId, name, salary);
            this.testingTool = testingTool;
    }

    @Override
      public String work(){
       return getEmployeeId() + " : " + getName() + " : " + getSalary() + " : " + this.testingTool;
    }

    @Override
    public String generateReport() {
        return getName() + " generated testing report";
    }
}
