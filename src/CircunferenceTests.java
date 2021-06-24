import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CircunferenceTests {

	public final double EPSILON = 0.01;
	
	@Before
    public void init() {
       Locale.setDefault(new Locale ("us", "US"));
    }
	
//----------- Circunferencia Tests -----------//

	//Test constructor with no arguments
	@Test
	public void testCircunferenciaConstructors0() {
		Assert.assertEquals("centro: (0.00, 0.00), raio: 0.00", new Circunferencia().toString());	
	}
	
	//Test constructor with 3 points as arguments
	@Test
	public void testCircunferenciaConstructors1() {
		Assert.assertEquals("centro: (3.00, 3.00), raio: 2.00", new Circunferencia(new Ponto(1,3), new Ponto(3,5), new Ponto(5,3)).toString());
		Assert.assertEquals("centro: (2.00, 2.00), raio: 2.00", new Circunferencia(new Ponto(0,2), new Ponto(4,2), new Ponto(2,4)).toString());
		Assert.assertEquals("centro: (1.00, 1.00), raio: 1.41", new Circunferencia(new Ponto(0,0), new Ponto(0,2), new Ponto(2,2)).toString());

	}
	
	//Test constructor with center and radius as arguments
	@Test
	public void testCircunferenciaConstructors2() {
		Assert.assertEquals("centro: (3.00, 3.00), raio: 1.41", new Circunferencia(new Ponto(3,3), 1.414).toString());
		Assert.assertEquals("centro: (2.00, 2.00), raio: 2.00", new Circunferencia(new Ponto(2,2), 2.0).toString());
		Assert.assertEquals("centro: (-1.00, 10.00), raio: 6.00", new Circunferencia(new Ponto(-1,10), 6.0).toString());
	}
	
	//Test that the three points create a right triangle
	@Test
	public void testRightTriangle0() {
		Assert.assertEquals(true, Circunferencia.rightTriangle(new Ponto(3,5), new Ponto(1,3), new Ponto(5,3)));
		Assert.assertEquals(false, Circunferencia.rightTriangle(new Ponto(1,3), new Ponto(3,4), new Ponto(5,3)));
		Assert.assertEquals(true, Circunferencia.rightTriangle(new Ponto(2,4), new Ponto(0,2), new Ponto(4,2)));
		Assert.assertEquals(false, Circunferencia.rightTriangle(new Ponto(0,2), new Ponto(4,2), new Ponto(2,7)));
	}
	
	//Test that the correct point is identified as the right-angle vertex.
	@Test
	public void testVerifyB0() {
		Assert.assertArrayEquals(new Ponto[] {new Ponto(4,4), new Ponto(2,4), new Ponto(4,2)}, Circunferencia.verifyB(new Ponto(2,4), new Ponto(4,4), new Ponto(4,2)));
		Assert.assertArrayEquals(new Ponto[] {new Ponto(2,4), new Ponto(4,2), new Ponto(0,2)}, Circunferencia.verifyB(new Ponto(4,2), new Ponto(0,2), new Ponto(2,4)));
		Assert.assertArrayEquals(new Ponto[] {new Ponto(3,5), new Ponto(5,3), new Ponto(1,3)}, Circunferencia.verifyB(new Ponto(5,3), new Ponto(1,3), new Ponto(3,5)));
		Assert.assertArrayEquals(new Ponto[] {new Ponto(2,4), new Ponto(0,2), new Ponto(4,2)}, Circunferencia.verifyB(new Ponto(0,2), new Ponto(2,4), new Ponto(4,2)));
	}
	
	//Verify that no 2 or 3 points are the same
	@Test
	public void verifyPoints0() {
		Assert.assertEquals(true, Circunferencia.verifyPoints(new Ponto(1,3), new Ponto(3,5), new Ponto(5,3)));
		Assert.assertEquals(true, Circunferencia.verifyPoints(new Ponto(1,3), new Ponto(3,5), new Ponto(3,3)));
		Assert.assertEquals(false, Circunferencia.verifyPoints(new Ponto(1,3), new Ponto(1,3), new Ponto(1,3)));
		Assert.assertEquals(false, Circunferencia.verifyPoints(new Ponto(1,3), new Ponto(2,3), new Ponto(3,3)));
	}
	
	//Test that toString of Circunferencia returns a string representation of the object 
	//Example: centro: (0.00, 0.00), raio: 1.00
	@Test
	public void testCircumferenceToString0() {
		Circunferencia c1 = new Circunferencia(new Ponto(2.0, 2.0), 1.0);
		Assert.assertEquals("centro: (2.00, 2.00), raio: 1.00", c1.toString());

		Circunferencia c2 = new Circunferencia(new Ponto(3.0, -1.0), 0.8);
		Assert.assertEquals("centro: (3.00, -1.00), raio: 0.80", c2.toString());
	}
		
	
	//----------- Getter and Setter Tests - removed -----------//
	
	//Test that getCenter returns the value of center stored in the object
//	@Test
//	void testGetCentro0() {
//		Assert.assertEquals(new Ponto(2,2), new Circunferencia(new Ponto(0,2), new Ponto(4,2), new Ponto(2,4)).getCentro());
//		Assert.assertEquals(new Ponto(2,2), new Circunferencia(new Ponto(2,2), 2.0).getCentro());
//		Assert.assertEquals(new Ponto(3,3), new Circunferencia(new Ponto(1,3), new Ponto(3,5), new Ponto(5,3)).getCentro());
//		Assert.assertEquals(new Ponto(3,3), new Circunferencia(new Ponto(3,3), 2.0).getCentro());
//	}
	
	//Test that setCenter, with a Ponto argument, changes the value of center stored in the object
//	@Test
//	void testSetCentro0() {
//		Circunferencia C1 = new Circunferencia(new Ponto(0,2), new Ponto(4,2), new Ponto(2,4));
//		C1.setCentro(new Ponto(6,6));
//		Assert.assertEquals(new Ponto(6,6), C1.getCentro());
//		C1.setCentro(new Ponto(60,60));
//		Assert.assertEquals(new Ponto(60,60), C1.getCentro());
//		
//		Circunferencia C2 = new Circunferencia(new Ponto(1,3), new Ponto(3,5), new Ponto(5,3));
//		C2.setCentro(new Ponto(1,1));
//		Assert.assertEquals(new Ponto(1,1), C2.getCentro());
//		C2.setCentro(new Ponto(10,10));
//		Assert.assertEquals(new Ponto(10,10), C2.getCentro());
//	}
	
	//Test that setCenter, with x and y coordinates as arguments, changes the value of center stored in the object
//	@Test
//	void testSetCentro1() {
//		Circunferencia C1 = new Circunferencia(new Ponto(0,2), new Ponto(4,2), new Ponto(2,4));
//		C1.setCentro(8,8);
//		Assert.assertEquals(new Ponto(8,8), C1.getCentro());
//		C1.setCentro(800,800);
//		Assert.assertEquals(new Ponto(800,800), C1.getCentro());
//		
//		Circunferencia C2 = new Circunferencia(new Ponto(1,3), new Ponto(3,5), new Ponto(5,3));
//		C2.setCentro(10,10);
//		Assert.assertEquals(new Ponto(10,10), C2.getCentro());
//		C2.setCentro(0,0);
//		Assert.assertEquals(new Ponto(0,0), C2.getCentro());
//	}
	
	//Test that getRadius returns the value of radius in the object
//	@Test
//	void testGetRaio0() {
//		Circunferencia C1 = new Circunferencia(new Ponto(0,2), new Ponto(4,2), new Ponto(2,4));
//		Assert.assertEquals(2.00, C1.getRaio(), EPSILON);
//		
//		Circunferencia C2 = new Circunferencia(new Ponto(1,3), new Ponto(3,5), new Ponto(5,3));
//		Assert.assertEquals(2.00, C2.getRaio(), EPSILON);
//		
//		Circunferencia C3 = new Circunferencia(new Ponto(2,4), new Ponto(4,2), new Ponto(4,4));
//		Assert.assertEquals(1.41, C3.getRaio(), EPSILON);
//	}
	
	//Test that setRadius changes the value of radius in the object
//	@Test
//	void testSetRaio0() {
//		Circunferencia C1 = new Circunferencia(new Ponto(0,2), new Ponto(4,2), new Ponto(2,4));
//		C1.setRaio(1.01);
//		Assert.assertEquals(1.01, C1.getRaio(), EPSILON);
//		
//		Circunferencia C2 = new Circunferencia(new Ponto(1,3), new Ponto(3,5), new Ponto(5,3));
//		C2.setRaio(2.02);
//		Assert.assertEquals(2.02, C2.getRaio(), EPSILON);
//		
//		Circunferencia C3 = new Circunferencia(new Ponto(2,4), new Ponto(4,2), new Ponto(4,4));
//		C3.setRaio(3.03);
//		Assert.assertEquals(3.03, C3.getRaio(), EPSILON);
//	}
	
}
