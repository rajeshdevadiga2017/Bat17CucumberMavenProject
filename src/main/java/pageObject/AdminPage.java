package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
public WebDriver ldriver;
	
	

	// java project we can use below statement to store web element
	// WebElement txtEmail1=driver.findElement(By.xpath("//input[@id='Email']"));

	public AdminPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}

	// maven project we can use below statement to store web element
	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement btnLogin;

	// user defined method to perform operation on above web element

	public void SetUsername(String uname) throws Exception {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
		Thread.sleep(2000);
	}

	public void SetPassword(String pwd) throws Exception {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
		Thread.sleep(2000);
	}

	public void clickOnLogin() throws Exception {
		btnLogin.click();
		Thread.sleep(2000);
	}

}
