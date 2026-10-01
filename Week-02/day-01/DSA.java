import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    
    /*
     * INPUT: An int array
     * OUTPUT: Return all unqiue pairs
     * Requirement: Need to check each element i with j in a nested loop -> return
     * if it is a pair, skip it if has been used or not form pair.
     * Final Information
     * If this value is part of another pair discard else check
     * 
     * Time is O(n^3) -> 2 n for loops and 1 for HashSet
     * Space -> O(n) for the HashSet
     */
    public static void allUniquePairsBrute(int[] arr, int target) {
        HashSet<Integer> usedValues = new HashSet<>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (usedValues.contains(arr[i]))
                continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (usedValues.contains(arr[j]))
                    continue;
                if (arr[i] + arr[j] == target) {
                    System.out.println(arr[i] + " , " + arr[j]);
                    usedValues.add(arr[i]);
                    usedValues.add(arr[j]);
                }
            }
        }
    }

    /*
     * INPUT: An int array
     * OUTPUT: Return all unqiue pairs
     * Requirement: Check diff of each element next values, if matched, move to finalLIst and mark both as checked
     * if it is a pair, skip it if has been used or not form pair.
     * Final Information
     * If this value is part of another pair discard else check
     *  Time is O(n)
     *  Space - not sure*(still confused with how space works)
     */
    public static ArrayList<ArrayList<Integer>> allUniquePairs(int[] arr, int target) {
        HashSet<Integer> usedValues = new HashSet<>();
        HashSet<Integer> currentDiffs = new HashSet<>();
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
           if(usedValues.contains(arr[i])) continue;
           int diff = target - arr[i];

           if(currentDiffs.contains(diff)){
              ArrayList<Integer> tempPairs = new ArrayList<>();
              tempPairs.add(diff);
              tempPairs.add(arr[i]);
              finalList.add(tempPairs);
              usedValues.add(arr[i]);
              usedValues.add(diff);
           }
           else{
            currentDiffs.add(arr[i]);
           }         
        }
        return finalList;
    }
}

public class DSA {
    public static void main(String args[]) {
        int[] arr1= {1,5,3,3,2,4,4};
        int target1 = 6;

        int[] arr2= {3};
        int target2 = 6;
        
        int[] arr3= {3,3};
        int target3 = 6;
        
        int[] arr4= {1,5,1,3,3,2,2,4,2,4,5,1};
        int target4 = 8;
        
        int[] arr5= {3,3};
        int target5 = 6;

        Solution.allUniquePairsBrute(arr1,target1);
        System.out.println(Solution.allUniquePairs(arr1,target1));
        System.out.println("***");

         Solution.allUniquePairsBrute(arr2,target2);
         System.out.println(Solution.allUniquePairs(arr2,target2));
         System.out.println("***");

         Solution.allUniquePairsBrute(arr3,target3);
         System.out.println(Solution.allUniquePairs(arr3,target3));
         System.out.println("***");

         Solution.allUniquePairsBrute(arr4,target4);
         System.out.println(Solution.allUniquePairs(arr4,target4));
         System.out.println("***");

         Solution.allUniquePairsBrute(arr5,target5);
        System.out.println(Solution.allUniquePairs(arr5,target5));
        System.out.println("***");
    }
}
