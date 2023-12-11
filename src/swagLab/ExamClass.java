package swagLab;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExamClass {

	WebDriver driver = new ChromeDriver();
	String LogoutPage="https://magento.softwaretestingboard.com/customer/account/logout/";
	String Login="https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
	String UserPassword= "ASDasd123!";
	
	String [] firstNames={"ahmad","mohammad","omar"};
	String [] lastNames = {"anas","ali","mahmoud"};
	
	Random rand = new Random();
	int randomIndex=rand.nextInt(3);
	int randomEmailID=rand.nextInt(9999);
	String UserFirstName= firstNames[randomIndex];
	String UserLastName= lastNames[randomIndex];
	String email_Address =UserFirstName+UserLastName+randomEmailID+"@gmail.com";
	
	
	@BeforeTest
	public void SetUp() {
		
		driver.get("https://magento.softwaretestingboard.com/");
WebElement SignUpButton= driver.findElement(By.linkText("Create an Account"));

SignUpButton.click();
	}
	
	@Test(priority=1)
	public void SignUp() throws InterruptedException {
		
		WebElement FirstName=driver.findElement(By.id("firstname"));
				WebElement LastName=driver.findElement(By.id("lastname"));
				WebElement Email=driver.findElement(By.id("email_address"));
				WebElement Password=driver.findElement(By.id("password"));
				WebElement  PasswordConfirm=driver.findElement(By.id("password-confirmation"));
				WebElement ButtonCreateAccount= driver.findElement(By.xpath("//button[@title='Create an Account']"));
				FirstName.sendKeys(UserFirstName);
				LastName.sendKeys(UserLastName);
				Email.sendKeys(email_Address);
				Password.sendKeys(UserPassword);
				PasswordConfirm.sendKeys(UserPassword);
				ButtonCreateAccount.click();
				
				Thread.sleep(3000);
				WebElement SuccessMsg=driver.findElement(By.className("message-success"));
				Assert.assertEquals(SuccessMsg.getText(), "Thank you for registering with Main Website Store.");
				
	}
	@Test(priority=2 , enabled=false)
	public void logoutTest() {
		driver.get(LogoutPage);
		

	}
	
	@Test(priority=3, enabled=false)
	public void Login() throws InterruptedException {
		driver.get(Login);
		WebElement EmailLogin=driver.findElement(By.id("email"));
		WebElement PassLogin=driver.findElement(By.id("pass"));
		WebElement ButtonLog=driver.findElement(By.id("send2"));
		
		EmailLogin.sendKeys(email_Address);
		PassLogin.sendKeys(UserPassword);
		ButtonLog.click();
		Thread.sleep(2000);
		WebElement WelcomeMsg= driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span"));
		
		Assert.assertEquals(WelcomeMsg.getText().contains("Welcome"),true,"this is to check the welcomemsg");
		
	}
	
	@AfterTest
	public void EndTest() {}
	
	
	
}
