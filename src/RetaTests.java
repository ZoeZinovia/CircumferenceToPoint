import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RetaTests {

	public final double EPSILON = 0.01;
	
	@Before
    public void init() {
       Locale.setDefault(new Locale ("us", "US"));
    }
	
//----------- Reta Tests -----------//
	
	//Test constructor Reta with no arguments
	@Test
	public void testRetaConstructor0() 
	{
		Reta r1 = new Reta();
		Assert.assertEquals("", r1.getDeclive());
		Assert.assertEquals(0.0, r1.getC(), EPSILON);
		Assert.assertEquals("y = x + 0.00", r1.toString());
	}
	
	//Test constructor Reta with slope and C as arguments
	@Test
	public void testRetaConstructor1() 
	{
		Reta r1 = new Reta("3.00", 1.0);
		Assert.assertEquals("3.00", r1.getDeclive());
		Assert.assertEquals(1.0, r1.getC(), EPSILON);
		Assert.assertEquals("y = 3.00*x + 1.00", r1.toString());

		Reta r2 = new Reta("-10.00", 2.12);
		Assert.assertEquals("-10.00", r2.getDeclive());
		Assert.assertEquals(2.12, r2.getC(), EPSILON);
		Assert.assertEquals("y = -10.00*x + 2.12", r2.toString());

		Reta r3 = new Reta("vertical", 2.0);
		Assert.assertEquals("vertical", r3.getDeclive());
		Assert.assertEquals(2.0, r3.getC(), EPSILON);
		Assert.assertEquals("x = 2.00", r3.toString());

		Reta r4 = new Reta("0.00", -3.00);
		Assert.assertEquals("0.00", r4.getDeclive());
		Assert.assertEquals(-3.0, r4.getC(), EPSILON);
		Assert.assertEquals("y = -3.00", r4.toString());
	}

	//Test constructor Reta with 2 Point as arguments
	@Test
	public void testRetaConstructor2() {
		Reta r1 = new Reta(new Ponto(2.0, 4.0), new Ponto(4.0, 2.0));
		Assert.assertEquals("-1.0", r1.getDeclive());
		Assert.assertEquals(6.0, r1.getC(), EPSILON);
		Assert.assertEquals("y = -1.00*x + 6.00", r1.toString());

		Reta r2 = new Reta(new Ponto(3.0, 2.0), new Ponto(7.0, -4.0));
		Assert.assertEquals("-1.5", r2.getDeclive());
		Assert.assertEquals(6.5, r2.getC(), EPSILON);
		Assert.assertEquals("y = -1.50*x + 6.50", r2.toString());
		
		Reta r3 = new Reta(new Ponto(-6.0, -2.0), new Ponto(-3.0, -4.0));
		Assert.assertEquals(Double.toString(-2.0 / 3.0), r3.getDeclive());
		Assert.assertEquals(-6.0, r3.getC(), EPSILON);
		Assert.assertEquals("y = -0.67*x - 6.00", r3.toString());
	}
	
	//Test constructor Reta with 1 Point and the slope as arguments
	@Test
	public void testRetaConstructor3() {
		Reta r1 = new Reta(new Ponto(2.0, 4.0), "-1.00");
		Assert.assertEquals("-1.00", r1.getDeclive());
		Assert.assertEquals(6.0, r1.getC(), EPSILON);
		Assert.assertEquals("y = -1.00*x + 6.00", r1.toString());

		Reta r2 = new Reta(new Ponto(3.0, 2.0), "-1.50");
		Assert.assertEquals("-1.50", r2.getDeclive());
		Assert.assertEquals(6.5, r2.getC(), EPSILON);
		Assert.assertEquals("y = -1.50*x + 6.50", r2.toString());
		
		Reta r3 = new Reta(new Ponto(-6.0, -2.0), Double.toString(-2.0 / 3.0));
		Assert.assertEquals(Double.toString(-2.0 / 3.0), r3.getDeclive());
		Assert.assertEquals(-6.0, r3.getC(), EPSILON);
		Assert.assertEquals("y = -0.67*x - 6.00", r3.toString());
	}

	//Test that calulateSlope, with two Points as arguments,  calculates the slope of the object and returns a String
	//If Reta is vertical, calculateSlope returns String "vertical". If Reta is not vertical, calculateSlope returns a string representation of a double
	@Test
	public void testCalculateDeclive0() {
		Assert.assertEquals("1.0", Reta.calculateDeclive(new Ponto(1.0, 1.0), new Ponto(2.0, 2.0)));
		Assert.assertEquals("0.00", Reta.calculateDeclive(new Ponto(3.0, 1.0), new Ponto(2.0, 1.0)));
		Assert.assertEquals(Double.toString(2.0 / 3.0), Reta.calculateDeclive(new Ponto(4.0, 2.0), new Ponto(1.0, 0.0)));
		Assert.assertEquals("vertical", Reta.calculateDeclive(new Ponto(2.0, 1.0), new Ponto(2.0, 2.0)));
	}

	//Test that calulates c, with a Point and a slope as arguments, and returns a double
	@Test
	public void testCalculateC0() {
		Assert.assertEquals(0.0, Reta.calculateC(new Ponto(2.0, 2.0), "1.00"), EPSILON);
		Assert.assertEquals(1.0, Reta.calculateC(new Ponto(2.0, 1.0), "0.00"), EPSILON);
		Assert.assertEquals(-1.0, Reta.calculateC(new Ponto(3.0, 1.0), Double.toString(2.0 / 3.0)), EPSILON);
		Assert.assertEquals(2.0, Reta.calculateC(new Ponto(2.0, 1.0), "vertical"), EPSILON);
	}
	
	//Test that intersection, with a Reta as argument, calculates the intersection between the object and the argument and returns a Point
	@Test
	public void testIntersection0() 
	{
		Reta sg1 = new Reta("0.0", 2.0 );
		Reta sg2 = new Reta("vertical", 1.0);
		Assert.assertEquals(new Ponto(1.0, 2.0), sg1.intersection(sg2));
		
		Reta sg3 = new Reta("1.0", 1.0 );
		Reta sg4 = new Reta("-1.0", 6.0);
		Assert.assertEquals(new Ponto(2.5, 3.5), sg3.intersection(sg4));
		
		Reta sg5 = new Reta("3.0", -4.0 );
		Reta sg6 = new Reta("2.0", -3.0);
		Assert.assertEquals(new Ponto(1.0, -1.0), sg5.intersection(sg6));
	}
	
	//Test that toString of Reta returns a string representation of the object 
	//Example1: y = 1.00*x + 2.00
	//Example2: x = 1.00
	@Test
	public void testRetaToString0() {
		Reta r1 = new Reta("vertical", 2.0);
		Assert.assertEquals("x = 2.00", r1.toString());

		Reta r2 = new Reta("vertical", -6.1);
		Assert.assertEquals("x = -6.10", r2.toString());

		Reta r3 = new Reta("0.00", 3.0);
		Assert.assertEquals("y = 3.00", r3.toString());

		Reta r4 = new Reta("0.00", -6.1);
		Assert.assertEquals("y = -6.10", r4.toString());

		Reta r5 = new Reta("3.1", 2.0);
		Assert.assertEquals("y = 3.10*x + 2.00", r5.toString());

		Reta r6 = new Reta("-1.9", 1.3);
		Assert.assertEquals("y = -1.90*x + 1.30", r6.toString());
	}

	
	//----------- Getter and Setter Tests - removed -----------//
	
	
	//Test that setSlope, with a String argument, changes the value of slope in the object
//	@Test
//	void testSetDeclive0() {
//		Reta r1 = new Reta();
//		r1.setDeclive("vertical");
//		Assert.assertEquals("vertical", r1.getDeclive());
//		
//		Reta r2 = new Reta();
//		r2.setDeclive("2.00");
//		Assert.assertEquals("2.00", r1.getDeclive());
//		
//		Reta r3 = new Reta();
//		r3.setDeclive(Double.toString(2.0 / 3.0));
//		Assert.assertEquals(Double.toString(2.0 / 3.0), r3.getDeclive());
//	}

	//Test that getSlope returns the value of slope stored in the object
//	@Test
//	void testGetDeclive0() {
//		Reta r1 = new Reta("3.00", 1.00);
//		Assert.assertEquals("3.00", r1.getDeclive());
//
//		Reta r2 = new Reta("-10.00", 2.12);
//		Assert.assertEquals("-10.00", r2.getDeclive());
//
//		Reta r3 = new Reta("vertical", 2.0);
//		Assert.assertEquals("vertical", r3.getDeclive());
//
//		Reta r4 = new Reta("0.00", -3.0);
//		Assert.assertEquals("0.00", r4.getDeclive());
//	}

	//Test that setC , with a double argument, changes the value of c in the object
//	@Test
//	void testSetC0() {
//		Reta r1 = new Reta();
//		r1.setC(2.0);
//		Assert.assertEquals(2.0, r1.getC(), EPSILON);
//
//		Reta r2 = new Reta();
//		r2.setC(0.0);
//		Assert.assertEquals(0.0, r2.getC(), EPSILON);
//
//		Reta r3 = new Reta();
//		r3.setC(-3.0);
//		Assert.assertEquals(-3.0, r3.getC(), EPSILON);
//
//		Reta r4 = new Reta();
//		r4.setC(2.0 / 3.0);
//		Assert.assertEquals(2.0 / 3.0, r4.getC(), EPSILON);
//	}

	//Test that getC returns the value of c stored in the object
//	@Test
//	void testGetC0() {
//		Reta r1 = new Reta("3.00", 1.00);
//		Assert.assertEquals(1.00, r1.getC(), EPSILON);
//
//		Reta r2 = new Reta("-10.00", 2.12);
//		Assert.assertEquals(2.12, r2.getC(), EPSILON);
//
//		Reta r3 = new Reta("vertical", 2.0);
//		Assert.assertEquals(2.00, r3.getC(), EPSILON);
//
//		Reta r4 = new Reta("0.00", -3.0);
//		Assert.assertEquals(-3.00, r4.getC(), EPSILON);
//	}

	
}
