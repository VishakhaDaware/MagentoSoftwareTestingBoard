package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='panel header']//a[normalize-space()='Create an Account']")
	WebElement lnkCreateaccount;
	
	@FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement lnkSignIn;
	
	public void createAccount()
	{
		lnkCreateaccount.click();
	}

	
	public void signIn()
	{
		lnkSignIn.click();
	}
}
