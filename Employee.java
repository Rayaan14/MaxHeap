package problem01;

public class Employee implements Comparable<Employee>{

	private String name;
	private String gender;
	private double salary;
	
	Employee()
	{
		name = "Default Name";
		gender = "unknown";
		salary = 0.0;	
	}
	
	Employee(String name, String gender, double salary)
	{
		this.name = name;
		this.gender = gender;
		this.salary = salary;
		
	}
	
	public String toString()
	{
		return "Name: " + this.name + ", Gender: " + this.gender + ", Salary: " + this.salary + "\n"; 	
	}

	@Override
	public int compareTo(Employee o) {
		
		return (int)(this.salary - o.salary);
	}
	
}

