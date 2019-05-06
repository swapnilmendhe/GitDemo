package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerForm {

	WebDriver driver;

	public CustomerForm(WebDriver driver) {
		this.driver = driver;
	}

	public By textbox_FirstName = By.name("cname");
	public By textbox_Age = By.name("age");
	public By textbox_address = By.name("address");
	public By textbox_Phonenumber = By.name("phonenumber");
	public By textbox_Email = By.name("email");
	public By text_ErrorMessage = By.id("message");
	public By button_Submit = By.id("submit");

	public void setCustomerName(String cName) {
		driver.findElement(textbox_FirstName).sendKeys(cName);
	}

	public void setAge(String age) {
		driver.findElement(textbox_Age).sendKeys(age);
	}

	public void setAddress(String address) {
		driver.findElement(textbox_address).sendKeys(address);
	}

	public void setPhoneNumber(String phoneNumber) {
		driver.findElement(textbox_Phonenumber).sendKeys(phoneNumber);
	}

	public void setEmail(String email) {
		driver.findElement(textbox_Email).sendKeys(email);
	}

	public void submitForm() {
		driver.findElement(button_Submit).click();
	}

	public String getErrorMessage() {
		return driver.findElement(text_ErrorMessage).getText();
	}
}