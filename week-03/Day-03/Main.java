/*
Part 1 — Cold Recall
    Q1. It will not compile because List<Integer> is not a subclass of List<Number>
    Q2. A. Here T sets class type
        B. Here T is is it's own type, which can be used for return type, parameter type
            and local declarations
    Q3. Since the logic is to move non 0 values to front, when encountering 0 we move to
            next value looking for non 0.
    Q4. Since the loops are one after another, the complexity is O(n) + O(n) which
            is simply O(2n) simplified to O(n)

Exercise B - 
    // List<? extends Number> a = new ArrayList<Integer>();
        // List<? super Number> b = new ArrayList<Number>();

        // Number x = a.get(0); // works, (Upper bound widlcard - used for reading);
        // a.add(25); // does not work, (Upper bound widlcard);
        // b.add(25); // work, (Lower bound widlcard);
        // b.get(0); // compiles, (but not safe);
        // Integer y = b.get(0); //does not compile

        // Object z= b.get(0); //compiles
*/

import java.util.ArrayList;
import java.util.List;

class Practice {
    public static <T extends Number> double average(List<T> numbers) {
        if (numbers.size() == 0) {
            throw new IllegalArgumentException("Empty array found");
        }
        double sum = 0;
        for (Number element : numbers) {
            sum += element.doubleValue();
            // We need to convert number to double as return type is set to double
        }
        return sum / numbers.size();
    }

}

public class Main {
    public static void main(String args[]) {
        // List<Double> doubles = new ArrayList<>();
        // doubles.add(20.2);
        // doubles.add(32.4);
        // doubles.add(48.6);
        // doubles.add(72.8);
        // System.out.println(Practice.average(doubles));

        // List<Integer> ints = new ArrayList<>();
        // ints.add(20);
        // ints.add(32);
        // ints.add(48);
        // ints.add(72);
        // System.out.println(Practice.average(ints));

        //DSA

        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("s1 : " + Solution.isPalindrome(s1));
        System.out.println("***");

        String s2 = "Madam";
        System.out.println("s2 : " + Solution.isPalindrome(s2));
        System.out.println("***");

        String s3 = "ab@a";
        System.out.println("s3 : " + Solution.isPalindrome(s3));
        System.out.println("***");
        
        String s4 = "abc";
        System.out.println("s4 : " + Solution.isPalindrome(s4));
        System.out.println("***");

        String s5 = "!!!";
        System.out.println("s5 : " + Solution.isPalindrome(s5));
        System.out.println("***");

        String s6 = "1a2";
        System.out.println("s6 : " + Solution.isPalindrome(s6));
        System.out.println("***");

        String s7 = "0P";
        System.out.println("s7 : " + Solution.isPalindrome(s7));
        System.out.println("***");

        

        
    }
}

/*
 * DSA
 * Q1. all non alphanumeric
 * Q2. We can inspect the original array
 * Q3. Since we are checking palindrome, any valid character not matching at
 * opposite
 * end will return false
 * Q4. We move left forward and check with next alphanumeric, same for right
 */
class Solution {
    /*
    Time -> O(n) -> as the value of left or right is bound by utmost n(size of string)
    Space -> O(1) -> The space remains constant and does not grow according to n
    Yes
    */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (Character.isLetterOrDigit(leftChar) == false) {
                left++;
                continue;
            }
            if (Character.isLetterOrDigit(rightChar) == false) {
                right--;
                continue;
            }
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
                //Once a mismatch is found, it already disobeys palindrome property
            }
            left++;
            right--;

        }

        return true;
    }
}

/*
Assessment
  1. T must be a number or one of its subclasses
  2. because accepted number can be double and adding integer would violate the element type
  3. because the List can contain other types.
  4. Yes, Double is a subclass of Number
  5. Since only alpahnumerics qualify to be palindrome
  6. since 0 != p, so false
  7. if we use a variable which grows with the iteration through n , the space will be O(n)
      eg: if we keep a arrayList of each visited character.

P.S. -> I am still not very confident with generics, I will need some more time with it,
        I still don't clearly understand everything, maybe I will need few more sessions, apologies.
    
*/