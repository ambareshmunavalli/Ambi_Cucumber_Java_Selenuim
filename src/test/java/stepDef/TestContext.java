package stepDef;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cucumberFramework.enums.Browsers;
import com.cucumberFramework.enums.OS;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.loginPage;
import utilClasses.GenericWebActions;
import utilities.ConfigProvider;

public class TestContext {
	public static  ThreadLocal<WebDriver> driver= new ThreadLocal<>();
	Hooksclass objHooks;
	//LoginSteps objLoginSteps;
	loginPage objloginPage;
	GenericWebActions objGenWebActions;
	public Scenario scenario;

	public TestContext() {
	System.out.println("within text context constructor start");
	getDriver();
	objGenWebActions=new GenericWebActions(this);
	objloginPage= new loginPage(this);
	objHooks = new Hooksclass(this);
	objGenWebActions=new GenericWebActions(this);
	System.out.println("within text context constructor end");
}

Hooksclass getHooksclass() {
	return objHooks;
}


loginPage getloginPage() {
 	return objloginPage;
}

public GenericWebActions getGenericWebActions() {
 	return objGenWebActions;
}

public  WebDriver getDriverInstance(){
    return  driver.get();
}

public WebDriver getDriver() {
	Properties propFile=ConfigProvider.readPropertiesFile("src\\test\\resources\\configuration.properties");
			return selectBrowser(propFile.getProperty("browser"));	
}

public void setScenario(Scenario scenarioobj) {
	scenario=scenarioobj;
	
}
public Scenario getScenario(){
	return scenario;
	
}
public WebDriver selectBrowser(String browser) {
	WebDriver driver = null;
	
	if (System.getProperty("os.name").toLowerCase().contains(OS.WINDOW.name().toLowerCase())) {
		if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	} else if (System.getProperty("os.name").toLowerCase().contains(OS.MAC.name().toLowerCase())) {
		if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver");
			driver = new FirefoxDriver();
		}
	}
	TestContext.driver.set(driver);
	return driver;
}

}
