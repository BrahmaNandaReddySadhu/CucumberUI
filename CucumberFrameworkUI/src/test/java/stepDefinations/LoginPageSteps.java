package stepDefinations;

import org.junit.Assert;

import com.Factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.*;

public class LoginPageSteps {
	
	private static String title;
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getWebdriver());
	
	@Given("user is on Login page")
	public void user_is_on_login_page() {
	   
		DriverFactory.getWebdriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user get the titleof the page")
	public void user_get_the_titleof_the_page() {
	   title=loginPage.getLoginPageTitle();
	   System.out.println("Title of the Page -->"+title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expected) {
		String title=loginPage.getLoginPageTitle();
		System.out.println("Login Page Title is ->"+title);
		Assert.assertTrue(title.contains(expected));
	}

	

	@Then("forgot your password link should display")
	public void forgot_your_password_link_should_display() {
	    Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}

	@When("user enter the username {string}")
	public void user_enter_the_username(String userName) {
	   loginPage.enterUsername(userName);
	}

	@When("user enter the password {string}")
	public void user_enter_the_password(String password) {
	  loginPage.enterPassword(password);
	}

	@When("user click on the login button")
	public void user_click_on_the_login_button() {
	   loginPage.clickOnLoginButton();
	}



}
