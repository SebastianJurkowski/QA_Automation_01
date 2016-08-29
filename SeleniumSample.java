import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumSample {
	private static WebDriver driver;
	//UI Elements
	String googleSearchTextBox = "//input[@id=\"lst-ib\"]";
	String googleSearchButton = "//button[@name=\"btnG\"]";
	String firstLinkOnPage = "//div[@id='search']//a";
	
	
	@Before
	public void initializeDriver(){
		//instantiate Driver
		System.out.println("Initialize driver.");
		driver = new FirefoxDriver();
					
		int driverImplicitWait = 10;
		System.out.println("Driver implicit wait set to "+driverImplicitWait+".");
		driver.manage().timeouts().implicitlyWait(driverImplicitWait, TimeUnit.SECONDS);
				
		int driverPageLoadTimeOut = 10;
		System.out.println("Driver page load timeout set to "+driverPageLoadTimeOut+".");
		driver.manage().timeouts().pageLoadTimeout(driverPageLoadTimeOut, TimeUnit.SECONDS);
		
	}
	
	@After
	public void cleanUp(){
		driver.quit();
	}

	@Test
	public void test() {
		
		
		
		try{								
			//Navigate to google
			String googleURL = "http://google.com";
			System.out.println("Navigating to google search engine site.");
			driver.get(googleURL);
			
			//Clear search box and enter search string
			System.out.println("Clearing out search box text.");
			driver.findElement(By.xpath(googleSearchTextBox)).clear();
			
			System.out.println("Entering new search parameter and clicking the search button.");
		    driver.findElement(By.xpath(googleSearchTextBox)).sendKeys("levels beyond reach engine");
		    driver.findElement(By.xpath(googleSearchButton)).click();
		    
		    //Click on the first available link presented by search results
		    System.out.println("Click on first available link in the results.");
			driver.findElement(By.xpath(firstLinkOnPage)).click();	
			
			//Explicit wait
		    Thread.sleep(5000);	
			
			//Next page
			System.out.println("Asserting URL displayed is www.reachengine.com.");
		    String CurrentURL = driver.getCurrentUrl();		    
		    String expectedURL = "https://www.reachengine.com/";
		    System.out.println("Current URL is " + CurrentURL + ".");
			assertEquals(expectedURL, CurrentURL);
			System.out.println("Assertion is successful");
			
			System.out.println("Quit system Driver");
			System.out.println("Test Has Passed!");
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the test execution, please revise the following exception;");
			System.out.println(ex);
		}		
		//fail("Not yet implemented");
	}

	
	@Test
	public void testNegative() {
		
		
		
		try{
			//Navigate to google
			String googleURL = "http://google.com";
			System.out.println("Navigating to google search engine site.");
			driver.get(googleURL);
			
			//Clear search box and enter search string
			System.out.println("Clearing out search box text.");
			driver.findElement(By.xpath(googleSearchTextBox)).clear();
			
			System.out.println("Entering new search parameter and clicking the search button.");
		    driver.findElement(By.xpath(googleSearchTextBox)).sendKeys("levels beyond reach engine");
		    driver.findElement(By.xpath(googleSearchButton)).click();
		    
		    //Click on the first available link presented by search results
		    System.out.println("Click on first available link in the results.");
			driver.findElement(By.xpath(firstLinkOnPage)).click();	
			
			//Explicit wait
			//This code executes too fast so without wait it will load previous URL
		    //Thread.sleep(5000);	
			
			//Next page
			System.out.println("Asserting URL displayed is www.reachengine.com.");
		    String CurrentURL = driver.getCurrentUrl();		    
		    String expectedURL = "https://www.reachengine.com/";
		    System.out.println("Current URL is " + CurrentURL + ".");
			assertEquals(expectedURL, CurrentURL);
			System.out.println("Assertion is successful");
			
			System.out.println("Quit system Driver");
			System.out.println("Test Has Passed!");
		}
		catch(Exception ex){
			System.out.println("Something went wrong in the test execution, please revise the following exception;");
			System.out.println(ex);
		}		
		//fail("Not yet implemented");
	}
}
