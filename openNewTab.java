package MainProject;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class openNewTab {
	static WebDriver Driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		Driver=new ChromeDriver();
		Driver.get("https://www.google.com");
		String MainPage=Driver.getWindowHandle();
		System.out.println("Google Page Winodw Handle"+" "+MainPage);
		Driver.switchTo().newWindow(WindowType.TAB);
		Driver.navigate().to("https://www.facebook.com");
		WebDriverWait wait =new WebDriverWait(Driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> AllWindowHandles =Driver.getWindowHandles();
		 String FacebookWindowHandle = null;
		for(String SinglwWindowHandle:AllWindowHandles) {
			if(!MainPage.contentEquals(SinglwWindowHandle)) {
				 FacebookWindowHandle =SinglwWindowHandle;
				System.out.println("FacebookWindowHandle is"+ " " + FacebookWindowHandle);
				//Driver.switchTo().window(MainPage);
				break;
			}
		}
		Driver.switchTo().newWindow(WindowType.TAB);
		Driver.navigate().to("https://www.Gmail.com");
		Set<String> ThreeHandles=Driver.getWindowHandles();
		//System.out.println(ThreeHandles);
		String GmailHandle = null;
		for(String Windowhandle:ThreeHandles) {
			if(!(Windowhandle.contentEquals(FacebookWindowHandle)||Windowhandle.contentEquals((MainPage)))) {
			 GmailHandle = Windowhandle;
			System.out.println("Gmail Winodw page handle is"+" "+GmailHandle);
			}
		}
		Driver.switchTo().newWindow(WindowType.TAB);
		Driver.navigate().to("https://www.appsandwebs.net");
		Set<String> FourHandles =Driver.getWindowHandles();
		System.out.println(FourHandles);
		String AppsWindowHandle= null;
		for(String UnvHandle:FourHandles) {
			if(!(UnvHandle.contentEquals(FacebookWindowHandle)||UnvHandle.contentEquals(MainPage)||UnvHandle.contentEquals(GmailHandle))) {
				AppsWindowHandle=UnvHandle;
				System.out.println("Window Handle for the Appstallions"+" "+AppsWindowHandle);
			}
					
		}
		
		Driver.switchTo().window(MainPage);
		Thread.sleep(2000);
		Driver.switchTo().window(AppsWindowHandle);
		Thread.sleep(2000);
		Driver.switchTo().window(GmailHandle);
		Thread.sleep(2000);
		Driver.switchTo().window(FacebookWindowHandle);
		Thread.sleep(2000);
		Driver.switchTo().window(MainPage);
		Thread.sleep(2000);
		Driver.switchTo().window(FacebookWindowHandle);
		

	}

}
