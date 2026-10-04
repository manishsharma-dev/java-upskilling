import java.util.HashSet;

class Solution {
    
    /*
    1. Need to return missing number from an array based on a given range
    2. check the candidate against all the numbers if it does not exists
    3. For optimised, we can you Hassets to store all array elements and
     then go one by one in the range and return the element missing from the 
     hashset
     Time -> O(arrayLength * range) => O(n^2)
     Space -> O(1) -> since we are using only 1 extra space for flag boolean
    */
    public static int firstMissing(int[] arr, int start, int end) {
        // for(int i = 0; i<end; i++){
        // if(i < arr.length-1 && arr[i] != start){
        // return start;
        // }
        // else if(i>arr.length-1) return start; // considering the range(end can be
        // larger than the last digit of array)
        // start ++;
        // }
        for (int i = start; i <= end; i++) {
            Boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                if (i == arr[j])
                    flag = true;
            }
            if (flag == false)
                return i;
        }
        return -1;
    }

    /*
    Time-> O(arrayLength + range) -> O(n)
    space -> O(n) -> Hashset on array length
    */
    public static int firstMissingOptimize(int[] arr, int start, int end) {
        HashSet<Integer> list = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        for (int i = start; i <= end; i++) {
            if (list.contains(i) == false)
                return i;
        }
        return -1;
    }
}

class Calc {
    public static int divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Dividing by zero is not allowed");
            return -1;
        }

    }
}

public class Main {
    public static void main(String args[]) {
        // Calc.divide(10,2);
        // Calc.divide(10,0);

        int[] arr1 = { 3, 4, 5, 6, 7 };
        int[] arr2 = { 1, 2, 4, 6 };
        int[] arr3 = { 2, 3, 4 };
        int[] arr4 = { 1, 2, 3, 4, 5 };
        int[] arr5 = { 3, 4, 5 };

        System.out.println(Solution.firstMissing(arr1, 3, 9));
        System.out.println(Solution.firstMissingOptimize(arr1, 3,9));
        System.out.println("***");
        System.out.println(Solution.firstMissing(arr2, 1,6));
        System.out.println(Solution.firstMissingOptimize(arr2, 1,6));
        System.out.println("***");
        System.out.println(Solution.firstMissing(arr3, 1,5));
        System.out.println(Solution.firstMissingOptimize(arr3, 1,5));
        System.out.println("***");
        System.out.println(Solution.firstMissing(arr4, 1,5));
        System.out.println(Solution.firstMissingOptimize(arr4, 1,5));
        System.out.println("***");
        System.out.println(Solution.firstMissing(arr5, 3,6));
        System.out.println(Solution.firstMissingOptimize(arr5, 3,6));
    }
}