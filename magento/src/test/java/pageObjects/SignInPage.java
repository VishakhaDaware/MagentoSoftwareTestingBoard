package pageObjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{
	
	//WebDriver driver;

	public SignInPage(WebDriver driver) 
	{
		super(driver);
	}
		

	
	@FindBy(xpath = "//input[@id='email']")
	WebElement setEmail;
	
	@FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
	WebElement setPassword;
	
	@FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	WebElement clkSignIn;
	
	@FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in'][contains(text(), 'Welcome')]")
	WebElement ConfirmLogin;
	
	
	public void setEmail(String email) 
	{
		setEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd) 
	{
		setPassword.sendKeys(pwd);
	}
	
	public void clkSignIn() 
	{
		clkSignIn.click();
	}
	
	
	public String ConfirmLogin() 
	{
		try 
		{
			return (ConfirmLogin.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}

}
