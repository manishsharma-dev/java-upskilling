import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 nums   = [1, 2, 4, 7, 8, 11, 15] -> target = 10
        answer = [2, 8]
 Q1. return the pair which sums upto target, assuming only there is only 1
 Q2. For the value, the difference of the target - the value will return the pair
     so we need to find that
 Q3. the array is sorted, so if we take that into consideration, we don't need
     to start from 1st 2 values, we can start from i at 1st and j  at
      last and increase
      i and decrease j based on current sum.
      So, after some rough sketching, I figured out that if 
        - sum of element  i+ j > target, we have to decrease j 
        - sum of element  i+ j < target, we have to increase i
        if we find sum before i crosses j, return the values else
            return blank list. 
 */
class Solution {
    /*
     * Time -> O(n^2) => as we are nesting on the same array
     * Space -> O(1) => since we are creating a fixed array of size 2
     */
    public static List<Integer> twoSumSortedBrute(int[] nums, int target) {
        List<Integer> pair = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    pair.add(nums[i]);
                    pair.add(nums[j]);
                    return pair;
                }
            }
        }
        return pair;
    }

    /*
     * Time -> O(n) => single loop
     * Space -> O(1) => fixed extra space
     */
    public static List<Integer> twoSumSortedOptimized(int[] nums, int target) {
        List<Integer> pair = new ArrayList<>();
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i] + nums[j] == target) {
                pair.add(nums[i]);
                pair.add(nums[j]);
                return pair;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return pair;
    }
}

public class Main {
    public static void main(String args[]) {
        int[] nums1 = { 1, 2, 4, 7, 8, 11, 15 };
        int[] nums2 = {2,3,5,8,12};
        int[] nums3 = {1,4,6,10};
        int[] nums4 = {-5,-2,1,4,9};
        

        System.out.println(Solution.twoSumSortedBrute(nums1, 10));
        System.out.println(Solution.twoSumSortedOptimized(nums1, 10));
        System.out.println("***");

        System.out.println(Solution.twoSumSortedBrute(nums2, 13));
        System.out.println(Solution.twoSumSortedOptimized(nums2, 13));
        System.out.println("***");

        System.out.println(Solution.twoSumSortedBrute(nums3, 11));
        System.out.println(Solution.twoSumSortedOptimized(nums3, 11));
        System.out.println("***");

        System.out.println(Solution.twoSumSortedBrute(nums4, 7));
        System.out.println(Solution.twoSumSortedOptimized(nums4, 7));
        System.out.println("***");

        System.out.println(Solution.twoSumSortedBrute(nums3, 17));
        System.out.println(Solution.twoSumSortedOptimized(nums3, 17));
        System.out.println("***");
    }
}

/*
PART 4 : 
                    Time        Extra Space                         Required Sorted input

    Nested Loop -    O(n^2)    fixed space(return value)           No, we are anyway checking all values 1 by 1

    HashMap Two Sum-  O(n)      O(n) for storing the list              Not required

    Two pointers -   O(n)        fixed space for indexes and            Yes
                                    return values

    Q1. Saves extra space of HashSet

    Q2. No, since it is not sorted, the change of index based on currentsum will not work as we
            won't know which index to change

PART 5 : 
    1. List is preferrable so reduce uneccessary coupling
    2. It will not compile as List is an interface and it can only be used
				as a reference and its object can not be created. 
    3. Right
    4. left
    5. Time -> O(n) => single loop
       Space -> O(1) => fixed extra space

*/