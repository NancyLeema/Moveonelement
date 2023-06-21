package seliniumproject4;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Mousehover {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Actions builder=new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"))).perform();
		File firstSrc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("./Snap/img.png");
		FileHandler.copy(firstSrc, dest);
		builder.doubleClick( driver.findElement(By.linkText("Video Purchases & Rentals"))).perform();
		File secondSrc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target=new File("./Snap/img1.png");
		FileHandler.copy(secondSrc, target);
		Thread.sleep(7000);
		
		builder.contextClick(driver.findElement(By.id("continue"))).perform();
		
		
		// TODO Auto-generated method stub
	}

}
