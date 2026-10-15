/*
Part 1 — Cold Recall
 Q1. 
    throw new IOException("File unavailable"); -> Handles the error through exception
    throws IOException -> declares that it may propagate exception

 Q2.
    It is providing the flexibility for the object to be anything that implements the
            contract st by List, any object that satisfies this  contract can be
             assigned to the variable of type List. This is the flexibility.

 Q3.
    Read pointer -> Handles the iteration and is responsible for finding the next unqiue
                    value in the array.
    write pointer -> It is responsible for keeping track of the position at which the next
                        unqiue value will be written.
    The requirement was to move all unque values to the front, as we are sending the
            reference of the array(which is an object), so the original array needed
            to be modified.
  
 Q4. Time in still O(n) as the read pointer is bound by n.
     Extra space is O(1) as constant extra space is used by read and write pointers.

     Exercise A
       - Box<String> a = new Box<>("Angular"); -> YES
       - Box<Integer> b = new Box<>(100); -> YES
       - Box<String> c = new Box<>(100); -> No, trying to set an Integer Value in String
       - Box<int> d = new Box<>(100); -> Generics accept only reference types?

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Exercise B
class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static <T> T getFirst(List<T> items) {
        if (items.size() == 0) {
            throw new IllegalArgumentException("The array is empty");
        }

        return items.get(0);
    }
}

public class Main {
    public static void main(String args[]) {
        List<String> names = new ArrayList<>();
        names.add("Manish");
        names.add("Java");
        names.add("Anvit");

        System.out.println(Box.getFirst(names));

        List<Integer> ages = new ArrayList<>();
        ages.add(32);
        ages.add(30);
        ages.add(2);
        System.out.println(Box.getFirst(ages));

        /* DSA */
        int[] nums = { 0, 1, 0, 3, 12 };
        /*
         * readIndex WriteIndex arr[readIndex] arr[writeIndex] arr(initial)
         * 0 1 0 1 [0, 1, 0, 3, 12]
         * 1 2 0 0 [1, 0, 0, 3, 12]
         * 1 3 0 3 [1, 0, 0, 3, 12]
         * 2 4 0 12 [1, 3, 0, 0, 12]
         * 2 5 0 - [1, 3, 12, 0, 0]
         */
        int[] nums2 = { 0, 0, 1 };
        int[] nums3 = { 1, 2, 3 };
        int[] nums4 = { 0, 0, 0 };
        int[] nums5 = { 4, 0, 5, 0, 6 };
        int[] nums6 = {};
        int[] nums7 = { 1, 0, 0, 2, 3 };

        // Solution.moveZeroes(nums);
        // Solution.moveZeroes(nums2);
        // Solution.moveZeroes(nums3);
        // Solution.moveZeroes(nums4);
        // Solution.moveZeroes(nums5);
        // Solution.moveZeroes(nums6);
        Solution.moveZeroes(nums7);

        // System.out.println(Arrays.toString(nums));
        // System.out.println(Arrays.toString(nums2));
        // System.out.println(Arrays.toString(nums3));
        // System.out.println(Arrays.toString(nums4));
        // System.out.println(Arrays.toString(nums5));
        // System.out.println(Arrays.toString(nums6));
        System.out.println(Arrays.toString(nums7));
        /* DSA */
    }
}

/*
 * Exercise B
 * List<Integer> numbers = new ArrayList<>(); -> Generics only work with
 * reference types and the statement works as 10 will be
 * auto converted from int to Integer because of autoboxing
 * The 2nd one won't work because of the same reason as the type passed to List
 * is primitive
 */

/*
 * Part 3 — DSA
 * 
 * Q1. We need to return the array with all 0s at the end and rest values in the
 * beginning
 * in the order they occured in the original array
 * Q2. If the element is 0, move to end, if non 0 ,
 * move to the next non zero value at the beginning
 * Q3. Yes, we need to move the non 0s to beginning in the order they appeared
 * originally
 * Just thinking --> (If we take 2 pointers, 1 at index 0(say zeroIndex) and one
 * at 1(say track))
 * we check if start is 0 and track is non zero -> we exchange the values
 * If the zeroIndex always points at zero and tracker acts as iterator finding
 * new non-zeros to
 * swap, need to check...
 */
class Solution {
    /*
     * Time -> O(n) -> trackerIndex is bound to arr.length(n)
     * Space -> O(1) -> constant space
     */
    public static void moveZeroes(int[] arr) {
        Number value = Integer.valueOf(10);

        try {
            System.out.println("start");
            System.out.println(10 / 0);
            System.out.println("worked");
        } finally {
            System.out.println("error");
        }
        if (arr == null || arr.length == 0)
            return;

        int writeIndex = 0;
        int readIndex = 1;

        while (readIndex < arr.length) {
            if (arr[writeIndex] == 0) {
                if (arr[readIndex] == 0) {
                    readIndex++;
                    continue;
                }
                if (arr[readIndex] != 0) {
                    arr[writeIndex] = arr[readIndex];
                    arr[readIndex] = 0;
                }
            }
            writeIndex++;
            readIndex++;
        }
    }

    public static void moveZeroes1(int[] nums) {
        if (nums == null) {
            return;
        }

        int writeIndex = 0;

        // First pass: move non-zero values forward
        for (int readIndex = 0; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != 0) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }

        // Second pass: fill remaining positions with zeroes
        while (writeIndex < nums.length) {
            nums[writeIndex] = 0;
            writeIndex++;
        }
    }
}

/*
 * Part 4
 * 1. Generics are helpful to make a type dynamic in such a way that it catches
 * a mismatch in type
 * at compile time.
 * 2. A. It sets the type of Generic in passed to the class
 * B. It sets the type of the paramater passed to the method.
 * 
 * 3. The reference type of int primitive is Integer,
 * so I don't think using Number as a type will work, but if there is reference
 * type Number which is
 * a parent class of Integer it will work
 * 4. read pointer tracks or iterates all elements write pointer tracks the
 * index of current 0 in
 * the list to be swapped
 * 5. [5,7,0,0]
 * 
 * 6. The last index can be a non zero(which is true in this case) which needs
 * to be swapped, so it is necessary
 * to track all elements
 * 7. Since the 2 passess are happening 1 after another and non in a nested way,
 * it is still going to be O(n)
 */