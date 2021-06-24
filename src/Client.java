import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		DecimalFormatSymbols s = new DecimalFormatSymbols();
		s.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("0.00", s);
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		try
		{
			try
			{
				Circunferencia circ = new Circunferencia(new Ponto(sc.nextDouble(), sc.nextDouble()), new Ponto(sc.nextDouble(), sc.nextDouble()), new Ponto(sc.nextDouble(), sc.nextDouble()));
				Ponto p = new Ponto(sc.nextDouble(), sc.nextDouble());

				double distance = circ.getCentro().dist(p) - circ.getRaio();
				System.out.println(df.format(distance));
			}
			catch(InputMismatchException e)
			{
				System.out.println("An incorrect data type was entered. Try again with type double.");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		finally
		{
			sc.close();
		}
	}
}
