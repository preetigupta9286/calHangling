package calenderHandling;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CalenderHandle {

public static void main(String[] args) {
System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\surbh\\Downloads\\geckodriver-v0.25.0-win64\\geckodriver.exe");
WebDriver driver=new FirefoxDriver();
driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().deleteAllCookies();
driver.manage().window().maximize();
driver.get("https://www.travelmedicare.com/");	
driver.findElement(By.xpath("//a[contains(text(),'My TM')]")).click();
driver.findElement(By.name("email")).sendKeys("roicianstesting1@gmail.com");
driver.findElement(By.name("password")).sendKeys("trewq12345");
driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

String date1="16-april-2020";
String datearr[]=date1.split("-");  //3,april,2020
String day1=datearr[0];
String month1=datearr[1];
String year1=datearr[2];
driver.findElement(By.name("first_date_of_cover")).click();

//Select select=new Select(driver.findElement(By.xpath("//td[@data-date='1585958400000']")));
//select.selectByVisibleText(day);

///html/body/div[5]/div[1]/table/tbody/tr[1]/td[1]
///html/body/div[5]/div[1]/table/tbody/tr[1]/td[6]
///html/body/div[5]/div[1]/table/tbody/tr[5]/td[7]


String beforeXpath="/html/body/div[5]/div[1]/table/tbody/tr[";
String afterXpath="]/td[";

final int totalweekdays=7;
boolean flag=false;
for(int rownum=1;rownum<=7;rownum++) {
 for(int colnum=1;colnum<=totalweekdays;colnum++) {
String dayvalue=driver.findElement(By.xpath(beforeXpath+rownum+afterXpath+colnum+"]")).getText();
System.out.println(dayvalue);
if(dayvalue.equals(day1)){
	driver.findElement(By.xpath(beforeXpath+rownum+afterXpath+colnum+"]")).click();
	//flag=true;
	break;

	}}
// if(flag) {
//	 break;
// }
String date2="23-april-2020";
String datearr2[]=date2.split("-");  //3,april,2020
String day2=datearr2[0];
String month2=datearr2[1];
String year2=datearr2[2];
driver.findElement(By.name("last_date_of_cover")).click();

///html/body/div[5]/div[1]/table/tbody/tr[1]/td[1]
///html/body/div[5]/div[1]/table/tbody/tr[6]/td[7]

String beforexpath2="/html/body/div[5]/div[1]/table/tbody/tr[";
String aterxpath2="]/td[";
boolean flag1=false;
for(int rownum2=1;rownum2<=7;rownum2++) {
	 for(int colnum2=1;colnum2<=totalweekdays;colnum2++) {
String dayvalue2=driver.findElement(By.xpath(beforexpath2+rownum2+aterxpath2+colnum2+"]")).getText();
System.out.println(dayvalue2);
if(dayvalue2.equals(day2)) {
	driver.findElement(By.xpath(beforexpath2+rownum2+aterxpath2+colnum2+"]")).click();
	flag1=true;
	break;
}}
	 if(flag1) {
		 break;
	 }}

//driver.quit();
}
}}
 