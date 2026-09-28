import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public static int firstUniqueBruteForce(int arr[]){
            int count;
            for(int i= 0;i<arr.length;i++){
                count = 1;
                for(int j= 0; j<arr.length;j++){
                    if(i == j)  continue;
                    if(arr[i] == arr[j]) {
                        count++;
                        break;
                    };
                    
                }
                if(count == 1) return arr[i];
            }
            return -1;
    }

    public static int firstUniqueOptimized(int arr[]){
        HashMap<Integer,Integer> list =  new HashMap<>();
        
        for(int ele : arr){
            if(list.containsKey(ele)) list.put(ele, list.get(ele) +1);
            else list.put(ele, 1);
        }
        
        for(Entry<Integer, Integer> entry: list.entrySet()){
            if(entry.getValue() == 1 ){
              return entry.getKey();
            }
        }

        return -1;
    }
}


public class Dsa {
    public static void main(String args[]){
        int[] arr =  {1,2,3,1,2,3,4,5,4,5,6,7}; //{4, 5, 1, 2, 1, 4, 5};
       int uniqueValue =  Solution.firstUniqueBruteForce(arr);
       if(uniqueValue != -1) System.out.println("The 1st non repeating value is "+ uniqueValue);

       int optimizedUniqueValue = Solution.firstUniqueOptimized(arr);
       if(optimizedUniqueValue != -1) System.out.println("The 1st non repeating value thorugh optimizes algo is "+ uniqueValue);
    }
}
