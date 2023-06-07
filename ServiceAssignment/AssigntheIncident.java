package week6.day1.ServiceAssignment;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AssigntheIncident extends ServiceNowBaseClass{
	@BeforeTest
	public void setData() {
		fileName="AssignIncedentService";
	}
	
@Test(dataProvider="testData")
	public void runAssigntheIncident(String input) throws InterruptedException {
			
		
		//switch to frame
		WebElement mainFrame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(mainFrame);		
		
		shadow.findElementByXPath("//tbody[@class='list2_body']//following::a[@class='linked formlink']").click();				
		
	    shadow.findElementByXPath("//span[@class='section_view']").click();
	    							    
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[text()='Cxs_popup']//following::div[text()='Default view']")).click();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//div[@id='element.incident.assignment_group']//span[@class='input-group-btn']")).click();
		
		
		Thread.sleep(5000);			
		String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> listWindow=new ArrayList<String>(windowHandles);
        driver.switchTo().window(listWindow.get(1));
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(input);
		System.out.println(driver.getTitle());
		String text = driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).getText();
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text , Keys.ENTER);
		driver.findElement(By.xpath("//table[@id='sys_user_group_table']//following::a[text()='Software']")).click();
		
		driver.switchTo().window(listWindow.get(0));
		
		System.out.println(driver.getTitle());
		WebElement mainFrame1 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(mainFrame1);		
		shadow.findElementByXPath("//span[@class='navbar_ui_actions']/button[text()='Update']").click();	
				
		shadow.findElementByXPath("//span[@class='section_view']").click();			    
					
		driver.findElement(By.xpath("//div[text()='Cxs_popup']//following::div[text()='Default view']")).click();
		driver.switchTo().window(listWindow.get(0));
		WebElement mainFrame2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(mainFrame2);	
		//String text2 = shadow.findElementByXPath("//div=[@class='section-content with-overflow']//following::div[@class='form-group ']//div[@class='input-group ref-container']").getText();
		String text2 = driver.findElement(By.xpath("//div[@id='label.incident.assignment_group']//following::div[@class='input-group ref-container']/input[@id='sys_display.incident.assignment_group']")).getText();
		
		System.out.println(text2);
		if (text2.contains("Software")) {
			
			System.out.println("Assignment Group is assigned correctly");
		}
		else {
			System.out.println("Assignment Group is not assigned correctly");
		}
		
	}

}



/*Assign the incident - Testcase Updated
=================
1. Launch ServiceNow application
2. Login with valid credentials 
3. Enter Incident from Self-Service in filter navigator and press enter
4. Search for the existing incident and click on  the incident
5. Click View: Self Service and select Default View from the pop up
6. Click on the search icon under Assignment group
7. Enter 'Software' in the search box from the window opened and press Enter
8. Click 'Software' from the results displayed
9. Update the incident with Work Notes
10. Verify the Assignment group and Assigned for the incident*/