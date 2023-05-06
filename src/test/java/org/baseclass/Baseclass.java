package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	public static WebDriver driver;
	
	public static WebDriver chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver edgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver =new EdgeDriver();
		return driver;
	}
	
	 public static WebDriver firefoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		return driver;
	}
	 
	public static void urlLaunch(String url) {
			
		driver.get(url);
	}
	 
	 public static void maximize() {
		driver.manage().window().maximize();
		
	}
	 
	 public static void implicitlyWait(long sec ) {
		 driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
    }
	 
	 public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	 
	 public static String getCurrentUrl() {
	  String currentUrl = driver.getCurrentUrl();
	  return currentUrl;

	}
	
	 public static void quit() {
	  driver.quit();
	}
	 
	 public static void close() {
	 driver.close();
	}
	 
	 public static void sendKeys(WebElement element,String value)  {
		element.sendKeys(value);
	}
	 
	 public static void click(WebElement element) {
		 element.click();	
	}
	 
	public static String getText(WebElement element) {
		String text = element.getText();
		return text;

	} 
	
	public static String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	 
	public static void moveToElement(WebElement target) {
		Actions a = new Actions(driver);
		a.moveToElement(target);
	}
	
	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target);
	}
	
	public static void clickAndHold(WebElement target) {
		Actions a = new Actions(driver);
		a.clickAndHold(target);
	}
	
	public static void doubleClick() {
		Actions a = new Actions(driver);
		a.doubleClick();
	}
	
	public static void contextClick() {
		Actions a = new Actions(driver);
		a.contextClick();
	}
	
	public static void selectByIndex(WebElement drpdwn,int index) {
	  Select s =new Select(drpdwn);
	  s.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement drpdwn,String value) {
	  Select s =new Select(drpdwn);
	  s.selectByValue(value);
	}
	
	public static void selectByVisibleText(WebElement drpdwn,String value) {
	  Select s =new Select(drpdwn);
	  s.selectByVisibleText(value);
	}
	
	public static String excelRead(String filename,String sheetname,int row,int cell) throws IOException {
		File f = new File("C:\\Users\\Hp\\eclipse-workspace\\SampleMavenProject\\src\\test\\resources\\"+filename+".xlsx");
		FileInputStream file = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(file);
		Sheet s = w.getSheet(sheetname);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		System.out.println(c);
		int rowCount = s.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		int cellCount = r.getPhysicalNumberOfCells();
		System.out.println(cellCount);

		int cellType = c.getCellType();
		System.out.println(cellType);
		String value =null;

		if(cellType==1)
		{
			value = c.getStringCellValue();
		}
		else {
			if(DateUtil.isCellDateFormatted(c)) {
				Date date = c.getDateCellValue();
				SimpleDateFormat sd = new SimpleDateFormat("dd-mm-yy");
				value=sd.format(date);
			}
			else {
				double numericCellValue = c.getNumericCellValue();
				long l = (long) numericCellValue;
				value = String.valueOf(l);
			}
		}
		return value;
		

	}
	
	

}
