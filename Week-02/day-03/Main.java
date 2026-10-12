import java.util.HashSet;
import java.util.Set;
/*
1.	
	1. Employee e = new Manager(...);
		e calls all the public methods of Employee and all Overridden methods of Employee in Manager
	   Reportable r = new Manager(...);
		r calls all the methods Overridden by Manager of the interface Reportable
	   Manager m = new Manager(...);
	    m call all the public methods of Manager
		
		which overridden implementation executes at runtime - the reference type determine that.
		
	2. throw new IllegalArgumentException("Invalid") - As I understood, this statement raise an exception and
		catch(...) handles the raise exception
		
	3.	A
		C
		D
	
	4. Here, since set.contains runs n time and it has complexity of O(1),
		So O(1) runs n time, so final will be O(n)
		
		For 2nd loop, .conatins() in an ArrayList has complexity of O(n),
		since loop runs n times so final will be O(n^2)
*/
class Solution {
    /*
    - I have to return common for both arrays based on there first 
    - appearance in 2nd array.
    - Is it present in the 1st array
    - HashSet can return that in o(1) complexity
    */
   /*
    Time -> O(n^2)
    Space -> O(1)
    */
    public static int firstCommon(int[] a, int b[]) {

        for (int elem : b) {
            for (int child : a) {
                if (elem == child)
                    return elem;
            }
        }

        return -1;
    }

    /*
    Time -> O(n)
    Space -> O(n)
    */
    public static int firstCommonOptimize(int[] a, int b[]) {
        Set<Integer> aSet = new HashSet<>();
        for (int elem : a) {
            aSet.add(elem);
        }

        for (int elem : b) {
            if (aSet.contains(elem))
                return elem;
        }
        return -1;
    }
}

public class Main {
    public static void main(String args[]) {
        /* DSA */
        int[] a = { 7, 2, 9, 4 };
        int[] b = { 5, 9, 2, 8 };

        System.out.println(Solution.firstCommon(a,b));
        System.out.println(Solution.firstCommonOptimize(a,b));
        System.out.println("***");

        int[] a2 = {10, 20, 30};
        int[] b2 = {5, 6, 20, 10};

        System.out.println(Solution.firstCommon(a2,b2));
        System.out.println(Solution.firstCommonOptimize(a2,b2));
        System.out.println("***");

        int[] a3 = {1, 2, 3};
        int[] b3 = {7, 8, 9};

        System.out.println(Solution.firstCommon(a3,b3));
        System.out.println(Solution.firstCommonOptimize(a3,b3));
        System.out.println("***");

        int[] a4 = {4, 8, 10};
        int[] b4 = {10, 8, 4};

        System.out.println(Solution.firstCommon(a4,b4));
        System.out.println(Solution.firstCommonOptimize(a4,b4));
        System.out.println("***");
        
    }
}


/*
 A. O(m+n)
 B. O(m*n)
 C. O(n)
 D. O(n)

 Asessment:
  1. Yes, as explained, the handler can be set at any hierarchial call.
  2. The salary state belongs to Employee and it should handle how it is managed.
  3. If the loops are nested - they may be of different sizes so O(m*n) makes more sense
     If they are parallel if is wrong, th complexity will be O(n+n) which is
       generally written as O(n)
  4. if unique items are required and the order doesn't matter
  5.  O(1) n times so, O(n)

*/