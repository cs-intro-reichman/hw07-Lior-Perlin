/** Returns the binary representation of a given integer. */
public class IntToBin {

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("Binary representation of " + x + " is: " + toBinary(x));
    }

    /** Returns the binary representation of the given integer, as a string of 0's and 1's.  */
    public static String toBinary(int x) {
        if(x <= 1) { // Base condition - we got to the end of the number
            return x + "";
        }
        if ((x % 2) == 0) { //That means our current bin number is devidable by 2 so it should recieve a '0'
            return toBinary(x / 2) + "0";
        }
        else { // Means our current bin index number is not devidable
            return  toBinary(x / 2) + "1";
        }
    }    
 }
