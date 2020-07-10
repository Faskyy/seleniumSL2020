// Automated regression testing program for use with SocialLadder platform. 
// Authors Patrick Kiefer and Fahd Ksara
// v1.0 06/2020

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class App {
    static String dataLog = "";
    static String currentDirectory = System.getProperty("user.dir");
    
    //NOTE - CONFIGURE BEFORE USE!! MAC = 1, PC = 2
    static int userNum = 2;
    // return current date/time in readable format
    public static String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return (formatter.format(date));
    }
    
    public static String nameByDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy'A'");
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

        //add 30 sec implicit wait for variable connection speeds
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // execute test methods in sequence
        searchGoogle(driver);
        loginTestArea(driver);
        // testHomeModule(driver);
        //Thread.sleep(3000);
        testChallenges(driver);
        //testPublish(driver);
        testFeed(driver);
        // close the browser
        //Thread.sleep(5000);
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
        
        try {
        	//Thread.sleep(1500);
        WebElement searchField = wd.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
        WebElement searchButton = wd
                .findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
        searchField.click();
        searchField.sendKeys("socialladder");
        searchButton.click();
        } catch (Exception e) {
        	System.out.println(e);
        }
        
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
        //Thread.sleep(2000);
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

            //Thread.sleep(3000);
            WebElement createButton = wd.findElement(By.xpath("//button[@class=\"md-primary md-raised md-button md-ink-ripple\"]"));
            createButton.click();

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            //Thread.sleep(3000);
            WebElement surveyButton = wd.findElement(By.xpath("/html/body/div[3]/md-dialog/div/div/section[2]/"
            		+ "section[2]/div[1]/section[1]/div/section[2]/section/div[2]"));
           
            surveyButton.click();
        } catch (Exception e) {
            System.out.println(e);
        }
        
      try {
    	  //Thread.sleep(1000);
        
    	  WebElement surveyName = wd.findElement(By.xpath("/html/body/div[3]"
        		+ "/md-dialog/div/div/section[2]/section[2]/div[2]/section/div[3]"
        		+ "/md-input-container/div[1]/textarea"));
        surveyName.click();
        surveyName.sendKeys("Regression Test " + nameByDate());
      } catch (Exception e) {
    	  System.out.print(e);
      }
        
        try {
        	//Thread.sleep(3000);
        WebElement nextButton = wd.findElement(By.xpath("/html/body/div[3]"
        		+ "/md-dialog/div/div/section[3]/div[2]/button"));
        	nextButton.click();
        
        } catch (Exception e) {
        	System.out.print(e);
        
        }
        
        try {
        	//Thread.sleep(3000);
        	WebElement nextButton = wd.findElement(By.xpath("/html/body/div[3]"
        			+ "/md-dialog/div/div/section[3]/div[2]/button"));
        	nextButton.click();
        } catch (Exception e) {
        	System.out.print(e);
        }
        
        try {
        	//Thread.sleep(3000);
        
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
        option1Input.sendKeys(nameByDate());
   
        WebElement option2Input = wd.findElement(By.xpath("/html/body/div[3]"
        		+ "/md-dialog/div/div/section[2]/section[2]/div[5]/section[6]/div[2]/div/div/div/ul[2]/li/ul/li"
        		+ "/md-input-container/div[1]/textarea"));
        option2Input.click();
        option2Input.sendKeys("Incorrect");
     
        
        
      try {
    	  //Thread.sleep(1000);
      
        WebElement nextButton = wd.findElement(By.xpath("/html/body/div[3]"
        		+ "/md-dialog/div/div/section[3]/div[2]/button"));
        nextButton.click();
      } catch (Exception e) {
    	  System.out.print(e);
      }
      
      try {
    	  //Thread.sleep(1000);
      
        WebElement nextButton = wd.findElement(By.xpath("/html/body/div[3]"
        		+ "/md-dialog/div/div/section[3]/div[2]/button"));
        nextButton.click();
      } catch (Exception e) {
    	  System.out.print(e);
      }

      	try {
      		//Thread.sleep(2000);
      	WebElement challengeDescription = wd.findElement(By.xpath("/html/body/div[3]"
      			+ "/md-dialog/div/div/section[2]/section[2]/div[6]"
      			+ "/section/div[3]/div/md-input-container/div[1]/textarea"));
      	challengeDescription.click();
      	challengeDescription.sendKeys("AUTO GENERATED CHALLENGE FOR REGRESSION TEST " + nameByDate());
      	} catch (Exception e) {
      		System.out.print(e);
      	}
      	
      	try {
      	  //Thread.sleep(1000);
        
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
        	  //Thread.sleep(1000);
          
            WebElement nextButton = wd.findElement(By.xpath("/html/body/div[3]"
            		+ "/md-dialog/div/div/section[3]/div[2]/button"));
            nextButton.click();
          } catch (Exception e) {
        	  System.out.print(e);
          }
      	try{
              //Thread.sleep(1000);
      	WebElement savePublish = wd.findElement(By.xpath("/html/body/div[3]/md-dialog/div/div/section[2]/section[2]/div[8]/section[2]/div[1]"));
        savePublish.click();
        } catch (Exception e) {
            System.out.print(e);
        }
      	
      	try { 
      		//Thread.sleep(3000);
      	
      	WebElement submitBtn = wd.findElement(By.xpath("/html/body/div[3]/md-dialog/div/div/section[3]/div[3]/button/span"));
      	submitBtn.click();
      	} catch (Exception e) {
      	System.out.print(e);
    }
//    	WebElement exitChallenge = wd.findElement(By.xpath("/html/body/div[3]/md-dialog/div/div/section[1]/span/i"));
//    	exitChallenge.click();
//    	
//    	try{
//            //Thread.sleep(3000);     
//            WebElement exitYes = wd.findElement(By.xpath("/html/body/div[9]/md-dialog/md-dialog-actions/button[2]"));
//            exitYes.click();
//            } catch(Exception e){
//            System.out.println("Exception caught: \n"); e.printStackTrace();}
        }
      	      	   
    
    public static void testFeed(WebDriver wd) {

    	WebElement feed = wd.findElement(By.xpath("/html/body/main-component/div/menu-component/md-sidenav/nav/a[7]"));
    	feed.click();
    
        WebElement createButton = wd.findElement(By.xpath("/html/body/main-component/div/div/div/div/div[1]/div[1]/button"));
        createButton.click();

        try { 
        	//Thread.sleep(3000);
        
        WebElement feedName = wd.findElement(By.xpath("/html/body/div[7]/md-dialog/section/div[2]/div[1]/input"));
        feedName.click();
        feedName.sendKeys("Regression Test " + nameByDate());
        
        WebElement textOverlay = wd.findElement(By.xpath("/html/body/div[7]/md-dialog/section/div[2]/div[2]/input"));
        textOverlay.click();
        textOverlay.sendKeys(nameByDate());
        
        WebElement notificationText = wd.findElement(By.xpath("/html/body/div[7]/md-dialog/section/div[2]/div[3]/input"));
        notificationText.click();
        notificationText.sendKeys(nameByDate());
        
        } catch (Exception e) {
        	System.out.println(e);
        }
         
        WebElement dropDown = wd.findElement(By.xpath("/html/body/div[7]/md-dialog/section/div[2]/div[7]/div/md-select"));
        dropDown.click();
    
        		
        WebElement challengeOption = wd.findElement(By.xpath("/html/body/div[8]/md-select-menu/md-content/md-option[3]"));
        challengeOption.click();
        
        WebElement dropDown2 = wd.findElement(By.xpath("/html/body/div[7]/md-dialog/section/div[2]/div[8]/md-select"));
        dropDown2.click();
        
        try {
        	//Thread.sleep(3000);
        
        WebElement allUsers = wd.findElement(By.xpath("/html/body/div[9]/md-select-menu/md-content/md-option[2]"));
        allUsers.click();
        } catch (Exception e) {
        	System.out.print(e);
        }       
        
        WebElement directChallenge = wd.findElement(By.xpath("/html/body/div[7]/md-dialog/section/div[2]/div[7]/div/md-select[2]"));
        directChallenge.click();
        
        try {
        	//Thread.sleep(3000);
        
        WebElement releaseTest = wd.findElement(By.xpath("/html/body/div[10]/md-select-menu/md-content/md-option[1]"));
        releaseTest.click();
        } catch (Exception e) {
        	System.out.print(e);
        }
        
//        WebElement link = wd.findElement(By.xpath("/html/body/div[7]/md-dialog/section/div[2]/div[7]/div/input"));
//        link.click();
//        link.sendKeys("https://socialladder.rkiapps.com/portal/#/challenges");
  
        WebElement save = wd.findElement(By.xpath("/html/body/div[7]/md-dialog/section/div[3]/button[1]"));
        save.click();
        
        WebElement savePublish = wd.findElement(By.xpath("/html/body/div[7]/md-dialog/section/div[3]/button[2]"));
        savePublish.click();
 
        }
        
    
}
    
    
    
    
