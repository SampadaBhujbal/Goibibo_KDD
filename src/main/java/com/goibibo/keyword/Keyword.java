package com.goibibo.keyword;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import com.goibibo.constant.Constant;
import com.goibibo.customUtil.CustomUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword extends Constant {
	public static void  openBrowser(String browserName) {
		switch(browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		case "HTML unit":
			driver=new HtmlUnitDriver();
			break;
			default:
				System.out.println("Open url successfully");
		}
				
		}
		public static void launchUrl(String url)	 {
			driver.get(url);
		}
		public static void maximize() {
			driver.manage().window().maximize();
		}
		public static void deleteAllCookies() {
			driver.manage().deleteAllCookies();
		}
		
		public static WebElement getWebElement(String locatorName) {
			String locatorType=CustomUtil.getLocaterValue(locatorName)[0];
			String locatorValue=CustomUtil.getLocaterValue(locatorName)[1];
			switch(locatorType) {
		    case "xpath":
				element=driver.findElement(By.xpath(locatorValue));
			break;
			case "css":
				element=driver.findElement(By.cssSelector(locatorValue));
			break;
			case "id":
				element=driver.findElement(By.id(locatorValue));
			break;
			
			}
			
			return element;
			
		}
		public static void enterText(String locatorName,String text) {
			getWebElement(locatorName).sendKeys(text);
		}
		public static void mouseHoverClick(String locatorName) {
			action=new Actions(driver);
			action.moveToElement(getWebElement(locatorName)).click().build().perform();
			
		}
		
		public static void implicitWait(int duration) {
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
		}
		public static void click(String locatorName) {
			 getWebElement(locatorName).click();
		}
		public static void explicitWait(int duration) {
			wait=new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.SECONDS);
			
		}
		public static String getText(String locatorName) {		
			return getWebElement(locatorName).getText();
		}
		
		public static void closeBrowser() {
			driver.close();
		}
		
	}


