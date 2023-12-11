package swagLab;

import java.time.Duration;
import java.util.List;

import org.apache.commons.compress.harmony.pack200.IntList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {

	String myWebSite="https://www.saucedemo.com/";
	String UserNmae="standard_user";
	String Password="secret_sauce";
	WebDriver driver =new ChromeDriver();
	
	@BeforeTest
	public void setUp() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().window().maximize();
		driver.get(myWebSite);
	}

	@Test(priority=1)
	public void loginTest() {
		WebElement UserNameInput= driver.findElement(By.id("user-name"));
		WebElement PasswordInput=driver.findElement(By.id("password"));
		WebElement LoginButton= driver.findElement(By.id("login-button"));
		
		UserNameInput.sendKeys(UserNmae);
		PasswordInput.sendKeys(Password);
		LoginButton.click();
	}
	
	@Test(priority=2)
	public void PrintItem () {
	
		WebElement Item=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
		 String ItemText=Item.getText();
		System.out.println(ItemText);
	
	}
	
	@Test(priority=3)
	public void PrintAllItem() {
	List<WebElement> allitems= driver.findElements(By.className("inventory_item_name"));
	
	for(int i = 0 ; i < allitems.size();i++) {
		System.out.println(allitems.get(i).getText());
	}
	}
	
	@AfterTest
	public void AfterMyTest() {
	}
}
