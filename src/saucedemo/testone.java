package saucedemo;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class testone {
	WebDriver driver=new EdgeDriver();
	 String mywebsite="https://www.saucedemo.com/";
	 String username="standard_user";
	 String password="secret_sauce";
	 
	@BeforeTest
	public void mysetup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
		
	@Test (priority = 1,invocationCount   = 3)
	public void addandremov() throws InterruptedException {
		driver.get(mywebsite);
		driver.manage().window().maximize();
		login();
		addcart();
		remove();	

	}
	
	public void login() {
	driver.findElement(By.id("user-name")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);;
	driver.findElement(By.id("login-button")).click();

	}
	
	public void addcart() throws InterruptedException {
		
//		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
//		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

		//add all cart
	List<WebElement>addall=driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
    for(int i=0;i<addall.size();i++) {
	addall.get(i).click();}}
	
public void remove() {
		
		List<WebElement>addall=driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory"));
	    for(int i=0;i<addall.size();i++) {
		addall.get(i).click();}
		
	}
	
	@Test(priority = 2)
	public void cart() {
		
		driver.navigate().to("https://www.saucedemo.com/cart.html");
//driver.findElement(By.className("shopping_cart_badge")).click();
driver.findElement(By.id("checkout")).click();


}
	@Test(priority = 3)
public void myinformatio() {
		
		driver.findElement(By.id("first-name")).sendKeys("Batool");
		driver.findElement(By.id("last-name")).sendKeys("Abualghanam");
		driver.findElement(By.id("postal-code")).sendKeys("123");
		driver.findElement(By.id("continue")).click();

//		Thread.sleep(3000);
		driver.findElement(By.id("finish")).click();

	}
	

	
	@AfterTest
	
	public void aftermytest() {
		

		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
