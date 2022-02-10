package VRS;
import java.util.Calendar;

public class Rental
{
	private static int counter = 0;
	private int rentalNo;
	private Member borrower;
	private Video video;
	private Calendar loanDate;
	
	public Rental()
	{
	}
	
	public Rental(Member m, Video v, Calendar c)
	{
		rentalNo = ++counter;
		borrower = m;
		video = v;
		loanDate = c;
	}
	
	public void setCounter(int c)
	{
		counter = c;
	}
	
	public int getCounter()
	{
		return counter;
	}
	
	public void setRentalNo(int r)
	{
		rentalNo = r;
	}
	
	public int getRentalNo()
	{
		return rentalNo;
	}
	
	public void setBorrower(Member m)
	{
		borrower = m;
	}
	
	public Member getBorrower()
	{
		return borrower;
	}
	
	public void setVideo(Video v)
	{
		video = v;
	}
	
	public Video getVideo()
	{
		return video;
	}
	
	public void setLoanDate(Calendar c)
	{
		loanDate = c;
	}
	
	public Calendar getLoanDate()
	{
		return loanDate;
	}
	
	public String toString()
	{
		return	"Counter = " + counter + "\t" +
					"Rental Number = " + rentalNo + "\t" +
					"Member = " + borrower + "\t" +
					"Video = " + video + "\t" +
					"Calendar = " + loanDate;
	}
}