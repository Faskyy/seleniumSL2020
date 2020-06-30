// Automated regression testing program for use with SocialLadder platform. 
// Authors Patrick Kiefer and Fahd Ksara
// v1.0 06/2020

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    static String dataLog = "";
    static String currentDirectory = System.getProperty("user.dir");
    
    //NOTE - CONFIGURE BEFORE USE!! MAC = 1, PC = 2
    static int userNum = 1;
    // return current date/time in readable format
    public static String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return (formatter.format(date));
    }
    // append string to log
    public static void writeToLog(String data) {
        dataLog = dataLog + "\n" + data;
    }
    public static void main(final String[] args) throws InterruptedException{
        writeToLog("++ Test initialized at " + getTime());
        // configure driver executable, initialize
        if(userNum == 1){
            System.setProperty("webdriver.chrome.driver", "/Users/fahdksara/Desktop/SeleniumTest/Installers/Drivers/chromedriver");
        }
        if(userNum == 2){
            System.setProperty("webdriver.chrome.driver", currentDirectory + "\\src\\chromedriver.exe");
        }
     
        final WebDriver driver = new ChromeDriver();
        // execute test methods in sequence
        searchGoogle(driver);
        loginTestArea(driver);
        // testHomeModule(driver);
        Thread.sleep(3000);
        testChallenges(driver);
        //testPublish(driver);
        // close the browser
        Thread.sleep(5000);
        driver.close();
        writeToLog("++ Test completed at " + getTime());
        System.out.println(dataLog);
    }

    
	// initialize a browser to google.com and search for "socialladder". click the
    // link to our website
    public static void searchGoogle(WebDriver wd) {
        // open browser with google
        wd.get("https://www.google.com");
        writeToLog("Browser loaded to www.google.com.");
        WebElement searchField = wd.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
        WebElement searchButton = wd
                .findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
        searchField.click();
        searchField.sendKeys("socialladder");
        searchButton.click();
        writeToLog("Searching Google for \"socialladder\".");
        WebElement slSiteGoogle = wd.findElement(By.partialLinkText("SocialLadder |"));
        slSiteGoogle.click();
        writeToLog(">> Site located on Google - PASS");
    }

    // starting from socialladder.rkiapps.com, click login button and use test
    // credentials to access area
    public static void loginTestArea(WebDriver wd) throws InterruptedException {
        writeToLog(">> SL website loaded - PASS");
        WebElement slSiteLogin = wd.findElement(By.xpath("/html/body/div[1]/nav/div[1]/div[2]/ul/li[6]/a"));
        slSiteLogin.click();
        writeToLog(">> SL login page loaded - PASS");
        Thread.sleep(2000);
        WebElement emailInput = wd.findElement(By.id("input_0"));
        emailInput.click();
        //manually input username
        emailInput.sendKeys("onebulletboy@socialladderapp.com");
        WebElement passwordInput = wd.findElement(By.id("input_1"));
        passwordInput.click();
        //manually input password
        passwordInput.sendKeys("social33!");
        writeToLog("Credentials entered.");
        WebElement loginButton = wd.findElement(By.xpath("/html/body/div/md-content[1]/button"));
        loginButton.click();
    }

    // run predetermined regression tests on the home module
    public static void testHomeModule(WebDriver wd) {
        // insert code to verify certain expected values on home tab
    }

    public static void testChallenges(WebDriver wd) {
        WebElement challengeBtn = wd.findElement(By.xpath("/html/body/main-component/div/menu-component/md-sidenav/nav/a[2]/span"));
        challengeBtn.click();

        //// a[contains(text(),'Create')] possibility if not using class type
        try {

            Thread.sleep(3000);
            WebElement createButton = wd.findElement(By.xpath("//button[@class=\"md-primary md-raised md-button md-ink-ripple\"]"));
            createButton.click();

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Thread.sleep(3000);
            WebElement surveyButton = wd.findElement(By.xpath("/html/body/div[3]/md-dialog/div/div/section[2]/"
            		+ "section[2]/div[1]/section[1]/div/section[2]/section/div[2]"));
           
            surveyButton.click();
        } catch (Exception e) {
            System.out.println(e);
        }
        
      
        WebElement surveyName = wd.findElement(By.id("input_332"));
        surveyName.click();
        surveyName.sendKeys("Regression Test 065120");
        
        try {
        	Thread.sleep(3000);
        WebElement nextButton = wd.findElement(By.xpath("/html/body/div[3]"
        		+ "/md-dialog/div/div/section[3]/div[2]/button"));
        	nextButton.click();
        
        } catch (Exception e) {
        	System.out.print(e);
        
        }
        
        try {
        	Thread.sleep(3000);
        	WebElement nextButton = wd.findElement(By.xpath("/html/body/div[3]"
        			+ "/md-dialog/div/div/section[3]/div[2]/button"));
        	nextButton.click();
        } catch (Exception e) {
        	System.out.print(e);
        }
        
        try {
        	Thread.sleep(3000);
        
        WebElement nextButton = wd.findElement(By.xpath("/html/body/div[3]"
        		+ "/md-dialog/div/div/section[3]/div[2]/button"));
        nextButton.click();
        } catch (Exception e) {
        	System.out.print(e);
        }
     
        
        
        WebElement option1Input = wd.findElement(By.xpath("/html/body/div[3]"
        		+ "/md-dialog/div/div/section[2]/section[2]/div[5]/section[6]/div[2]"
        		+ "/div/div/div/ul[1]/li/ul/li/md-input-container/div[1]/textarea"));
        option1Input.click();
        option1Input.sendKeys("061521");
   
        WebElement option2Input = wd.findElement(By.id("input_439"));
        option2Input.click();
        option2Input.sendKeys("061522");
     
        
        
      try {
    	  Thread.sleep(1000);
      
        WebElement nextButton = wd.findElement(By.xpath("/html/body/div[3]"
        		+ "/md-dialog/div/div/section[3]/div[2]/button"));
        nextButton.click();
      } catch (Exception e) {
    	  System.out.print(e);
      }
      
      try {
    	  Thread.sleep(1000);
      
        WebElement nextButton = wd.findElement(By.xpath("/html/body/div[3]"
        		+ "/md-dialog/div/div/section[3]/div[2]/button"));
        nextButton.click();
      } catch (Exception e) {
    	  System.out.print(e);
      }

      	try {
      		Thread.sleep(2000);
      	WebElement challengeDescription = wd.findElement(By.id("input_380"));
      	challengeDescription.click();
      	challengeDescription.sendKeys("Pick one of the two survey answers");
      	} catch (Exception e) {
      		System.out.print(e);
      	}
      	
      	try {
      	  Thread.sleep(1000);
        
          WebElement nextButton = wd.findElement(By.xpath("/html/body/div[3]"
          		+ "/md-dialog/div/div/section[3]/div[2]/button"));
          nextButton.click();
        } catch (Exception e) {
      	  System.out.print(e);
        }
      	
      	WebElement dropDown = wd.findElement(By.xpath("/html/body/div[3]"
      			+ "/md-dialog/div/div/section[2]/section[2]/div[7]/div[2]/div[1]/div[2]"
      			+ "/md-input-container/md-select/md-select-value/span[1]/div"));
      	
      	dropDown.click();
      	
      	WebElement allUsers = wd.findElement(By.xpath("/html/body/div[8]/md-select-menu/md-content/md-option[2]"));
      	allUsers.click();
      	
      	try {
        	  Thread.sleep(1000);
          
            WebElement nextButton = wd.findElement(By.xpath("/html/body/div[3]"
            		+ "/md-dialog/div/div/section[3]/div[2]/button"));
            nextButton.click();
          } catch (Exception e) {
        	  System.out.print(e);
          }
      	
      	      	
    }

}
    
