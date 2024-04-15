package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageTask {

	public static void main(String[] args) throws InterruptedException {
		
		//load the browser
		ChromeDriver driver = new ChromeDriver();
		//load the url
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//maximize window
		driver.manage().window().maximize();
		//enter login details
		driver.findElement(By.id("username")).sendKeys("jeisjohn@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("jeis1607");
		driver.findElement(By.id("Login")).click();
		//click on toggler menu
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//click on view all
	    driver.findElement(By.xpath("//button[@class='slds-button']")).click();
	    //click on sales
	    driver.findElement(By.xpath("//p[text()='Sales']")).click();
	    //click on opportunity
	    WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
	    driver.executeScript("arguments[0].click()",opportunity);
	    //click on opportunity search box
	    driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Testleaf");
	    driver.findElement(By.xpath("(//a[@title='Testleaf-'])[1]")).click();
	    //Click on the new task icon
	    driver.findElement(By.xpath("(//span[text()='New Task'])[2]")).click();
	    //Set Task Details
	    driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
	    driver.findElement(By.xpath("//span[text()='Other']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("(//input[@class='slds-input'])[5]")).click();
	    driver.findElement(By.xpath("//td[@class='slds-is-today']/following-sibling::td[1]")).click();
	    driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
	    //Upload Sample File
	    WebElement browse = driver.findElement(By.xpath("//input[@type='file']"));
	    browse.sendKeys("C:\\Testleaf\\Selenium\\pom.xml");
	    driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral ok desktop uiButton--default uiButton--brand uiButton']")).click();
	    String verify = driver.findElement(By.xpath("//span[@title='pom']")).getText();
	    if (verify.contains("pom")) {
			System.out.println("File is correctly uploaded");
		}
	    else {
			System.out.println("File is incorrectly uploaded");
		}
	    //Click on the 'Details' tab
	    WebElement details = driver.findElement(By.xpath("(//a[@class='slds-tabs_default__link'])[2]"));
	    driver.executeScript("arguments[0].click()",details);
	    driver.executeScript("window.scrollBy(0,500)");
	    Thread.sleep(5000);
	    //click on description
	    driver.findElement(By.xpath("//button[@title='Edit Description']")).click();
	    driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow textarea-container']")).sendKeys("Attachments uploaded successfully");
	    //click on save
	    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	    //click on mark as complete
	    WebElement complete = driver.findElement(By.xpath("//span[text()='Mark Stage as Complete']"));
     	driver.executeScript("arguments[0].click();", complete);

	}

}
