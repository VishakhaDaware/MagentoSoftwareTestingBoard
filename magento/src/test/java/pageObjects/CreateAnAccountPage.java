package pageObjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPage extends BasePage{

	WebDriver driver;

	public CreateAnAccountPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement setFirstName;

	@FindBy(xpath = "//input[@id='lastname']")
	WebElement setLastName;

	@FindBy(xpath = "//input[@id='email_address']")
	public
	WebElement setEmail;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement setPassword;
	
	@FindBy(xpath = "//input[@id='password-confirmation']")
	WebElement setConfirmPassword;
	
	@FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
	WebElement btnCreateAcc;

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement msgConfirmation;
	
	
	
	public void setFirstName(String fname) 
	{
		setFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) 
	{
		setLastName.sendKeys(lname);
	}

	public void setEmail(String email) 
	{
		setEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd) 
	{
		setPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) 
	{
		setConfirmPassword.sendKeys(pwd);
	}
	
	public void clickCreateAcc() {
		btnCreateAcc.submit();
	}

	public String getConfirmationMsg() 
	{
		try 
		{
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}
	
	// Method to validate email format using regular expression
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
