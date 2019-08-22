package Lib;

import org.testng.annotations.Test;

public class DataProvider {

	
	@Test(dataProvider="getData")
	public void UserNamePassword(String username, String password) 
	{
		System.out.println(username);
		System.out.println(password);
	}

	@org.testng.annotations.DataProvider
	public Object[][] getData()
	{
//	i stands for number of times testcase should run
//	j stands for number of times parameters should for one go
	Object[][] data=new Object[1][2];
//	Object[][] data=new Object[i][j];
	data[0][0]="marcoolarr@hotmail.com";
	data[0][1]="pa0sosw0rd";
	
	return data;
	}
}
