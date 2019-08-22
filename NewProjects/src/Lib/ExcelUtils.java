package Lib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;

/*
 * ExcelUtils class provides methods to read data from the Excel Spread Sheets
 */
public class ExcelUtils {
	
	static String fileName;
	static String sheetName;
	// All the functions with in the class are overloaded with an optional sheetname parameter 
	// Constructors that initialises the class with the excel file path and the spread sheet names 
	
	public ExcelUtils( String fName )
	{
		
		fileName = fName;

	}
	
	public ExcelUtils( String fName,String SName )
	{
		
		fileName = fName;
		sheetName = SName;

	}
	
	// Returns the total number of rows (datasets) within the spreadsheet
	
	public int rowCount(String SName) throws Exception 
	{
		
		 File src=new File(fileName);
		 FileInputStream fis=new FileInputStream(src);
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		  XSSFSheet sh1= wb.getSheet(SName);
		  int ctRows = sh1.getLastRowNum();
		  wb.close();
		  if(fis != null) fis.close();
		 return ctRows+1;
		
	}
	
	public int rowCount() throws Exception 
	{
		
		String SName;
		int ctRows;
		XSSFSheet sh1;
		 File src=new File(fileName);
		 FileInputStream fis=new FileInputStream(src);
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		  if (ExcelUtils.sheetName != null)
		  {
			  SName = ExcelUtils.sheetName;
			sh1= wb.getSheet(SName);

		  } else
		  {
			  
			  sh1= wb.getSheetAt(0);
		  }
		  ctRows = sh1.getLastRowNum();
			  
		 wb.close();
		 if(fis != null) fis.close();
		return ctRows+1;
		
	}
	
	// Returns the total number of columns within the spreadsheet
	
	public int colCount(String SName) throws Exception 
	{
		
		 File src=new File(fileName);
		 FileInputStream fis=new FileInputStream(src);
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		  XSSFSheet sh1= wb.getSheet(SName);
		  int ctRows = sh1.getLastRowNum();
		  XSSFRow row = sh1.getRow(ctRows);
		  int ctCols = row.getLastCellNum();
		  wb.close();
		  if( fis != null) fis.close();
		 return ctCols;
		
	}
	
	public int colCount() throws Exception 
	{
		
		String SName = null;
		int ctRows,ctCols;
		XSSFSheet sh1;
		
		 File src=new File(fileName);
		 FileInputStream fis=new FileInputStream(src);
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		 if (ExcelUtils.sheetName != null)
		  {
			  SName = ExcelUtils.sheetName;
		  sh1= wb.getSheet(SName);
		
		  }else
		  {
			  
			  sh1= wb.getSheetAt(0);
			  
		  }
		 ctRows = sh1.getLastRowNum();
		  XSSFRow row = sh1.getRow(ctRows);
		  ctCols = row.getLastCellNum();
		 
		  wb.close();
		  if(fis != null) fis.close();
		 return ctCols;
		
	}
	
	// Read the data within Excel spreadsheet and return a two dimensional array 
	
	public String[][] readExcelContents(String SName) throws Exception 
	{
		 File src=new File(fileName);
		 FileInputStream fis=new FileInputStream(src);
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		  XSSFSheet sh1= wb.getSheet(SName);
		  int ctRows = sh1.getLastRowNum();
		  XSSFRow row = sh1.getRow(ctRows);
		  int ctCols = row.getLastCellNum();
		  int r = 0,i = 0;
			  
		String[][] content = new String[ctRows+1][ctCols] ;
  	 
  
		  for ( r = 0 ; r <= ctRows; r++)
		  {
			  for ( i = 0 ; i < ctCols; i++)
			  {
				  XSSFCell cell = sh1.getRow(r).getCell(i);
				  cell.setCellType(Cell.CELL_TYPE_STRING); 
				  content[r][i] = sh1.getRow(r).getCell(i).getStringCellValue();
				 // System.out.println(content[r][i]);
				  
			  }

		  }
		  wb.close();
		  if(fis != null) fis.close();
		  return content;
	}
	
	public String[][] readExcelContents() throws Exception 
	{
		XSSFSheet sh1;
		String SName = null;
		int ctRows,ctCols;
		 File src=new File(fileName);
		 FileInputStream fis=new FileInputStream(src);
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		 if (ExcelUtils.sheetName != null)
		{
			  SName = ExcelUtils.sheetName;
			  sh1= wb.getSheet(SName);
		}
		 else
		  {
			  
			  sh1= wb.getSheetAt(0);
			  
		  }
		  ctRows = sh1.getLastRowNum();
		  XSSFRow row = sh1.getRow(ctRows);
		  ctCols = row.getLastCellNum();
		  int r = 0,i = 0;
			  
		String[][] content = new String[ctRows+1][ctCols] ;
  	 
  
		  for ( r = 0 ; r <= ctRows; r++)
		  {
			  for ( i = 0 ; i < ctCols; i++)
			  {
				  XSSFCell cell = sh1.getRow(r).getCell(i);
				  cell.setCellType(Cell.CELL_TYPE_STRING); 
				  content[r][i] = sh1.getRow(r).getCell(i).getStringCellValue();
				 // System.out.println(content[r][i]);
				  
			  }

		  }
		  wb.close();
		  if(fis != null) fis.close();
		  return content;
	}
	
	
	// Read and returns a specific row of data within Excel spreadsheet 
	
	public HashMap<String,String> readRow(String SName,int rowNum) throws Exception 
	{
		
		HashMap<String,String> record = new HashMap<String, String>();
		int i = 0, j = 0;
		 i = rowNum ;
		 String[][] output = null;
		 
			ExcelUtils EU = new ExcelUtils(fileName);
			int rc = EU.rowCount(SName);
			int cc = EU.colCount(SName);
 		   output = new String[rc][cc];
			 output = EU.readExcelContents(SName);
			 
			//System.out.println("output.length = " + output.length);
			for (  j = 0 ; j < output[i].length; j++)
			{		
				record.put(output[0][j], output[i][j]);
			}
		
		return record;
		
	}
	
	public HashMap<String,String> readRow(int rowNum) throws Exception 
	{
		String SName = null;
		HashMap<String,String> record = new HashMap<String, String>();
		int i = 0, j = 0,rc,cc;
		 i = rowNum ;
		 String[][] output = null;
		 
			ExcelUtils EU = new ExcelUtils(fileName);
			 if (ExcelUtils.sheetName != null)
				{
					  SName = ExcelUtils.sheetName;
						rc = EU.rowCount(SName);
						cc = EU.colCount(SName);
				} else
				{
					
					rc = EU.rowCount();
					cc = EU.colCount();
				}
	
 		   output = new String[rc][cc];
 			 if (ExcelUtils.sheetName != null)
				{
 				    SName = ExcelUtils.sheetName;
 				 	output = EU.readExcelContents(SName);
				}else
				{
					output = EU.readExcelContents();
				}
				
 			 
			 
			//System.out.println("output.length = " + output.length);
			for (  j = 0 ; j < output[i].length; j++)
			{		
				record.put(output[0][j], output[i][j]);
			}
		
		return record;
		
	}
	
	// Read and returns a specific row of data ( Corresponding to a column name and its unique value )within Excel spreadsheet 
	
	public HashMap<String,String> readRecord(String SName,String key,String value) throws Exception 
	{
		
		HashMap<String,String> record = new HashMap<String, String>();
		int i = 0, j = 0, rowNum;
		
		 String[][] output = null;
		 
			ExcelUtils EU = new ExcelUtils(fileName);
			int rc = EU.rowCount(SName);
			int cc = EU.colCount(SName);
			 int recNum = 0;
			 
			//System.out.println("output.length = " + output.length);
				for ( i = 1 ; i < rc; i++)
				{	
		      
					record = EU.readRow(SName,i); 
				 
					
			 // check set values contentEquals
					if (record.get(key).contentEquals(value) )
					{
						recNum = i;
						break;
					}
				}
		
			return record;
		
	}
	
	public HashMap<String,String> readRecord(String key,String value) throws Exception 
	{
		String SName = null;
		HashMap<String,String> record = new HashMap<String, String>();
		int i = 0, j = 0,rc = 0,cc = 0,recNum, rowNum;
		
		 String[][] output = null;
		 
			ExcelUtils EU = new ExcelUtils(fileName);
			if (ExcelUtils.sheetName != null)
			{
				  SName = ExcelUtils.sheetName;
					rc = EU.rowCount(SName);
					cc = EU.colCount(SName);
			} else
			{
			 rc = EU.rowCount();
			 cc = EU.colCount();
			}
			recNum = 0;
			 
			//System.out.println("output.length = " + output.length);
				for ( i = 1 ; i < rc; i++)
				{	
		      
					record = EU.readRow(i); 
				 
					
			 // check set values contentEquals
					if (record.get(key).contentEquals(value) )
					{
						recNum = i;
						break;
					}
				}
		
			return record;
		
	}
	
	// Creates an excel spreadsheet and write the header and and a single record passed into by arrays 
	
	public synchronized void addSheetContent( String sName, String[] headers,String[] values) throws Exception 
	{
		File src=new File(fileName);
		
		FileOutputStream fos = new FileOutputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(sName);
		
		// Create headers
	
		XSSFRow row = sheet.createRow(0);
        for ( int i = 0 ; i < headers.length; i++)
		  {
		XSSFCell cell = row.createCell(i);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(headers[i]);
		  }
        
        // Create Contents
        XSSFRow row1 = sheet.createRow(1);
        for ( int i = 0 ; i < values.length; i++)
		  {
		XSSFCell cell = row1.createCell(i);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(values[i]);
		  }
        
    	workbook.write(fos);
    	workbook.close();
		if(fos != null) fos.close();
		
	}
	
	// Write the data into excel spreadsheet passed into by a two dimensional array 
	
	public synchronized void WriteSheetContents( String sName, String[][] contents) throws Exception 
	{
		File src=new File(fileName);
		
		FileOutputStream fos = new FileOutputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(sName);
		
		// Create headers + contents
	for ( int r = 0 ; r < contents.length; r++)
	{
		XSSFRow row = sheet.createRow(r);
        for ( int i = 0 ; i < contents[r].length; i++)
		  {
		XSSFCell cell = row.createCell(i);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(contents[r][i]);
		  }
	}
        

        
    	workbook.write(fos);
    	workbook.close();
		if(fos != null) fos.close();
		
	}
		
//Sample usage of the ExcelUtils Usage

public static void main(String []args) throws Exception
	
	{
			String[] headers = {"TestId","RequestId","Purpose","RuleId","Category","Score"};
			String[] values = {"2","077000001277","High","AWRS02","BUS_ANOM","3"};
			
			String[][] contents = {{"TestId","RequestId","Purpose","RuleId","Category","Score"},{"2","077000001277","High","AWRS02","BUS_ANOM","3"},{"2","077000001277","High","AWRS02","BUS_ANOM","3"},{"2","077000001277","High","AWRS02","BUS_ANOM","3"}
			
																						};
			//List ContentList = new ArrayList();
			
			
		//	[TestId=2, Score=3, Category=BUS_ANOM, RequestId=077000001277, RuleId=AWRS02, Purpose=High]
		    HashMap<String,String> record1 = new HashMap<String, String>();
		    HashMap<String,String> record2 = new HashMap<String, String>();
			ExcelUtils EU = new ExcelUtils("C:\\Automation\\DataDriven\\Inp.xlsx");
	
		
			// create set view for the map
			  int rc = EU.rowCount();
			  int cc = EU.colCount();
		      int recNum = 2;
		      String key;
		      String value;
		      key = "TestId";
		      value = "4";

		      record1 = EU.readRecord(key,value);
		      record2 = EU.readRow(recNum);
			 System.out.println("Total Number of the rows " + rc );
			 Set<Entry<String, String>> set=record1.entrySet();
			  System.out.println("Set values: " + set);
			  Set<Entry<String, String>> set2=record2.entrySet();
			  System.out.println("Set values: " + set2);
			  ExcelUtils EU1 = new ExcelUtils("C:\\Automation\\DataDriven\\Inp2.xlsx");
			  

			 EU1.addSheetContent("Automation",headers,values);
			 EU1.WriteSheetContents("Auto",contents);
		
	} 



}



