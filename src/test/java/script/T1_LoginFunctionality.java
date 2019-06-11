package script;

import java.util.Set;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import generic.WebGeneric;
import page.DashBoardPage;
import page.ForgotPasswordPage;
import page.LoginPage;


public class T1_LoginFunctionality extends BaseTest
{
	@Test (description = "Verifying valid login functionality" , priority =1, groups = {"smoke"})
	public void TestCase_1_ValidLogin() throws InterruptedException
	{
		String un=Utility.getJSONData(DATA_JSONPATH,"username", "LoginDetails");
		String pw=Utility.getJSONData(DATA_JSONPATH,"password", "LoginDetails");
		
		LoginPage login=new LoginPage(driver);
		login.VerifyUserNameField();
		login.setUserName(un);
		login.VerifyPasswordField();
		login.setPassword(pw);
		login.VerifyLoginButton();
		login.clickLoginButton();
		Thread.sleep(3000);
		
		//verify that dashboard page is displayed.
		String homepageURL=Utility.getJSONData(DATA_JSONPATH,"homepage", "LoginDetails");
		WebGeneric.VerifyURL(driver, lngETO, homepageURL);
		
		DashBoardPage home = new DashBoardPage(driver);
		home.clickMyPageImage(lngETO);
		//click -> logout
		home.VerifyHomeLogo();
		home.VerifyLogoutButton();
		home.clickLogoutButton(lngETO);
		
		//verify that login page is displayed
		String loginpageURL=Utility.getJSONData(DATA_JSONPATH,"loginpage", "LoginDetails");
		WebGeneric.VerifyURL(driver, lngETO, loginpageURL);
		
	}
	
	@Test (description = "Verifying invalid login functionality" , priority =2, groups = {"smoke"})
	public void TestCase_2_InvalidLogin() throws InterruptedException
	{
		String un=Utility.getJSONData(DATA_JSONPATH,"invalidusername", "LoginDetails");
		String pw=Utility.getJSONData(DATA_JSONPATH,"invalidpassword", "LoginDetails");
		
		LoginPage login=new LoginPage(driver);
		login.setUserName(un);
		login.setPassword(pw);
		login.clickLoginButton();
		Thread.sleep(3000);
		
		//verify that login page is displayed
		String loginpageURL=Utility.getJSONData(DATA_JSONPATH,"loginpage", "LoginDetails");
		WebGeneric.VerifyURL(driver, lngETO, loginpageURL);
		
		String ActualText = "Username or password incorrect";
		String ExpectedText = login.getErrorMessage();
		System.out.println(ExpectedText);
		WebGeneric.verifyErrorMessage(ActualText, ExpectedText);
	}
	
	@Test (description = "Verifying invalid login functionality" , priority =3, groups = {"smoke"})
	public void TestCase_3_InvalidBlankLogin() throws InterruptedException
	{
		String un=Utility.getJSONData(DATA_JSONPATH,"blankusername", "LoginDetails");
		String pw=Utility.getJSONData(DATA_JSONPATH,"blankpassword", "LoginDetails");
		
		LoginPage login=new LoginPage(driver);
		login.setUserName(un);
		login.setPassword(pw);
		login.clickLoginButton();
		Thread.sleep(3000);
		
		//verify that login page is displayed
		String loginpageURL=Utility.getJSONData(DATA_JSONPATH,"loginpage", "LoginDetails");
		WebGeneric.VerifyURL(driver, lngETO, loginpageURL);
		
		String ActualText = "Username and password required";
		String ExpectedText = login.getErrorMessage();
		System.out.println(ExpectedText);
		WebGeneric.verifyErrorMessage(ActualText, ExpectedText);
	}
	
	@Test (description = "Verifying forgot password link functionality" , priority =4, groups = {"smoke"})
	public void TestCase_4_ForgotLinkVerify() throws InterruptedException
	{
		Thread.sleep(3000);
		LoginPage login=new LoginPage(driver);
		String parentTab = driver.getWindowHandle();
		System.out.println("WindowHandle of Parent tab : " +parentTab);
		login.clickForgotPasswordLink();
		
		Set<String> allTab = driver.getWindowHandles();
		System.out.println("WindowHandle of Parent and child tabs : " +allTab);
		for(String childTab:allTab)
		{
			if(!parentTab.equalsIgnoreCase(childTab))
			{
				driver.switchTo().window(childTab);
				Thread.sleep(3000);
				System.out.println("Child Tab Title " +driver.getTitle());
				String forgotpageURL=Utility.getJSONData(DATA_JSONPATH,"forgotpasswordpage", "LoginDetails");
				WebGeneric.VerifyURL(driver, lngETO, forgotpageURL);
				ForgotPasswordPage forgot = new ForgotPasswordPage(driver);
				String ActualText = "If you have forgotten your password, follow the prompts to reset your password.";
				String ExpectedText = forgot.headerMessage();
				System.out.println(ExpectedText);
				WebGeneric.verifyErrorMessage(ActualText, ExpectedText);
				driver.close();
			}
			//driver.switchTo().defaultContent();
			//System.out.println("Parent Tab Title " +driver.getTitle());
		}
	}
}
