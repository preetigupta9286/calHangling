package calenderHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsingJavaScriptdoubleCalHandle {

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


WebElement date=driver.findElement(By.xpath("//input[@name='first_date_of_cover' and @type='text']"));
String datevalue="17-04-2020";
selectDateByJS(driver, date, datevalue);

WebElement date1=driver.findElement(By.name("last_date_of_cover"));
String datevalue1="30-04-2020";
selectDateByJS(driver, date1, datevalue1);
}

//by using javaScriptExecuter
public static void selectDateByJS(WebDriver driver,WebElement element, String datevalue) {
JavascriptExecutor js=((JavascriptExecutor)driver);	
js.executeScript("arguments[0].setAttribute('value','"+datevalue+"');", element);
}
}