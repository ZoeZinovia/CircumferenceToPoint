//import java.util.Locale;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//public class Lab4Part2Tests {
//
//	public final double EPSILON = 0.01;
//	
//	@Before
//    public void init() {
//       Locale.setDefault(new Locale ("us", "US"));
//    }
//	
////----------- Circunferencia Tests -----------//
//
//	//Test constructor with no arguments
//	@Test
//	public void testCircunferenciaConstructors0() {
//		Assert.assertEquals("centro: (0.00, 0.00), raio: 0.00", new Circunferencia().toString());	
//	}
//	
//	//Test constructor with 3 points as arguments
//	@Test
//	public void testCircunferenciaConstructors1() {
//		Assert.assertEquals("centro: (3.00, 3.00), raio: 2.00", new Circunferencia(new Ponto(1,3), new Ponto(3,5), new Ponto(5,3)).toString());
//		Assert.assertEquals("centro: (2.00, 2.00), raio: 2.00", new Circunferencia(new Ponto(0,2), new Ponto(4,2), new Ponto(2,4)).toString());
//		Assert.assertEquals("centro: (1.00, 1.00), raio: 1.41", new Circunferencia(new Ponto(0,0), new Ponto(0,2), new Ponto(2,2)).toString());
//
//	}
//	
//	//Test constructor with center and radius as arguments
//	@Test
//	public void testCircunferenciaConstructors2() {
//		Assert.assertEquals("centro: (3.00, 3.00), raio: 1.41", new Circunferencia(new Ponto(3,3), 1.414).toString());
//		Assert.assertEquals("centro: (2.00, 2.00), raio: 2.00", new Circunferencia(new Ponto(2,2), 2.0).toString());
//		Assert.assertEquals("centro: (-1.00, 10.00), raio: 6.00", new Circunferencia(new Ponto(-1,10), 6.0).toString());
//	}
//	
//	//Test that the three points create a right triangle
//	@Test
//	public void testRightTriangle0() {
//		Assert.assertEquals(true, Circunferencia.rightTriangle(new Ponto(3,5), new Ponto(1,3), new Ponto(5,3)));
//		Assert.assertEquals(false, Circunferencia.rightTriangle(new Ponto(1,3), new Ponto(3,4), new Ponto(5,3)));
//		Assert.assertEquals(true, Circunferencia.rightTriangle(new Ponto(2,4), new Ponto(0,2), new Ponto(4,2)));
//		Assert.assertEquals(false, Circunferencia.rightTriangle(new Ponto(0,2), new Ponto(4,2), new Ponto(2,7)));
//	}
//	
//	//Test that the correct point is identified as the right-angle vertex.
//	@Test
//	public void testVerifyB0() {
//		Assert.assertArrayEquals(new Ponto[] {new Ponto(4,4), new Ponto(2,4), new Ponto(4,2)}, Circunferencia.verifyB(new Ponto(2,4), new Ponto(4,4), new Ponto(4,2)));
//		Assert.assertArrayEquals(new Ponto[] {new Ponto(2,4), new Ponto(4,2), new Ponto(0,2)}, Circunferencia.verifyB(new Ponto(4,2), new Ponto(0,2), new Ponto(2,4)));
//		Assert.assertArrayEquals(new Ponto[] {new Ponto(3,5), new Ponto(5,3), new Ponto(1,3)}, Circunferencia.verifyB(new Ponto(5,3), new Ponto(1,3), new Ponto(3,5)));
//		Assert.assertArrayEquals(new Ponto[] {new Ponto(2,4), new Ponto(0,2), new Ponto(4,2)}, Circunferencia.verifyB(new Ponto(0,2), new Ponto(2,4), new Ponto(4,2)));
//	}
//	
//	//Verify that no 2 or 3 points are the same
//	@Test
//	public void verifyPoints0() {
//		Assert.assertEquals(true, Circunferencia.verifyPoints(new Ponto(1,3), new Ponto(3,5), new Ponto(5,3)));
//		Assert.assertEquals(true, Circunferencia.verifyPoints(new Ponto(1,3), new Ponto(3,5), new Ponto(3,3)));
//		Assert.assertEquals(false, Circunferencia.verifyPoints(new Ponto(1,3), new Ponto(1,3), new Ponto(1,3)));
//		Assert.assertEquals(false, Circunferencia.verifyPoints(new Ponto(1,3), new Ponto(2,3), new Ponto(3,3)));
//	}
//	
//	//Test that toString of Circunferencia returns a string representation of the object 
//	//Example: centro: (0.00, 0.00), raio: 1.00
//	@Test
//	public void testCircumferenceToString0() {
//		Circunferencia c1 = new Circunferencia(new Ponto(2.0, 2.0), 1.0);
//		Assert.assertEquals("centro: (2.00, 2.00), raio: 1.00", c1.toString());
//
//		Circunferencia c2 = new Circunferencia(new Ponto(3.0, -1.0), 0.8);
//		Assert.assertEquals("centro: (3.00, -1.00), raio: 0.80", c2.toString());
//	}
//		
////----------- Ponto Tests -----------//
//	
//	//Test constructor with no arguments
//	@Test
//	public void testPontoConstructor0() {
//		Assert.assertEquals("(0.00, 0.00)", new Ponto().toString());
//	}
//	
//	//Test constructor with 2 doubles as arguments
//	@Test
//	public void testPontoConstructor1()
//	{
//		Assert.assertEquals("(1.00, 2.00)", new Ponto(1,2).toString());
//		Assert.assertEquals("(0.00, 0.00)", new Ponto(0,0).toString());
//		Assert.assertEquals("(-1.00, -2.00)", new Ponto(-1,-2).toString());
//	}
//
//	//Test the calculation of distance between 2 points
//	@Test
//	public void testDistancia0() 
//	{
//		Assert.assertEquals(1.41, new Ponto(3,3).dist(new Ponto(4,2)), EPSILON);
//		Assert.assertEquals(26.20, new Ponto(-7,-4).dist(new Ponto(17,6.5)), EPSILON);	
//		Assert.assertEquals(0.00, new Ponto(0,0).dist(new Ponto(0,0)), EPSILON);	
//	}
//	
//	//Test that toString of Ponto returns a string representation of the object 
//	//Example: (0.00, 1.00)
//	@Test
//	public void testPointToString0() {
//		Ponto a1 = new Ponto(1.0, 2.5);
//		Assert.assertEquals("(1.00, 2.50)", a1.toString());
//
//		Ponto a2 = new Ponto(-2.4, 4.1);
//		Assert.assertEquals("(-2.40, 4.10)", a2.toString());
//
//		Ponto a3 = new Ponto(9.3, -1.9);
//		Assert.assertEquals("(9.30, -1.90)", a3.toString());
//	}
//	
////----------- SegmentoReta Tests -----------//
//
//	//Test constructor SegmentoReta with no arguments
//	@Test
//	public void testSegmentoRetaConstructor0() {
//		SegmentoReta sg1 = new SegmentoReta();
//		Assert.assertEquals(new Ponto(0.0, 0.0), sg1.getPontoA());
//		Assert.assertEquals(new Ponto(0.0, 0.0), sg1.getPontoB());
//		Assert.assertEquals(new Ponto(0.0, 0.0), sg1.calculateMidPonto());
//	}
//	
//	//Test consctructor SegmentoReta with 2 points as arguments
//	@Test
//	public void testSegmentoRetaConstructor1() {
//		SegmentoReta sg1 = new SegmentoReta(new Ponto(2.0, 2.0), new Ponto(5.0, 1.4));
//		Assert.assertEquals(new Ponto(2.0, 2.0), sg1.getPontoA());
//		Assert.assertEquals(new Ponto(5.0, 1.4), sg1.getPontoB());
//		Assert.assertEquals("y = 5.00*x - 15.80", sg1.getMediatriz().toString());
//
//		SegmentoReta sg2 = new SegmentoReta(new Ponto(-3.0, 3.0), new Ponto(-2.0, -2.0));
//		Assert.assertEquals(new Ponto(-3.0, 3.0), sg2.getPontoA());
//		Assert.assertEquals(new Ponto(-2.0, -2.0), sg2.getPontoB());
//		Assert.assertEquals("y = 0.20*x + 1.00", sg2.getMediatriz().toString());
//
//		SegmentoReta sg3 = new SegmentoReta(new Ponto(1.0, 1.0), new Ponto(1.0, 4.0));
//		Assert.assertEquals(new Ponto(1.0, 1.0), sg3.getPontoA());
//		Assert.assertEquals(new Ponto(1.0, 4.0), sg3.getPontoB());
//		Assert.assertEquals("y = 2.50", sg3.getMediatriz().toString());
//
//		SegmentoReta sg4 = new SegmentoReta(new Ponto(1.0, 2.0), new Ponto(-2.0, 2.0));
//		Assert.assertEquals(new Ponto(1.0, 2.0), sg4.getPontoA());
//		Assert.assertEquals(new Ponto(-2.0, 2.0), sg4.getPontoB());
//		Assert.assertEquals("x = -0.50", sg4.getMediatriz().toString());
//	}
//	
//	//Test calculation of mediatrice of line segment
//	@Test
//	public void testCalculateMediatriz0() 
//	{
//		SegmentoReta sg1 = new SegmentoReta(new Ponto(2.0, 2.0), new Ponto(5.0, 1.4));
//		Reta r1 = sg1.calculateMediatriz();
//		Assert.assertEquals("y = 5.00*x - 15.80", r1.toString());
//
//		SegmentoReta sg2 = new SegmentoReta(new Ponto(-3.0, 3.0), new Ponto(-2.0, -2.0));
//		Reta r2 = sg2.calculateMediatriz();
//		Assert.assertEquals("y = 0.20*x + 1.00", r2.toString());
//
//		SegmentoReta sg3 = new SegmentoReta(new Ponto(1.0, 1.0), new Ponto(1.0, 4.0));
//		Reta r3 = sg3.calculateMediatriz();
//		Assert.assertEquals("y = 2.50", r3.toString());
//
//		SegmentoReta sg4 = new SegmentoReta(new Ponto(1.0, 2.0), new Ponto(-2.0, 2.0));
//		Reta r4 = sg4.calculateMediatriz();
//		
//		Assert.assertEquals("x = -0.50", r4.toString());
//	}
//
//	//Test calculation of mid point of line segment
//	@Test
//	public void testCalculateMidPonto0() 
//	{
//		SegmentoReta sg1 = new SegmentoReta(new Ponto(2.0, 2.0), new Ponto(5.0, 1.4));
//		Assert.assertEquals(new Ponto(3.5, 1.7), sg1.calculateMidPonto());
//
//		SegmentoReta sg2 = new SegmentoReta(new Ponto(-3.0, 3.0), new Ponto(-2.0, -2.0));
//		Assert.assertEquals(new Ponto(-2.5, 0.5), sg2.calculateMidPonto());
//
//		SegmentoReta sg3 = new SegmentoReta(new Ponto(1.0, 1.0), new Ponto(1.0, 4.0));
//		Assert.assertEquals(new Ponto(1.0, 2.5), sg3.calculateMidPonto());
//
//		SegmentoReta sg4 = new SegmentoReta(new Ponto(1.0, 2.0), new Ponto(-2.0, 2.0));
//		Assert.assertEquals(new Ponto(-0.5, 2.0), sg4.calculateMidPonto());
//	}
//	
//	//Test that toString of SegmentoReta returns a string representation of the object 
//	//Example: segmentoReta[(0.00, 0.00), (1.00, 1.00)]
//	@Test
//	public void testSegmentoToString0() {
//		SegmentoReta sg1 = new SegmentoReta(new Ponto(2.0, 2.0), new Ponto(5.0, 1.4));
//		Assert.assertEquals("segmentoReta[(2.00, 2.00), (5.00, 1.40)]", sg1.toString());
//
//		SegmentoReta sg2 = new SegmentoReta(new Ponto(-3.0, 3.0), new Ponto(-2.0, -2.0));
//		Assert.assertEquals("segmentoReta[(-3.00, 3.00), (-2.00, -2.00)]", sg2.toString());
//
//		SegmentoReta sg3 = new SegmentoReta(new Ponto(-1.0, -1.0), new Ponto(1.0, 4.0));
//		Assert.assertEquals("segmentoReta[(-1.00, -1.00), (1.00, 4.00)]", sg3.toString());
//
//		SegmentoReta sg4 = new SegmentoReta(new Ponto(1.0, 2.0), new Ponto(-2.0, -2.0));
//		Assert.assertEquals("segmentoReta[(1.00, 2.00), (-2.00, -2.00)]", sg4.toString());
//	}
//
////----------- Reta Tests -----------//
//	
//	//Test constructor Reta with no arguments
//	@Test
//	public void testRetaConstructor0() 
//	{
//		Reta r1 = new Reta();
//		Assert.assertEquals("", r1.getDeclive());
//		Assert.assertEquals(0.0, r1.getC(), EPSILON);
//		Assert.assertEquals("y = x + 0.00", r1.toString());
//	}
//	
//	//Test constructor Reta with slope and C as arguments
//	@Test
//	public void testRetaConstructor1() 
//	{
//		Reta r1 = new Reta("3.00", 1.0);
//		Assert.assertEquals("3.00", r1.getDeclive());
//		Assert.assertEquals(1.0, r1.getC(), EPSILON);
//		Assert.assertEquals("y = 3.00*x + 1.00", r1.toString());
//
//		Reta r2 = new Reta("-10.00", 2.12);
//		Assert.assertEquals("-10.00", r2.getDeclive());
//		Assert.assertEquals(2.12, r2.getC(), EPSILON);
//		Assert.assertEquals("y = -10.00*x + 2.12", r2.toString());
//
//		Reta r3 = new Reta("vertical", 2.0);
//		Assert.assertEquals("vertical", r3.getDeclive());
//		Assert.assertEquals(2.0, r3.getC(), EPSILON);
//		Assert.assertEquals("x = 2.00", r3.toString());
//
//		Reta r4 = new Reta("0.00", -3.00);
//		Assert.assertEquals("0.00", r4.getDeclive());
//		Assert.assertEquals(-3.0, r4.getC(), EPSILON);
//		Assert.assertEquals("y = -3.00", r4.toString());
//	}
//
//	//Test constructor Reta with 2 Point as arguments
//	@Test
//	public void testRetaConstructor2() {
//		Reta r1 = new Reta(new Ponto(2.0, 4.0), new Ponto(4.0, 2.0));
//		Assert.assertEquals("-1.0", r1.getDeclive());
//		Assert.assertEquals(6.0, r1.getC(), EPSILON);
//		Assert.assertEquals("y = -1.00*x + 6.00", r1.toString());
//
//		Reta r2 = new Reta(new Ponto(3.0, 2.0), new Ponto(7.0, -4.0));
//		Assert.assertEquals("-1.5", r2.getDeclive());
//		Assert.assertEquals(6.5, r2.getC(), EPSILON);
//		Assert.assertEquals("y = -1.50*x + 6.50", r2.toString());
//		
//		Reta r3 = new Reta(new Ponto(-6.0, -2.0), new Ponto(-3.0, -4.0));
//		Assert.assertEquals(Double.toString(-2.0 / 3.0), r3.getDeclive());
//		Assert.assertEquals(-6.0, r3.getC(), EPSILON);
//		Assert.assertEquals("y = -0.67*x - 6.00", r3.toString());
//	}
//	
//	//Test constructor Reta with 1 Point and the slope as arguments
//	@Test
//	public void testRetaConstructor3() {
//		Reta r1 = new Reta(new Ponto(2.0, 4.0), "-1.00");
//		Assert.assertEquals("-1.00", r1.getDeclive());
//		Assert.assertEquals(6.0, r1.getC(), EPSILON);
//		Assert.assertEquals("y = -1.00*x + 6.00", r1.toString());
//
//		Reta r2 = new Reta(new Ponto(3.0, 2.0), "-1.50");
//		Assert.assertEquals("-1.50", r2.getDeclive());
//		Assert.assertEquals(6.5, r2.getC(), EPSILON);
//		Assert.assertEquals("y = -1.50*x + 6.50", r2.toString());
//		
//		Reta r3 = new Reta(new Ponto(-6.0, -2.0), Double.toString(-2.0 / 3.0));
//		Assert.assertEquals(Double.toString(-2.0 / 3.0), r3.getDeclive());
//		Assert.assertEquals(-6.0, r3.getC(), EPSILON);
//		Assert.assertEquals("y = -0.67*x - 6.00", r3.toString());
//	}
//
//	//Test that calulateSlope, with two Points as arguments,  calculates the slope of the object and returns a String
//	//If Reta is vertical, calculateSlope returns String "vertical". If Reta is not vertical, calculateSlope returns a string representation of a double
//	@Test
//	public void testCalculateDeclive0() {
//		Assert.assertEquals("1.0", Reta.calculateDeclive(new Ponto(1.0, 1.0), new Ponto(2.0, 2.0)));
//		Assert.assertEquals("0.00", Reta.calculateDeclive(new Ponto(3.0, 1.0), new Ponto(2.0, 1.0)));
//		Assert.assertEquals(Double.toString(2.0 / 3.0), Reta.calculateDeclive(new Ponto(4.0, 2.0), new Ponto(1.0, 0.0)));
//		Assert.assertEquals("vertical", Reta.calculateDeclive(new Ponto(2.0, 1.0), new Ponto(2.0, 2.0)));
//	}
//
//	//Test that calulates c, with a Point and a slope as arguments, and returns a double
//	@Test
//	public void testCalculateC0() {
//		Assert.assertEquals(0.0, Reta.calculateC(new Ponto(2.0, 2.0), "1.00"), EPSILON);
//		Assert.assertEquals(1.0, Reta.calculateC(new Ponto(2.0, 1.0), "0.00"), EPSILON);
//		Assert.assertEquals(-1.0, Reta.calculateC(new Ponto(3.0, 1.0), Double.toString(2.0 / 3.0)), EPSILON);
//		Assert.assertEquals(2.0, Reta.calculateC(new Ponto(2.0, 1.0), "vertical"), EPSILON);
//	}
//	
//	//Test that intersection, with a Reta as argument, calculates the intersection between the object and the argument and returns a Point
//	@Test
//	public void testIntersection0() 
//	{
//		Reta sg1 = new Reta("0.0", 2.0 );
//		Reta sg2 = new Reta("vertical", 1.0);
//		Assert.assertEquals(new Ponto(1.0, 2.0), sg1.intersection(sg2));
//		
//		Reta sg3 = new Reta("1.0", 1.0 );
//		Reta sg4 = new Reta("-1.0", 6.0);
//		Assert.assertEquals(new Ponto(2.5, 3.5), sg3.intersection(sg4));
//		
//		Reta sg5 = new Reta("3.0", -4.0 );
//		Reta sg6 = new Reta("2.0", -3.0);
//		Assert.assertEquals(new Ponto(1.0, -1.0), sg5.intersection(sg6));
//	}
//	
//	//Test that toString of Reta returns a string representation of the object 
//	//Example1: y = 1.00*x + 2.00
//	//Example2: x = 1.00
//	@Test
//	public void testRetaToString0() {
//		Reta r1 = new Reta("vertical", 2.0);
//		Assert.assertEquals("x = 2.00", r1.toString());
//
//		Reta r2 = new Reta("vertical", -6.1);
//		Assert.assertEquals("x = -6.10", r2.toString());
//
//		Reta r3 = new Reta("0.00", 3.0);
//		Assert.assertEquals("y = 3.00", r3.toString());
//
//		Reta r4 = new Reta("0.00", -6.1);
//		Assert.assertEquals("y = -6.10", r4.toString());
//
//		Reta r5 = new Reta("3.1", 2.0);
//		Assert.assertEquals("y = 3.10*x + 2.00", r5.toString());
//
//		Reta r6 = new Reta("-1.9", 1.3);
//		Assert.assertEquals("y = -1.90*x + 1.30", r6.toString());
//	}
//
//	
//	//----------- Getter and Setter Tests - removed -----------//
//	
//	//Test that getCenter returns the value of center stored in the object
////	@Test
////	void testGetCentro0() {
////		Assert.assertEquals(new Ponto(2,2), new Circunferencia(new Ponto(0,2), new Ponto(4,2), new Ponto(2,4)).getCentro());
////		Assert.assertEquals(new Ponto(2,2), new Circunferencia(new Ponto(2,2), 2.0).getCentro());
////		Assert.assertEquals(new Ponto(3,3), new Circunferencia(new Ponto(1,3), new Ponto(3,5), new Ponto(5,3)).getCentro());
////		Assert.assertEquals(new Ponto(3,3), new Circunferencia(new Ponto(3,3), 2.0).getCentro());
////	}
//	
//	//Test that setCenter, with a Ponto argument, changes the value of center stored in the object
////	@Test
////	void testSetCentro0() {
////		Circunferencia C1 = new Circunferencia(new Ponto(0,2), new Ponto(4,2), new Ponto(2,4));
////		C1.setCentro(new Ponto(6,6));
////		Assert.assertEquals(new Ponto(6,6), C1.getCentro());
////		C1.setCentro(new Ponto(60,60));
////		Assert.assertEquals(new Ponto(60,60), C1.getCentro());
////		
////		Circunferencia C2 = new Circunferencia(new Ponto(1,3), new Ponto(3,5), new Ponto(5,3));
////		C2.setCentro(new Ponto(1,1));
////		Assert.assertEquals(new Ponto(1,1), C2.getCentro());
////		C2.setCentro(new Ponto(10,10));
////		Assert.assertEquals(new Ponto(10,10), C2.getCentro());
////	}
//	
//	//Test that setCenter, with x and y coordinates as arguments, changes the value of center stored in the object
////	@Test
////	void testSetCentro1() {
////		Circunferencia C1 = new Circunferencia(new Ponto(0,2), new Ponto(4,2), new Ponto(2,4));
////		C1.setCentro(8,8);
////		Assert.assertEquals(new Ponto(8,8), C1.getCentro());
////		C1.setCentro(800,800);
////		Assert.assertEquals(new Ponto(800,800), C1.getCentro());
////		
////		Circunferencia C2 = new Circunferencia(new Ponto(1,3), new Ponto(3,5), new Ponto(5,3));
////		C2.setCentro(10,10);
////		Assert.assertEquals(new Ponto(10,10), C2.getCentro());
////		C2.setCentro(0,0);
////		Assert.assertEquals(new Ponto(0,0), C2.getCentro());
////	}
//	
//	//Test that getRadius returns the value of radius in the object
////	@Test
////	void testGetRaio0() {
////		Circunferencia C1 = new Circunferencia(new Ponto(0,2), new Ponto(4,2), new Ponto(2,4));
////		Assert.assertEquals(2.00, C1.getRaio(), EPSILON);
////		
////		Circunferencia C2 = new Circunferencia(new Ponto(1,3), new Ponto(3,5), new Ponto(5,3));
////		Assert.assertEquals(2.00, C2.getRaio(), EPSILON);
////		
////		Circunferencia C3 = new Circunferencia(new Ponto(2,4), new Ponto(4,2), new Ponto(4,4));
////		Assert.assertEquals(1.41, C3.getRaio(), EPSILON);
////	}
//	
//	//Test that setRadius changes the value of radius in the object
////	@Test
////	void testSetRaio0() {
////		Circunferencia C1 = new Circunferencia(new Ponto(0,2), new Ponto(4,2), new Ponto(2,4));
////		C1.setRaio(1.01);
////		Assert.assertEquals(1.01, C1.getRaio(), EPSILON);
////		
////		Circunferencia C2 = new Circunferencia(new Ponto(1,3), new Ponto(3,5), new Ponto(5,3));
////		C2.setRaio(2.02);
////		Assert.assertEquals(2.02, C2.getRaio(), EPSILON);
////		
////		Circunferencia C3 = new Circunferencia(new Ponto(2,4), new Ponto(4,2), new Ponto(4,4));
////		C3.setRaio(3.03);
////		Assert.assertEquals(3.03, C3.getRaio(), EPSILON);
////	}
//	
//	//Test that getX returns the value of x in the Point object
////	@Test
////	void testGetX0()
////	{
////		Assert.assertEquals(1.00, new Ponto(1,2).getX(), EPSILON);
////		Assert.assertEquals(-4.00, new Ponto(-4,-4).getX(), EPSILON);
////		Assert.assertEquals(0.00, new Ponto(0,0).getX(), EPSILON);
////	}
//	
//	//Test that setX changes the value of x in the Point object
////	@Test
////	void testSetX0()
////	{
////		Ponto p1 = new Ponto(1,1);
////		p1.setX(3);
////		Assert.assertEquals("(3.00,1.00)", p1.toString());
////		
////		Ponto p2 = new Ponto(20,-3);
////		p2.setX(-20);
////		Assert.assertEquals("(-20.00,-3.00)", p2.toString());
////		
////		Ponto p3 = new Ponto(0,0);
////		p3.setX(100);
////		Assert.assertEquals("(100.00,0.00)", p3.toString());
////	}
////	
//	//Test that getY returns the value of y in the Point object
////	@Test
////	void testGetY0()
////	{
////		Assert.assertEquals(2.00, new Ponto(1,2).getY(), EPSILON);
////		Assert.assertEquals(-4.00, new Ponto(-4,-4).getY(), EPSILON);
////		Assert.assertEquals(10.00, new Ponto(0,10).getY(), EPSILON);
////	}
//	
//	//Test that setY changes the value of y in the Point object
////	@Test
////	void testSetY0()
////	{
////		Ponto p1 = new Ponto(1,1);
////		p1.setY(3);
////		Assert.assertEquals("(1.00, 3.00)", p1.toString());
////		
////		Ponto p2 = new Ponto(20,-3);
////		p2.setY(-20);
////		Assert.assertEquals("(20.00, -20.00)", p2.toString());
////		
////		Ponto p3 = new Ponto(0,0);
////		p3.setY(100);
////		Assert.assertEquals("(0.00, 100.00)", p3.toString());
////	}	
//	
//	//Test that setMidPonto , with 2 Point as argument, changes the value of midPonto in the object
////	@Test
////	void testSetMidpoint0() {
////		SegmentoReta sg1 = new SegmentoReta();
////		sg1.setMidPonto(new Ponto(2.0, 2.0), new Ponto(5.0, 1.4));
////		Assert.assertEquals(new Ponto(3.5, 1.7), sg1.getMidPonto());
////
////		SegmentoReta sg2 = new SegmentoReta();
////		sg2.setMidPonto(new Ponto(-3.0, 3.0), new Ponto(-2.0, -2.0));
////		Assert.assertEquals(new Ponto(-2.5, 0.5), sg2.getMidPonto());
////
////		SegmentoReta sg3 = new SegmentoReta();
////		sg3.setMidPonto(new Ponto(1.0, 1.0), new Ponto(1.0, 4.0));
////		Assert.assertEquals(new Ponto(1.0, 2.5), sg3.getMidPonto());
////
////		SegmentoReta sg4 = new SegmentoReta();
////		sg4.setMidPonto(new Ponto(1.0, 2.0), new Ponto(-2.0, 2.0));
////		Assert.assertEquals(new Ponto(-0.5, 2.0), sg4.getMidPonto());
////	}
//
//	//Test that getMidPoint returns the value of midPoint stored in the object
////	@Test
////	void testGetMidpoint0() {
////		SegmentoReta sg1 = new SegmentoReta(new Ponto(2.0, 2.0), new Ponto(5.0, 1.4));
////		Assert.assertEquals(new Ponto(3.5, 1.7), sg1.getMidPonto());
////
////		SegmentoReta sg2 = new SegmentoReta(new Ponto(-3.0, 3.0), new Ponto(-2.0, -2.0));
////		Assert.assertEquals(new Ponto(-2.5, 0.5), sg2.getMidPonto());
////
////		SegmentoReta sg3 = new SegmentoReta(new Ponto(1.0, 1.0), new Ponto(1.0, 4.0));
////		Assert.assertEquals(new Ponto(1.0, 2.5), sg3.getMidPonto());
////
////		SegmentoReta sg4 = new SegmentoReta(new Ponto(1.0, 2.0), new Ponto(-2.0, 2.0));
////		Assert.assertEquals(new Ponto(-0.5, 2.0), sg4.getMidPonto());
////	}
//
//	//Test that setPontoA , with a Point as argument, changes the value of pointA in the object
////	@Test
////	void testSetPontoA() {
////		SegmentoReta sg1 = new SegmentoReta();
////		sg1.setPontoA(new Ponto(2.0, 4.3));
////		Assert.assertEquals(new Ponto(2.0, 4.3), sg1.getPontoA());
////
////		SegmentoReta sg2 = new SegmentoReta();
////		sg2.setPontoA(new Ponto(-2.7, 6.1));
////		Assert.assertEquals(new Ponto(-2.7, 6.1), sg2.getPontoA());
////
////		SegmentoReta sg3 = new SegmentoReta();
////		sg3.setPontoA(new Ponto(1.1, -7.4));
////		Assert.assertEquals(new Ponto(1.1, -7.4), sg3.getPontoA());
////
////		SegmentoReta sg4 = new SegmentoReta();
////		sg4.setPontoA(new Ponto(-5.3, -5.6));
////		Assert.assertEquals(new Ponto(-5.3, -5.6), sg4.getPontoA());
////	}
//
//	//Test that getPontoA returns the value of pontoA stored in the object
////	@Test
////	void testGetPontoA() {
////		SegmentoReta sg1 = new SegmentoReta(new Ponto(2.0, 4.3), new Ponto(1.0, 1.3));
////		Assert.assertEquals(new Ponto(2.0, 4.3), sg1.getPontoA());
////
////		SegmentoReta sg2 = new SegmentoReta(new Ponto(-2.7, 6.1), new Ponto(-1.7, 1.1));
////		Assert.assertEquals(new Ponto(-2.7, 6.1), sg2.getPontoA());
////
////		SegmentoReta sg3 = new SegmentoReta(new Ponto(1.1, -7.4), new Ponto(0.1, -0.4));
////		Assert.assertEquals(new Ponto(1.1, -7.4), sg3.getPontoA());
////
////		SegmentoReta sg4 = new SegmentoReta(new Ponto(-5.3, -5.6), new Ponto(-1.3, -1.6));
////		Assert.assertEquals(new Ponto(-5.3, -5.6), sg4.getPontoA());
////	}
//
//	//Test that setPontoB , with a Point as argument, changes the value of pointB in the object
////	@Test
////	void testSetPontoB() {
////		SegmentoReta sg1 = new SegmentoReta();
////		sg1.setPontoB(new Ponto(0.0, 0.0));
////		Assert.assertEquals(new Ponto(0.0, 0.0), sg1.getPontoB());
////
////		SegmentoReta sg2 = new SegmentoReta();
////		sg2.setPontoB(new Ponto(-6.5, 2.1));
////		Assert.assertEquals(new Ponto(-6.5, 2.1), sg2.getPontoB());
////
////		SegmentoReta sg3 = new SegmentoReta();
////		sg3.setPontoB(new Ponto(4.0, -2.9));
////		Assert.assertEquals(new Ponto(4.0, -2.9), sg3.getPontoB());
////
////		SegmentoReta sg4 = new SegmentoReta();
////		sg4.setPontoB(new Ponto(-7.8, -0.6));
////		Assert.assertEquals(new Ponto(-7.8, -0.6), sg4.getPontoB());
////	}
//
//	//Test that getPontoB returns the value of pontoB stored in the object
////	@Test
////	void testGetPontoB() {
////		SegmentoReta sg1 = new SegmentoReta(new Ponto(1.0, 1.0), new Ponto(0.0, 0.0));
////		Assert.assertEquals(new Ponto(0.0, 0.0), sg1.getPontoB());
////
////		SegmentoReta sg2 = new SegmentoReta(new Ponto(-1.5, 1.1), new Ponto(-6.5, 2.1));
////		Assert.assertEquals(new Ponto(-6.5, 2.1), sg2.getPontoB());
////
////		SegmentoReta sg3 = new SegmentoReta(new Ponto(1.0, -1.9), new Ponto(4.0, -2.9));
////		Assert.assertEquals(new Ponto(4.0, -2.9), sg3.getPontoB());
////
////		SegmentoReta sg4 = new SegmentoReta(new Ponto(-1.8, -1.6), new Ponto(-7.8, -0.6));
////		Assert.assertEquals(new Ponto(-7.8, -0.6), sg4.getPontoB());
////	}
//	
//	//Test that setSlope, with a String argument, changes the value of slope in the object
////	@Test
////	void testSetDeclive0() {
////		Reta r1 = new Reta();
////		r1.setDeclive("vertical");
////		Assert.assertEquals("vertical", r1.getDeclive());
////		
////		Reta r2 = new Reta();
////		r2.setDeclive("2.00");
////		Assert.assertEquals("2.00", r1.getDeclive());
////		
////		Reta r3 = new Reta();
////		r3.setDeclive(Double.toString(2.0 / 3.0));
////		Assert.assertEquals(Double.toString(2.0 / 3.0), r3.getDeclive());
////	}
//
//	//Test that getSlope returns the value of slope stored in the object
////	@Test
////	void testGetDeclive0() {
////		Reta r1 = new Reta("3.00", 1.00);
////		Assert.assertEquals("3.00", r1.getDeclive());
////
////		Reta r2 = new Reta("-10.00", 2.12);
////		Assert.assertEquals("-10.00", r2.getDeclive());
////
////		Reta r3 = new Reta("vertical", 2.0);
////		Assert.assertEquals("vertical", r3.getDeclive());
////
////		Reta r4 = new Reta("0.00", -3.0);
////		Assert.assertEquals("0.00", r4.getDeclive());
////	}
//
//	//Test that setC , with a double argument, changes the value of c in the object
////	@Test
////	void testSetC0() {
////		Reta r1 = new Reta();
////		r1.setC(2.0);
////		Assert.assertEquals(2.0, r1.getC(), EPSILON);
////
////		Reta r2 = new Reta();
////		r2.setC(0.0);
////		Assert.assertEquals(0.0, r2.getC(), EPSILON);
////
////		Reta r3 = new Reta();
////		r3.setC(-3.0);
////		Assert.assertEquals(-3.0, r3.getC(), EPSILON);
////
////		Reta r4 = new Reta();
////		r4.setC(2.0 / 3.0);
////		Assert.assertEquals(2.0 / 3.0, r4.getC(), EPSILON);
////	}
//
//	//Test that getC returns the value of c stored in the object
////	@Test
////	void testGetC0() {
////		Reta r1 = new Reta("3.00", 1.00);
////		Assert.assertEquals(1.00, r1.getC(), EPSILON);
////
////		Reta r2 = new Reta("-10.00", 2.12);
////		Assert.assertEquals(2.12, r2.getC(), EPSILON);
////
////		Reta r3 = new Reta("vertical", 2.0);
////		Assert.assertEquals(2.00, r3.getC(), EPSILON);
////
////		Reta r4 = new Reta("0.00", -3.0);
////		Assert.assertEquals(-3.00, r4.getC(), EPSILON);
////	}
//
//	
//}
