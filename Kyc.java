package pixdynamics;

import java.time.Duration;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KYC {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://pixd-demo-vkyc-nginx-1-2.14c19d9d.lowtouch.cloud/");
		System.out.println("Successfuly login");
		
	    WebElement e = driver.findElement(By.xpath("(//button[@class='btn'])[1]"));
		e.click();
		
		
		WebElement startbtn = driver.findElement(By.id("getstartbtn"));
		startbtn.click();
		
		WebElement mob= driver.findElement(By.id("Mobile"));
		mob.sendKeys("9828745444");
		
		WebElement email= driver.findElement(By.id("email"));
		email.sendKeys("Sylkdaaa@gmail.com");
		
		driver.findElement(By.id("promo")).sendKeys(Keys.TAB);
	
		WebElement captcha = driver.findElement(By.id("cpatchaTextBox"));
		Thread.sleep(20000);
		System.out.println(captcha.getText());
		JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down the page
        js.executeScript("window.scrollBy(0,500)");

		 //Assuming the captcha has been filled correctly, proceed with the checkbox
		WebElement hl = driver.findElement(By.xpath("//a[@class='hyper-link']"));
		hl.click();
	    driver.findElement(By.id("agree-button")).click();
	    
	    driver.findElement(By.id("proceed-button")).click();
	    Thread.sleep(10000);
	    
	  //OTP verification
	    driver.findElement(By.id("submit-button")).click();
	
	    //Let's start with your Aadhaar & PAN.
	    //Aadhaar
	    Thread.sleep(2000);
      //Aadhaar
        driver.findElement(By.id("digit-1")).sendKeys("4545");
	    driver.findElement(By.id("digit-2")).sendKeys("4555");
	    driver.findElement(By.id("digit-3")).sendKeys("4545");
		//Enter your 10 digit PAN (Permanent Account Number).
		driver.findElement(By.id("pan-verification-digit")).sendKeys("BJXPA8888K");
		// Scroll down the page
        js.executeScript("window.scrollBy(0,500)");
		 driver.findElement(By.xpath("(//p[@class='text-muted mb-4'])[1]")).click();
		driver.findElement(By.id("validate-aadhar-pan")).click();
		
		//OTP has been sent to your Aadhaar registered mobile number.
		Thread.sleep(2000);
			 
		driver.findElement(By.id("digit-otp-1")).sendKeys("5");
	    driver.findElement(By.id("digit-otp-2")).sendKeys("7");
	    driver.findElement(By.id("digit-otp-3")).sendKeys("5");
	    driver.findElement(By.id("digit-otp-4")).sendKeys("7");
	    driver.findElement(By.id("digit-otp-5")).sendKeys("5");
	    driver.findElement(By.id("digit-otp-6")).sendKeys("5");
	    
	    driver.findElement(By.id("aadhar-otp-verification-button")).click();
	   // Please verify your details.
	    Thread.sleep(10000);
	    driver.findElement(By.id("aadhaar-submit-btn")).click();
	    
	    //Please select the account type & branch.
		//WebElement e1 = driver.findElement(By.xpath(("(//span[@class='select2-selection select2-selection--single'])[1]")));
//e1.click();

//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='select2-selection select2-selection--single']")));
//element.click();
//element.sendKeys(Keys.ARROW_DOWN.ENTER);
//WebElement option = driver.findElement(By.id("select2-select_category-result-vh6x-Pixdynamics Blue SA"));
//option.click();
WebElement element = driver.findElement(By.id("select_category"));

Select s= new Select(element);
 s.selectByValue("Pixdynamics Silver Plus SA");
 
		WebElement search = driver.findElement(By.id("item-search"));  
		  
		  search.sendKeys("Kochi");
		  
		 /*Actions a = new Actions(driver);
		  WebElement element2 = driver.findElement(By.id("search-result"));
		  a.doubleClick(element2).perform();*/
		  Thread.sleep(10000);
		  driver.findElement(By.id("atm-eligibility")).click();
		  
		// Personal Details
		  Thread.sleep(10000);
			 driver.findElement(By.id("fathers-fullname")).sendKeys("Kumlra");
			  driver.findElement(By.id("mothers-fullname")).sendKeys("Anisha");
			  
			//Marital status
			  WebElement ms = driver.findElement(By.id("cust_birth_select_page_3_ccmaritial"));
//ms.click();
				driver.findElement(By.xpath("//option[@value='Single']")).click();
				/*
				 * Select s1= new Select(ms); s.selectByValue("Single");
				 */
				
				
				
				  //driver.findElement(By.id("new-spouse-full")).sendKeys("Kripha");
				 
			  
			 driver.findElement(By.id("new-placeofbirth-full")).sendKeys("Kollam");
	//Educational Qualification
			 WebElement eq = driver.findElement(By.id("select_page_3_education"));
			driver.findElement(By.xpath("//option[@value='Graduate']")).click();
			
	//occupation
			 WebElement occ = driver.findElement(By.id("select_page_3_occupation"));
				driver.findElement(By.xpath("//option[@value='Self Employed']")).click();				
	//Annual Income
		WebElement An = driver.findElement(By.id("select_page_3_income"));
		driver.findElement(By.xpath("//option[@value='1 to 5 lac']")).click();	
				
	//Religion
		WebElement rg = driver.findElement(By.id("select_page_3_religion"));
		driver.findElement(By.xpath("//option[@value='Hindu']")).click();	
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(10000);
	//Source of income
		WebElement soi = driver.findElement(By.id("select_page_3_source_income"));
		//driver.findElement(By.xpath("//option[@value='2']")).click();
		driver.findElement(By.xpath("//option[@value='2']")).click();
		
		
		 //RAdio buttons 
		driver.findElement(By.id("taxNo")).click();
		 driver.findElement(By.id("literateNo")).click();
		 driver.findElement(By.id("phyNo")).click();
		 driver.findElement(By.id("mentNo")).click();
		 driver.findElement(By.id("pepNo")).click(); Thread.sleep(10000);
		driver.findElement(By.xpath("(//label[@class='declaration-text custom-control-label'])[1]")).click();
		Thread.sleep(10000);
		
		  
driver.findElement(By.id("review_personal_submit_btn")).click();
		//review_address_submit_btn
//Permanent Address
Thread.sleep(10000);
		  driver.findElement(By.id("review_address_submit_btn")).click();
		 
	//Request For
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("(//label[@class='custom-control-label'])[1]")).click();
//nominee
		  driver.findElement(By.id("requre-nominee-no")).click();
		  
		  driver.findElement(By.id("requre-atm-no")).click(); 
			 
		  Thread.sleep(10000);
		  driver.findElement(By.id("review_other_details_submit_btn")).click(); 
		//Application Review
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("  (//label[@class='declaration-text custom-control-label'])[6]")).click();
		
		  Thread.sleep(10000);
		  driver.findElement(By.id("submit-personaldetails")).click();  
			 
	//payment
		  Thread.sleep(10000);
		  WebElement pyt = driver.findElement(By.id("payment_amount"));
			
			driver.findElement(By.xpath("//option[@value='20']")).click();
			Thread.sleep(10000);
			driver.findElement(By.id("paymentbutton")).click();
			//driver.navigate().refresh();
			//Manually refresh 
			//driver.navigate().refresh();
			Thread.sleep(50000);
			
		   // WebElement element2 = driver.findElement(By.id("paymentbutton"));
		   // js.executeScript("argument[0].click()", element2);
		   //element2.click();
		    
		    
	//Video kyc
	/*
	 * driver.findElement(By.
	 * xpath("(//button[@class='new-method has-tooltip false svelte-1d17g67'])[2]"))
	 * .click();
	 * 
	 * driver.findElement(By.
	 * xpath("(//label[@class='radio-label mfix svelte-1te52k3'])[6]")).click();
	 * 
	 * driver.findElement(By.id("redesign-v15-cta")).click();
	 * 
	 * driver.navigate().to(
	 * "https://api.razorpay.com/v1/gateway/mocksharp/payment?key_id=rzp_test_JO0ozLYi5tmHj4"
	 * );
	 * 
	 * driver.findElement(By.id("//button[@class='success']")).click();
	 */
			
			 
			 
			 
			 
			 
			 
			 
			 
			 
	}
}
