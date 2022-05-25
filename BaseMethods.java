package MainProject;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseMethods  {
	protected static WebDriver Driver;
	protected static ExtentReports extent;
	protected static ExtentTest logger;
	protected static Properties obj;
	protected static String StringToBeUsed;
	protected static String readtext;
	protected static Actions builder;
	protected static WebElement Element;
	
	//Invoke the chromeDriver
	public static  void  StartBrowser() {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.edgedriver().setup();
		String Browser = BaseParameters.Browser;
		if(Browser.contains("Chrome")) {
			
			Driver = new ChromeDriver();
		}
		else if(Browser.contains("Firefox")) {
			Driver = new FirefoxDriver();
		}
		else if(Browser.contains("Edge")) {
			Driver = new EdgeDriver();
		}
		
		
	}
	
	//Get method
	public void LoadWeb() {
		Driver.get(BaseParameters.URL);
	}
	
	//Click a webelement
	public void click(WebElement Element) {
		Element.click();
	}
	
	//sendkeys to a webelement
	public void sendkeys(WebElement Element,String Text) {
		Element.sendKeys(Text);
	}
	
	//scroll to an element
	public void scrollToView() {
		builder = new Actions(Driver);
		builder.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
	
	//Quit Browser
	public void quit() {
		Driver.quit();
	}
	
	//xpath identifier
	public  WebElement Xidentifier( String Name) {
		 Element = Driver.findElement(By.xpath(Name));
		 return Element;
	}
	//css selector
	public WebElement Css(String Css) {
		return Driver.findElement(By.cssSelector(Css));
	}
	//Switch to a Frame using WebIdentifier
	public void Switchtoframe(String Iframe) {
		Driver.switchTo().frame(Driver.findElement(By.xpath(Iframe)));
	}
	
	//Extent reports
	public void Extentreport(String Reportname, String ReportDescription, String LogDescription) {
	ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(Reportname);
	 extent = new ExtentReports();
	 extent.attachReporter(htmlreporter);
	 logger = extent.createTest(ReportDescription);
	 logger.log(Status.INFO, LogDescription);
	}
	
	//take a screenshot 
	public void Takescreenshot(String fileWithPath) {
	TakesScreenshot scrShot =((TakesScreenshot)Driver);
	//File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	File DestFile=new File(fileWithPath);
	//FileUtils.copyFile(SrcFile, DestFile);
	//FileUtils.copyFile(	screenshotFile , new File("C:\\temp\\screenshot.png"));
	}
	
	//Maximize Window
	public void MaximizeWindow() {
		Driver.manage().window().maximize();
	}
	
	//Wait for a element
	public void waitForElement(String xpathOfElement) {
		 WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathOfElement)));
	}
	
	//Verify if the text is visible
	public void VerifyText(WebElement Element, String TextToVerify) {
		if(Element.getText().equals(TextToVerify)) 
		{
			System.out.println("Text enterted is present");
		}
		else {
			System.out.println("Text is not present");
		}
	}
	
	//Delete all the cookies
	public void deleteCookies() {
		Driver.manage().deleteAllCookies();
	}
	
	//Compare the Strings
	public void validateString(WebElement Element ,String ExpectedText) {
		String Actual = Element.getText();
		assertEquals(ExpectedText,Actual);
	}
	
	//Check if the webelement is present
	public void checkElement(String XpathOfTheElements) {
		List<WebElement> Elements = Driver.findElements(By.xpath(XpathOfTheElements));
		if(Elements.size()==0) {
			System.out.println("Element is not present");
		}
		else {
			System.out.println("At least Element is Present with the web identifier");
		}	
		
	}
	
	
	//Implicit Wait
	public void Implicitwait() {
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	//PropertiesFile
	public void PropertiesFile(String FilePath) throws IOException {
		  obj = new Properties();
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+FilePath);									
		    obj.load(objfile);
	}
	
	//Get Object Property
	public void getobj(String StringNameOnPropfile) {
		 StringToBeUsed =obj.getProperty(StringNameOnPropfile);
	}
	
	//get text
	public void ReadText(WebElement Element) {
		readtext = Element.getText();
	}
	
	//Pick the heightFeet
	public void HeightFeet(int Feet) throws InterruptedException {
		String DefFeet= Xidentifier(BaseParameters.HeightFeet).getText();
		int NumFeet = Integer.parseInt(DefFeet);
		while(!(Feet==NumFeet)) 
		{
			if(Feet<NumFeet) 
			{
			click(Xidentifier(BaseParameters.MinusFeet));
			Thread.sleep(2000);
			DefFeet=Xidentifier(BaseParameters.HeightFeet).getText();
			 NumFeet = Integer.parseInt(DefFeet);
			}
		
			else if(Feet>NumFeet) {
				 
				{
				click(Xidentifier(BaseParameters.PlusFeet));
				Thread.sleep(2000);
				DefFeet=Xidentifier(BaseParameters.HeightFeet).getText();
				 NumFeet = Integer.parseInt(DefFeet);
				}
			}
		}
			
	
	}
	
	
	//Pick the height Inch
	public void HeightInch(int Inch) throws InterruptedException {
		String DefInch = Xidentifier(BaseParameters.HeightInch).getText();
		int NumInch = Integer.parseInt(DefInch);
		builder = new Actions(Driver);
		while(!(NumInch==Inch)) 
		{
			if(Inch<NumInch)
			{
				click(Xidentifier(BaseParameters.MinusInch));
				Thread.sleep(2000);
				DefInch = Xidentifier(BaseParameters.HeightInch).getText();
				NumInch = Integer.parseInt(DefInch);
			}
		
			else if(Inch>NumInch) 
			{
				click(Xidentifier(BaseParameters.PlusInch));
				Thread.sleep(2000);
				DefInch = Xidentifier(BaseParameters.HeightInch).getText();	
				NumInch = Integer.parseInt(DefInch);
			}	
		}
	}
	
	//Set Weight
	
	public void setWeight(int Weight) 
	{
		String DefWeight = Xidentifier(BaseParameters.WeightDisplayed).getText();
		int defweight = Integer.parseInt(DefWeight);
		while(!(Weight==defweight))
		{
			if(Weight<defweight)
			{
				click(Xidentifier(BaseParameters.MinusWeight));
				
			}
			else if(Weight>defweight)
			{
				click(Xidentifier(BaseParameters.PlusWeight));
			}
			DefWeight = Xidentifier(BaseParameters.WeightDisplayed).getText();
			defweight = Integer.parseInt(DefWeight);
		}
		
	}
	
	//Set Age
	public void setAge(int Age) {
		String DefAge = Xidentifier(BaseParameters.AgeDisplayed).getText();
		int defage = Integer.parseInt(DefAge);
		while(!(Age==defage)) 
		{
			if(Age<defage) 
			{
				click(Xidentifier(BaseParameters.MinusAge));
			}
			else if(Age>defage)
			{
				click(Xidentifier(BaseParameters.PlusAge));
			}
			DefAge = Xidentifier(BaseParameters.AgeDisplayed).getText();
			defage = Integer.parseInt(DefAge);
		}
	}
	
	//Enter Pincode
	public void Pincode(String pincode) 
	{
		sendkeys(Xidentifier(BaseParameters.PincodeField),pincode);
	}
	
	//Date Picker
	public void DatePicker(int Mydate)
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		outer:for(int i=2;i<7;i++) {
			String todaydate = Xidentifier(BaseParameters.TodayDate).getText();
			int numdate = Integer.parseInt(todaydate);
			if(Mydate<=numdate) 
			{
				System.out.println("Enter a valid date");
					break outer;
			}
			
		List<WebElement> dates= Driver.findElements(By.xpath("//div[@class='rmdp-week']["+i+"]//div//span"));
		for(WebElement Date:dates) {
			String str= Date.getText();
			arr.add(Integer.parseInt(str));
			for(int t=0;t<arr.size();t++) 
			{
				if(arr.get(t)==Mydate) {
					click(Date);
					break outer;
				}
			}
		}
	}
		
	}
	
	
	
}
