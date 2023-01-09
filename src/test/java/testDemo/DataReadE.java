package testDemo;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

public class DataReadE {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String excelFilePath = ".\\jsonFiles\\ExcelUserData.xlsx";
		FileInputStream fis = new FileInputStream(excelFilePath);
		@SuppressWarnings("resource")
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheetAt(0);//get sheet of excel file
		 ////Using by Iterator////////////
		Iterator itr = sheet.iterator();
		while(itr.hasNext())
		{
			XSSFRow row	= (XSSFRow) itr.next();
			
		
			Iterator cellItr = row.cellIterator();				
			while(cellItr.hasNext())
			{
				XSSFCell cell = (XSSFCell) cellItr.next();
				
				switch(cell.getCellType())
				{
				case STRING : System.out.print(cell.getStringCellValue()); break;
				case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
				case BOOLEAN : System.out.print(cell.getBooleanCellValue()); break;
				default:
					break;
					
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
//	@DataProvider
		public Object [][] getLoginData()
		{
			Object [][] data = {{"ramdhani222222@gmail.com","Ram@123","Successfull"},{"ramdhani222@gmail.com","Ram@123","Failure"}};
			return data;
		}
//	@DataProvider(name = "dp")
		public String[] readJson() throws IOException, ParseException {
			JSONParser jsonParser = new JSONParser();
			FileReader reader = new FileReader(".\\jsonFiles\\registerTestData.json");

			Object obj = jsonParser.parse(reader);
			JSONObject userregisterJsonObject = (JSONObject) obj;
			JSONArray userregisterArray = (JSONArray) userregisterJsonObject.get("userregister");

			String arr[] = new String[userregisterArray.size()];

			for (int i = 0; i < userregisterArray.size(); i++) {
				JSONObject registers = (JSONObject) userregisterArray.get(i);

				String firstname = (String) registers.get("firstname");
				String lasename = (String) registers.get("lasename");
				
				arr[i] = firstname + "," + lasename;
			}

			return arr;

		}
		
		

	}

}
