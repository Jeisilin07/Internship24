package day1;

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
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("jeisjohn07@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Jeis1607"); 
		driver.findElement(By.xpath("//input[@id='Login']")).click();
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        driver.findElement(By.xpath("//button[@class='slds button']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        WebElement lead = driver.findElement(By.xpath("//span[text()='Leads'][1]"));
        driver.executeScript("arguments[0].click()",lead);
        WebElement drop = driver.findElement(By.xpath("//button[@role='combobox'])[3]"));
        driver.executeScript("arguments[0].click()",drop);
        driver.findElement(By.xpath("//span[text()='Mr.']")).click();
        driver.findElement(By.xpath("//label[text()='Last Name']/following::input[1]")).sendKeys("Kumar");
        driver.findElement(By.xpath("//label[text()='Company']/following::input[1]")).sendKeys("Testleaf");
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        
	}

}
