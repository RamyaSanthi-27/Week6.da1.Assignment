package week6.day1.ServiceAssignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class DeleteTheIncident extends ServiceNowBaseClass{
	
	
	
@Test
	public  void runDeleteTheIncident() throws InterruptedException {
			
		
		
		//switch to frame
				WebElement mainFrame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
				driver.switchTo().frame(mainFrame);
				String text =shadow.findElementByXPath("//tbody[@class='list2_body']//following::a[@class='linked formlink']").getText();
				System.out.println(text);
				shadow.findElementByXPath("//tbody[@class='list2_body']//following::a[@class='linked formlink']").click();
				
				
				Thread.sleep(3000);
				shadow.findElementByXPath("//div[@id='moreOptionsContainer']//following::button[text()='Delete']").click();
				
				Thread.sleep(3000);			
					String text2 = driver.findElement(By.xpath("//div[@class='modal-body container-fluid']//div[text()='Warning!']")).getText();
		            System.out.println(text2);
		            String text1 = driver.findElement(By.xpath("//div[text()='Warning!']")).getText();
		            System.out.println(text1);
		           if (text1.contains(text2)) {
		            	driver.findElement(By.xpath("//button[@id='cancel_button']")).click();
		            }
		           
		           else {
		        	    
		            	shadow.findElementByXPath("//div[text()='text-'Delete this record?']//following::button[@id='ok_button']").click();
		           } 
		            System.out.println(driver.getTitle());
		            System.out.println(text + "  : The Incident is Deleted");
					
				
	            
	}
}



/*1. Launch ServiceNow application
2. Login with valid credentials 
3. Enter Incident in filter navigator and press enter"

4. Search for the existing incident and navigate into the incident
5. Delete the incident
6. Verify the deleted incident
*/