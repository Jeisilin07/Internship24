package day1;

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
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("jeisjohn07@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Jeis1607"); 
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
        WebElement lead = driver.findElement(By.xpath("//span[text()='Leads'][1]"));
        driver.executeScript("arguments[0].click()",lead);
        driver.findElement(By.xpath("//input[@name='Lead-search-input']")).sendKeys("Kumar");
        driver.findElement(By.xpath("//a[@title='Edit']")).click();
        driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Ganesh");
        driver.findElement(By.xpath("//button[@title='Save']")).click();

	}

}
