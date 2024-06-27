package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	
	//Write By locators
	private By logoutlink = By.linkText("Logout");
	private By headers = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	
	
	//Create Public Methods
	public String getAccPageTitle() {

		String title = driver.getTitle();
		System.out.println("Account page title " + title);
		return title;
	}

	public String getAccPageUrl() {
		
		String url = driver.getCurrentUrl();
		System.out.println("Account page url " + url);
		return url;
	}
	
	public boolean isLogoutLinkExist() {
		return driver.findElement(logoutlink).isDisplayed();
	}
	
	public List<String> getAccPageHeaders() {
	   List<WebElement> headersList = driver.findElements(headers);
	   List<String> headerValList = new ArrayList<String>; //create a blank list 
	   for(WebElement e , headersList) {
		   String text = e.getText();
		   headerValList.add(text); //append list
	   }
	   return headerValList;
	}
	
	public boolean isSearchExist() {
		return driver.findElement(search).isDisplayed();
	}
	
	public void doSearch(String searchKey ) {
		System.out.println("Search key is " + searchKey);
		
		if(isSearchExist()) {
			driver.findElement(search).isDisplayed();
			driver.findElement(searchIcon).click();
		}
		else {
			System.out.println("Search key not present");
		}
		
	}
	
	//constructor 
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		
		
	}

}
