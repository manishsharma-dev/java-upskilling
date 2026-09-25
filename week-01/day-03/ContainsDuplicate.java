import java.util.HashSet;

class Solution{
    public static boolean bruteForce(int arr[]){  // O(n^2)
        if(arr.length == 0){
            return false;
        }
        for(int i= 0;i<arr.length - 1; i++){
            for(int j= i+1; j<arr.length; j++){
                    if(arr[i] == arr[j]) return true;
            }
        }
        return false;
    }

    public static boolean optimised(int arr[]){ // O(n)
        if(arr.length == 0){
            return false;
        }
        HashSet<Integer> uniques = new HashSet<>();

        for(int val: arr){
            if(uniques.contains(val)) return true;
            uniques.add(val);
        }
        return false;
    }

    public static int firstDuplicate(int arr[]){ // O(n)
        
        HashSet<Integer> uniques = new HashSet<>();

        for(int val: arr){
            if(uniques.contains(val)) return val;
            uniques.add(val);
        }
        return -1;
    }
}

public class ContainsDuplicate {
    public static void main(String args[]){
        int[] bruteForceParams  = {1,2,3,1};
        int[] optimisedParams = {1,2,3,4,3};
        int[] firstDuplicateParams = {4, 2, 7, 4, 8, 2};

        System.out.println(Solution.bruteForce(bruteForceParams));
        System.out.println(Solution.optimised(optimisedParams));
        System.out.println(Solution.firstDuplicate(firstDuplicateParams));
    }
}
