package com.baseclass;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver browserLanuch(String browserName) {

		// 1
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		// 2
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}

		// 3
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		return driver;
		
	}

	// 4- urlLaunch
	public static void urlLaunch(String url) {
		driver.get(url);
	}

	// 5-getTitle
	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println("Title of Page : " + title);
	}

	// 6- pass input
	public static void passinput(WebElement element, String input) {
		element.sendKeys(input);
	}

	// 7- getcntUrl
	public static void getcntUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current url : " + currentUrl);
	}

	// 8- close
	public static void close() {
		driver.close();
	}

	// 09- quit
	public static void quit() {
		driver.quit();
	}
	// 10- click
	public static void clickElement(WebElement element) {
		element.click();
	}
	
////To clear  the Text
	public static void clear_Text(WebElement element) {
		element.clear();
	}

	// 12- getText
	public static void getText(WebElement target) {
		String text = target.getText();
		System.out.println("Text : " + text);
	}

	// 13- getAttribute
	public static void getAttribute(WebElement passtext, String name) {
		String s = passtext.getAttribute(name);
		System.out.println("Attribute of : " + s);
	}

	// 14- timeDelay
	public static void timeDelay(int arg) throws InterruptedException {
		Thread.sleep(arg);
	}

	// 15- mouseOver
	public static void mouseOver(WebElement move) {
		Actions a = new Actions(driver);
		a.moveToElement(move).perform();
	}

	// 16- dragAndDrop
	public static void dragAndDrop(WebElement src, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, target).perform();
	}

	// 17- doubleClick
	public void doubleClick(WebElement target) {
		Actions a = new Actions(driver);
		a.doubleClick(target).perform();
	}

	// 18- contextClick
	public static void contextClick(WebElement target) {
		Actions a = new Actions(driver);
		a.contextClick(target).perform();
	}

	// 19- acceptAlert
	public static void acceptAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	// 20- dismissAlert
	public static void dismissAlert() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	// 21- acceptPromptAlert
	public static void acceptPromptAlert(String keytosend) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(keytosend);
		a.accept();
	}

	// 22- dismissPromptAlert
	public static void dismissPromptAlert(String keytosend) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(keytosend);
		a.dismiss();
	}

	// 23- sendTextJavaScript
	public static void sendTextJavaScript(String javascriptcommand, WebElement target) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javascriptcommand, target);
	}

	// 24- getAttributeJavaScript
	public static void getAttributeJavaScript(WebElement target) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object o = js.executeScript("return arguments[0].getAttribute('value')", target);
		String s = (String) o;
		System.out.println("Attribute JS : " + s);
	}

	// 25- clickJavaScript
	public static void clickJavaScript(WebElement target) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", target);
	}

	// 26
	public static void scrollUpJavaScript(WebElement target) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", target);
	}

	// 27
	public static void scrollDownJavaScript(WebElement target) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", target);
	}

	// 28
	// String path
	public static void screenshot(String imgname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sc = ts.getScreenshotAs(OutputType.FILE);// path
		File des = new File("E:\\Eclipse\\New folder\\Maven10am\\screenshot\\" + imgname + ".png");
		FileUtils.copyFile(sc, des);
	}

	// 29
	public static void switchToFrameWithID(String id) {
		driver.switchTo().frame(id);
	}

	// 30
	public static void switchToFrameWithName(String name) {
		driver.switchTo().frame(name);
	}

	// 31
	public static void switchToFrameWithWebElement(WebElement returnrefname) {
		driver.switchTo().frame(returnrefname);
	}

	// 32
	public static void switchToParenrFrame() {
		driver.switchTo().parentFrame();
	}

	// 33
	public static void switchToDefaultPage() {
		driver.switchTo().defaultContent();
	}

	// 34
	public static void windowsHandleGoToChildWindow() {
		String parwind = driver.getWindowHandle();
		Set<String> allwind = driver.getWindowHandles();
		for (String s : allwind) {
			if (s != parwind) {
				driver.switchTo().window(s);
			}
		}

	}

	// 35
	public static void windowsHandleGoToParentWindow() {
		String parwind = driver.getWindowHandle();
		Set<String> allwind = driver.getWindowHandles();
		for (String s : allwind) {
			if (s == parwind) {
				driver.switchTo().window(s);
			}
		}

	}

	// 36
	public static void multipleWindow(int indexpostion) {
		Set<String> allwind = driver.getWindowHandles();
		List<String> parclrwind = new LinkedList<String>();
		parclrwind.addAll(allwind);
		String s = parclrwind.get(indexpostion);
		driver.switchTo().window(s);

	}

	// 37
	public static void dropDownSelectByIndex(WebElement target, int index) {
		Select s = new Select(target);
		s.selectByIndex(index);
	}

	// 38
	public static void dropDownSelectByVisibleText(WebElement target, String text) {
		Select s = new Select(target);
		s.selectByVisibleText(text);
	}

	// 39
	public static void dropDownSelectByValue(WebElement target, String value) {
		Select s = new Select(target);
		s.selectByValue(value);
	}

	// 40
	public static void dropDownGetOption(WebElement target, int index) {
		Select s = new Select(target);
		List<WebElement> options = s.getOptions();
		for (WebElement all : options) {
			String text = all.getText();
			System.out.println("All Options : " + text);
		}
	}

	// 41
	public static void dropDownIsMultiple(WebElement target) {
		Select s = new Select(target);
		boolean b = s.isMultiple();
		System.out.println("We Can Select Multiple Option:" + b);
	}

	// 42
	public static void dropDownGetAllSelectedOption(WebElement target) {
		Select s = new Select(target);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement w : allSelectedOptions) {
			System.out.println(w.getText());
		}
	}

	// 43
	public static void dropDownGetFirstSelectedOption(WebElement target) {
		Select s = new Select(target);
		WebElement first = s.getFirstSelectedOption();
		System.out.println(first.getText());
	}

	// 44
	public static void dropDownDeselectByIndex(WebElement target, int index) {
		Select s = new Select(target);
		s.deselectByIndex(index);
	}

	// 45
	public static void dropDownDeSelectByValue(WebElement target, String value) {
		Select s = new Select(target);
		s.deselectByValue(value);
	}

	// 46
	public static void dropDownDeSelectByVisibleText(WebElement target, String text) {
		Select s = new Select(target);
		s.deselectByVisibleText(text);
	}

	// 47
	public static void dropDownDeSelectAll(WebElement target) {
		Select s = new Select(target);
		s.deselectAll();
	}

	// 48
	public static void implicitlyWait(int req_Time) {
	driver.manage().timeouts().implicitlyWait(req_Time,TimeUnit.SECONDS);
	}
	
}

