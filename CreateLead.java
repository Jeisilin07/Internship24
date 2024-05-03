package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("jeisjohn@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("jeis1607"); 
		driver.findElement(By.xpath("//input[@id='Login']")).click();
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        driver.findElement(By.xpath("//button[@class='slds-button']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        WebElement lead = driver.findElement(By.xpath("//span[text()='Leads'][1]"));
        driver.executeScript("arguments[0].click()",lead);
        driver.findElement(By.xpath("//div[@title='New']")).click();
        driver.findElement(By.xpath("//button[@name='salutation']")).click();
	driver.findElement(By.xpath("//span[@title='Mr.']")).click();
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Kumar");
        driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("Testleaf");
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        
	}

}
