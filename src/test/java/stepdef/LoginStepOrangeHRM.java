package stepdef;

import org.testng.Assert;

import com.baseclass.BaseClass;
import com.pageobjectmodel.Login_OpenHRM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepOrangeHRM extends BaseClass {
	Login_OpenHRM lp;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
		browserLanuch("edge");
		urlLaunch("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		implicitlyWait(30);
	}

	@When("the user enter thr vaild username and password")
	public void the_user_enter_thr_vaild_username_and_password() {
		lp=new Login_OpenHRM();
		lp.getUserName().sendKeys("Admin");
		lp.getPassword().sendKeys("admin123");
	}

	@When("user click the login button")
	public void user_click_the_login_button() {
		lp.getLoginButton().click();
	}

	@Then("the user should be navigated to home page")
	public void the_user_should_be_navigated_to_home_page() {
		boolean status = lp.gethomepage().isDisplayed();
	Assert.assertTrue(status);
	}
	
}
