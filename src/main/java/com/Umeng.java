package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;

/**
 * TODO
 *
 * @author shijl
 * @date 2019-06-26 19:08
 */
public class Umeng {
	private static void getCookie(String userName, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-devtools-experiments", "enable-automation"));
		chromeOptions.addArguments("disable-infobars");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://passport.umeng.com/login");
		driver.manage().window().maximize();
		driver.switchTo().frame("alibaba-login-box");
		driver.findElement(By.xpath("//*[@id=\"fm-login-id\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"fm-login-id\"]")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id=\"fm-login-password\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"fm-login-password\"]")).sendKeys(password);

		WebElement element = driver.findElement(By.xpath("//*[@id=\"nc_1_n1z\"]"));
		Actions    actions = new Actions(driver);
		actions.clickAndHold(element).perform();
		actions.moveByOffset(280, 0).perform();
		//Thread.sleep(1000);
		actions.release(element).perform();
		//driver.findElement(By.xpath("//*[@id=\"fm-login-submit\"]")).click();

		//driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		getCookie("username", "passowrd");
	}
}
