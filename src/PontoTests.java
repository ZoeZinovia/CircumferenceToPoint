import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PontoTests {

	public final double EPSILON = 0.01;
	
	@Before
    public void init() {
       Locale.setDefault(new Locale ("us", "US"));
    }
	
//----------- Ponto Tests -----------//
	
	//Test constructor with no arguments
	@Test
	public void testPontoConstructor0() {
		Assert.assertEquals("(0.00, 0.00)", new Ponto().toString());
	}
	
	//Test constructor with 2 doubles as arguments
	@Test
	public void testPontoConstructor1()
	{
		Assert.assertEquals("(1.00, 2.00)", new Ponto(1,2).toString());
		Assert.assertEquals("(0.00, 0.00)", new Ponto(0,0).toString());
		Assert.assertEquals("(-1.00, -2.00)", new Ponto(-1,-2).toString());
	}

	//Test the calculation of distance between 2 points
	@Test
	public void testDistancia0() 
	{
		Assert.assertEquals(1.41, new Ponto(3,3).dist(new Ponto(4,2)), EPSILON);
		Assert.assertEquals(26.20, new Ponto(-7,-4).dist(new Ponto(17,6.5)), EPSILON);	
		Assert.assertEquals(0.00, new Ponto(0,0).dist(new Ponto(0,0)), EPSILON);	
	}
	
	//Test that toString of Ponto returns a string representation of the object 
	//Example: (0.00, 1.00)
	@Test
	public void testPointToString0() {
		Ponto a1 = new Ponto(1.0, 2.5);
		Assert.assertEquals("(1.00, 2.50)", a1.toString());

		Ponto a2 = new Ponto(-2.4, 4.1);
		Assert.assertEquals("(-2.40, 4.10)", a2.toString());

		Ponto a3 = new Ponto(9.3, -1.9);
		Assert.assertEquals("(9.30, -1.90)", a3.toString());
	}
	
	
	//----------- Getter and Setter Tests - removed -----------//
	
	//Test that getX returns the value of x in the Point object
//	@Test
//	void testGetX0()
//	{
//		Assert.assertEquals(1.00, new Ponto(1,2).getX(), EPSILON);
//		Assert.assertEquals(-4.00, new Ponto(-4,-4).getX(), EPSILON);
//		Assert.assertEquals(0.00, new Ponto(0,0).getX(), EPSILON);
//	}
	
	//Test that setX changes the value of x in the Point object
//	@Test
//	void testSetX0()
//	{
//		Ponto p1 = new Ponto(1,1);
//		p1.setX(3);
//		Assert.assertEquals("(3.00,1.00)", p1.toString());
//		
//		Ponto p2 = new Ponto(20,-3);
//		p2.setX(-20);
//		Assert.assertEquals("(-20.00,-3.00)", p2.toString());
//		
//		Ponto p3 = new Ponto(0,0);
//		p3.setX(100);
//		Assert.assertEquals("(100.00,0.00)", p3.toString());
//	}
//	
	//Test that getY returns the value of y in the Point object
//	@Test
//	void testGetY0()
//	{
//		Assert.assertEquals(2.00, new Ponto(1,2).getY(), EPSILON);
//		Assert.assertEquals(-4.00, new Ponto(-4,-4).getY(), EPSILON);
//		Assert.assertEquals(10.00, new Ponto(0,10).getY(), EPSILON);
//	}
	
	//Test that setY changes the value of y in the Point object
//	@Test
//	void testSetY0()
//	{
//		Ponto p1 = new Ponto(1,1);
//		p1.setY(3);
//		Assert.assertEquals("(1.00, 3.00)", p1.toString());
//		
//		Ponto p2 = new Ponto(20,-3);
//		p2.setY(-20);
//		Assert.assertEquals("(20.00, -20.00)", p2.toString());
//		
//		Ponto p3 = new Ponto(0,0);
//		p3.setY(100);
//		Assert.assertEquals("(0.00, 100.00)", p3.toString());
//	}	
	
	
}

