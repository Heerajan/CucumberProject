package org.drakes.pages;

import org.baseclass.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Baseclass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Continue']")
	private WebElement countrySelection;
	
	@FindBy(xpath="(//li[@class='display@md'])[2]/div/span")
	private WebElement signInBtn;
	
	@FindBy(xpath="(//input[@type='email'])[1]")
	private WebElement userName;
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	private WebElement password;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	private WebElement loginBtn;
	
	public WebElement getCountrySelection() {
		return countrySelection;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	

}
