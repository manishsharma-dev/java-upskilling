/*
Part 1 — Cold Recall
    Q1. It is not making is mandatory for the object to be an ArrayList,
            any object that satisfies this  contract can be assigned to the
            variable of type List. This gives us flexibility.
    Q2. Since HashMap stores data as a key-> value pair, having
            employeeId as key and employee object as value will
            make the retrieval of the employee object based on
            key that is employeeId will be faster.
    Q3. start   last    sum     target  check       move
         1        12    13       10      13 > 10     right --
         1        8      9        10      9 <10      left ++
         and so on....

    q4. The total number of inward movement of the pointers is bounded
            by n, thats why complexity is O(n)

Exercise A:
    1. Yes, an unchecked exception, will work
    2. No, need the method to throw the error - IOException
            - public static void test() throws IOException{}
    3. Yes, checked exception properly handled

Exercise B:
    A
    B
    C
    D
    Finally is used to execute an statement  when an error is
        encountered and handled, it will run in all cases.
*/

import java.io.IOException;

class LearnJava {
    public static void readFile() throws IOException {
        throw new IOException("File unavailable");
    }
}

/*
 * Part 3 — DSA:
 * Q1. return the count of all unqiue elements from an array
 * eg arr -> [1,1,2,2,3]
 * will make the unqiue items -> [1,2,3]
 * which will return the count 3.
 *
 * Q2. while iterating, once a values has passed, it won't occur again
 *
 * Q3. I think, we will need 2 pointers moving in the same direction
 * here, as we need unique values at the end
 * 1 can keep track of duplicates and 1 of the actual value
 * Q4. Since we need to return the count, we can use the same array
 * for iteration and keep counting the unique values
 */
class Solution {
    /*
     * Time -> O(n) -> value of tracker increment bound to n
     * Space -> O(1) -> constant space for readIndex + uniqueIndex + counter
     */
    public static int removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int readIndex = 1;
        int writeIndex = 0;

        while (readIndex < arr.length) {

            if (arr[readIndex] == arr[readIndex - 1]) {
                readIndex++;
            } else {
                writeIndex++;
                arr[writeIndex] = arr[readIndex];
                readIndex++;
            }
        }

        // while (readIndex < arr.length) {
        // if (uniqueIndex == readIndex) {
        // counter++;
        // readIndex++;
        // } else if (arr[uniqueIndex] == arr[readIndex]) {
        // readIndex++;
        // } else {
        // uniqueIndex = readIndex;
        // }
        // }
        return writeIndex + 1;
    }
}

public class Main {
    public static void main(String args[]) {
        int[] arr1 = { 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(Solution.removeDuplicates(arr1));
        System.out.println("***");

        int[] arr2 = { 1, 1, 1, 1 };
        System.out.println(Solution.removeDuplicates(arr2));
        System.out.println("***");

        int[] arr3 = { 1, 2, 3, 4 };
        System.out.println(Solution.removeDuplicates(arr3));
        System.out.println("***");

        int[] arr4 = {};
        System.out.println(Solution.removeDuplicates(arr4));
        System.out.println("***");
    }
}

/*
 * Part 4 — Mini Assessment
 * 1. unchecked need not to be handled
 * checked will throw compiler error if not handled
 * 
 * 2. It must always run as long as there are not errors which
 * causes the program to terminate like system failure,
 * power outage, JVM termination, so as long as external
 * factors don't interfare, finally runs.
 * 
 * 3. As we are sure we won't encounter a value, once it has passed
 * so we need to track it only as long as it's 1st stretch of
 * ocurrences.
 * 4. occurences?
 * 5. Target Time O(n) Target space O(1).
 * 
 * Since this was 1st day, I used dictation to write the cold call answers,
 * but typing on touch pad was feeling wierd to I moved to laptop.
 * 
 * One doubt, as per my understanding, I need to return the final count only
 * , the problem keeps saying to remove the duplicates as well.
 * Do I have to do that as well and correct my solution.
 * 
 * 
 */