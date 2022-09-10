package stepdef;

import com.baseclass.BaseClass;
import com.pageobjectmodel.Amazon_Data_SignIn;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Amazon_Login_Data_Step_Def extends BaseClass {
	Amazon_Data_SignIn a;

	@Given("user navigates to Amazon")
	public void user_navigates_to_amazon() {

		browserLanuch("edge");
		urlLaunch("https://www.amazon.in/");
		implicitlyWait(60);
	}

	@Given("user click the sign in button for Sign Page")
	public void user_click_the_sign_in_button_for_sign_page() {
		a = new Amazon_Data_SignIn();
		clickJavaScript( a.getSignInButtonClick());
	}

	@When("user entering email {string}")
	public void user_entering_email(String username) {
		a.getEmail().sendKeys(username);
	}

	@When("user click the continue button")
	public void user_click_the_continue_button() {
		a.getContinueButton().click();
	}

	@When("user entering passwod {string}")
	public void user_entering_passwod(String password) {
		a.getPassword().sendKeys(password);
	}

	@When("user click the Sign in button")
	public void user_click_the_sign_in_button() {
		
		a.getSignInButton().click();
	}

	@Then("user close the browser")
	public void user_close_the_browser() {
	}
}
