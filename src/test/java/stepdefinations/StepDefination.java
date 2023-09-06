package stepdefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AdminPage;
import utilities.ReadConfig;





public class StepDefination extends Base {
	
	
	@Before
	public void setUp() throws Exception {
		
		readConfig=new ReadConfig();
		System.out.println("Setup method executed");
		//driver=new ChromeDriver();
		
		String browser=readConfig.getBrowser();//browser=firefox
		
		if(browser.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(1000);
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("IE")) {
			driver=new InternetExplorerDriver();
		}
		
	}
	
	@Given("User Lanch Chrome Browser")
	public void user_lanch_chrome_browser() {
		driver=new ChromeDriver();
		ad=new AdminPage(driver);
	    
	}

	@When("User open url {string}")
	public void user_open_url(String url) throws Exception {
		driver.get(url);
		Thread.sleep(2000);
	    
	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) throws Exception {
		ad.SetUsername(email);
		ad.SetPassword(password);
	    
	}

	@When("User click on Login button")
	public void user_click_on_login_button() throws Exception {
		ad.clickOnLogin();
	    
	}
	
	@Then("User Verify page title should be {string}")
	public void user_verify_page_title_should_be(String title) {
		Assert.assertEquals(driver.getTitle(), title);
		System.out.println("Title verified successfully");
	    
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	    
	}
	
	@After
	public void tearDown(Scenario sc) throws Exception {
		
		System.out.println("Tear down method executed");
		
		if(sc.isFailed()==true) {
			
			String filewithPath="D:\\QE17_Softwares\\BAT_17_Workspace\\Bat17CucumberMavenProject\\screenshot\\failedScrenshot.png";
		
			//convert WebDriver object into TakeScreenshot
			
			TakesScreenshot scrShot=((TakesScreenshot)driver);
			
			//call getScreenshotAs to store image file
			
			File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
			
			File destFile=new File(filewithPath);
			
			try {
				FileUtils.copyFile(scrFile, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		Thread.sleep(2000);
		driver.quit();
	
	}

}
