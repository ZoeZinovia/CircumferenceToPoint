import java.text.DecimalFormat;

public class Ponto {

	private double x, y;
	
	/**
	 * Empty constructor
	 */
	public Ponto()
	{
		this.x = 0;
		this.y = 0;
	}
	
	/** 
	 * Point constructor
	 * @param x-coordinate
	 * @param y-coordinate
	 */
	public Ponto(double x, double y)
	{
		setX(x);
		setY(y);		
	}
	
	/** 
	 * calculate distance between 2 points
	 * @pre neither of the points is null
	 * @param p is the point whose distance from the instance object will be calculated
	 * @return Euclidean distance 
	 */
	double dist (Ponto p) {
		double dx = x - p.x;
		double dy = y - p.y;
		return Math.sqrt(dx*dx + dy*dy);
	}

	/**
	 * @param x is the x-coordinate of point
	 * @return value of x
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * @param x is the new x-coordinate of point
	 */
	public void setX(double x)
	{
			this.x = x;		
	}

	/**
	 * @param y is the y-coordinate of point
	 * @return value of y
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * @param y to set new y-coordinate of point
	 */
	public void setY(double y)
	{
			this.y = y;
	}
	
	/**
	 * this function redefines equals() for the Point object
	 */
	@Override
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (other == null)
			return false;
		if (getClass() != other.getClass())
			return false;
		Ponto that = (Ponto) other;
		return (Double.compare(this.x, that.x) == 0 && Double.compare(this.y, that.y) == 0);
	}
	
	/**
	 * @return String representation of point
	 */
	public String toString()
	{
		DecimalFormat format = new DecimalFormat("0.00");
		return "(" + format.format(this.x) + ", " + format.format(this.y) + ")";
	}
}
