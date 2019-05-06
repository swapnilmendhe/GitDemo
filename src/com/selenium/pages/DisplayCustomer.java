package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DisplayCustomer {

	WebDriver driver;

	public DisplayCustomer(WebDriver driver) {
		this.driver = driver;
	}

	public By text_Title = By.tagName("h2");
	public By text_Name = By.xpath("//*[text()='Name']/following-sibling::*");
	public By text_Age = By.xpath("//*[text()='Age']/following-sibling::*");
	public By text_Address = By.xpath("//*[text()='Address']/following-sibling::*");
	public By text_PhoneNumber = By.xpath("//*[text()='Phone number']/following-sibling::*");
	public By text_Email = By.xpath("//*[text()='Email']/following-sibling::*");

	public String getTitle() {
		return driver.findElement(text_Title).getText();

	}

	public String getName() {
		return driver.findElement(text_Name).getText();
	}

	public String getAge() {
		return driver.findElement(text_Age).getText();
	}

	public String getAddress() {
		return driver.findElement(text_Address).getText();

	}

	public String getEmail() {
		return driver.findElement(text_Email).getText();
	}

	public String getNumber() {
		return driver.findElement(text_PhoneNumber).getText();
	}
}
