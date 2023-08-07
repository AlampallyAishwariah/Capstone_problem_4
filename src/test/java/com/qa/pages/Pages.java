package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pages {
	WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Contact']")
	WebElement ContactButtononHeader;
	public WebElement getContactButton() {
		return ContactButtononHeader;
	}

	@FindBy(xpath = "//input[@id=\"g3-name\"]")
	WebElement Name;
	public WebElement getName() {
		return Name;
	}

	@FindBy(id = "g3-email")
	WebElement Email;
	public WebElement getEmail() {
		return Email;
	}
	@FindBy(id = "contact-form-comment-g3-message")
	WebElement message;
	public WebElement getMessage() {
		return message;
	}

	@FindBy(xpath = "//button[@class=\"wp-block-button__link has-text-color has-black-color\"]")
	WebElement ContactMe;
	public WebElement getContactMe() {
		return ContactMe;
	}
	@FindBy(css = "#contact-form-success-header")
	WebElement SentMessage;
	public WebElement getSentMessage() {
		return SentMessage;
	}
	public Pages(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);

	}

}
