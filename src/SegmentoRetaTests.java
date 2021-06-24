import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SegmentoRetaTests {

	public final double EPSILON = 0.01;
	
	@Before
    public void init() {
       Locale.setDefault(new Locale ("us", "US"));
    }
	
//----------- SegmentoReta Tests -----------//

	//Test constructor SegmentoReta with no arguments
	@Test
	public void testSegmentoRetaConstructor0() {
		SegmentoReta sg1 = new SegmentoReta();
		Assert.assertEquals(new Ponto(0.0, 0.0), sg1.getPontoA());
		Assert.assertEquals(new Ponto(0.0, 0.0), sg1.getPontoB());
		Assert.assertEquals(new Ponto(0.0, 0.0), sg1.calculateMidPonto());
	}
	
	//Test consctructor SegmentoReta with 2 points as arguments
	@Test
	public void testSegmentoRetaConstructor1() {
		SegmentoReta sg1 = new SegmentoReta(new Ponto(2.0, 2.0), new Ponto(5.0, 1.4));
		Assert.assertEquals(new Ponto(2.0, 2.0), sg1.getPontoA());
		Assert.assertEquals(new Ponto(5.0, 1.4), sg1.getPontoB());
		Assert.assertEquals("y = 5.00*x - 15.80", sg1.getMediatriz().toString());

		SegmentoReta sg2 = new SegmentoReta(new Ponto(-3.0, 3.0), new Ponto(-2.0, -2.0));
		Assert.assertEquals(new Ponto(-3.0, 3.0), sg2.getPontoA());
		Assert.assertEquals(new Ponto(-2.0, -2.0), sg2.getPontoB());
		Assert.assertEquals("y = 0.20*x + 1.00", sg2.getMediatriz().toString());

		SegmentoReta sg3 = new SegmentoReta(new Ponto(1.0, 1.0), new Ponto(1.0, 4.0));
		Assert.assertEquals(new Ponto(1.0, 1.0), sg3.getPontoA());
		Assert.assertEquals(new Ponto(1.0, 4.0), sg3.getPontoB());
		Assert.assertEquals("y = 2.50", sg3.getMediatriz().toString());

		SegmentoReta sg4 = new SegmentoReta(new Ponto(1.0, 2.0), new Ponto(-2.0, 2.0));
		Assert.assertEquals(new Ponto(1.0, 2.0), sg4.getPontoA());
		Assert.assertEquals(new Ponto(-2.0, 2.0), sg4.getPontoB());
		Assert.assertEquals("x = -0.50", sg4.getMediatriz().toString());
	}
	
	//Test calculation of mediatrice of line segment
	@Test
	public void testCalculateMediatriz0() 
	{
		SegmentoReta sg1 = new SegmentoReta(new Ponto(2.0, 2.0), new Ponto(5.0, 1.4));
		Reta r1 = sg1.calculateMediatriz();
		Assert.assertEquals("y = 5.00*x - 15.80", r1.toString());

		SegmentoReta sg2 = new SegmentoReta(new Ponto(-3.0, 3.0), new Ponto(-2.0, -2.0));
		Reta r2 = sg2.calculateMediatriz();
		Assert.assertEquals("y = 0.20*x + 1.00", r2.toString());

		SegmentoReta sg3 = new SegmentoReta(new Ponto(1.0, 1.0), new Ponto(1.0, 4.0));
		Reta r3 = sg3.calculateMediatriz();
		Assert.assertEquals("y = 2.50", r3.toString());

		SegmentoReta sg4 = new SegmentoReta(new Ponto(1.0, 2.0), new Ponto(-2.0, 2.0));
		Reta r4 = sg4.calculateMediatriz();
		
		Assert.assertEquals("x = -0.50", r4.toString());
	}

	//Test calculation of mid point of line segment
	@Test
	public void testCalculateMidPonto0() 
	{
		SegmentoReta sg1 = new SegmentoReta(new Ponto(2.0, 2.0), new Ponto(5.0, 1.4));
		Assert.assertEquals(new Ponto(3.5, 1.7), sg1.calculateMidPonto());

		SegmentoReta sg2 = new SegmentoReta(new Ponto(-3.0, 3.0), new Ponto(-2.0, -2.0));
		Assert.assertEquals(new Ponto(-2.5, 0.5), sg2.calculateMidPonto());

		SegmentoReta sg3 = new SegmentoReta(new Ponto(1.0, 1.0), new Ponto(1.0, 4.0));
		Assert.assertEquals(new Ponto(1.0, 2.5), sg3.calculateMidPonto());

		SegmentoReta sg4 = new SegmentoReta(new Ponto(1.0, 2.0), new Ponto(-2.0, 2.0));
		Assert.assertEquals(new Ponto(-0.5, 2.0), sg4.calculateMidPonto());
	}
	
	//Test that toString of SegmentoReta returns a string representation of the object 
	//Example: segmentoReta[(0.00, 0.00), (1.00, 1.00)]
	@Test
	public void testSegmentoToString0() {
		SegmentoReta sg1 = new SegmentoReta(new Ponto(2.0, 2.0), new Ponto(5.0, 1.4));
		Assert.assertEquals("segmentoReta[(2.00, 2.00), (5.00, 1.40)]", sg1.toString());

		SegmentoReta sg2 = new SegmentoReta(new Ponto(-3.0, 3.0), new Ponto(-2.0, -2.0));
		Assert.assertEquals("segmentoReta[(-3.00, 3.00), (-2.00, -2.00)]", sg2.toString());

		SegmentoReta sg3 = new SegmentoReta(new Ponto(-1.0, -1.0), new Ponto(1.0, 4.0));
		Assert.assertEquals("segmentoReta[(-1.00, -1.00), (1.00, 4.00)]", sg3.toString());

		SegmentoReta sg4 = new SegmentoReta(new Ponto(1.0, 2.0), new Ponto(-2.0, -2.0));
		Assert.assertEquals("segmentoReta[(1.00, 2.00), (-2.00, -2.00)]", sg4.toString());
	}

	
	//----------- Getter and Setter Tests - removed -----------//
	
	//Test that setMidPonto , with 2 Point as argument, changes the value of midPonto in the object
//	@Test
//	void testSetMidpoint0() {
//		SegmentoReta sg1 = new SegmentoReta();
//		sg1.setMidPonto(new Ponto(2.0, 2.0), new Ponto(5.0, 1.4));
//		Assert.assertEquals(new Ponto(3.5, 1.7), sg1.getMidPonto());
//
//		SegmentoReta sg2 = new SegmentoReta();
//		sg2.setMidPonto(new Ponto(-3.0, 3.0), new Ponto(-2.0, -2.0));
//		Assert.assertEquals(new Ponto(-2.5, 0.5), sg2.getMidPonto());
//
//		SegmentoReta sg3 = new SegmentoReta();
//		sg3.setMidPonto(new Ponto(1.0, 1.0), new Ponto(1.0, 4.0));
//		Assert.assertEquals(new Ponto(1.0, 2.5), sg3.getMidPonto());
//
//		SegmentoReta sg4 = new SegmentoReta();
//		sg4.setMidPonto(new Ponto(1.0, 2.0), new Ponto(-2.0, 2.0));
//		Assert.assertEquals(new Ponto(-0.5, 2.0), sg4.getMidPonto());
//	}

	//Test that getMidPoint returns the value of midPoint stored in the object
//	@Test
//	void testGetMidpoint0() {
//		SegmentoReta sg1 = new SegmentoReta(new Ponto(2.0, 2.0), new Ponto(5.0, 1.4));
//		Assert.assertEquals(new Ponto(3.5, 1.7), sg1.getMidPonto());
//
//		SegmentoReta sg2 = new SegmentoReta(new Ponto(-3.0, 3.0), new Ponto(-2.0, -2.0));
//		Assert.assertEquals(new Ponto(-2.5, 0.5), sg2.getMidPonto());
//
//		SegmentoReta sg3 = new SegmentoReta(new Ponto(1.0, 1.0), new Ponto(1.0, 4.0));
//		Assert.assertEquals(new Ponto(1.0, 2.5), sg3.getMidPonto());
//
//		SegmentoReta sg4 = new SegmentoReta(new Ponto(1.0, 2.0), new Ponto(-2.0, 2.0));
//		Assert.assertEquals(new Ponto(-0.5, 2.0), sg4.getMidPonto());
//	}

	//Test that setPontoA , with a Point as argument, changes the value of pointA in the object
//	@Test
//	void testSetPontoA() {
//		SegmentoReta sg1 = new SegmentoReta();
//		sg1.setPontoA(new Ponto(2.0, 4.3));
//		Assert.assertEquals(new Ponto(2.0, 4.3), sg1.getPontoA());
//
//		SegmentoReta sg2 = new SegmentoReta();
//		sg2.setPontoA(new Ponto(-2.7, 6.1));
//		Assert.assertEquals(new Ponto(-2.7, 6.1), sg2.getPontoA());
//
//		SegmentoReta sg3 = new SegmentoReta();
//		sg3.setPontoA(new Ponto(1.1, -7.4));
//		Assert.assertEquals(new Ponto(1.1, -7.4), sg3.getPontoA());
//
//		SegmentoReta sg4 = new SegmentoReta();
//		sg4.setPontoA(new Ponto(-5.3, -5.6));
//		Assert.assertEquals(new Ponto(-5.3, -5.6), sg4.getPontoA());
//	}

	//Test that getPontoA returns the value of pontoA stored in the object
//	@Test
//	void testGetPontoA() {
//		SegmentoReta sg1 = new SegmentoReta(new Ponto(2.0, 4.3), new Ponto(1.0, 1.3));
//		Assert.assertEquals(new Ponto(2.0, 4.3), sg1.getPontoA());
//
//		SegmentoReta sg2 = new SegmentoReta(new Ponto(-2.7, 6.1), new Ponto(-1.7, 1.1));
//		Assert.assertEquals(new Ponto(-2.7, 6.1), sg2.getPontoA());
//
//		SegmentoReta sg3 = new SegmentoReta(new Ponto(1.1, -7.4), new Ponto(0.1, -0.4));
//		Assert.assertEquals(new Ponto(1.1, -7.4), sg3.getPontoA());
//
//		SegmentoReta sg4 = new SegmentoReta(new Ponto(-5.3, -5.6), new Ponto(-1.3, -1.6));
//		Assert.assertEquals(new Ponto(-5.3, -5.6), sg4.getPontoA());
//	}

	//Test that setPontoB , with a Point as argument, changes the value of pointB in the object
//	@Test
//	void testSetPontoB() {
//		SegmentoReta sg1 = new SegmentoReta();
//		sg1.setPontoB(new Ponto(0.0, 0.0));
//		Assert.assertEquals(new Ponto(0.0, 0.0), sg1.getPontoB());
//
//		SegmentoReta sg2 = new SegmentoReta();
//		sg2.setPontoB(new Ponto(-6.5, 2.1));
//		Assert.assertEquals(new Ponto(-6.5, 2.1), sg2.getPontoB());
//
//		SegmentoReta sg3 = new SegmentoReta();
//		sg3.setPontoB(new Ponto(4.0, -2.9));
//		Assert.assertEquals(new Ponto(4.0, -2.9), sg3.getPontoB());
//
//		SegmentoReta sg4 = new SegmentoReta();
//		sg4.setPontoB(new Ponto(-7.8, -0.6));
//		Assert.assertEquals(new Ponto(-7.8, -0.6), sg4.getPontoB());
//	}

	//Test that getPontoB returns the value of pontoB stored in the object
//	@Test
//	void testGetPontoB() {
//		SegmentoReta sg1 = new SegmentoReta(new Ponto(1.0, 1.0), new Ponto(0.0, 0.0));
//		Assert.assertEquals(new Ponto(0.0, 0.0), sg1.getPontoB());
//
//		SegmentoReta sg2 = new SegmentoReta(new Ponto(-1.5, 1.1), new Ponto(-6.5, 2.1));
//		Assert.assertEquals(new Ponto(-6.5, 2.1), sg2.getPontoB());
//
//		SegmentoReta sg3 = new SegmentoReta(new Ponto(1.0, -1.9), new Ponto(4.0, -2.9));
//		Assert.assertEquals(new Ponto(4.0, -2.9), sg3.getPontoB());
//
//		SegmentoReta sg4 = new SegmentoReta(new Ponto(-1.8, -1.6), new Ponto(-7.8, -0.6));
//		Assert.assertEquals(new Ponto(-7.8, -0.6), sg4.getPontoB());
//	}
		
}
