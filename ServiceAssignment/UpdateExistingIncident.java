package week6.day1.ServiceAssignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UpdateExistingIncident extends ServiceNowBaseClass{
	
	
	
@Test
	public void runUpdateExistingIncident() throws InterruptedException {
		
		
		WebElement mainFrame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(mainFrame);
		//Search for the existing incident and click on the incident
		shadow.findElementByXPath("//tbody[@class='list2_body']//following::a[contains(@aria-label,'Open record: ')]").click();
		//Update the incidents with Urgency as High and State as In Progress
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='incident.urgency']")).click();
		driver.findElement(By.xpath("//option[text()='1 - High']")).click();
		driver.findElement(By.xpath("//select[@id='incident.state']")).click();
		
		driver.findElement(By.xpath("//option[text()='In Progress']")).click();
		driver.findElement(By.xpath("//button[@id='sysverb_update']")).click();
		
		Thread.sleep(3000);
		shadow.findElementByXPath("//tbody[@class='list2_body']//following::a[contains(@aria-label,'Open record: ')]").click();
		
		//Verify the priority and state
        String urgency = driver.findElement(By.xpath("//span[text()='In Progress']")).getText();        
        System.out.println("Incident State is : " +urgency);
        String state = driver.findElement(By.xpath("//span[contains(text(),'Moderate')]")).getText();
		System.out.println("Priority is : " +state);	
		}
		
		
		
	}


/*2.Update existing incident
====================
1. Launch ServiceNow application
2. Login with valid credentials 
3. Enter Incident in filter navigator and press enter "

4. Search for the existing incident and click on the incident
5. Update the incidents with Urgency as High and State as In Progress
6. Verify the priority and state */