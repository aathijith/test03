package Maven.zdn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends BaseTest {
	
	
	@Test(testName = "signUpTest",groups={"smoke"})
	public void signUpTest()throws IOException {
		driver.get("https://the-internet.herokuapp.com/");
		sleep(3000);
		
		File file=new File("C:\\Users/amrut/eclipse-workspace/zdn/src/test/java/Maven/zdn/obj_log.properties");
		FileInputStream fis=new  FileInputStream(file);
		Properties obj=new Properties();
		obj.load(fis);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[18]/a")).click();
		sleep(3000);
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='file-submit']")).isDisplayed());
		sleep(3000);
		
		
		
		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users/amrut/Downloads/kick.png");
		
		sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(0));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/h3")));
		driver.get("https://the-internet.herokuapp.com/");
		sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[24]/a")).click();
		sleep(3000);
		WebElement slider=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/input"));
		for(int i=1;i<=7;i++) {
			slider.sendKeys(Keys.ARROW_RIGHT);
		}
		sleep(5000);
		
	}
	
	@Test(testName="logInTest",groups={"smoke"})
	public void logInTest() {
		driver.get("https://the-internet.herokuapp.com/");
		sleep(3000);
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		sleep(6000);
		
	}
	@Test(testName="frameTest",groups= {"sanity"})
	public void frameTest() {
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[22]/a")).click();
		sleep(3000);
		String actualTitle=driver.getTitle();
		String expectedTitle="The Internet";
		Assert.assertEquals(actualTitle, expectedTitle,"Title not matching");
		sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/a")).click();
		sleep(1500);
		driver.switchTo().frame("mce_0_ifr");
		sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"tinymce\"]")).sendKeys("HI Amruth. Athira is Waiting !!!");
		sleep(5000);
		
		
	}
	
	
	public void sleep(long m) {
		try {
			Thread.sleep(m);
		}catch (InterruptedException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
