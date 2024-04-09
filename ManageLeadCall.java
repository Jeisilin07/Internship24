package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageLeadCall {

	public static void main(String[] args) throws InterruptedException {
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
		
		WebElement choose = driver.findElement(By.xpath("(//a[@title='Kumar'])[1]"));
		driver.executeScript("arguments[0].click();",choose);
		driver.findElement(By.xpath("(//button[@title='More Actions'])[3]")).click();
		driver.findElement(By.xpath("(//div[@class='slds-dropdown__item'])[1]")).click();
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("call");
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']")).click();
		driver.findElement(By.xpath("(//td[@class='slds-is-today']/following-sibling::td)[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[@aria-label='Log a Call']")).click();
		driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys("Can we discuss working together?");
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton uiButton']")).click();
		WebElement emailstatus = driver.findElement(By.xpath("(//span[text()='Show more actions'])[3]/.."));
		driver.executeScript("arguments[0].click();",emailstatus);
        WebElement click = driver.findElement(By.xpath("//div[@title='Change Status']"));
        driver.executeScript("arguments[0].click();",click);
		driver.findElement(By.xpath("//a[@title='Completed']")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	}

}