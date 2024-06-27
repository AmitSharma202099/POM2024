package open.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;

public class LoginPageTest  extends BaseTest{
	
	/*AAA Pattern
	 * 
	 * 1st create object of page class -> loginpage
	 * 2nd call Method  of pageclass -> getLoginPageTitle -> Method will return that will be actual value 
	 * 3rd Do the Assertion with actual vs expected value 
	 * 
	 */
	@Test(priority =1 )
	public void loginPageTitelTest() {
		
		String act_title = loginpage.getLoginPageTitle();
		Assert.assertEquals(act_title, AppConstants.LOGIN_PAGE_TITLE,AppError.TITLE_NOT_FOUND);
	}

	@Test(priority =2 )
		public void getLoginPageUrlTest() {
			String act_url = loginpage.getLoginPageUrl();
			Assert.assertTrue(act_url.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
		}
	
	@Test(priority = 3 )
	public void getForgetPwdLinkTest() {
		boolean b= loginpage.getForgetPwdLink();
		Assert.assertTrue(b,AppError.ElEMENT_NOT_FOUND);
	}
	
	
	@Test(priority = 4 )
	public void doLogin_Test() {
		//String actAccPageTitle = loginpage.doLogin("feb2024@gmail.com", "Selenium@12345");
		String actAccPageTitle = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));

		Assert.assertEquals(actAccPageTitle, AppConstants.ACCOUNT_PAGE_TITLE,AppError.TITLE_NOT_FOUND);
		
		
		
	}
}
