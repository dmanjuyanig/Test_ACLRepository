package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebGeneric;

public class DashBoardPage 
{
	private WebDriver driver;

	//***************************************************************************************
	@FindBy(id="IMG1")
	private WebElement LogoutButton;
	
	@FindBy(id="IMG3")
	private WebElement HomeButton;
	
	@FindBy(id="Image2")
	private WebElement HomePageLogo;
	
	@FindBy(xpath="//img[@src = \"Images/home-mypage1.png\"]")
	private WebElement MyPageImage;
	
	@FindBy(xpath="//img[@src = \"Images/home-leave1.png\"]")
	private WebElement ApplyLeaveImage;
	
	@FindBy(xpath="//img[@src = \"Images/home-empse1.png\"]")
	private WebElement HolidayListImage;
	
	@FindBy(xpath="//img[@src = \"Images/home-timelive.png\"]")
	private WebElement PolicyDocumentImage;
	
	@FindBy(xpath="//img[@src = \"Images/home-iconnect1.png\"]")
	private WebElement EmployeeHandbookImage;
	
	@FindBy(xpath="//img[@src = \"Images/img-timelive.png\"]")
	private WebElement TimeLiveImage;
	
	@FindBy(xpath="//img[@src = \"Images/img-talent.png\"]")
	private WebElement TaleoImage;
	
	@FindBy(xpath="//img[@src = \"Images/img-quality.png\"]")
	private WebElement ualityManagementImage;
	
	//***************************************************************************************
	public DashBoardPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
	
	//***************************************************************************************
	public void VerifyLogoutButton()
	{
		WebGeneric.WebelementPresent(LogoutButton);
	}
	
	public void clickLogoutButton(long time)
		{
			WebGeneric.waitForVisibilityAndClick(driver, time, LogoutButton);		
		}
	
	public void VerifyHomeButton()
	{
		WebGeneric.WebelementPresent(HomeButton);
	}
	
	public void VerifyHomeLogo()
	{
		WebGeneric.WebelementPresent(HomePageLogo);
		System.out.println("Logo is displayed in homepage");
	}
	
	public void clickHomeButton(long time)
		{
			WebGeneric.waitForVisibilityAndClick(driver, time, HomeButton);		
		}
	public void clickMyPageImage(long time)
	{
		WebGeneric.waitForVisibilityAndClick(driver, time, MyPageImage);		
	}
	public void clickApplyLeaveImage(long time)
	{
		WebGeneric.waitForVisibilityAndClick(driver, time, ApplyLeaveImage);		
	}
	public void clickHolidayListImage(long time)
	{
		WebGeneric.waitForVisibilityAndClick(driver, time, HolidayListImage);		
	}
	public void clickPolicyDocumentImage(long time)
	{
		WebGeneric.waitForVisibilityAndClick(driver, time, PolicyDocumentImage);		
	}
	public void clickEmployeeHandbookImage(long time)
	{
		WebGeneric.waitForVisibilityAndClick(driver, time, EmployeeHandbookImage);		
	}
	public void clickTimeLiveImage(long time)
	{
		WebGeneric.waitForVisibilityAndClick(driver, time, TimeLiveImage);		
	}
	public void clickTaleoImage(long time)
	{
		WebGeneric.waitForVisibilityAndClick(driver, time, TaleoImage);		
	}
	public void clickualityManagementImage(long time)
	{
		WebGeneric.waitForVisibilityAndClick(driver, time, ualityManagementImage);		
	}
	//***************************************************************************************
}
