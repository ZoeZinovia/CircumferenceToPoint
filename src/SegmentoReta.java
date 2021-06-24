
public class SegmentoReta {
	private Ponto pontoA;
	private Ponto pontoB;
	private Reta mediatriz;
	/**
	 * empty segmento de reta constructor
	 */
	public SegmentoReta() {
		setPontoA(new Ponto(0, 0));
		setPontoB(new Ponto(0, 0));
		setMediatriz();
	}

	/**
	 * Segmento de reta constructor with two points
	 * @param p is one of the end points
	 * @param q is the other end point
	 */
	public SegmentoReta(Ponto p, Ponto q) {
		setPontoA(p);
		setPontoB(q);
		setMediatriz();
	}

	/**
	 * Calculates the middle point of the reta segment
	 */
	public Ponto calculateMidPonto() {
		return new Ponto((pontoA.getX() + pontoB.getX()) / 2, (pontoA.getY() + pontoB.getY()) / 2);
	}

	/**
	 * Calculates the mediatriz of the reta segment
	 */
	public Reta calculateMediatriz() {
		Ponto mid = calculateMidPonto();
		String declive_s = Reta.calculateDeclive(pontoA, pontoB);
		if (declive_s.equals("vertical")) {
			return new Reta(mid, "0.00");
		} else if (declive_s.equals("0.00")||declive_s.equals("0.0")) {
			return new Reta(mid, "vertical");
		} else
			return new Reta(mid,Double.toString(-1 / Double.valueOf(declive_s)));
	}

	/**
	 * @return mediatriz
	 */
	public Reta getMediatriz() {
		return mediatriz;
	}

	/**
	 * to set new mediatriz
	 */
	public void setMediatriz() {
		this.mediatriz = this.calculateMediatriz();
	}

	/**
	 * @return point A
	 */
	public Ponto getPontoA() {
		return pontoA;
	}

	/**
	 * to set new point A with argument
	 * @param pointA
	 */
	public void setPontoA(Ponto pontoA) {
		this.pontoA = pontoA;
	}

	/**
	 * @return point B
	 */
	public Ponto getPontoB() {
		return pontoB;
	}

	/**
	 * to set new point B with argument
	 * @param pointB
	 */
	public void setPontoB(Ponto pontoB) {
		this.pontoB = pontoB;
	}

	/**
	 * @return String representation of segmentoReta
	 */
	public String toString() {
		return "segmentoReta[" + pontoA.toString() + ", " + pontoB.toString() + "]";
	}
}
