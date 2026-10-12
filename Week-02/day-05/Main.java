/*
Q1. The 1st element to have exacty 2 count
Q2.  For one element it's total frequency and where did it appear 
        in the original array
Q3. We need final information as we need total frequency, as an item
     can duplicate itself first but can have another repition later on
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    /*
     * I am adding a brute force although not asked, just wanted to figure out
     * a solution
     * Time -> O(n^2)
     * Space -> O(1)-> since we are using the same currentElement only 1
     * extra space is used
     * 
     */
    public static int firstExactlyTwice(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int currentElementCount;
        for (int i = 0; i < nums.length - 1; i++) {
            if (seen.contains(nums[i]))
                continue;
            currentElementCount = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    currentElementCount++;
                }
            }
            if (currentElementCount == 2)
                return nums[i];
            seen.add(nums[i]);
        }
        return -1;
    }

    /*
     * I am adding a brute force although not asked, just wanted to figure out
     * a solution
     * Time -> O(n)
     * Space -> O(n)
     * 
     */
    public static int firstExactlyTwiceOptimised(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int element : nums) {
            frequency.put(
                    element,
                    frequency.getOrDefault(element, 0) + 1);
        }

        for (int element : nums) {
            if (frequency.get(element) == 2)
                return element;
        }
        return -1;
    }
}

public class Main {
    public static void main(String args[]) {
        String a = new String("hello");
        String b = new String("hello");

        System.out.println(a == b);
        System.out.println(a.equals(b));

        String name = "Manish";

        String upper = name.toUpperCase();

        System.out.println(name);
        System.out.println(upper);

        // DSA
        System.out.println("***");
        int[] nums1 = { 4, 7, 4, 2, 7, 7, 9, 2 };
        System.out.println(Solution.firstExactlyTwice(nums1));
        System.out.println(Solution.firstExactlyTwiceOptimised(nums1));
        System.out.println("***");

        int[] nums2 = { 5, 1, 5, 1, 5, 8, 8 };
        System.out.println(Solution.firstExactlyTwice(nums2));
        System.out.println(Solution.firstExactlyTwiceOptimised(nums2));
        System.out.println("***");

        int[] nums3 = { 1, 2, 3, 4 };
        System.out.println(Solution.firstExactlyTwice(nums3));
        System.out.println(Solution.firstExactlyTwiceOptimised(nums3));
        System.out.println("***");

        int[] nums4 = { 3, 3, 3, 2, 2 };
        System.out.println(Solution.firstExactlyTwice(nums4));
        System.out.println(Solution.firstExactlyTwiceOptimised(nums4));
        System.out.println("***");

        // DSA
    }
}

/*
    1. == uses the Object reference to check
       .equals() check equality based on characters present
    
    2. java -> due to immutability property .toUppercase() has not effect
        on the original String rather it returns a new string with Uppercase
            changes characters.
    
    3. == 2, means the count should be exact 2
       >=2 will include greater that 2 too, in todays DSA, we needed element
            with exact count as 2, so == was required here. 

    4. O(n) + O(n) -> O(n)

*/