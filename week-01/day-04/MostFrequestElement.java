import java.util.HashMap;
import java.util.Map.Entry;

class Solutions{

    public static int bruteForce(int arr[]){
        int maxCountElement = 0;
        int maxCount = 0;
        for(int i=0;i < arr.length;i++){
            int count = 1;
            for (int j = 0; j<arr.length; j++){
                if(i == j) continue;
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count>maxCount){
                maxCount = count;
                maxCountElement = arr[i];
            } 
        }
        return maxCountElement;
    }

    public static int optimized(int arr[]){
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int val: arr){
            if(freq.containsKey(val)) {
                freq.put(val, freq.get(val) +1);
            }
            else {
                freq.put(val, 1);
            }
        }


        
        int highestFreqElement = 0;
        int highestFreqValue = 0;
        for(Entry<Integer, Integer> entry: freq.entrySet()){
            if(entry.getValue() > highestFreqValue){
                highestFreqValue = entry.getValue();
                highestFreqElement = entry.getKey();
            }
        }

        return highestFreqElement;
       
    }
}

public class MostFrequestElement {
    public static void main(String Args[]){
        int[] param  = {1, 3, 2, 3, 4, 3, 2};
        //System.out.println(Solutions.bruteForce(param));
        System.out.println(Solutions.optimized(param)); 
    }
}
