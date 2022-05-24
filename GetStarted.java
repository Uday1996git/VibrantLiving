package MainProject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetStarted extends ProjectMethods {
	
	@BeforeTest()
	public void BeforeTesting() {
		StartBrowser();
		MaximizeWindow();
		deleteCookies();	
	}
	@Test()
	public void StartTest() throws InterruptedException
	{
		LoadWebUrl();
		Implicitwait();
		ClickGetStarted();
		clickFusionVegan();
		ManageMyWeight();	
		ClickOnMale();
		ChooseHeight(5,8);
		SelectWeight(85);
		SelectAge(27);
		ClickOnNext();
		Thread.sleep(1000);
		ChooseBreakfast();
		Thread.sleep(1000);
		ScrollDownToView();
		Thread.sleep(3000);
		SelectPickup();
		SelectPlan();
		clickCalendar();
		SelectDate(23);
		AddTocart();
		NewLogin("1234567890","Userx","Qwerty");
		IferrorSigning();
		ClickToLogin();
		Login();
		Thread.sleep(2000);
		ScrollDownToView();
		Thread.sleep(10000);
		//WaitForConfirmpaybtn();
		ConfirmAndPay();
		switchframe();
		WaitForPayButton();
		EnterEmailAddress("uday.janoos@gmail.com");
		ClickProccedPayment();
		Thread.sleep(2000);
		ChoosePhonePe();
		Thread.sleep(8000);
		ClickProccedPayment();
		SwitchToPaymentWindow();
		ScrollUpToView();
		ShowQRCode();
		WaitForPayment();
		SwitchToParentWindow();
		Thread.sleep(4000);
		GoToOrders();
		
	}
	
	@AfterTest()
	public void EndTest() throws InterruptedException {
		WaitforSubscriptionPage();	
		Logout();
		closeBrowser();
	}
}
