import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

class Solution{

    //Time -> O(n^2) , space O(1)
    public static int firstKOccurenceBrute(int arr[], int k){ 
        int lowestIndex = arr.length;
        int lowestVal = -1; 
        for(int i = 0; i < arr.length;i++){
            if(i >= lowestIndex) return lowestVal;
            int currentCount = 1;
            for(int j = 0;j < arr.length;j++){
                if(i == j) continue;
                if(arr[i] == arr[j]) currentCount++;
                if(currentCount == k && j < lowestIndex) {
                    lowestIndex = j;
                    lowestVal = arr[j];
                    break;
                }
            }
        }
        return lowestVal;
    }

    //Time o(n) space O(n)
    public static int firstKOccurenceOptimized(int arr[], int k){
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i< arr.length; i++){
            if(freq.containsKey(arr[i])){
                freq.put(arr[i],freq.get(arr[i])+1);                
            }
            else{
                freq.put(arr[i],1);
            }
            if(freq.get(arr[i]) == k) return arr[i];
        }
        return -1;
    }

    //Time o(n) space O(n)
    public static ArrayList<Integer> allUnique(int arr[]){
        ArrayList<Integer> unqiqueList = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i< arr.length; i++){
            if(freq.containsKey(arr[i])){
                freq.put(arr[i],freq.get(arr[i])+1);
            }
            else{
                freq.put(arr[i],1);
            }
        }

       for(int elem: arr){
            if(freq.get(elem) == 1 ){
              unqiqueList.add(elem);
            }
        }
        return unqiqueList;
    }
}

public class Main {
   public static void main(String args[]){
    //int[] nums =  {4, 2, 7, 2, 4, 2, 7}; // {1, 2, 1, 2, 2};
    int[] nums = {1, 2, 1, 2, 2}; //{3, 1, 4, 1, 5, 3, 6};
    int k =  3;
    int[] numns2 = {8,5,3};
    int[] un = {3,1,4,1,5,3,6};
    int x = 1;

    // System.out.println(Solution.firstKOccurenceBrute(nums,k));
     System.out.println(Solution.firstKOccurenceOptimized(nums,k));
    System.out.println(Solution.firstKOccurenceOptimized(numns2,x));

    System.out.println(Solution.allUnique(un));
   }    
}
