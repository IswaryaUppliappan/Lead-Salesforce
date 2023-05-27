package leads.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
        WebElement opp=driver.findElement(By.xpath("(//span[text()='Leads'])[1]"));
        driver.executeScript("arguments[0].click();", opp);
        WebElement a = driver.findElement(By.xpath("//input[@name='Lead-search-input']"));
        a.sendKeys("Kumar");
        a.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']")).click();
        WebElement s = driver.findElement(By.xpath("//div[text()='Edit']"));
        driver.executeScript("arguments[0].click();", s);
        WebElement drop = driver.findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[4]"));
        driver.executeScript("arguments[0].click();", drop);
        driver.findElement(By.xpath("//span[@title='Working - Contacted']")).click();
        driver.findElement(By.xpath("//button[text()='Save']")).click();
    	String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String expected_Result="Lead \"Ganesh Kumar\" was saved.";
		Assert.assertEquals(actual_Result,expected_Result);
      

	}

}
