package com.selenium.tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.CustomerForm;
import com.selenium.pages.DisplayCustomer;
import com.selenium.setup.DriverSetup;
import com.selenium.setup.ExcelUtils;

// fill the code
public class TestDisplayCustomer extends DriverSetup {

	WebDriver driver;

	DisplayCustomer displayCustomer;
	CustomerForm customerForm;

	public static String titletxt;
	public static String customerNametxt;
	public static String agetxt;
	public static String addresstxt;
	public static String numbertxt;
	public static String emailtxt;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
		displayCustomer = new DisplayCustomer(driver);
		customerForm = new CustomerForm(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "customerValid")
	public void testValidCustomerDetails(String customerName, String age, String address, String phoneNumber,
			String email) {
		customerForm.setCustomerName(customerName);
		customerForm.setAge(age);
		customerForm.setAddress(address);
		customerForm.setPhoneNumber(phoneNumber);
		customerForm.setEmail(email);
		customerForm.submitForm();

		titletxt = displayCustomer.getTitle();
		assertEquals(titletxt, "Registered Succesfully");
		customerNametxt = displayCustomer.getName();
		String[] splitted = customerNametxt.split("\\s+");
		assertEquals(splitted[0], customerName);
		agetxt = displayCustomer.getAge();
		assertEquals(agetxt, age);
		addresstxt = displayCustomer.getAddress();
		assertEquals(agetxt, age);
		numbertxt = displayCustomer.getNumber();
		assertEquals(numbertxt, phoneNumber);
		emailtxt = displayCustomer.getEmail();
		assertEquals(emailtxt, email);

	}

	@DataProvider(name = "customerValid")
	public Object[][] getExcelData() throws Exception {
		Object[][] arrayObject = ExcelUtils.readExcelData("customer_valid");
		return arrayObject;
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();

	}

}
