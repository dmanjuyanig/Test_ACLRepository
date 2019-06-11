package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.net.URL;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.TestException;

public class Utility 
{
	static WebDriver driver;
	//To get photo for an failed test cases.
	public static String getPhoto(WebDriver driver,String folder) 
	{
		Date d=new Date();
		String dateTime=d.toString().replaceAll(":","_");
		String path=folder+"/"+dateTime+".png";

		
		try {
				TakesScreenshot t=(TakesScreenshot)driver;
				File srcFile = t.getScreenshotAs(OutputType.FILE);
				File destFile=new File(path);
				FileUtils.copyFile(srcFile, destFile);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	//To open an specific browser.
	public static WebDriver openBrowser(String ip,String browser)
	{
		WebDriver driver;
				if(ip.equals("localhost")){
					if(browser.equals("chrome")){
						driver=new ChromeDriver();
					}
					else{
						driver=new FirefoxDriver();
					}
				}
				else{
						try{
							URL url=new URL("http://"+ip+":4444/wd/hub");
							DesiredCapabilities dc=new DesiredCapabilities();
							dc.setBrowserName(browser);
							driver=new RemoteWebDriver(url,dc);
						}
						catch (Exception e) {
							e.printStackTrace();
							driver=new ChromeDriver();
						}
				
					}

		return driver;
	}
	
	//To read data from excel sheet.
	public static String getXLData(String path,String sheet,int r,int c)
	{
		String value="";
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			value=w.getSheet(sheet).getRow(r).getCell(c).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	//To read data from JSON file.
	public static String getJSONData(String path,String fieldName,String getJsonObject)
	{
		String fieldValue = "" ;
		try
		{
			FileReader reader = new FileReader(path);
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(reader);
			JSONObject jsonobj = (JSONObject) obj;;
			JSONObject parent = (JSONObject) jsonobj.get(getJsonObject);
			
			fieldValue = (String)parent.get(fieldName);
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return fieldValue;
	}
	
	//To get the property value.
	public static String getPropertyValue(String path,String key)
	{
		String value="";
		try{
				Properties p=new Properties();
				p.load(new FileInputStream(path));
				value=p.getProperty(key);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return value;
	}
	
	//To write data into excel sheet.
	public static void writeResultToXL(String path,int passCount,int failCount)
	{
		try{
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			w.getSheet("Sheet1").getRow(1).getCell(0).setCellValue(passCount);
			w.getSheet("Sheet1").getRow(1).getCell(1).setCellValue(failCount);
			w.write(new FileOutputStream(path));
			w.close();
		}
		catch (Exception e) {
		}
	}
	
	/*public void click(By selector) {
		WebDriver driver = null;
        WebElement element = driver.findElement(selector);
        waitForElementToBeClickable(selector);
        try {
            element.click();
        } catch (Exception e) {
            throw new TestException(String.format("The following element is not clickable: [%s]", selector));
        }
    }*/

	public static String safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
		return null;
	}
}
