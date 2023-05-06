package org.stepdefinition;

import java.util.List;
import java.util.Map;
import org.baseclass.Baseclass;
import org.drakes.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;

public class LoginSteps extends Baseclass {

    //static WebDriver driver;
    LoginPage l;
	@Given("The user should be drakes login page")
	public void the_user_should_be_drakes_login_page() {
		chromeBrowser();
		urlLaunch("https://us.drakes.com/");
		implicitlyWait(10);
		maximize();	
		}
	@When("The user should fill the username {string}  and password {string}")
	public void the_user_should_fill_the_username_and_password(String user, String pass) {
		click(l.getSignInBtn());
		sendKeys(l.getUserName(), user);
		sendKeys(l.getPassword(), pass);
	}
	@When("The user should click the login button")
	public void the_user_should_click_the_login_button() {
		click(l.getLoginBtn());
	}
	@Then("The user should be navigate to invalid login page")
	public void the_user_should_be_navigate_to_invalid_login_page() {
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.urlContains("login"));
	  Assert.assertTrue("verify url",driver.getCurrentUrl().contains("login"));
	  System.out.println("User in invalid page");
	 }
	}

