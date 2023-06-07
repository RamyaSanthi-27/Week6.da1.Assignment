package week6.day1.LeafAssignment;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Edit1 extends SpecificMethod{
	@BeforeTest
	public void setData() {
		fileName="EditLeadTest";
	}
	
	@Test(dataProvider="testData")
	public void testEdit1(String pnum, String cname) throws InterruptedException {		
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pnum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.name("submitButton")).click();
		//driver.close();
     }	

}



