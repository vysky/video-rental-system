package VRS;
import java.util.ArrayList;

public class Member
{
	private int id;
	private String name;
	private String tel;
	private ArrayList rentalList = new ArrayList();
	
	public Member()
	{
	}
	
	public Member(int i, String n, String t)
	{
		id = i;
		name = n;
		tel = t;
	}
	
	public void setID(int i)
	{
		id = i;
	}
	
	public int getID()
	{
		return id;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setTel(String t)
	{
		tel = t;
	}
	
	public String getTel()
	{
		return tel;
	}
	
	public void addRental(Rental r)
	{
		rentalList.add(r);
	}
	
	public ArrayList getRentalList()
	{
		return rentalList;
	}
	
	public String toString()
	{
		return	"ID = " + id + "\t" +
					"Name = " + name + "\t" +
					"Telephone = " + tel + "\t" +
					"Rental = " + rentalList;
	}
}