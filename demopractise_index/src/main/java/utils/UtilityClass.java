package utils;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {
public static void captureScreenShots(WebDriver driver,int testId) throws IOException
{
        TakesScreenshot t =(TakesScreenshot)driver; 
		File srcFile=t.getScreenshotAs(OutputType.FILE);
		//File destFile=new File("C:\\Users\\ftvas\\eclipse-workspace\\Hellojava\\demopractise_index\\screenshots\\"+Utilities.random()+".png");
		Date dtref=new Date() ;
		SimpleDateFormat sdf=new SimpleDateFormat("DDD-MM-YYYY hh mm ss");
		sdf.format(dtref);		
		
		
		File destFile=new File("E:\\Automation Practices\\TestCaseID-"+testId+" "+sdf.format(dtref)+".png");
		
		//FileUtils.copyFile(srcFile, destFile);
		FileHandler.copy(srcFile, destFile);
		
	}	
	 
	

	public static String fetchDataFromExcel(String s, int r, int c) throws EncryptedDocumentException, IOException {
		

		File file=new File("E:\\Automation Practices\\First_Test1.xlsx");
		//String path="C:\\Users\\ftvas\\OneDrive\\Desktop\\First_Test1.xlsx";
		
	    Cell expectedcellvalue=	WorkbookFactory.create( file).getSheet(s).getRow(r).getCell(c);
       String cellvalueString="";
       
       try {
    	   cellvalueString= expectedcellvalue.getStringCellValue();
    	   
	} catch (IllegalStateException ill) {
 	  double numcellvalue= expectedcellvalue.getNumericCellValue();
         cellvalueString= numcellvalue+"";
        cellvalueString= Double.toString(numcellvalue);
	}catch (Exception e) {
		e.printStackTrace();
		e.getMessage();
	}
      return cellvalueString;
		
	}
	
}

