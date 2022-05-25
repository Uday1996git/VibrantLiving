package MainProject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeliveryForServiceableArea extends ProjectMethods{
	@BeforeTest
	public void BeforeServiceableAreaTest() {
		StartBrowser();
		MaximizeWindow();
		deleteCookies();
	}
	
	@Test
	public void StartTestingForServiceableArea() throws InterruptedException {
		LoadWeb();
		Implicitwait();
		ClickFaceIcon();
		Login();
		ClickGetStarted();
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
		Thread.sleep(2000);
		SelectDelivery();
		EnterServiceablePincode();
		EnterAddressDetails();
		Thread.sleep(1000);
		ScrollDownToView();
		Thread.sleep(1000);
		SelectPlan();
		clickCalendar();
		WaitForCalendarToLoad();
		SelectDate(31);
		AddTocart();
		ScrollToElement();
		ConfirmAndPay();
		//switchframe();
		WaitForFrameToLoad();
		EnterEmailAddress("uday.janoos@gmail.com");
		ClickProccedPayment();
		WaitForPhonePeOptionToAppear();
		ChoosePhonePe();
		WaitForPayButtonToAppear();
		ClickProccedPayment();
		SwitchToPaymentWindow();
		ScrollUpToView();
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
	
	@AfterTest()
	public void EndServiceableTest() throws InterruptedException {
		Logout();
		closeBrowser();
	}

}
