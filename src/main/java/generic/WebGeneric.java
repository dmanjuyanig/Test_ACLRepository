package generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WebGeneric 
{
	//This method is used to check the visibility of element and click the element.
	public static void waitForVisibilityAndClick(WebDriver driver, long time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		
		//Adding try-catch to avoid exception in framework and included assert.fail to fail the script if element is not visible.
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is Visible" , true);
		}
		catch (Exception e)
		{
			Reporter.log("Element is NOT Visible" , true);
		}
		
		element.click();
	}
	
	//This method id used to compare the actual and expected URLs
	public static void VerifyURL(WebDriver driver, long time, String partialURL)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		try
		{
			wait.until(ExpectedConditions.urlContains(partialURL));
			Reporter.log("Required page is displayed" , true);
		}
		catch (Exception e)
		{
			Reporter.log("Required page is NOT displayed" , true);
		}
	}
	
	//This method is used to verify the presence of the element
	/*public static void WebelementPresent(WebElement element) 
	{
			boolean actual = element.isDisplayed();
			boolean expected = true;
			
			if(expected=actual)
			{ 
			Reporter.log("Element is present-- PASS ",true);
			}
			else
			{
			 Reporter.log("Element is not present-- PASS ",true);
			}*/
	
	/*
	 * 
	 * Modification done by kruthi, if working fine utilize this or else above module for element displayed
	 */
	public static void WebelementPresent(WebElement element) {
		try {
			element.isDisplayed();

			Reporter.log("Element is present-- PASS ", true);
		} 
		catch (Exception e) {
			Reporter.log("Element is not present-- PASS ", true);
		}

	}

	public static void VerifyText(WebElement element, String actualErrorMessage, String expectedErrorMessage)
	{
		try
		{
			if(actualErrorMessage.equals(expectedErrorMessage))
			Reporter.log("error message is matching" +actualErrorMessage);
			
		}
		catch (Exception e) {

			Reporter.log("error message is not matching with " +actualErrorMessage +  "error message should be " +expectedErrorMessage );
		}
	}
	
	//This method is used to compare the displayed text with actual text
	public static void verifyErrorMessage(String actualErrorMessage, String expectedErrorMessage)
	{
		try
		{
			if(actualErrorMessage.equals(expectedErrorMessage))
			Reporter.log("error message is matching" +actualErrorMessage);
			
		}
		catch (Exception e) {

			Reporter.log("error message is not matching with " +actualErrorMessage +  "error message should be " +expectedErrorMessage );
		}
	}
	
	/*public static void click_The_Element(WebElement element) {
		try {
            if (element.isDisplayed()) {
               System.out.println("Element: " + element + "is already displayed");
            } else {
            	// Click the element
                element.click();
            }
        } catch (Exception e) {
        	System.out.println("Unable to click the element: " + element);
        }
		
	}*/
	
	
}
		
		

