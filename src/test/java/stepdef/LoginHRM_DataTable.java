package stepdef;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginHRM_DataTable {
	@Given("the user is on login page")
	public void the_user_is_on_login_page() {
		
	}
	@When("the user enter the below credentials")
	public void the_user_enter_the_below_credentials(DataTable dataTable) {
		List<String> credential = dataTable.asList();
		String username = credential.get(0);
		String password = credential.get(1);
	}
	@When("the user click the login button")
	public void the_user_click_the_login_button() {
		
	}
}
