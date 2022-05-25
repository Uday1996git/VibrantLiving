package MainProject;

public class BaseParameters {
	public static String Browser = System.getProperty("Browser", "Chrome");
	public static String URL = System.getProperty("URL", "https://daily.vibrantliving.in/");
	public static String ReadBodyText = "//body";
	public static String MenuBar = "//img[@src='/static/media/search-normal.dd99156f.svg']";
	public static String FaceIcon = "//img[@src='/static/media/smile.eeafb11c.svg']";
	public static String LoginButton = "//*[contains(text(),'Log In')]";
	public static String SignupButton = "//button[@type='submit']";
	public static String PhoneNumberField ="//input[@name='phone']";
	public static String PhoneNumber= System.getProperty("PhoneNumber","6281219339");
	public static String NameField= "//input[@name='name']";
	public static String UserName= System.getProperty("UserName","User");
	public static String PassewordField = "//input[@name='password']";
	public static String Password =System.getProperty("Password","Number@1");
	public static String SubmitButton ="//button[@type='submit']";
	public static String ClickLogout = "//*[contains(text(),'Log Out')]";
	public static String GetStartedBtn = "//a[@class='mb-0 px-7']";
	public static String FusionVegan = "//*[contains(text(),'Fusion Vegan')]";
	public static String ManageWeight = "//*[contains(text(),'Manage My Weight')]";
	public static String ChooseMale = "//img[@src='/static/media/male.8b3d1fd2.svg']";
	public static String HeightFeet = "//div[@class='personal-info-step']//div[2]/div[1]/div/div";
	public static String HeightInch = "//div[@class='personal-info-step']//div[2]/div[2]/div/div";
	public static String MinusFeet = "//div[@class='personal-info-step']//div[2]/div[1]/div[1]/button[1]";
	public static String PlusFeet = "//div[@class='personal-info-step']//div[2]/div[1]/div[1]/button[2]";
	public static String MinusInch = "//div[@class='personal-info-step']//div[2]/div[2]/div/button[1]";
	public static String PlusInch = "//div[@class='personal-info-step']//div[2]/div[2]/div/button[2]";
	public static String WeightDisplayed = "//div[@class='personal-info-step']//div[3]//div[1]//div//div";
	public static String AgeDisplayed= "//div[@class='personal-info-step']//div[3]//div[2]//div//div";
	public static String MinusWeight = "//div[@class='personal-info-step']//div[3]//div[1]/div/button[1]";
	public static String PlusWeight = "//div[@class='personal-info-step']//div[3]//div[1]/div/button[2]";
	public static String MinusAge = "//div[@class='personal-info-step']//div[3]//div[2]//div//button[1]";
	public static String PlusAge= "//div[@class='personal-info-step']//div[3]//div[2]//div//button[2]";
	public static String ClickNext = "//button[@class='btn w-100p vl-go-next-btn']";
	public static String Breakfast = "//*[contains(text(),'Breakfast')]";
	public static String Delivery = "//*[@id=\"root\"]/div/section/section/div[2]/div/div[1]/div[3]/div[1]/button[2]";
	public static String PincodeField = "//input[@class='bg-transparent border border-dark form-control']";
	public static String ClickCalender = "//input[@class='rmdp-input']";
	public static String TodayDate= "//div[@class='rmdp-day rmdp-selected']/span";
	public static String SelectPickUp = "//button[contains(text(),'Pickup')]";
	public static String SelectPlan = "//*[contains(text(),'7 Days Plan')]";
	public static String AddtocartBtn= "//*[contains(text(),'Add To Cart')]";
	public static String CheckIfShoppingCartIsLoaaded= "//div[@class='cart-summary-wrapper']//div[2]/div/div[2]/div[2]/span";
	public static String AlreadyHaveAccount = "//a[@class='vl-hyper-link-txt']";
	public static String ConfirmPayBtn = "//button[contains(text(),'Confirm and Pay')]";
	public static String EmailField = "//input[@id='email']";
	public static String ProceedPaymentBtn = "//span[@id='footer-cta']";
	public static String SelectPhonePe = "//button[@class='instrument radio-option ellipsis slotted-radio']";
	public static String SwitchToframe = "//div[@class='razorpay-container']//iframe";
	public static String QRCode = "//button[@class='showQRButton__1hkk9']";
	public static String GotoOrders = "//button[@class='vl-btn-primary w-100 btn btn-primary']";
	public static String Visbilitycheck = "//*[contains(text(),'Checking payment status�')]";
	public static String CheckSbscription = "//p[@class='h5 m-2 page-title']";
	public static String CheckForSubscriptions = "//div[@class='orders-info-3 w-100p']";
	public static String PauseButton = "//section[@class='vl-bg-1 vl-orders-wrapper']/div[2]/div/div/div[2]/div/div/button";
	public static String ClickPauseBtn = "//button[contains(text(),'Pause')]";
	public static String ClickOk= "//button[contains(text(),'Ok')]";
	public static String SubscriptionButton = "//*[contains(text(),'Subscriptions')]";
	public static String ServiceablePincode = System.getProperty("ServiceablePincode","500089");
	public static String AddressType = "//label[contains(text(),'Work')]";
	public static String AddressField = "//input[@class='bg-transparent border border-dark form-control pac-target-input']";
	public static String HouseOrFlatNo = "//div[@class='mt-3 mb-2 form-floating']/input";
	public static String AppartmentOrRoad = "//input[@name='aline2']";
	public static String LandMark ="//input[@name='landmark']";
	public static String ClickEnterAfterEnteringAddress ="//button[@class='btn w-50p vl-go-next-btn']";
	public static String ErrorPincodeMessage = "//div[@class='card text-dark text-center bg-transparent border-0 disclaimer-info']/h3";
	public static String NonServiceablePincode = System.getProperty("ServiceablePincode","500089");
}
