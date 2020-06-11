# seleniumSL2020 for Java.

## Installations

* To download Selenium, click [here](https://www.selenium.dev/downloads/)
* To download the Eclipse IDE, click [here](https://www.eclipse.org/downloads/)
* To install ChromeDriver, click [here](https://sites.google.com/a/chromium.org/chromedriver/)
* **NOTE: if you are not using ChromeDriver, other WebDrivers are available on the Selenium download page**

## Setup
1. Once everything is installed, open the Eclipse IDE.
2. Change your workspace if you desire by adding its name before /Workspace.
3. Create a new Java project.
4. Add Selenium External Jar files to your project. You can do this by: 
   * Right clicking on your Java project
   * Navigate to Build Path, then click on Add External Archives
   * Look for your Selenium download file, and import all .jar files

5. In this case, we are using ChromeDriver. Import a WebDriver for your Selenium project using this syntax:
   * ``` import org.openqa.selenium.WebDriver; ```

6. To test if your WebDriver works:
   * ``` public static void main(final String[] args) ```
   * ```System.setProperty("webdriver.chrome.driver","INSERT YOUR WEBDRIVER DIRECTORY LOCATION HERE"); ```
   
7. If that doesn't work, you might have to initialize your directory by:
   * Opening your command prompt.
   * Typing in the "command chmod +x" followed by the WebDriver directory.
   
8. Once all this is complete, your Selenium should be set up. Happy Seleniuming!
