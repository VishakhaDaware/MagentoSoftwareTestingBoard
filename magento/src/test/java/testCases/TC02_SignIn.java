package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CreateAnAccountPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import testBase.BaseClass;

public class TC02_SignIn extends BaseClass{
  
	
	@Test
  public void verify_sign_in() {
        logger.info("*******Starting TC02_SignIn*********");
		
		HomePage hp1=new HomePage(driver);
		hp1.signIn();
		logger.info("Clicked on sign-in page");
		
		SignInPage regpage1=new SignInPage(driver); 
		regpage1.setEmail(p.getProperty("username"));
		regpage1.setPassword(p.getProperty("password"));
		regpage1.clkSignIn();
		
		String confmsg=regpage1.ConfirmLogin();
		logger.info("confmsg: " + confmsg);
		if(confmsg.contains("Welcome"))
		{
			logger.info("login successful.");
		}
		else
		{
			Assert.fail();
		}
		
	  
  }
}
