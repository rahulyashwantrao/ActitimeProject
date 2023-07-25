package com.ActiTime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ActiTime.ObjectRepository.LoginPage;

public class Baseclass {
	
	public static WebDriver driver;
	FileLibrary r = new FileLibrary();
	
	@BeforeSuite
	public void databaseConnection(){
		Reporter.log("database connected",true);
	}
	
	@BeforeClass//or beforeTest
	public void launchBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String link = r.readFromPropertyFile("url");
		driver.get(link);
		Reporter.log("Browser is Launch succesfully",true);
	}
	
	@BeforeMethod
	public void login() throws InterruptedException, IOException {
		String UN = r.readFromPropertyFile("username");
		LoginPage lp = new LoginPage(driver);
		lp.getUn().sendKeys(UN);
		String PW = r.readFromPropertyFile("password");
		lp.getPw().sendKeys(PW);
		Thread.sleep(3000);
		lp.getLbtn().click();
		Reporter.log("logged in succesfully",true);
	}
	
	@AfterMethod
	public void logOut() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logged out succesfully",true);
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.close();
		Reporter.log("Browser is close succesfully",true);
	}
	
	@AfterSuite
	public void databaseDisconnection() {

		Reporter.log("database disconnected succesfully",true);
	}
}
