package MainProject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WithInitialLogin extends ProjectMethods {
	
	@BeforeTest
	public void BeforeInitialLogin() {
		StartBrowser();
		MaximizeWindow();
		deleteCookies();
	}
	
	@Test
	public void StartInitialLoginTest() throws InterruptedException {
		LoadWeb();
		ClickFaceIcon();
		Login();
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
		ScrollDownToView();
		Thread.sleep(2000);
		//WaitForConfirmpaybtn();
		ConfirmAndPay();
		switchframe();
		WaitForPayButton();
		EnterEmailAddress("uday.janoos@gmail.com");
		ClickProccedPayment();
		Thread.sleep(2000);
		ChoosePhonePe();
		Thread.sleep(3000);
		ClickProccedPayment();
		SwitchToPaymentWindow();
		ScrollUpToView();
		ShowQRCode();
		WaitForPayment();
		SwitchToParentWindow();
		Thread.sleep(3000);
		GoToOrders();
		WaitforSubscriptionPage();	
		Thread.sleep(8000);
		refreshSubscriptionPage();
		ClickPauseButton();
		ClickPause();
		
	}
	
	@AfterTest
	public void AfterInitialLoginTest() throws InterruptedException {
		Logout();
		quit();
	}

}
