package calenderHandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DiffrentTypeOfCalHandler {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\surbh\\Downloads\\geckodriver-v0.25.0-win64\\geckodriver.exe");
WebDriver driver=new FirefoxDriver();
driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().deleteAllCookies();
driver.manage().window().maximize();
driver.get("https://www.spicejet.com/");	

driver.findElement(By.xpath("//*[@id=\"flightSearchContainer\"]/div[4]/button")).click();
String month="July 2020";
String EXP_DATE="25";

//System.out.println(text);
////*[@id="ui-datepicker-div"]/div[1]/div/div
while(true) {
	String text=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/div")).getText();
 if(text.equals(month)){
	break;	
	}
 else {
	driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a/span")).click();
	}
}
 ////*[@id="ui-datepicker-div"]/div[1]/table/tbody/tr[3]/td[3]/a

List<WebElement>alldate=  driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr/td"));
for(WebElement ele:alldate) {
	String date=ele.getText();
	//String datevalue[]=date.split("/n");    to split the month and day
	if(date.equals(EXP_DATE)) {
	ele.click();
	break;
	}
}
	}

}
