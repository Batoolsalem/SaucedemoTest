import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SauceDemoTest{

	WebDriver driver = new EdgeDriver();
    String URL = "https://www.saucedemo.com/";

    @BeforeTest
	public void Setup(){
	    driver.get(URL);
	    driver.manage().window().maximize();
	}

    // Login with standard user account
	@Test(priority = 1)
	public void Login(){
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();	
	}

    // Add All items to cart
	@Test(priority = 2)
	public void AddRandomlyItems() {
		List<WebElement>addall=driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
	    for(int i=0;i<addall.size();i++) {
		addall.get(i).click();}

	    WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
	    System.out.println("Items added to cart: " + cartBadge.getText());
	}

    //  checkout and confirm 
	@Test(priority = 3)
	public void Checkout() throws InterruptedException {
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("checkout")).click();

		driver.findElement(By.id("first-name")).sendKeys("Batool");
	    driver.findElement(By.id("last-name")).sendKeys("Salem");
	    driver.findElement(By.id("postal-code")).sendKeys("1234");
	    driver.findElement(By.id("continue")).click();
	    Thread.sleep(1000);

	    driver.findElement(By.id("finish")).click();
	    Thread.sleep(2000);

	}
	
}