package week6.day1.LeafAssignment;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week6.day1.SpecificMethod;

public class Duplicate1 extends SpecificMethod{
	@BeforeTest
	public void setData() {
		fileName="DuplicateLeadTest";
	}
	
	@Test(dataProvider="testData")
public void testDuplicateLead(String pnum) throws InterruptedException {
		
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pnum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();

    }
	
}