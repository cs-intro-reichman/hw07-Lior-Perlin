/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));

		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		StdDraw.setPenColor(StdDraw.BLACK);
		//Base situation to finish the recursion and not remove a third of the line
		if(n < 0) {
			return;
		}
		if(n == 0) { 
			StdDraw.line(x1, y1, x2, y2);
			return;
		}
		// Making sure I'm able to devide the line to 3 parts
		double xThirdDistance = (x2 - x1) / 3, yThirdDistance = (y2 - y1) / 3;
		// According to what we recieved on the task's p3 coordinates, Thanks for that, saves a lot of trouble
		double xNewPoint = (Math.sqrt(3) / 6 * (y1 - y2)) + ((x1 + x2) / 2); 
		double yNewPoint = (Math.sqrt(3) / 6 * (x2 - x1)) + ((y1 + y2) / 2);
		//Make the next curve from both sides
		curve(n - 1, x1 + xThirdDistance, y1 + yThirdDistance, xNewPoint, yNewPoint);
		curve(n - 1 , xNewPoint, yNewPoint, x2 - xThirdDistance, y2 - yThirdDistance);
		curve(n - 1, x1, y1, x1 + xThirdDistance, y1 + yThirdDistance);
		curve(n - 1, x2 - xThirdDistance, y2 - yThirdDistance, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		// Set the points of the sides first.
		double x1 = 0.200, y1 = 0.750;
    	double x2 = 0.800, y2 = 0.750;
    	double x3 = 0.500, y3 = y1 - (Math.sqrt(3) / 2) * (x2 - x1);
    	// Draws the curves on the 3 sides of the triangle
    	curve(n, x1, y1, x2, y2);
    	curve(n, x2, y2, x3, y3);
    	curve(n, x3, y3, x1, y1);
	}
}
