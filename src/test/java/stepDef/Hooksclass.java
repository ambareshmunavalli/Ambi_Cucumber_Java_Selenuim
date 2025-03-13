package stepDef;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import stepDef.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooksclass {

	private WebDriver driver;
	private TestContext context;
	private Scenario scenario;

	/**
	 * Dependency Injection using Pico container
	 */
	public Hooksclass(TestContext context) {
		this.context = context;
		System.out.println("in hooks constructor");
		this.driver=context.getDriverInstance();
	}

	@Before
	public void startScenario(Scenario currScenario) {
		System.out.println("Thread id ="+Thread.currentThread().getId()+"scenario "+currScenario.getName());
		System.out.println("in hooks before tag");
		context.setScenario(currScenario);
		this.scenario=context.getScenario();
		scenario.log("Starting test scenario");		
}
	
		@After(order=0)
	 public void tearDown() throws InterruptedException{
		        driver.quit();
		        Thread.sleep(3000);
		       System.out.println("In Tear down method");
		   }
		
		@After(order=1)
		    public void takeScreenshot(Scenario scenario){
			
		        String screenShotName=scenario.getName().toUpperCase().replaceAll(" ","_");
		    byte[] srcLocation=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		    if(scenario.isFailed()) {
		        scenario.attach(srcLocation, "image/png", screenShotName);
		        System.out.println("SCREENSHOT TAKEN");
		        
		    }
		     
				
		if(!this.scenario.isFailed())
			System.out.println("Test Case : Passed");
		else 
			System.out.println("Test Case : Failed");
	}
	
}
