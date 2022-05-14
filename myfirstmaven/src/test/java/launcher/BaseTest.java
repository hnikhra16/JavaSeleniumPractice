package launcher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static Properties p;
	
	public static void init() throws Exception
	
	{
		
		FileInputStream fis =   new FileInputStream(projectPath+"/src/test/resources/data.properties");
		//Properties p = new Properties();
		p = new Properties();
		p.load(fis);
		

	}
	
	
	
	
	public static void launch(String browser)
	
	{
		
		if(p.getProperty(browser).equals("chrome"))
			
		{
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
				
		else if(p.getProperty(browser).equals("firefox"))
	
				{ WebDriverManager.firefoxdriver().setup();
	             driver = new FirefoxDriver();
	
	           }
	
	

}
	public static void navigateUrl(String url)
	
	{
	
		driver.navigate().to(p.getProperty(url));
		
	}
	
}