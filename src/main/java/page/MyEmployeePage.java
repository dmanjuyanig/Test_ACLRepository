package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebGeneric;

public class MyEmployeePage 
{
	private WebDriver driver;
	
	//***************************************************************************************
	@FindBy(xpath="//div[@id = \"menuheading\"]")
	private WebElement ManuHeading;
	
	@FindBy(xpath="//span[contains(text(),'Official')]")
	private WebElement OfficialTab;
	
	@FindBy(xpath="//span[contains(text(),'Personal')]")
	private WebElement PersonalTab;
	
	@FindBy(xpath="//span[contains(text(),'Banking')]")
	private WebElement BankingTab;
	
	@FindBy(xpath="//span[contains(text(),'Academic-Passport')]")
	private WebElement AcademicPassportTab;
	
	@FindBy(xpath="//span[contains(text(),'Skills-Certification')]")
	private WebElement SkillsCertificationTab;
	
	@FindBy(xpath="//span[contains(text(),'Leave History')]")
	private WebElement LeaveHistoryTab;
	
	@FindBy(xpath="//span[contains(text(),'Status History')]")
	private WebElement StatusHistoryTab;
	
	//***************************************************************************************
	public MyEmployeePage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
		//***************************************************************************************
	/*public String menuHeader()
	{
		return ManuHeading.getText();
	}*/
	public void VerifyOfficialTab()
	{
		WebGeneric.WebelementPresent(OfficialTab);
	}
	public void VerifyPersonalTab()
	{
		WebGeneric.WebelementPresent(PersonalTab);
	}
	public void ClickPersonalTab() throws InterruptedException
	{
		Thread.sleep(3000);
		PersonalTab.click();
		WebGeneric.WebelementPresent(PersonalTab);
	}
	public void VerifyBankingTab()
	{
		WebGeneric.WebelementPresent(BankingTab);
	}
	public void VerifyAcademicPassportTab()
	{
		WebGeneric.WebelementPresent(AcademicPassportTab);
	}
	public void VerifySkillsCertificationTab()
	{
		WebGeneric.WebelementPresent(SkillsCertificationTab);
	}
	public void VerifyLeaveHistoryTab()
	{
		WebGeneric.WebelementPresent(LeaveHistoryTab);
	}
	public void VerifyStatusHistoryTab()
	{
		WebGeneric.WebelementPresent(StatusHistoryTab);
	}
}
