package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import stepDef.TestContext;
import utilClasses.GenericWebActions;

public class loginPage {

	TestContext context;   
	WebDriver driver;
	GenericWebActions objGenWebActions;
	
	
	public loginPage(TestContext testContext) {
		this.context=testContext;
		this.driver=context.getDriverInstance();
		this.objGenWebActions=context.getGenericWebActions();
		System.out.println("within login page constructor");
		
	}
	
	By SignInfromNav =By.xpath("//div[@id='nav-tools']/a[@data-nav-role='signin']");
	By SignInfromNav1 = By.id("nav-link-accountList-nav-line-1");
	 By Xpath_userName =By.id("ap_email");
	 By Xpath_login_Continue_Btn =By.id("continue");
	 By Xptah_login_Password=By.id("ap_password");
	 
	
	
	
	public void lauchApp(String url) {
		context.getDriverInstance().get(url);
		
	}
	
	public void clickSignInButton(){
		//Actions builder = new Actions(driver);
		WebElement btn_SignInfromNav=driver.findElement(SignInfromNav1);
		objGenWebActions.actionsClick(btn_SignInfromNav);
	}
	
	public void iVerifyInSignPage(){
		objGenWebActions.waitElementVisibilityOf(driver.findElement(Xpath_userName));
	boolean val=	driver.findElement(Xpath_userName).isDisplayed();
	Assert.assertTrue("Sign is page is not displayed",val);
	
	}

	public void enterUserName(String UName) {
		
		driver.findElement(Xpath_userName).sendKeys(UName);
	}

	public void clickOnLoginContinueBtn() {
		driver.findElement(Xpath_login_Continue_Btn).click();
		
	}

	public void enterUserPassword(String pswrd) {
		driver.findElement(Xptah_login_Password).sendKeys(pswrd);;
	}
}
