package VRS;

public abstract class Video
{
	private int code;
	private String title;
	private boolean available;
	
	public Video()
	{
	}
	
	public Video(int c, String t, boolean a)
	{
		code = c;
		title = t;
		available = a;
	}
	
	public void setCode(int c)
	{
		code = c;
	}
	
	public int getCode()
	{
		return code;
	}
	
	public void setTitle(String t)
	{
		title = t;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setAvailable(boolean a)
	{
		available = a;
	}
	
	public boolean getAvailable()
	{
		return available;
	}
	
	public abstract double calculateAmount();
	
	public String toString()
	{
		return	"Code = " + code + "\t" +
					"Title = " + title + "\t" +
					"Available = " + available;
	}
}