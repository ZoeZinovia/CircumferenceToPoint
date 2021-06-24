import java.text.DecimalFormat;

public class Reta {
	
	private String declive;
	private double c;
	
	/** 
	 * empty line constructor
	 */
	public Reta()
	{
		setDeclive("");
		setC(0.00);
	}
	
	/**
	 * Line constructor with slope and constant C
	 * @param newDeclive is the gradient of the line
	 * @param newC is the constant in the straight line equation
	 */
	public Reta(String newDeclive, double newC)
	{
		setDeclive(newDeclive);
		setC(newC);
	}
	
	/**
	 * Line constructor with 2 points
	 * @param p is one point on the line segment
	 * @param q is the other point
	 */
	public Reta(Ponto p, Ponto q) //will be called from SegmentoReta class using two points.
	{
		this(calculateDeclive(p,q),calculateC(p, calculateDeclive(p,q)));
	}
	
	/**
	 * Constructor for mediatrice line equation since only 1 point will be known.
	 * @param p is any point on the line
	 * @param declive 
	 */
	public Reta(Ponto p, String declive)
	{
		setDeclive(declive);
		setC(calculateC(p, declive));
	}
	
	/**
	 * Intersects two retas and returns the point resultant of the intersection
	 * @pre the two lines cannot be parallel. 
	 * @pre only non-vertical lines can be passed in.
	 * @param other is the line that intersects the instance object
	 * @return point of intersection
	 */
	public Ponto intersection(Reta other)
	{		
		double x = this.getDeclive().equals("vertical")? this.getC() : other.getDeclive().contentEquals("vertical")? other.getC() : (other.getC() - this.getC())/(Double.parseDouble(this.getDeclive())-Double.parseDouble(other.getDeclive()));
		double y = this.getDeclive().equals("0.00")? this.getC() : other.getDeclive().contentEquals("0.00")? other.getC() : Double.parseDouble(this.getDeclive())*x + this.getC();
		return new Ponto(x,y);
	}
	
	/**
	 * Calculates the gradient of the reta 
	 * @param p is one point of the line segment
	 * @param q is the other point 
	 * @return string representation of a double if not vertical, if vertical returns "vertical"
	 */
	// must return type string because slope could be vertical (i.e. undefined)
	public static String calculateDeclive(Ponto p, Ponto q) {
		double n=(q.getY() - p.getY());
		double d=(q.getX() - p.getX());
		
		return n == 0 ? "0.00" : d == 0 ? "vertical" : String.valueOf(n/d);
	}
	
	/**
	 * Calculates the c of the reta equation
	 * @param p is one point of the line segment
	 * @param declive is the gradient of reta
	 * @return the double value of c
	 */
	public static double calculateC(Ponto p, String declive) {
		return declive.equals("vertical") ? p.getX()  : p.getY() - (Double.valueOf(declive) * p.getX());
	}
	
	/**
	 * @return declive of reta
	 */
	public String getDeclive() {
		return declive;
	}

	/**
	 * to set new declive of reta
	 * @param declive is the new value of declive
	 * @post if reta is vertical declive is set "vertical"
	 */
	public void setDeclive(String declive) {
		this.declive = declive;
	}

	/**
	 * @return c of reta
	 */
	public double getC() {
		return c;
	}

	/**
	 * to set new c of reta
	 * @param c is the new value of c
	 */
	public void setC(double c) {
		this.c = c;
	}
	
	/**
	 * @return String representation of reta with all doubles shown with 0.00 format
	 */
	public String toString()
	{
		DecimalFormat format = new DecimalFormat("0.00");
		String result = "";
		if(declive.equals("vertical"))
			result = "x = " + format.format(c); //use c as the constant value of x
		else if(declive.equals("0.00"))
			result = "y = " + format.format(c); //use c as the constant value of y
		else if(declive.contentEquals(""))
			result = "y = x" + (c<0? " - " + format.format(c*-1) : " + " + format.format(c));
		else
			result = "y = " + format.format(Double.valueOf(declive)) + "*x" + (c<0? " - " + format.format(c*-1) : " + " + format.format(c));
		return result;
	} 

}
