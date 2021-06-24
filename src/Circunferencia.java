import java.text.DecimalFormat;

public class Circunferencia {
	
	private Ponto centro;
	private double raio;
	
	/** 
	 * Empty constructor
	 */ 
	public Circunferencia()
	{
		setCentro(new Ponto(0,0));
		setRaio(0);
	}
	
	/**
	 * Circumference constructor from center point and radius
	 * @param centro is the center of the circle
	 * @param radius is the distance from the center to the circumference
	 */
	public Circunferencia(Ponto centro, double raio)
	{
		setCentro(centro);
		setRaio(raio);
	}
	
	/** 
	 * Circumference constructor from 3 points
	 * @param pt1
	 * @param pt2
	 * @param pt3
	 */
	public Circunferencia(Ponto pt1, Ponto pt2, Ponto pt3)
	{
		Ponto[] pontos = verifyB(pt1, pt2, pt3);
		Ponto B = pontos[0]; Ponto A = pontos[1]; Ponto C = pontos[2];
		SegmentoReta AB = new SegmentoReta(A, B);
		SegmentoReta BC = new SegmentoReta(B, C);
		setCentro(AB, BC);
		setRaio(A.dist(this.centro));
	}
	
	/** 
	 * Verify which point is the right angle vertex 
	 * @param pt1
	 * @param pt2
	 * @param pt3
	 * @return point array with right angle vertex in index[0]
	 */
	public static Ponto[] verifyB(Ponto pt1, Ponto pt2, Ponto pt3)
	{
		Ponto[] pontos = new Ponto[3];
		if(pt1.dist(pt2) == pt1.dist(pt3) && rightTriangle(pt1, pt2, pt3) && verifyPoints(pt1, pt2, pt3))
		{
			pontos[0] = pt1; pontos[1] = pt2; pontos[2] = pt3;
		}
		else if(pt2.dist(pt1) == pt2.dist(pt3) && rightTriangle(pt2, pt1, pt3) && verifyPoints(pt1, pt2, pt3))
		{
			pontos[0] = pt2; pontos[1] = pt1; pontos[2] = pt3;
		}
		else if(pt3.dist(pt1) == pt3.dist(pt2) && rightTriangle(pt3, pt1, pt2) && verifyPoints(pt1, pt2, pt3))
		{
			pontos[0] = pt3; pontos[1] = pt1; pontos[2] = pt2;
		}
		else
		{		
			System.out.println("invalid points");
			System.exit(0);
		}
		return pontos;
	}
	
	/**
	 * Check that the 3 points form a right triangle using Pythagorus' theorem
	 * @param pt1 is the assumed right and vertex
	 * @param pt2
	 * @param pt3
	 * @return true if 3 points form a right triangle. False otherwise.
	 */
	public static boolean rightTriangle(Ponto pt1, Ponto pt2, Ponto pt3)
	{
		return (pt1.dist(pt2)*pt1.dist(pt2)) + (pt1.dist(pt3)*pt1.dist(pt3)) - (pt2.dist(pt3)*pt2.dist(pt3)) <= 0.0001;
	}
	
	/**	
	 * implement check that we don't have 2 or 3 identical points and that we don't have 3 colinear points
	 * @param pt1
	 * @param pt2
	 * @param pt3
	 * @return false if 2 or more points are equal or colinear. True otherwise.
	 */ 
	public static boolean verifyPoints(Ponto pt1, Ponto pt2, Ponto pt3)
	{
		return(!pt1.equals(pt2) && !pt2.equals(pt3) && !pt3.equals(pt1)) && !(Reta.calculateDeclive(pt1, pt2).equals(Reta.calculateDeclive(pt2, pt3)));
	}

	/**
	 * @return center of circumference
	 */
	public Ponto getCentro() {
		return centro;
	}
	
	/**
	 * to set new center of circumference with argument
	 * @param centro 
	 */
	public void setCentro(Ponto centro) {
		this.centro = centro;
	}
	
	/**
	 * to set new center of circumference with x and y coordinates as arguments
	 * @param x is the x-coordinate of the point
	 * @param y is the y-coordinate of the point
	 */
	public void setCentro(double x, double y) {
		this.centro = new Ponto(x, y);
	}
	
	/** 
	 * set center using two line segments
	 * @param AB is one of the lines
	 * @param BC is the other line
	 */
	public void setCentro(SegmentoReta AB, SegmentoReta BC)
	{
		Reta r = AB.getMediatriz();
		Reta s = BC.getMediatriz();
		setCentro(r.intersection(s));
	}

	/**
	 * @return radius of circumference
	 */
	public double getRaio() {
		return raio;
	}
	
	/**
	 * to set new radius of circumference
	 * @param raio is the new value of radius 
	 * @post set raio with new value if value is not negative
	 */
	public void setRaio(double raio) {
		if(raio < 0)
			throw new IllegalArgumentException("Raio cannot be negative");
		this.raio = raio;
	}
	
	/**
	 * @return String representation of circumference with all doubles shown with 0.00 format
	 */
	public String toString()
	{
		DecimalFormat format = new DecimalFormat("0.00");
		return "centro: " + centro.toString() + ", raio: " + format.format(raio);
	}

}
