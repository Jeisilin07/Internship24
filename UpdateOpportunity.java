package salesforce;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateOpportunity {

	public static void main(String[] args) throws InterruptedException, IOException {
		
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
	    WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
	    driver.executeScript("arguments[0].click()",opportunity);
	    driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Testleaf");
	    driver.findElement(By.xpath("(//a[@title='Testleaf-'])[1]")).click();
	    String contact = driver.findElement(By.xpath("(//a[@data-refid='recordId'])[12]")).getText();
        System.out.println("The contact verified by:" +contact);
        if (contact.contains("Kumar")) {
        	System.out.println("The contact name is verified");	
		}
        else {
			System.out.println("The contact name is not verified");
		}
        driver.findElement(By.xpath("(//span[text()='New Task'])[2]")).click();
	    driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("email");
	    driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input slds-combobox__input-value']")).click();
	    WebElement date = driver.findElement(By.xpath("//td[@class='slds-is-today']"));
	    driver.executeScript("arguments[0].click()",date);
	    driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']")).sendKeys("Kumar");
	    driver.findElement(By.xpath("(//div[@title='Kumar'])[1]")).click();
	    WebElement status = driver.findElement(By.xpath("//a[@class='select']"));
	    driver.executeScript("arguments[0].click()",status);
	    driver.findElement(By.xpath("(//a[text()='In Progress'])[1]")).click();
	    driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
	    
	    driver.findElement(By.xpath("//span[@value='SendEmail']")).click();
	    driver.findElement(By.xpath("(//input[@aria-describedby='recipientsInputLabel'])[1]")).sendKeys("kumar@testleaf.com");
	    driver.findElement(By.xpath("//input[@placeholder='Enter Subject...']")).sendKeys("managelead");
	   
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//body[@spellcheck='true']")).sendKeys("opportunity is completed");
		driver.switchTo().defaultContent();
	    driver.findElement(By.xpath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton  send uiButton']")).click();
	    WebElement emailstatus = driver.findElement(By.xpath("(//span[text()='Show more actions'])[3]/.."));
		driver.executeScript("arguments[0].click();",emailstatus);
        WebElement click = driver.findElement(By.xpath("//div[@title='Change Status']"));
        driver.executeScript("arguments[0].click();",click);
        Thread.sleep(3000);
        WebElement clickEle = driver.findElement(By.xpath("//a[text()='Not Started']"));
        driver.executeScript("arguments[0].click();",clickEle);
		WebElement clickstatus = driver.findElement(By.xpath("//a[@title='In Progress']"));
		driver.executeScript("arguments[0].click();",clickstatus);
		driver.findElement(By.xpath("(//span[@class=' label bBody'])[7]")).click();
		Thread.sleep(3000);
	    WebElement icon = driver.findElement(By.xpath("(//button[@class='slds-button slds-button_icon-border-filled fix-slds-button_icon-border-filled slds-button_last'])[1]"));
	    driver.executeScript("arguments[0].click();",icon);
	    WebElement edit = driver.findElement(By.xpath("(//span[text()='Edit'])[1]"));
	    driver.executeScript("arguments[0].click();",edit);
	    Thread.sleep(3000);
	    WebElement stage = driver.findElement(By.xpath("(//button[@aria-label='Stage - Current Selection: Prospecting'])[1]"));
	    driver.executeScript("arguments[0].click();",stage);
	    Thread.sleep(3000);
	    WebElement dd = driver.findElement(By.xpath("(//span[text()='Qualification'])[2]"));
	    driver.executeScript("arguments[0].click();",dd);
	    File src = driver.getScreenshotAs(OutputType.FILE);
	    File dec = new File("./screenshot/img1.png");
	    FileUtils.copyFile(src, dec);
	    driver.findElement(By.xpath("(//button[@name='SaveEdit'])[1]")).click();
	    

	}

}
