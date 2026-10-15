/*
Part 1 — Cold recall 
    Q1. It doesn't because, ArrayList<Integer> is not a subtype of List<Number>
    Q2. 
        A. Here the subtype is unknown at compile time
            - Allows reading, but not writing
        B. Here the supertype is unknown at compile time
            - Allows writing but reading is not allowed
    Q3. 
        Since the start and end pointers do not grow with the the array length
            and remains contant size throughout the iteration. 

    Exercise A - 
    //1
    Employee e = new Manager(1, "A"); // Employee is a super type of Manager

    // 2
    List<Employee> x = managers; // List<Manager> is not a subType of List<Employee>

    //3
    List<? extends Employee> y = managers; //Here we are allow Employee or any of its subtypes

    // 4
    y.add(new Manager(2, "B")); // subtype is unknown at compile type so writing not allowed

    // 5
    Employee first = y.get(0); // Reading allowed for Employee and its subtypes

    // 6
    List<? super Manager> z = employees; // Here we allow Managers and it's super types

    // 7
    z.add(new Manager(3, "C")); //writing is allowed

    // 8
    Manager m = z.get(0); //reading is not allowed as supertype not known as compile time List<...> only guarantees Object.
            
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Manager extends Employee {
    public Manager(int id, String name) {
        super(id, name);
    }
}

class Developer extends Employee {
    public Developer(int id, String name) {
        super(id, name);
    }
}

class Practice {
    public static void printEmployeeNames(
            List<? extends Employee> employees) {
        /*
         * List<? extends Employee> preferable to List<Employee>
         * for this particular method so it allows Employee or its subtypes
         */
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }
}

public class Main {
    public static void main(String args[]) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Manish"));
        List<Manager> managers = new ArrayList<>();
        managers.add(new Manager(102, "Jaya"));
        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer(103, "Anvit"));
        Practice.printEmployeeNames(employees);
        Practice.printEmployeeNames(managers);
        Practice.printEmployeeNames(developers);

        // DSA
        int[] nums = { 3, 2, 2, 3 };
        System.out.println(Solution.removeElement(nums, 3) + " : " + Arrays.toString(nums));

        // DSA
        int[] nums1 = { 0, 1, 2, 2, 3, 0, 4, 2 };
        System.out.println(Solution.removeElement(nums1, 2) + " : " + Arrays.toString(nums1));

        // DSA
        int[] nums2 = { 1, 2, 3 };
        System.out.println(Solution.removeElement(nums2, 4) + " : " + Arrays.toString(nums2));

        // DSA
        int[] nums3 = { 5, 5, 5 };
        System.out.println(Solution.removeElement(nums3, 5) + " : " + Arrays.toString(nums3));

        // DSA
        int[] nums4 = { 2, 1, 2, 3, 2, 4 };
        System.out.println(Solution.removeElement(nums4, 2) + " : " + Arrays.toString(nums4));
    }

}

/*
 * Q1. In sorted array once a number was passed it did not occur again, here it
 * can
 * Q2. Not required, we need not val in order of occurence
 * Q3. Count of non val elements
 * Q4. Yes, instead of 0s we need val to be traced.
 */
class Solution {
    public static int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int writeIndex = 0;

        /*
         * Here readIndex traces each value
         * WriteIndex writes non val values to start to there total count,
         * We are tracing each value and looking for non-val values, so sorting doesn't
         * matter
         */
        for (int readIndex = 0; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != val) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }

        return writeIndex;
    }
}

/*
 * Part 4:
 * 1. because List<Manager> is not a subtype of List<Employee>
 * 2. because the subtype cannot be deduced at compile time
 * 3. List<Manager>, List<Employee>, List<Object>
 * 4. Object
 * 5. We are looking for next index for the retained element to be written
 * 6. - Time -> O(n)
 * - Space -> O(1)
 * 
 * Question - I have a little doubt with my DSA solution - the ask is to return
 * all non val elements which my solution
 * is doing, but the 2nd ask to remove all val elements is not fulfilled here,
 * as after writeIndex if
 * val is there, we don't remove it, so is my solution wrong
 */