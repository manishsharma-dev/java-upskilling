import java.util.HashSet;

class Solution{
    public static int firstDuplicateBruteForce(int[] nums){
        int lowerIndex = nums.length;
        for(int i= 0; i < nums.length-1; i++){            
            for(int j= i+1;j < nums.length; j++){
                    if(nums[i] == nums[j] && j< lowerIndex){
                            lowerIndex = j;
                    }
            }
        }
        if(lowerIndex < nums.length) return nums[lowerIndex];
        //if(lowerIndex < nums.length) return lowerIndex;  // to return index instead of value
        return -1;
    }   
    
    public static int firstDuplicateOptimize(int[] nums){
        HashSet<Integer> uniqueList = new HashSet<>();
        
        for(int i=0; i< nums.length; i++){
            if(uniqueList.contains(nums[i])) return nums[i];  // to return index return i instead of nums[i]
            uniqueList.add(nums[i]);
        }
        return -1;
    }
}

public class Main {
    public static void main(String args[]){
        int[] arr = {7, 3, 8, 3, 7}; //{2, 5, 1, 3, 5, 2}; //{1, 2, 2, 1};

        //System.out.println(Solution.firstDuplicateBruteForce(arr));
        System.out.println(Solution.firstDuplicateOptimize(arr));
    }
}
