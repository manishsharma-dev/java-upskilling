import java.util.HashSet;

class Solution{
    public static HashSet<Integer> findCommon(int a[],int b[]){
        HashSet<Integer> aHash = new HashSet<>();
        HashSet<Integer> mainHash = new HashSet<>();

        for(int elem : a){
            aHash.add(elem);
        }
        
        for(int elem : b){
            if(aHash.contains(elem)){
                mainHash.add(elem);
            }
        }
       return mainHash;

    }
}

public class Intersection {
    public static void main(String args[]){
    int[] a = {1, 2, 2, 3, 4,5};
    int[] b = {2, 2, 4, 6, 5};
    
    HashSet<Integer> result = Solution.findCommon(a, b);
    for(int el : result){
        System.out.println(el);
    }
    }
}
