package runnuer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
//src/test/resources/features/login.feature
@CucumberOptions(
		//features = "@target/cucumber-reports/rerun.txt",
		features = "src/test/resources/features",
		glue = { "stepDef" }, 
		plugin = {"pretty", "rerun:target/failedScenarios/rerun.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
		
		monochrome = true, dryRun = false)

public class TestNGRunner2 {
	
	@BeforeClass
	public static void test() {
		System.out.println("Before all");
		
	}
	
	
	 @AfterClass 
	public static void after() 
	{    
		 String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 
		 String dest="Execution_"+timeStamp;
		 dest=dest.replace(" ","_").replace(":","_");
		 try {
			 FileUtils.moveDirectory(new File(System.getProperty("user.dir")+"//target//SparkReport//"),
					  new File(System.getProperty("user.dir")+"//target//"+"//Reports//"+dest));
		 }catch(IOException e){		 e.printStackTrace();}
	
	} 
	

}
