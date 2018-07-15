package com.cybertek;

import static com.cybertek.ConfigReader.getProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelfTest {

	WebDriver driver;
	Map<String, Integer> gold;
	Map<String, Integer> silver;
	Map<String, Integer> bronze;
	Map<String, Integer> medal;
	Self self;
	int max = 0;
	
	

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
	}
	
	@BeforeMethod
	public void navigate() {
		//1) Go to website
		self = new Self(driver);
		driver.get( getProperty("url"));
		gold = new HashMap<>();
		silver = new HashMap<>();
		bronze = new HashMap<>();
		medal = new HashMap<>();

}

	@Test(priority = 1)
	public void sortTest() {
		
		//2) Verify that by default the Medal table is sorted by rank.
        List<Integer> actRank = new ArrayList<>();
		for (int i = 0; i < self.originalRank.size() - 1; i++) {
			actRank.add(Integer.parseInt(self.originalRank.get(i).getText()));
		}
		SortedSet<Integer> expected = new TreeSet<>(actRank);
		assertEquals(expected, actRank);
		
		//3) Click link NOC.
		self.NOC.click();
		
		//4) Now verify that the table is now sorted by the country names.
        List<String> listCountries = new ArrayList<>();
		for (int i = 0; i < self.countries.size()-1; i++) {
			listCountries.add(self.countries.get(i).getText());}
		SortedSet<String> expectedCountries = new TreeSet(listCountries);
		assertEquals(expectedCountries, listCountries);
         
		//5)Verify that Rank column is not in ascending order anymore.
		List<Integer> listNew = new ArrayList<>();
		for (int i = 0; i < self.newRank.size() - 1; i++) {
			listNew.add(Integer.parseInt(self.newRank.get(i).getText()));
		}
		assertNotEquals(expected, listNew);}

	@Test(priority = 2)
	public void theMost() {
		driver.get( getProperty("commonURL"));
		goldMost();
		silverMost();
		bronzeMost();
		medalMost();
	}

	public String goldMost()  {
	
		for(int i = 0; i < self.goldAmount.size()-1; i++) {
			gold.put(self.countries.get(i).getText(), Integer.parseInt(self.goldAmount.get(i).getText()));
		}
		max = Collections.max(gold.values());
		
		for(Entry<String, Integer> each : gold.entrySet()) {
			if(each.getValue() == max)
				return each.getKey();
		}	return null;
	}

	public String silverMost() {
		
		for(int i = 0; i < self.silverAmount.size()-1; i++) {
			silver.put(self.countries.get(i).getText(), Integer.parseInt(self.silverAmount.get(i).getText()));
		}
		max = Collections.max(silver.values());
		
		for(Entry<String,Integer> each : silver.entrySet()) {
			if(each.getValue() == max) {
				return each.getKey();}
		} return null;
		}

	public String bronzeMost() {
		
		for(int i = 0; i < self.bronzeAmount.size()-1; i++) {
			bronze.put(self.countries.get(i).getText(), Integer.parseInt(self.bronzeAmount.get(i).getText()));
		}
		max = Collections.max(bronze.values());
		
		for(Entry<String, Integer> each : bronze.entrySet()) {
			if(each.getValue() == max) {
				return each.getKey();
			}
		}
		return null;}

	public String medalMost() {
		
		for(int i = 0; i < self.medalAmount.size()-1; i++) {
			medal.put(self.countries.get(i).getText(), Integer.parseInt(self.medalAmount.get(i).getText()));
			}
		max = Collections.max(medal.values());
		
		
		for(Entry<String, Integer> each : medal.entrySet()) {
			if(each.getValue() ==  max) {
				return each.getKey();
			}
		}
		return null;}
	
	@Test(priority = 3)
	public void countryByMedal() {
		driver.get( getProperty("commonURL"));
		silverCountry();
		
}
	public String silverCountry() {
		
		for(int i = 0; i < self.silverAmount.size()-1; i++) {
			silver.put(self.countries.get(i).getText(), Integer.parseInt(self.silverAmount.get(i).getText()));
		}
		
		for(Entry<String,Integer> each : silver.entrySet()) {
			if(each.getValue() == 18) {
				return each.getKey();}
		} return null;
		}
	
	@Test
	public void getIndex() {
		driver.get( getProperty("commonURL"));
		rowColumn("Japan");
		
	}
	
	public String rowColumn(String country) {
		int row = 1;
		
		for(int i = 0; i < self.countries.size()-1; i++) {
			
			if(!self.countries.get(i).getText().equals("Japan")) 
				row++;
			else
				break;
			}
			return "row: " + row + " column : " + 2;
}
	@Test
	public void getSum() {
		driver.get( getProperty("commonURL"));
		bronze18();

		
	}
	public String bronze18() {
		
		String str = "";
		for(int i = 0; i < self.bronzeAmount.size()-1; i++) {
			bronze.put(self.countries.get(i).getText(), Integer.parseInt(self.bronzeAmount.get(i).getText()));
		}
		System.out.println(bronze);
	for(Entry<String, Integer> each : bronze.entrySet()) {
		for(Entry<String, Integer> each2 : bronze.entrySet()) {
			if((each.getValue()+ each2.getValue() == 18) && !(each.getKey().equals(each2.getKey()))) 
				str = each.getKey() + " " + each2.getKey();
			
	}	
	}	return str;

	
		
	}}
	
	
	
	
	


