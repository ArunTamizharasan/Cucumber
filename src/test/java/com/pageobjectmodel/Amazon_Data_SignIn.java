package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.baseclass.BaseClass;

public class Amazon_Data_SignIn extends BaseClass {
	
	@FindBy(xpath = "//span[@class='nav-action-inner']")
	private WebElement signInButtonClick;

	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//div[@class='a-section']//input[@id='ap_password']")
	private WebElement password;

	@FindBy(xpath = "//div[@class='a-section']//child::input[@id='signInSubmit']")
	private WebElement signInButton;

	public Amazon_Data_SignIn() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSignInButtonClick() {
		return signInButtonClick;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}
}
