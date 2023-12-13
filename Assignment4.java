package co.edurekatraining;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4 {

	public static void main(String[] args) {
		
        //step 1- set up the path for browser
		System.setProperty("webdriver.chrome.driver", "..\\SeleniumAutomation\\Drivers\\chromedriver.exe");
		
		//step 2 - launch the light and empty browser
		WebDriver driver = new ChromeDriver();
		
		//step 3 - Maximize the window
	    driver.manage().window().maximize();
		
		//step 4 - Open www.rediff.com website
		driver.get("https://www.rediff.com/");
		
		//step 5 - Verify on which page we are
		String currentURL = driver.getCurrentUrl();
		System.out.println("current URL ="+currentURL);
		
		// Step 6 - Get the page title of the webpage
		
		String currentPageTitle = driver.getTitle();
		System.out.println("Current page title ="+currentPageTitle);
		
		//Step 7 - Click on sign in link
		WebElement signInLink = driver.findElement(By.xpath("//a[@title = 'Already a user? Sign in']"));
		signInLink.click();
		
		System.out.println("Landed to sign in page");
		
		//Step 8 - Click on sign in button 
		WebElement signInButton = driver.findElement(By.xpath("//input[@title = 'Sign in']"));
		signInButton.click();
		
		//Step 9 - Switching to alert 
		Alert alert = driver.switchTo().alert();
		
		//Step 10 - Capture the alert message
		
		String alertMessage = alert.getText();
		System.out.println("Alert message = "+alertMessage);
		
		//Step 11- Accept the alert 
		alert.accept();
		System.out.println("Accepted the alert");
		
		//Step 12 - Navigate to demoqa.com website
		driver.navigate().to("https://demoqa.com/browser-windows");
		
		//Step 13 - Click on New Tab, New Window, and New Window Message
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle= "+parentWindowHandle);
		WebElement clickElement = driver.findElement(By.id("tabButton"));
		for(int i =0; i<3; i++)
		{
			clickElement.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}
		//Step 14 - Print the list of windowhandles() for all the newly opened tabs.

			Set<String> allWindowHandles = driver.getWindowHandles();
			for(String handle :allWindowHandles)
			{
				System.out.println("Window Handle ->"+handle);
				
			}
		//step 15 - Print the total window count size.
			ArrayList<String> tabs = new ArrayList<String>(allWindowHandles);
			System.out.println("No. of tabs:" +tabs.size());
					
		
		
		
		

	}

}
