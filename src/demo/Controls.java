package demo;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Controls {

	public void checkbox(WebDriver driver)
	{
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		// driver.findElement(By.xpath("//*[@class='css-1dbjc4n'] //*[text()='Armed
		// Forces']")).click(); //find x path using *
		driver.findElement(By.cssSelector("div[class*='r-1ozqkpa']")).click();
		// System.out.println(driver.findElement(By.cssSelector("*[class='css-1dbjc4n
		// r-1d09ksm r-1inuy60 r-m611by']")));
	}

	public void checkboxassignment1(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
	}

	public void checkboxassignment2(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		// driver.findElements(By.cssSelector("input[type='checkbox'")).size();

		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox'")).size());

	}

	public void alertsDemo(WebDriver driver) {
		String name = "Dheeraj";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
	}
	
	public void childWindowHandle(WebDriver driver)

	{
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles(); // [parentid,childid,subchildId]
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim()
				.split(" ")[0];
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailId);
	}
	
	public void frames(WebDriver driver)
	{
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText()); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions p = new ChromeOptions(); //// Handle window notification like allow and block
		p.addArguments("--disable-notifications");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		Controls obj = new Controls();
		// obj.checkbox(driver);
		// obj.checkboxassignment1(driver);
		// obj.checkboxassignment2(driver);
		// obj.alertsDemo(driver);
		//obj.childWindowHandle(driver);
		obj.frames(driver);
	}

}
