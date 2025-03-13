package stepDef;

import java.util.Scanner;

import io.cucumber.java.en.*;
import pages.loginPage;
import utilClasses.GenericWebActions;

public class LoginSteps {
	TestContext context;
	loginPage objloginPage;
	
	public LoginSteps(TestContext testContext) {
		this.context=testContext;
		System.out.println("within text login step before creating login page obj");
		objloginPage=context.getloginPage();
		System.out.println("within text login step");   
	}
	

	@Given("I am on the Login page URL {string}")
	public void i_am_on_the_login_page_url(String url) {
		objloginPage.lauchApp(url);
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter some number to after captha resolved");
		//scan.next();	
	}
	
	@Then("^I click on sign in button and wait for sign in page$")
	public void i_click_on_sign_in_button_and_wait_for_sign_in_page() throws Throwable {
		objloginPage.clickSignInButton();
	//#waitHelper.WaitForElement(loginPage.userName, 60);
	}

	@Then("^I should see Sign In Page$")
	public void i_should_see_Sign_In_Page() throws Throwable {
		objloginPage.iVerifyInSignPage();
	}
	
	@When("I enter username as {string}")
	public void i_enter_username_as(String UName) {
		objloginPage.enterUserName(UName);  
	}
	
	@When("I Click on Continue button")
	public void i_click_on_continue_button() {
		objloginPage.clickOnLoginContinueBtn();
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String pswrd) {
		objloginPage.enterUserPassword(pswrd);
		
	}


	
}
