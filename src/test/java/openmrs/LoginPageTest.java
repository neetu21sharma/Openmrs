package openmrs;

import java.io.IOException;

import org.bouncycastle.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
	
	@Test(priority = 1)
	
	public void testLoginFunction() throws IOException
	{
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertTrue(loginPageTitle.contains("Login"));
	    
	}

}
