import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main{
  public static void main(String args[]){
    // ArrayList<Integer> marks = new ArrayList<>();

    // marks.add(78);
    // marks.add(91);
    // marks.add(65);
    // marks.add(88);
    // marks.add(95);

    // System.out.println(marks.get(0));
    // System.out.println(marks.size());

    // marks.remove(3);

    // for(int val: marks){
    //     System.out.println(val);
    // }

    // HashSet<String> technologies = new HashSet<>();

    // technologies.add("Angular");
    // technologies.add("Java");
    // technologies.add("Spring");
    // technologies.add("Java");

    // System.out.println(technologies);

    // System.out.println(technologies.contains("Java"));

    // HashSet<String> technologies = new HashSet<>();

    // technologies.add("Java");
    // technologies.add("Angular");
    // technologies.add("Java");
    // technologies.add("Spring");
    // technologies.add("Angular");
    // technologies.add("Java");

    // for(String val: technologies){
    //     System.out.println(val);
    // }

    //  HashMap<String, Integer> scores = new HashMap<>();

    //  scores.put("Manish", 45);
    //  scores.put("Jaya", 90);

    //  System.out.println(scores.get("Manish"));

    //  System.out.println(scores.containsKey("Manish"));
    //  System.out.println(scores.get("Manish"));
    //  scores.put("Manish", 95);
    //  System.out.println(scores.get("Manish"));

    // HashMap<String, Integer> inventory = new HashMap<>();

    // inventory.put("Laptop", 5);
    // inventory.put("Mouse", 10);
    // inventory.put("Keyboard", 7);

    // inventory.put("Mouse", inventory.get("Mouse") - 2);

    // System.out.println(inventory.get("Mouse"));

    Integer[] arr = {2,7,11,15}; 
    ArrayList<Integer> result = new ArrayList<>();

    int target = 9;

    HashMap<Integer,Integer> temp = new HashMap<>();

    for(int i = 0; i<arr.length - 1; i++){
        for(int j = i+1; j<arr.length;j++){
            if(arr[i]+ arr[j] == target){
                result.add(i);
                result.add(j);
            }
        }
    }

    if(result.size() != 0){
        for(int val:result){
            System.out.println(val);
        }
    }
    else {
        System.out.println("Target not found in the array");
    }

    for(int i = 0;i<arr.length;i++){
        int complement = target - arr[i];

        if(temp.containsKey(complement)){
            result.add(temp.get(complement));
            result.add(i);
        }
        else {
            temp.put(arr[i], i);
        }
    }

     if(result.size() != 0){
        for(int val:result){
            System.out.println(val);
        }
    }
    else {
        System.out.println("Target not found in the array");
    }
  }
}