import java.util.HashMap;
 
public class Company {
     private HashMap<Integer, Employee> empMap  = new HashMap<>();

     public void addEmployee(Employee employee){
        empMap.put(employee.getEmployeeId(), employee);
     }

     public Employee findEmployeeById(int employeeId){
        return empMap.get(employeeId);
     }

     public String giveRaiseToEmployee(int employeeId, double percentage){
         Employee employee = findEmployeeById(employeeId);

         if(employee == null){
            return "Please send a valid employee id";
         }

         return employee.giveRaise(percentage);
     }
}
