import java.util.HashMap;
import java.util.HashSet;

/*
Q1. I need to return 1st whose duplicate value exists in the array and not the 1st value whose
    duplicate was found
Q2. for a candidate i, it should find it's duplicate regardless of the fact when it was found.
Q3. FINAL information about the entire array -> we need this as we need to find duplicate upto last value
    -> eg, in [1,2,3,4,2,1]; -> although 2 finds its duplicate 1st, but until we go to last index, we don't see that
        1 has a duplicate too, which makes it the right answer
    (just thinking) -> I will need 2 info. here, have I seen this before and when did I see it
      so if I keep going through each element and keep a track of each, 
*/
class Solution {
    /*
    Time -> O(n^2) -> nested loop on same array
    Space -> O(1) -> No extra space needed(Please verify)
    */
    public static int firstRepeatingBrute(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return nums[i];
            }
        }
        return -1;
    }

    /*
    Time -> O(n) -> single loop on same array
    Space -> O(n) -> HashMap can grow to same size for all unqiue items.
    */
    public static int firstRepeatingOptimized(int[] nums){
        // n= [10, 5, 3, 4, 3, 5, 6]; 
        int lowestSeenIndex = nums.length;
        HashMap<Integer, Integer> seenIndexMap = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            if(seenIndexMap.containsKey(nums[i])){
                if(seenIndexMap.get(nums[i]) < lowestSeenIndex){
                    lowestSeenIndex = seenIndexMap.get(nums[i]);
                }
            }
            else{
                seenIndexMap.put(nums[i], i);
            }
        }
        if(lowestSeenIndex !=  nums.length){
            return nums[lowestSeenIndex];
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Amit", 50000);
        Employee e2 = new Employee(101, "Rahul", 90000);
        Employee e3 = new Employee(102, "Amit", 50000);

        System.out.println(e1.equals(e2));
        System.out.println(e1.equals(e3));

        HashSet<Employee> employees = new HashSet<>();

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        System.out.println(employees.size());

        /* DSA */
        int[] n1 = { 10, 5, 3, 4, 3, 5, 6 };
        int[] n2 = { 7, 1, 4, 7, 1 };
        int[] n3 = { 1, 2, 3, 4 };

        System.out.println(Solution.firstRepeatingBrute(n1));
        System.out.println(Solution.firstRepeatingOptimized(n1));
        System.out.println("***");

        System.out.println(Solution.firstRepeatingBrute(n2));
        System.out.println(Solution.firstRepeatingOptimized(n2));
        System.out.println("***");

        System.out.println(Solution.firstRepeatingBrute(n3));
        System.out.println(Solution.firstRepeatingOptimized(n3));
        System.out.println("***");

        /* DSA */
    }
}

/*
 * Here the equals() method is overridden to compare Employee objects based on
 * their employeeId.
 * The hashCode() method is also overridden to ensure that Employee objects with
 * the same employeeId
 * have the same hash code. So 101 for 2 2 objects will be considered equal and
 * only one of them will
 * be stored in the HashSet.
 */

/*
Part 7: 
        A. Time is O(n+n) which can written as O(n)
        B. Space O(n)
        C. O(n^2)


Assessment:
    1.  e1 == e2 -> checks the reference to be equal for the objects.
        e1.equals(e2) -> we can overide the equals method to set our equality condition.
    
    2.  a.equals(b) == true -> hash codes must also be equal
    3.  a.hashCode() == b.hashCode() -> does not guarantee a.equals(b) to be true, 
            as the equality condition added in the equals() overridden method
             may be more complex
    4.  As HashSet/HashMap use hashCode for there operations, incorrectly handling it may cause 
         them to behave not as expected.
    5. Running 2nd loop after 1st completes on same array sets time complexity to O(n+n)
         or simply denoted as O(n)
*/