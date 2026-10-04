public class Manager extends Employee implements Reportable {
    
    private int teamSize;

    public Manager(int employeeId, String name, double salary, int teamSize){
         super(employeeId, name, salary);

         this.teamSize = teamSize;
    }

    @Override
    public String work(){
        return super.getName() + " is managing a team of " + this.teamSize + " people";
    }

    @Override
      public String getDetails(){
       return getEmployeeId() + " : " + getName() + " : " + getSalary() + " : " + this.teamSize;
    }

    @Override
    public String generateReport() {
        return getName() + " generated management report";
    }
}
