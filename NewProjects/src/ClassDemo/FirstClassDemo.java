package ClassDemo;

public class FirstClassDemo {

	int x=90;
	int y=100;
	
	public static void main(String[] args) 
	{
		System.out.println("Program started");
		FirstClassDemo obj1=new FirstClassDemo();
		
		obj1.sum();
		
		System.out.println("End Program");
		
	}

	public void sum()
	{
		int a = 90;
		int b = 100;		
		int c =b+a;
		System.out.println("Sum of two numbers is "+c);;
	}
	
}
