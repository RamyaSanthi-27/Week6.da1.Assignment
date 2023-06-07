package week6.day1.LeafAssignment;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Create1  extends SpecificMethod{
	@BeforeTest
	public void setData() {
		fileName="CreateLeadTest";
	}
	
	@Test(dataProvider="testData")
	public  void testCreate1(String cname,String fname,String lname,String pnum) {		
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(pnum);
		driver.findElement(By.name("submitButton")).click();
		//driver.close();
		
}
  
}
			
		
        	
       


