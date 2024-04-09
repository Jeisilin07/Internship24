package salesforce;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class ManageLead {

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
        driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral middleButton actionListButton']")).click();
		driver.findElement(By.xpath("//button[@name='salutation']")).click();
		driver.findElement(By.xpath("//span[@title='Mr.']")).click();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("Testleaf");
		driver.findElement(By.xpath("//input[@name='Title']")).sendKeys("QA");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		WebElement drop = driver.findElement(By.xpath("(//span[contains(text(),'More Actions')])[1]"));
		driver.executeScript("arguments[0].click();",drop);
		driver.findElement(By.xpath("(//div[@class='slds-dropdown__item'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']")).click();
		driver.findElement(By.xpath("(//td[@class='slds-is-today']/following-sibling::td)[1]")).click();
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton uiButton']")).click();
		driver.findElement(By.xpath("//button[@value='SendEmail']")).click();
		driver.findElement(By.xpath("(//input[@aria-describedby='recipientsInputLabel'])[1]")).sendKeys("kumar@testleaf.com");
	        driver.findElement(By.xpath("//input[@placeholder='Enter Subject...']")).sendKeys("managelead");
	    
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton  send uiButton']")).click();
		WebElement emailstatus = driver.findElement(By.xpath("(//span[text()='Show more actions'])[2]/.."));
		driver.executeScript("arguments[0].click();",emailstatus);
                WebElement click = driver.findElement(By.xpath("//div[@title='Change Status']"));
                driver.executeScript("arguments[0].click();",click);
		driver.findElement(By.xpath("(//a[contains(text(),'Not Started')])[1]")).click();
		driver.findElement(By.xpath("//a[@title='Completed']")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	}

}
