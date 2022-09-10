package stepdef;

import com.baseclass.BaseClass;
import com.pageobjectmodel.Amazon_SignIn_Click;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Amazon_StepDefinition extends BaseClass{
	Amazon_SignIn_Click a=new Amazon_SignIn_Click();

	
	@Given("the user navigates to Amazon")
	public void the_user_navigates_to_amazon() {
		browserLanuch("edge");
		urlLaunch("https://www.amazon.in/");
		implicitlyWait(60);
	}

	@Given("the user click the sign in button for Sign Page")
	public void the_user_click_the_sign_in_button_for_sign_page() {
			
	
		clickJavaScript(a.getSignInButtonClick());
	}

	@When("the user entering email")
	public void the_user_entering_email() {
		a.getEmail().sendKeys("arun.engineer92@gmail.com");
	}

	@When("the user click the continue button")
	public void the_user_click_the_continue_button() {
		a.getContinueButton().click();
	}

	@When("the user entering passwod")
	public void the_user_entering_passwod() {
		a.getPassword().sendKeys("Good_Start_7");
	}

	@When("the user click the Sign in button")
	public void the_user_click_the_sign_in_button() {
		a.getSignInButton().click();
	}

	@Then("the user close the browser")
	public void the_user_close_the_browser() {
	driver.close();
	}

}
