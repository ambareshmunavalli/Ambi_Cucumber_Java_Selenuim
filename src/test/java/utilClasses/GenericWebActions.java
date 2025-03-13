package utilClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDef.TestContext;

public class GenericWebActions {
	
	
	TestContext context;   
	WebDriver driver;
	JavascriptExecutor js;
	Actions action;
	WebDriverWait wait;
	Select select;
	
	public GenericWebActions(TestContext testContext) {
		this.context=testContext;
		this.driver=context.getDriverInstance();
	        js=  (JavascriptExecutor)driver;
		action=new Actions(driver);
		 wait =new WebDriverWait(driver,Duration.ofSeconds(30));
		 
	}

	public void waitElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitPresenceOfElementLocated(By element) {
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}
	public void waitElementVisibilityOf(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void jsElementClick(WebElement element) {
		js.executeScript("argumens[0].click();", element);
		
	}
	
	public void jsScrollToViewTrue(WebElement element) {
		 js.executeScript("argumens[0].scrollIntoView(true);", element);
		
	}
	
	public void jsScrollToView(WebElement element) {
		js.executeScript("window.scrollBy(0, 250)", "");	}
	


    public void actionsClick(WebElement element) {
    	
    	action.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    	
    }
    
    public void actionsmoveToElement(WebElement element) {
    	action.moveToElement(element).build().perform();
    }
    
    public void contextClick(WebElement element) {
    	action.contextClick(element).build().perform();
    }
    
    
    public void selctByVisibleText(WebElement element,String text) {
    
    select =new Select(element);
    select.selectByVisibleText(text);
    }
    
    public void selctByValue(WebElement element,String value) {
        select =new Select(element);
        select.selectByValue(value);
        }
    
   public void selectByIndex(WebElement element,int value) {
        select =new Select(element);
        select.selectByIndex(value);
        }
   
  
}