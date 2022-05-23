package MainProject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PauseOrder extends ProjectMethods {

	@BeforeTest()
	public void beforeTest() throws InterruptedException 
	{
		StartBrowser();
		MaximizeWindow();
		deleteCookies();
		
	}
	@Test()
	public void StartTesting() throws InterruptedException 
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
		ScrollDownToView();
		Thread.sleep(8000);
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
		WaitforSubscriptionPage();	
		Thread.sleep(8000);
		refreshSubscriptionPage();
		ClickPauseButton();
		ClickPause();
	}
	
	@AfterClass()
	public void Endtesting() throws InterruptedException 
	{
		Logout();
		quit();
	}
}
