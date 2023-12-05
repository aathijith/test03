package Maven.zdn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public static WebDriver driver;
	
	
	@Parameters("browserName")
	@BeforeTest
	public void setup(@Optional("chrome")String browserName){
		switch(browserName.toLowerCase()) {
		case"chrome":
			driver=new ChromeDriver();
			break;

		case"edge":
			driver=new EdgeDriver();
			break;
		case"firefox":
			driver=new FirefoxDriver();
			break;
		default:
			System.out.println("invalid browser");
			break;

		}
		driver.manage().window().maximize();
			driver.manage().deleteAllCookies();		
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
