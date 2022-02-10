package VRS;

public class Movie extends Video
{
	private int length;
	private static double ratePerMovie;
	
	public Movie()
	{
		super();
	}
	
	public Movie(int c, String t, boolean a, int l)
	{
		super(c, t, a);
		length = l;
		ratePerMovie = 5.0;
	}
	
	public void setLength(int l)
	{
		length = l;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public void setRatePerMovie(double rpm)
	{
		ratePerMovie = rpm;
	}
	
	public double getRatePerMovie()
	{
		return ratePerMovie;
	}
	
	public double calculateAmount()
	{
		return ratePerMovie;
	}
	
	public String toString()
	{
		return	super.toString() + "\t" +
					"Length = " + length + "\t" +
					"Rate Per Movie = " + ratePerMovie;
	}
}