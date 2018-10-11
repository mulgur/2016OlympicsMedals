package com.cybertek;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Self {

<<<<<<< HEAD
	//local eclipse
=======
	//github
>>>>>>> 6398f686dd185cb5f53501b46057bf0ec452bf9e
	
	public Self(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[1]")
	public List<WebElement> originalRank;
	
	@FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//thead/tr/th[2]")
	public WebElement NOC;
	
	@FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody//a")
	public List<WebElement> countries;
	
	@FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[1]")
	public List<WebElement> newRank;
	
	@FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[2]")
	public List<WebElement> goldAmount;
	
	@FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[3]")
	public List<WebElement> silverAmount;
	
	@FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[4]")
	public List<WebElement> bronzeAmount;
	
	@FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[5]")
	public List<WebElement> medalAmount;
	
	
	
	
	
	

}
