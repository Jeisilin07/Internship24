package salesforce;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ConvertLeads {

     
	public static void main(String[] args) throws InterruptedException, IOException  {
	
	
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("jeisjohn@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("jeis1607");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    driver.findElement(By.xpath("//button[@class='slds-button']")).click();
	    driver.findElement(By.xpath("//p[text()='Sales']")).click();
	    WebElement lead = driver.findElement(By.xpath("//span[text()='Leads'][1]"));
	    driver.executeScript("arguments[0].click()",lead);
	    
	    driver.findElement(By.xpath("//input[@name='Lead-search-input']")).sendKeys("Kumar");
	    driver.findElement(By.xpath("(//a[@title='Kumar'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Details']")).click();
		driver.executeScript("window.scrollBy(0,250)");
		Thread.sleep(5000);
		WebElement editLead = driver.findElement(By.xpath("///button[@aria-label='Lead Status - Current Selection: Open - Not Contacted']"));
		driver.executeScript("arguments[0].click();",editLead);
		Thread.sleep(5000);
	    WebElement workCt = driver.findElement(By.xpath("//span[@title='Working - Contacted']"));
		driver.executeScript("arguments[0].click();",workCt);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(5000);
		WebElement complete = driver.findElement(By.xpath("//span[text()='Mark Status as Complete']"));
		driver.executeScript("arguments[0].click();",complete);
		WebElement dd = driver.findElement(By.xpath("(//button[contains(@class,'slds-button slds-button_icon-border-filled')]//lightning-primitive-icon)[1]"));
		driver.executeScript("arguments[0].click();",dd);
		driver.findElement(By.xpath("//span[text()='Convert']")).click();
		File src = driver.getScreenshotAs(OutputType.FILE);
	    File dec = new File("./screenshot/img.png");
	    FileUtils.copyFile(src, dec);
		driver.findElement(By.xpath("//button[text()='Convert']")).click();
       }
}
