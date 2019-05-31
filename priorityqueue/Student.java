public class Student implements Comparable<Student>
{
	private String lname = null;
	private String fname = null;
	private Integer year = null;

	public Student(String lname, String fname, Integer year)
	{
		this.lname = lname;
		this.fname = fname;
		this.year = year;
	}

	public int compareTo (Student st)
	{
		if (year < st.year) //lower grad year - higher priority
		{
			return 1;
		}	
		else if (year > st.year) //higher grad year - lower priority
		{
			return -1;
		}
		else 
		{
			if (lname.compareTo(st.lname) == 0)
			{
				return 0; //last names are same
			}
			else if (lname.compareTo(st.lname) < 0) 
			{
				return 1; //first name has higher priority (comes before in abcs)
			}
			else
			{
				return -1; //first name has lower priority (comes after in abcs)
			}
		}
	}
	
	public String toString()
	{
		String str = this.lname + " " + this.fname + " " + this.year;

		return str;
	}
}
