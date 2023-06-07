package week6.day1.LeafAssignment;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class SpecificMethod {
	public String fileName;

	 public RemoteWebDriver driver;
	    @Parameters({"Browser","url","username","password"})
	    @BeforeMethod
	    public void preCondition(String Browser,String url,String uname,String pwd) {
	    	if (Browser.equalsIgnoreCase("chrome")) {
				driver =new ChromeDriver();
			}
	    	else if (Browser.equalsIgnoreCase("edge")) {
	    		driver =new EdgeDriver();
			} 
	    	
	    	
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get(url);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.findElement(By.id("username")).sendKeys(uname);
	        driver.findElement(By.id("password")).sendKeys(pwd);
	        driver.findElement(By.className("decorativeSubmit")).click();
	        driver.findElement(By.linkText("CRM/SFA")).click();
	        driver.findElement(By.linkText("Leads")).click();
	        
	    }
	    

        @DataProvider
        public String[][] testData() throws IOException {
        	String[][] readData = CreateLead.readData(fileName);
			return readData;
        }
	    @AfterMethod
	    public void postCondition() {
	        driver.close();
	    }
}
