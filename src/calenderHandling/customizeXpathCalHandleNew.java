package calenderHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class customizeXpathCalHandleNew {

public static void main(String[] args) {
String month="June 2020";
String day="20";
System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\surbh\\Downloads\\geckodriver-v0.25.0-win64\\geckodriver.exe");
WebDriver driver=new FirefoxDriver();
driver.manage().deleteAllCookies();
driver.manage().window().maximize();
driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

driver.get("https://www.travelmedicare.com/");	
driver.findElement(By.xpath("//a[contains(text(),'My TM')]")).click();
driver.findElement(By.name("email")).sendKeys("roicianstesting1@gmail.com");
driver.findElement(By.name("password")).sendKeys("trewq12345");
driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[1]/div/div/span/span")).click();

///html/body/div[5]/div[1]/table/thead/tr[2]/th[2] 

///html/body/div[5]/div[1]/table/thead/tr/th + [contains(text(),'20')]
////div[@class='form-group']/descendant::select[@class='form-control province_id']"

while(true){
	String text=driver.findElement(By.xpath("/html/body/div[5]/div[1]/table/thead/tr[2]/th[2]")).getText();
	if(text.equals(month)) {
		break;
	}
	else {
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/table/thead/tr[2]/th[3]")).click();
	}
}
 driver.findElement(By.xpath("html/body/div[5]/div[1]/table/tbody/tr/td[contains(text(),"+day+")]")).click();



}

}
