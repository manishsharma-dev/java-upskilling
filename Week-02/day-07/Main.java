import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void work();
}

class Developer extends Employee {
    private String lang;

    public Developer(String name, String lang) {
        super(name);
        this.lang = lang;
    }

    public void work() {
        System.out.println(getName() + " : " + lang);
    }
}

class Operation {
    public static void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }

    public static void processEmployees(List<Employee> employees) {
        // ...
    }
}

/*
 * Q1. pair, closest to the target
 * Q2. we diff target from sum of start + end index values.
 * Q3. we keep that diff and overwrite it when a smaller diff is found,
 * eventually giving
 * our smallest diff pair
 * Q4. - if target is smaller than sum, we need to move the right to find
 * smaller no. to sum with
 * - if target is larger than sum, we need to move the left to find a larger no.
 * to sum with
 * Currently We are considering 0 to be a valid smallest distance, if it is not
 * so
 * we need to ignore that == condition on line 71 and only check < and >
 * operations
 * and find targets there
 */
class Solution {
    /*
     * Time -> O(n)
     * Space -> O(1) , same we already know List will consist of only 2 values,
     * else usage of List will makes it O(n) if the size was goin to be dynamic
     */
    public static List<Integer> closestPair(int[] nums, int target) {

        List<Integer> pair = new ArrayList<>();

        int left = 0;
        int right = nums.length - 1;

        int smallestDiff = Integer.MAX_VALUE;
        int bestLeft = nums[left];
        int bestRight = nums[right];

        while (left < right) {

            int sum = nums[left] + nums[right];

            int currentDiff = Math.abs(target - sum);

            if (currentDiff < smallestDiff) {
                smallestDiff = currentDiff;
                bestLeft = nums[left];
                bestRight = nums[right];
            }

            if (sum == target) {
                pair.add(nums[left]);
                pair.add(nums[right]);
                return pair;
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        pair.add(bestLeft);
        pair.add(bestRight);

        return pair;
    }

    /*
    Time -> O(n)
    Space -> O(1)
    */
    public static int[] closestPair2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        /*
        int smallestDiff = target;  
        as explained, this target can be smaller than the diff between elements and it will not work,
        we need larger number, corrected next statement
        */
        int smallestDiff = Integer.MAX_VALUE;
        int bestLeft = 0;
        int bestRight = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            int diff = Math.abs(target - sum);

            if (diff < smallestDiff) {
                smallestDiff = diff;
                bestLeft = nums[left];
                bestRight = nums[right];
            }

            if (sum > target) {
                 
                /*
                left++;
                this increase the left value when sum is more, so the next sum will be
                even larger, we need to decrease the gap in this case so we need to decrease
                right, corrected next line
                */
               right--;
            } else {
                /*
                right--;
                just like the if part, the endgame is to decrease the gap between the sum and target,
                if we decrease right here, the sum will be lower thus increasing the gap.corrected next
                line
                */
               left++;
            }
        }

        return new int[] { bestLeft, bestRight };
    }

    //As the smallest diff there can be is 0, so the pair obtained with sum === target should be returned

}

public class Main {
    public static void main(String args[]) {
        Employee e1 = new Developer("Manish", "Java");
        Employee e2 = new Developer("Jaya", "Angular");
        Employee e3 = new Developer("Anvit", "Python");

        ArrayList<Employee> developers = new ArrayList<>();
        developers.add(e1);
        developers.add(e2);
        developers.add(e3);
        Operation.processEmployees(developers);

        // DSA
        int[] arr1 = { 1, 3, 5, 8, 12 };
        System.out.println(Solution.closestPair(arr1, 10));
        System.out.println("arr1 | ***");

        int[] arr2 = { 2, 5, 9, 14 };
        System.out.println(Solution.closestPair(arr2, 12));
        System.out.println("arr2 | ***");

        int[] arr3 = { -10, -3, 1, 7, 15 };
        System.out.println(Solution.closestPair(arr3, 5)); // The example gives(-3,7) which is 4, where as (-10,15)
                                                           // gives 0 which logically is closed
        System.out.println("arr3 | ***");

        int[] arr4 = { 1, 4, 6, 9 };
        System.out.println(Solution.closestPair(arr4, 10));
        System.out.println("arr4 | ***");

        // DSA

    }
}

/*
 * Part 4 — Tiny Assessment
 * 1. List<Employee> a = new ArrayList<>(); -> The reference is of type List, a
 * contract of List is set
 * and it will compile if the object(here ArrayList) fulfills all the contract
 * methods
 * ArrayList<Employee> b = new ArrayList<>(); -> Here the reference and object
 * both are of same type, all methods
 * are callable here
 * 
 * 2. Reference type determines -> what members are
 * accessible through that reference.
 * Actual object type determines -> which overridden implementation runs
 * 
 * 3. Because there is single iteration and only one/or both pointers changes in
 * the single iteration
 * based on the condition.
 * 
 * 4. Rightm as the sum is larger, so we need to move right to bring sum closer
 * or equal to target
 * 
 * 5. In our code we are assuming, 0 is the closer sum, as both 1 and -1 return
 * same abs +ve value,
 * so 0 is closest.
 * 
 * Also I looked at syntax to find Absolute value(Math.abs()), almost 1 hour is
 * done
 */