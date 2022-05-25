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
		WaitForFusionVeganToLoad();
		clickFusionVegan();
		ManageMyWeight();
		WaitForMaleToLoad();
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
		SelectDate(31);
		AddTocart();
		WaitForShoppingCartToLoad();
		ScrollToElement();
		WaitForConfirmAndPayToAppear();
		ConfirmAndPay();
		WaitForFrameToLoad();
		//switchframe();
		WaitForEmailField();
		EnterEmailAddress("uday.janoos@gmail.com");
		ClickProccedPayment();
		WaitForPhonePeOptionToAppear();
		ChoosePhonePe();
		WaitForPayButtonToAppear();
		ClickProccedPayment();
		SwitchToPaymentWindow();
		WaitForPaymentWindowToLoad();
		scrollUpToQRCode();
		WaitForQRCode();
		ShowQRCode();
		WaitForPayment();
		SwitchToParentWindow();
		Thread.sleep(4000);
		GoToOrders();		
		WaitforSubscriptionPage();	
		refreshSubscriptionPage();
		WaitforSubscriptionPage();
		ClickPauseButton();
		ClickPause();
		
	}
	
	@AfterTest
	public void AfterInitialLoginTest() throws InterruptedException {
		Logout();
		quit();
	}

}
