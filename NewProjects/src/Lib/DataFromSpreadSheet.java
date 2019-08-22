package Lib;

import org.testng.annotations.DataProvider;

import expenses.ExcelDataConfigFile;

public class DataFromSpreadSheet {
	
	@DataProvider
	public Object[][] NavisionData()
	{
		
		ExcelDataConfigFile config=new ExcelDataConfigFile("C:\\Users\\mardarri\\workspace\\NewProjects\\src\\expenses\\NavisionData.xlsx");
		
		int rows=config.getRowCount(0);
		
		Object[][] data=new Object[rows][5];
		
		for(int i=0;i<rows;i++)
			
		{
			data[i][0]=config.getData(0, i, 0);
			data[i][1]=config.getData(0, i, 1);
			data[i][2]=config.getData(0, i, 2);
			data[i][3]=config.getData(0, i, 3);
			data[i][4]=config.getData(0, i, 4);
		}
		
		return data;
	}

}
