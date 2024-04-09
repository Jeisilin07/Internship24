package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

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
	    driver.findElement(By.xpath("(//button[contains(@class,'slds-button slds-button_icon-border')]//lightning-primitive-icon)[2]")).click();
	    driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Ganesh");
		WebElement element = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value'])[5]"));
		driver.executeScript("arguments[0].click();",element);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
       
	}

}
