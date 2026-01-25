/*
Feedback: nicely written :)
*/

public class IsSorted {

    // Public function: called by the user
    public static boolean isSorted(int[] a) {
        return isSorted(a, 0);
    }

    // Helper recursive function
    private static boolean isSorted(int[] a, int i) {
        // Defining base, This is when our current index number does not has a number after it.
        // In this case we've gotten to the end of the array and we should start going back.
        if(i + 1 == a.length || i >= a.length) {
            return true;
        }
        // Making sure our current number and the one after that are sorted
        // and requesting the same on the next index on recurtion
        return a[i] <= a[i + 1] && isSorted(a, i + 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 5};
        System.out.println(isSorted(a)); // true

        int[] b = {1, 3, 2};
        System.out.println(isSorted(b)); // false
    }
}
