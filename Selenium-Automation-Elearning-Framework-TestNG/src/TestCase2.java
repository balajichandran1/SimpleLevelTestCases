import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BALAJICHANDRAN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		// Launching new browser
		WebDriver driver =new ChromeDriver();
		// Maximizing the window
		driver.manage().window().maximize();
		// Navigating to the desired url
		driver.navigate().to("http://uniformm1.upskills.in/");
		Thread.sleep(3000);
		// Finding the element Regular T shirts Rust
		WebElement link = driver.findElement(By.linkText("REGULAR T-SHIRTS (Rust)"));
		Actions Act = new Actions(driver);
		Action mouseover = Act.moveToElement(link).build();
		mouseover.perform();
		//Clicking on Regular T-Shirts Rust option
		Act.sendKeys(link,(Keys.RETURN)).perform();
		// click on the chext size
		driver.findElement(By.id("input-option376")).click();
		//driver.findElement(By.id(id))
		Select dropdown = new Select(driver.findElement(By.id("input-option376")));
		dropdown.selectByIndex(11);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-lg btn-block']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='cart']/ul/li[2]/div/p/a[1]")).click();
			
		
	}

}
