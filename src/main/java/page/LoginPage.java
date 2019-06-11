package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebGeneric;

public class LoginPage 
{
	private WebDriver driver;
	
	//***************************************************************************************
	@FindBy(id="txtLoginID")
	private WebElement UsernamTextField;
	
	@FindBy(id="txtpassword1")
	private WebElement PasswordTextField;
	
	@FindBy(id="imgbtnloginsso")
	private WebElement LoginButton;
	
	/*@FindBy(id="imgbtnloginsso")
	public WebElement LoginButton;*/
	
	@FindBy(id="imgbtnCancel")
	private WebElement CancelButton;
	
	@FindBy(id="lnkbtnForgotPwd")
	private WebElement ForgotPasswordLink;
	
	@FindBy(id="lblError")
	private WebElement ErrorMessage;

	//***************************************************************************************
	public LoginPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
		//***************************************************************************************
	public void setUserName(String un) throws InterruptedException
		{
			UsernamTextField.sendKeys(un);
		}
	
	public void setPassword(String pw)
		{
		PasswordTextField.sendKeys(pw);
		}
	
	public void clickLoginButton()	
		{
			LoginButton.click();
		}
	public void clickCancelButton()
		{
			CancelButton.click();
		}
	public void clickForgotPasswordLink()
	{
		ForgotPasswordLink.click();
	}
	
	public String getErrorMessage()
	{
		return ErrorMessage.getText();
	}

	//***************************************************************************************
	
	public void VerifyUserNameField()
	{
		WebGeneric.WebelementPresent(UsernamTextField);
	}
	
	public void VerifyPasswordField()
	{
		WebGeneric.WebelementPresent(PasswordTextField);
	}
	
	public void VerifyLoginButton()
	{
		WebGeneric.WebelementPresent(LoginButton);
	}
	
	public void VerifyCancelButton()
	{
		WebGeneric.WebelementPresent(CancelButton);
	}
	
//***************************************************************************************
	
	/*public void VerifyUserNameField(long time)
	{
		WenGeneric.waitForVisibilityAndClick(driver, time, unTB);		
	}
	
	public void VerifyPasswordField(long time)
	{
		WenGeneric.waitForVisibilityAndClick(driver, time, pwTB);		
	}
	
	public void VerifyLoginButton(long time)
	{
		WenGeneric.waitForVisibilityAndClick(driver, time, loginBTN);		
	}*/
}
