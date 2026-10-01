import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}

class Solution {
    /*
    Input -> An integer array
    Output -> Return unqiue in the order they appeard in the original array
    Important Requirements -> iterate and escape duplicate values and return final list
    Final info is required as we need to check each element here
    DATA STRUCTURE -> ArrayList as we need to preserve order, if order was optional, HashSet would have solved the problem.
    TIME -> O(n) 
    Space -> O(n)
     */
    public static ArrayList<Integer> removeDuplicates(int[] nums) {
        ArrayList<Integer> unique = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (unique.contains(nums[i]) == false)
                unique.add(nums[i]);
        }
        return unique;
    }

    /*
    Input -> An integer array
    Output -> First element with frequency K
    Important Requirements -> find frequency of each element and then find 1st to K freq.
    Final info is required as we need to check each element here as we need total frequency.
    DATA STRUCTURE -> HashMap to store element with there freq
    TIME -> O(n) 
    Space -> O(n)
     */
    public static int firstWithFrequencyK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int elem : nums) {
            if (map.containsKey(elem)) {
                map.put(elem, map.get(elem) + 1);
            } else {
                map.put(elem, 1);
            }
        }
        for (int elem : nums) {
            if (map.get(elem) == k) {
                return elem;
            }
        }
        return -1;
    }

    /*
    Input -> ArrayList of EmployeeType
    Output -> HashMap with deaprtment as key and names as value arranged in a arrayList
    Important Requirements -> The arrangement of names by deaprtment as key
    Final info is required as we need to check each element here
    DATA STRUCTURE -> I am using ArrayList to maintain order
    TIME -> O(n) 
    Space -> O(n)
     */
    public static ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> finalList = new ArrayList<>();

        for (int elem : a) {
            aList.add(elem);
        }

        for (int elem : b) {
            if (finalList.contains(elem))
                continue;
            if (aList.contains(elem))
                finalList.add(elem);
        }

        return finalList;
    }

    /*
    Input -> An integer array
    Output -> First element with frequency K
    Important Requirements -> find frequency of each element and then find 1st to K freq.
    Final info is required as we need to check each element here
    DATA STRUCTURE -> HashMap to store element with there freq
    TIME -> O(n) 
    Space -> O(n)
     */
    public static HashMap<String, ArrayList<String>> groupByDepartment(ArrayList<Employee> employees) {
        HashMap<String, ArrayList<String>> freq = new HashMap<String, ArrayList<String>>();

        for (Employee elem : employees) {
            if (freq.containsKey(elem.getDepartment())) {
                ArrayList<String> names = freq.get(elem.getDepartment());
                names.add(elem.getName());
                freq.put(elem.getDepartment(), names);
            } else {
                ArrayList<String> emptyList = new ArrayList<>();
                emptyList.add(elem.getName());
                freq.put(elem.getDepartment(), emptyList);
            }
        }

        return freq;
    }

    /*
    Input -> An integer array
    Output -> First duplicate
    Important Requirements -> return as soon as a duplicate encountered.
    SEEN-SO-FAR as we return as soon as a duplicate encountered
    DATA STRUCTURE -> Hashset is being used as order is not important, we just need 1st duplicate.
    TIME -> O(n) 
    Space -> O(n)
     */
    public static int firstDuplicate(int[] nums) {
        HashSet<Integer> uniqueList = new HashSet<>();

        for (int element : nums) {
            if (uniqueList.contains(element)) {
                return element;
            } else {
                uniqueList.add(element);
            }
        }
        return -1;
    }

    /*
    Input -> An integer array
    Output -> return element with most frequency
    Important Requirements -> need freuency of each element 1st then find return the 1st or last if multiple with max frequency.
    Final info is required as we need to check each element here
    DATA STRUCTURE -> HashMap to store each element as key and there frequency as value.
    TIME -> O(n) 
    Space -> O(n)
     */
    public static int mostFrequent(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int element : nums) {
            if (freq.containsKey(element)) {
                freq.put(element, freq.get(element) + 1);
            } else {
                freq.put(element, 1);
            }
        }
        int highestCountElement = -1;
        int highestCount = -1;
        for (int element : nums) {
            if (freq.get(element) > highestCount) { // making this >= will return last element with max frequency
                highestCount = freq.get(element);
                highestCountElement = element;
            }
        }
        if (highestCount > -1)
            return highestCountElement;
        return -1;
    }

    
    /*
    Input -> 2 arrays one of registered and one of present
    Output -> return list of absents
    Important Requirements -> return absent in order of registered
    Final info is required as we need to check each element here
    DATA STRUCTURE -> ArrayList as order of register important.
    TIME -> O(n) 
    Space -> O(n)
     */
    public static ArrayList<Integer> findAbsent(int[] registered, int[] present) {
        HashSet<Integer> list = new HashSet<>();
        ArrayList<Integer> absent = new ArrayList<>();
        for(int element: present){
            list.add(element);
        }
        System.out.println("Regsitered: " + list);
        for(int element: registered){
            if(list.contains(element) == false) absent.add(element);
        }

        return absent;


    }
}

public class Main {
    public static void main(String args[]) {
        int[] nums = { 4, 2, 4, 7, 2, 9 };
        int[] nums1 = { 4, 1, 1, 2 };

        int[] A = { 1, 2, 2, 3, 5, 7 };
        int[] B = { 2, 2, 4, 5, 5, 7 };

        System.out.println("removeDuplicates -> " + Solution.removeDuplicates(nums));
        System.out.println("removeDuplicates -> " + Solution.removeDuplicates(nums1));

        int[] firstK = {5, 3, 5, 2, 3, 5, 2};
        System.out.println("firstWithFrequencyK -> " + Solution.firstWithFrequencyK(firstK,2));

        System.out.println("intersection -> " + Solution.intersection(A, B));

        Employee manish = new Employee("Manish", "Engineering");
        Employee amit = new Employee("Amit", "Engineering");
        Employee rahul = new Employee("Rahul", "Sales");
        Employee raj = new Employee("Raj", "Testing");
        Employee aadi = new Employee("Aadi", "Engineering");

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(manish);
        employeeList.add(amit);
        employeeList.add(rahul);
        employeeList.add(raj);
        employeeList.add(aadi);

        System.out.println("groupByDepartment -> " + Solution.groupByDepartment(employeeList));

        int[] duplicateArray = { 4, 7, 2, 7, 4, 7, 2, 2 };
        System.out.println("firstDuplicate -> " + Solution.firstDuplicate(duplicateArray));
        System.out.println("mostFrequent -> " + Solution.mostFrequent(duplicateArray));

        int[] registered = {101, 102, 103, 104, 105};
        int [] present = {105, 102, 101};
        System.out.println("findAbsent -> " + Solution.findAbsent(registered, present));

    }
}


/*
  for (int n : nums) {
        if (freq.containsKey(n)) {
            freq.put(n, 1);  
        } else {
            freq.put(n, freq.get(n) + 1);
        }
    }
   this logic is wrong, we are setting if found to 1 and +1 when not found, runtime error will come, we need to exchange the statement in if & else.
*/