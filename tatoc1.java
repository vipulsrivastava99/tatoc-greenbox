package qa1;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tatoc1 {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		WebElement ele=driver.findElement(By.linkText("Basic Course"));
		ele.click();
		WebElement ele1=driver.findElement(By.className("greenbox"));
		ele1.click();
	}
}
