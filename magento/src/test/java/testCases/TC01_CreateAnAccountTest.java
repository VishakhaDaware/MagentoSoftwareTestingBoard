package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CreateAnAccountPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_CreateAnAccountTest extends BaseClass{
  
	
	
	@Test
  public void verify_account_registration() 
	{
		logger.info("*******Starting TC01_CreateAnAccountTest*********");
		
		HomePage hp=new HomePage(driver);
		hp.createAccount();
		logger.info("Clicked on Create An Account page");
		
		CreateAnAccountPage regpage=new CreateAnAccountPage(driver);
		regpage.setFirstName("jbl");
		regpage.setLastName("jbl");
		regpage.setEmail("jbl15@gmail.com");
		
		// Get the email entered from the input field and validate its format
        String enteredEmail = regpage.setEmail.getAttribute("value");
        if (!regpage.isValidEmail(enteredEmail)) {
            logger.error("Invalid email format entered: " + enteredEmail);
            Assert.fail("Invalid email format");
            return; // Stop the test execution if email format is invalid
        }
		
		regpage.setPassword("No Password");
		regpage.setConfirmPassword("No Password");
		regpage.clickCreateAcc();
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Thank you for registering with Main Website Store.");
		
		logger.info("Account created successfully");	
  }
	
	/*public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}*/
}
