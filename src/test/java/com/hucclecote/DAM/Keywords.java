package com.hucclecote.DAM;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
//import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keywords {
	

	
//	System.out.println(prop.getProperty("location"));
	static FirefoxDriver driver;
	static	JavascriptExecutor jse;
	static Properties prop;
	
	public void openBrowser() throws IOException{
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		jse = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void navigate(String data){
		driver.get(data);		
	}
	
//	Locate and select location
	
	public void selectInputDropdown(String data, String objectname) throws InterruptedException{
		WebElement lc = driver.findElement(By.xpath(prop.getProperty(objectname)));
		System.out.println(lc);
		jse.executeScript("arguments[0].click()", lc);
		Thread.sleep(5000);
		lc.sendKeys(data);
		Thread.sleep(3000);
		lc.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
//	Select calender
	
	public void openCalender(String calender, String monthview) throws InterruptedException{
		WebElement menu= driver.findElement(By.xpath(prop.getProperty(calender)));
		Actions actions = new Actions(driver);
		actions.moveToElement(menu).click().build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty(monthview))).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
//	Select date and month of booking
	public void selectDate(String month, String date) throws InterruptedException{
		driver.findElement(By.xpath(prop.getProperty(month))).click();
		driver.findElement(By.xpath(prop.getProperty(date))).click();
		Thread.sleep(1000);
		}
	
	
//	Select Slot of single day booking
	public void selectSlot(String slot_time, String slotconfirmbtn) throws InterruptedException{
		driver.findElement(By.xpath(prop.getProperty(slot_time))).click();
		driver.findElement(By.xpath(prop.getProperty(slotconfirmbtn))).click();
		Thread.sleep(5000);
		}
//	Select Slot of recurring day booking
	public void selectSlotrec(String slot_time, String slotconfirmbtn) throws InterruptedException{
		driver.findElement(By.xpath(prop.getProperty(slot_time))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty(slot_time))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty(slotconfirmbtn))).click();
		Thread.sleep(5000);
		}
	
//	Insert detailsf
	public void insertDetails(String path, String data) throws InterruptedException{
		WebElement p= driver.findElement(By.xpath(prop.getProperty(path)));
		jse.executeScript("arguments[0].click()", p);
		p.sendKeys(data);
		Thread.sleep(2000);
		}
	
//	Select form drop down
	public	void selectFormDropdown(String dropdown, String choice) throws InterruptedException{
		WebElement dd= driver.findElement(By.xpath(prop.getProperty(dropdown)));
		jse.executeScript("arguments[0].click()", dd);
		
		WebElement g =  driver.findElement(By.xpath(prop.getProperty(choice)));
		jse.executeScript("arguments[0].click()", g);
		Thread.sleep(3000);
//		System.out.println(lst);
//		lst.get(1).click();
		
	}
//	Select checkbox 
	public void checkBox(String path){
		WebElement cb = driver.findElement(By.xpath(prop.getProperty(path)));
		jse.executeScript("arguments[0].scrollIntoView();", cb);
		jse.executeScript("arguments[0].click()", cb);
			}
//	Select button 
	public void selectBtn(String path) throws InterruptedException{
		WebElement bt=driver.findElement(By.xpath(prop.getProperty(path)));
		jse.executeScript("arguments[0].click()", bt);
		Thread.sleep(3000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
//	Wait till expectation
	public void waitforElement(String expectedresult){
		WebDriverWait wait = new WebDriverWait(driver,25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty(expectedresult))));
	}
	

	
//	Add child info Continue button
	public void continueBtn(String args) throws InterruptedException{
		
		WebElement menu= driver.findElement(By.xpath(prop.getProperty(args)));
//		jse.executeScript("arguments[0].click()", menu);
		Actions actions = new Actions(driver);
		actions.moveToElement(menu).click().build().perform();
		Thread.sleep(6000);
//		jse.executeScript("arguments[0].click()", menu);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		jse.executeScript("arguments[0].removeAttribute('disabled','disabled')",menu);
//
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.elementToBeClickable(menu));
//
//		menu.click();
//		Thread.sleep(1000);
		
	}
	
//	Add number of people
	public void addPeople(String path, String value) throws InterruptedException{
		WebElement ap = driver.findElement(By.xpath(path));
		Actions actions = new Actions(driver);
		actions.moveToElement(ap);
		actions.click();
		actions.build().perform();
		ap.clear();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ap.sendKeys(value);
		ap.sendKeys(Keys.TAB);
	}
	static int count;
	
//	Close the browser
	public void closeBrowser() throws InterruptedException{
//		
		driver.quit();
		System.out.println("Test ran for "+ count + " times for different products and clinics");
		System.out.println("Test case exceuted successfully");
		System.out.println("Booking created");
		Thread.sleep(3000);
	}

//	Select form drop down
	public	void selectinfoDropdown(String dropdown, String choice) throws InterruptedException{
		WebElement dd= driver.findElement(By.xpath(prop.getProperty(dropdown)));
		jse.executeScript("arguments[0].click()", dd);
		WebElement g =  driver.findElement(By.xpath(prop.getProperty(choice)));
		jse.executeScript("arguments[0].click()", g);
		Thread.sleep(3000);		
	}
	

	
}
