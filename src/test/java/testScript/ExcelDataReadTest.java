package testScript;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;

public class ExcelDataReadTest extends Base {
WebDriver driver;
	
	@BeforeMethod
	public void startUp() throws IOException
	{
		driver = intializeDrive();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider = "execlDataUser")
	public void readDatatfromExcelTest()
	{
		
	}
	
	@DataProvider(name ="execlDataUser")
	public void getUserLoginDataExcel() throws IOException
	{
		String excelFilePath = ".\\jsonFiles\\ExcelUserData.xlsx";
		FileInputStream fis = new FileInputStream(excelFilePath);
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheetAt(0);//get sheet of excel file
		System.out.println(sheet);
		
		int rows = sheet.getLastRowNum();
		int columns =sheet.getRow(1).getLastCellNum();
		
		for(int r = 1; r<= rows; r++)
		{
			XSSFRow  row = sheet.getRow(r);
			System.out.println(row.getCell(columns));
//			for(int c =0; c<=columns; c++ )
//			{
//				XSSFCell cell  = row.getCell(c);
//				switch(cell.getCellType())
//				{
//				case STRING : System.out.print(cell.getStringCellValue()); break;
//				case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
//				case BOOLEAN : System.out.print(cell.getBooleanCellValue()); break;
//				default:
//					break;
//				}
//				System.out.print(" | ");
//			}
			System.out.println();
			
		}
		workBook.close();
		
		// Using by Iterator////////////
//			Iterator itr = sheet.iterator();
//			while(itr.hasNext())
//			{
//				XSSFRow row	= (XSSFRow) itr.next();
//				
//				
//				Iterator cellItr = row.cellIterator();				
//				while(cellItr.hasNext())
//				{
//					XSSFCell cell = (XSSFCell) cellItr.next();
//					
//					switch(cell.getCellType())
//					{
//					case STRING : System.out.print(cell.getStringCellValue()); break;
//					case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
//					case BOOLEAN : System.out.print(cell.getBooleanCellValue()); break;
//					default:
//						break;
//						
//					}
//					System.out.print(" | ");
//				}
//				System.out.println();
//			}
				
		}
	
	@AfterMethod
	public void closure()
	{
		driver.quit();
	}


}
