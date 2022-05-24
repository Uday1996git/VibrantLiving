package MainProject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeliveryForNonServiceablePinCode extends ProjectMethods{

	@BeforeTest
	public void BeforeNonServiceablePoncodeTest() {
		StartBrowser();
		MaximizeWindow();
		deleteCookies();
		
	}
	
	@Test
	public void StartNonServiceabletest() throws InterruptedException {
		LoadWeb();
		ClickFaceIcon();
		Login();
		Thread.sleep(2000);
		ClickGetStarted();
		Thread.sleep(2000);
		clickFusionVegan();
		Thread.sleep(2000);
		ManageMyWeight();	
		Thread.sleep(2000);
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
		SelectDelivery();
		//SendKeysUsingJS();
		EnterNonServiceablePincode();
	}
	@AfterTest
	public void EndTestIfPass() throws InterruptedException {
	Logout();
	closeBrowser();
	}
}
