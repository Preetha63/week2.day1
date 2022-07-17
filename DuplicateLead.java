package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
	
			
			WebDriverManager.chromedriver().setup();

			//Launch the browser (chrome)
					
					ChromeDriver driver = new ChromeDriver();
					//Load the url
					driver.get("http://leaftaps.com/opentaps/");
					//Maximize the browser
					driver.manage().window().maximize();
					//Find the username and enter the username value
					driver.findElement(By.id("username")).sendKeys("demosalesmanager");
					//Find the password field and enter the password
					driver.findElement(By.id("password")).sendKeys("crmsfa");
					//click the login button
					driver.findElement(By.className("decorativeSubmit")).click();
					
		            //link text to move to lead and create lead page
					driver.findElement(By.linkText("CRM/SFA")).click();
					driver.findElement(By.linkText("Leads")).click();
					driver.findElement(By.linkText("Create Lead")).click();
					//Input Lead informations
					driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Tech Mahindra");
					driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Preetha");
					driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Thiyagarajan");
					WebElement dropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
					driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Pree");
					driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
					driver.findElement(By.id("createLeadForm_description")).sendKeys("QA Automation Engineer");
					driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("tpreetha63@gmail.com");
					WebElement State = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
					//creating select class to select value in dropdown
					Select select = new Select(State);
					select.selectByVisibleText("New York");
					driver.findElement(By.className("smallSubmit")).click();
					//Get window title to check we are in correct page
					String title = driver.getTitle();
					if(title.equals("View Lead | Opentaps CRM"))
					{
					System.out.println("Lead Created Successfully");
					}
                   // click on Duplicate button
					driver.findElement(By.linkText("Duplicate Lead")).click();
					
                   //clear the company name field and enter the new company name
					driver.findElement(By.id("createLeadForm_companyName")).clear();
					driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Leaftap");
                    //clear the first name field and enter the new first name
					driver.findElement(By.id("createLeadForm_firstName")).clear();
					driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sujatha");
                    // click the create lead button
					driver.findElement(By.className("smallSubmit")).click();
                    if(title.equals("View Lead | opentaps CRM"))
                    {
                    	System.out.println("Duplicate Lead updated successfully");
                    }
			}
	}
					
					