package MainProject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProjectMethods extends BaseMethods {
	static String Main;
	static Actions builder;
	
	public void LoadWebUrl() {
		Driver.get(BaseParameters.URL);
	}
	
	public void ClickGetStarted()
	{
		Xidentifier(BaseParameters.GetStartedBtn);
		click(Element);
	}
	
	public void clickFusionVegan() {
		Xidentifier(BaseParameters.FusionVegan);
		click(Element);
	}
	public void ManageMyWeight() {
		Xidentifier(BaseParameters.ManageWeight);
		click(Element);
	}
	public void ClickOnMale() {
		Xidentifier(BaseParameters.ChooseMale);
		click(Element);
	}
	public void ChooseHeight(int Feet, int Inch) throws InterruptedException {
		String DefFeet= Xidentifier(BaseParameters.HeightFeet).getText();
		int NumFeet = Integer.parseInt(DefFeet);
		String DefInch = Xidentifier(BaseParameters.HeightInch).getText();
		int NumInch = Integer.parseInt(DefInch);
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
				
				click(Xidentifier(BaseParameters.PlusFeet));
				Thread.sleep(2000);
				DefFeet=Xidentifier(BaseParameters.HeightFeet).getText();
				 NumFeet = Integer.parseInt(DefFeet);
			}
		}
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
	
	public void SelectWeight(int Weight) {
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
	public void SelectAge(int Age) {
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
	
	public void ClickOnNext() {
		Xidentifier(BaseParameters.ClickNext);
		click(Element);
	}
	public void ScrollDownToView() {
		builder = new Actions(Driver);
		builder.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	public void ScrollUpToView() {
		builder = new Actions(Driver);
		builder.sendKeys(Keys.PAGE_UP).build().perform();
	}
	
	public void clickCalendar() {
		Xidentifier(BaseParameters.ClickCalender);
		click(Element);
	}
	
	public void ChooseBreakfast() {
		Xidentifier(BaseParameters.Breakfast);
		click(Element);
	}
	public void SelectPickup() {
		Xidentifier(BaseParameters.SelectPickUp);
		click(Element);
	}
	public void SelectDelivery() {
		Xidentifier(BaseParameters.Delivery);
		click(Element);
	}
	public void EnterServiceablePincode() throws InterruptedException {
		builder = new Actions(Driver);
		sendkeys(Xidentifier(BaseParameters.PincodeField),BaseParameters.ServiceablePincode);
		Thread.sleep(2000);
		builder.keyDown(Keys.CONTROL);
		builder.sendKeys("A");
		builder.keyUp(Keys.CONTROL);
	    builder.build().perform();
	    builder.keyDown(Keys.CONTROL);
		builder.sendKeys("C");
		builder.keyUp(Keys.CONTROL);
	    builder.build().perform();
	    builder.keyDown(Keys.CONTROL);
		builder.sendKeys("X");
		builder.keyUp(Keys.CONTROL);
	    builder.build().perform();
	    builder.keyDown(Keys.CONTROL);
		builder.sendKeys("V");
		builder.keyUp(Keys.CONTROL);
	    builder.build().perform();
		
	}
	public void EnterNonServiceablePincode() throws InterruptedException {
		builder = new Actions(Driver);
		sendkeys(Xidentifier(BaseParameters.PincodeField),BaseParameters.NonServiceablePincode);
		Thread.sleep(2000);
		builder.keyDown(Keys.CONTROL);
		builder.sendKeys("A");
		builder.keyUp(Keys.CONTROL);
	    builder.build().perform();
	    builder.keyDown(Keys.CONTROL);
		builder.sendKeys("C");
		builder.keyUp(Keys.CONTROL);
	    builder.build().perform();
	    builder.keyDown(Keys.CONTROL);
		builder.sendKeys("X");
		builder.keyUp(Keys.CONTROL);
	    builder.build().perform();
	    builder.keyDown(Keys.CONTROL);
		builder.sendKeys("V");
		builder.keyUp(Keys.CONTROL);
	    builder.build().perform();
	    String Expected = "Unfortunately our services are not available in your area, please give a call to arrange alternate delivery options";
	    ReadText(Xidentifier(BaseParameters.ReadBodyText));
	    if(readtext.contains(Expected)) {
	    	System.out.println("Non serviceable pincode");
	    }
	    Assert.assertEquals(readtext.contains(Expected),"Failed Test Case");	
	}
	
	public void EnterAddressDetails() throws InterruptedException {
		builder  = new Actions(Driver);
		sendkeys(Xidentifier(BaseParameters.AddressField),"Manikonda");
		Thread.sleep(2000);
		
		sendkeys(Xidentifier(BaseParameters.HouseOrFlatNo),"LH-15");
		sendkeys(Xidentifier(BaseParameters.AppartmentOrRoad),"LancoHills");
		sendkeys(Xidentifier(BaseParameters.LandMark),"Manikonda Circle");
		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(Xidentifier(BaseParameters.ClickEnterAfterEnteringAddress)));
		click(Xidentifier(BaseParameters.ClickEnterAfterEnteringAddress));
	}
	public void SelectPlan() {
		Xidentifier(BaseParameters.SelectPlan);
		click(Element);
	}
	public void AddTocart() {
		Xidentifier(BaseParameters.AddtocartBtn);
		click(Element);
	}
	public void SelectDate(int Mydate) {
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
	public void NewLogin(String number,String Name, String pass) {
		sendkeys(Xidentifier(BaseParameters.PhoneNumberField), number);
		sendkeys(Xidentifier(BaseParameters.NameField), Name);
		sendkeys(Xidentifier(BaseParameters.PassewordField), pass);
		click(Xidentifier(BaseParameters.SignupButton));
	}
	
	public void IferrorSigning() {
		ReadText(Xidentifier(BaseParameters.ReadBodyText));
		if(readtext.contains("Please enter a valid phone number")) {
			System.out.println("Enter a valid 10 digit Number");
		}
		Xidentifier(BaseParameters.PhoneNumberField).clear();
	}
	public void ClickToLogin() {
		Xidentifier(BaseParameters.AlreadyHaveAccount);
		click(Element);	
	}
	public void ClickFaceIcon() {
		click(Xidentifier(BaseParameters.FaceIcon));
	}
	public void Login() throws InterruptedException {
		sendkeys(Xidentifier(BaseParameters.PhoneNumberField),BaseParameters.PhoneNumber);
		sendkeys(Xidentifier(BaseParameters.PassewordField),BaseParameters.Password);
		Thread.sleep(2000);
		ReadText(Xidentifier(BaseParameters.ReadBodyText));
		if(readtext.contains("Please enter a valid phone number")) 
		{	
		
			System.out.println("Sign in Failed - Please Enter a Valid Phone Number");	
			quit();
			System.exit(0);
		}
		click(Xidentifier(BaseParameters.SubmitButton));
		Thread.sleep(3000);
		ReadText(Xidentifier(BaseParameters.ReadBodyText));
		if(readtext.contains("Incorrect username or password."))
		{
			System.out.println("Sign in failed due to Invalid Credentials");
			quit();
			System.exit(0);
		}
		System.out.println("Login Successfull");
	}
	
	public  void WaitForConfirmpaybtn(){
	
	}
	public void ConfirmAndPay() {
//		builder = new Actions(Driver);
//		Point p = Xidentifier(BaseParameters.ConfirmPayBtn).getLocation();
//		int xcord = p.getX();
//		int ycord = p.getY();
//		builder.moveByOffset(xcord, ycord).click().build().perform();
		click(Xidentifier(BaseParameters.ConfirmPayBtn));
	}
	
	public void switchframe() {
		Switchtoframe(BaseParameters.SwitchToframe);
	}
	public void EnterEmailAddress(String Email) {
		
		sendkeys(Xidentifier(BaseParameters.EmailField), Email);
	}
	public void ClickProccedPayment() {
		click(Xidentifier(BaseParameters.ProceedPaymentBtn));
	}
	public void ChoosePhonePe() {
		 Main = Driver.getWindowHandle();
		click(Xidentifier(BaseParameters.SelectPhonePe)); 
	}
	
	public void WaitForPayButton() {
		 WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(Xidentifier(BaseParameters.EmailField)));
	}
	
	public void SwitchToPaymentWindow() {
		Set<String> handle = Driver.getWindowHandles();
		Iterator<String> I1= handle.iterator();
		while(I1.hasNext()) {
			String subchild = I1.next();
			if(!Main.equals(subchild)) {
				Driver.switchTo().window(subchild);
			}
		}
		
	}
	public void WaitForPayment() {
		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofMinutes(8));
		wait.until(ExpectedConditions.invisibilityOf(Xidentifier(BaseParameters.Visbilitycheck)));
	}

	public void SwitchToParentWindow() {
	Driver.switchTo().window(Main);	
	}
	
	public void ShowQRCode() {
		click(Xidentifier(BaseParameters.QRCode));
	}
	public void GoToOrders() {
		click(Xidentifier(BaseParameters.GotoOrders));
	}
	
	public void WaitforSubscriptionPage() {
		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Xidentifier(BaseParameters.PauseButton)));
		while(!(Xidentifier(BaseParameters.CheckForSubscriptions).isDisplayed())) {
		if(Xidentifier(BaseParameters.CheckForSubscriptions).isDisplayed()) {
			System.out.println("Take a look at your Orders");
		}
		else {
		
		Driver.navigate().refresh();
			}
		}
	}
	
	public void Logout() throws InterruptedException {
		click(Xidentifier(BaseParameters.MenuBar));
		Thread.sleep(3000);
		click(Xidentifier(BaseParameters.ClickLogout));
		System.out.println("Logged out successfully");
	}
	public void closeBrowser() {
		quit();
	}
	public void ClickPauseButton() {
		click(Xidentifier(BaseParameters.PauseButton));
				
	}
	public void ClickPause() throws InterruptedException {
		click(Xidentifier(BaseParameters.ClickPauseBtn));
		Thread.sleep(8000);
		click(Xidentifier(BaseParameters.ClickOk));
		Thread.sleep(8000);
		click(Xidentifier(BaseParameters.ClickOk));
	
	}
	
	public void refreshSubscriptionPage() {
		Driver.navigate().refresh();
	}
	
	public void SendKeysUsingJS() {
		Element = Xidentifier(BaseParameters.PincodeField);
		JavascriptExecutor js = (JavascriptExecutor)Driver;
		js.executeScript("arguments[0].value='500089';", Element);
	}
	
}


