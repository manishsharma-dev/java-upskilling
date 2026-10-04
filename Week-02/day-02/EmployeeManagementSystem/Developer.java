

public class Developer extends Employee {
     private String programmingLanguage;

     public Developer(int employeeId, String name, double salary, String programmingLanguage){
        super(employeeId, name, salary);
        this.programmingLanguage = programmingLanguage;
     }

     @Override
     public String work(){
            return super.getName() + " is writing " + this.programmingLanguage + " code.";
     }

     @Override
      public String getDetails(){
       return getEmployeeId() + " : " + getName() + " : " + getSalary() + " : " + this.programmingLanguage;
    }
}
