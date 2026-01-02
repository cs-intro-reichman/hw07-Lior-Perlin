/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		StdDraw.line(0.0, 0.0, 1.0, 0.0);
		StdDraw.line(1.0, 0.0, 0.5, 0.866);
		StdDraw.line(0.5, 0.866, 0.0, 0.0);
		sierpinski(n - 1, 0.0, 1.0, 0.5, 0.0, 0.0, 0.866);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3, double y1, double y2, double y3) {
		if(n <= 0) {
			return;
		}
		StdDraw.setPenColor(StdDraw.BLACK);
		double newPointx1 = (x1 + x2) / 2;
		double newPointx2 = (x2 + x3) / 2;
		double newPointx3 = (x3 + x1) / 2;
		double newPointy1 = (y1 + y2) / 2;
		double newPointy2 = (y2 + y3) / 2;
		double newPointy3 = (y3 + y1) / 2;
		StdDraw.line(newPointx1, newPointy1, newPointx2, newPointy2);
		StdDraw.line(newPointx2, newPointy2, newPointx3, newPointy3);
		StdDraw.line(newPointx3, newPointy3, newPointx1, newPointy1);
		sierpinski(n - 1, newPointx3, newPointx2, x3, newPointy3, newPointy2, y3);
		sierpinski(n - 1, newPointx1, x2, newPointx2, newPointy1, y2, newPointy2);
		sierpinski(n - 1, x1, newPointx1, newPointx3, y1, newPointy1, newPointy3);
	}
}
