package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1. Page Objects : By Locators:
	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By LoginBtn = By.xpath("//input[@value='Login']");
	private By ForgetPwdLink = By.linkText("Forgotten Password");

	// public const.. of the page
	public LoginPage(WebDriver driver) { // --> A constructor
		this.driver = driver;

	}

	// 3. public page actions/methods

	public String getLoginPageTitle() {

		String title = driver.getTitle();
		System.out.println("Login page title " + title);
		return title;
	}

	public String getLoginPageUrl() {
		
		String url = driver.getCurrentUrl();
		System.out.println("Login page url " + url);
		return url;
	}

	public boolean getForgetPwdLink() {
		return driver.findElement(ForgetPwdLink).isDisplayed();

	}
	
	public AccountsPage doLogin(String username, String pwd) {
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(LoginBtn).click();
		
		
		return new AccountsPage(driver);
//		String title=  driver.getTitle();
//		System.out.println("Account Page Title is " + title);
//		return title;
		}

}
