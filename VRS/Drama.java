package VRS;

public class Drama extends Video
{
	private int numberOfDisc;
	private static double ratePerDisc;
	
	public Drama()
	{
		super();
	}
	
	public Drama(int c, String t, boolean a, int d)
	{
		super(c, t, a);
		numberOfDisc = d;
		ratePerDisc = 2.0;
	}
	
	public void setNumberOfDisc(int d)
	{
		numberOfDisc = d;
	}
	
	public int getNumberOfDisc()
	{
		return numberOfDisc;
	}
	
	public void setRatePerDisc(double r)
	{
		ratePerDisc = r;
	}
	
	public double getRatePerDisc()
	{
		return ratePerDisc;
	}
	
	public double calculateAmount()
	{
		return ratePerDisc * numberOfDisc;
	}
	
	public String toString()
	{
		return	super.toString() + "\t" +
					"Number Of Disc = " + numberOfDisc + "\t" +
					"Rate Per Disc = " + ratePerDisc;
	}
}