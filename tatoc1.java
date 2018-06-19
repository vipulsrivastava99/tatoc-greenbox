package qa1;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class tatoc1 {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		WebElement ele=driver.findElement(By.linkText("Basic Course"));
		ele.click();
		WebElement ele1=driver.findElement(By.className("greenbox"));
		ele1.click();
		int flag=0;
		String firstcolor=driver.switchTo().frame("main").findElement(By.id("answer")).getAttribute("class");
		String secondcolor=driver.switchTo().frame("child").findElement(By.id("answer")).getAttribute("class");
		while(!firstcolor.equals(secondcolor))
		{
			driver.switchTo().parentFrame().findElement(By.linkText("Repaint Box 2")).click();
			secondcolor=driver.switchTo().frame("child").findElement(By.id("answer")).getAttribute("class");
		}
		driver.switchTo().parentFrame().findElement(By.linkText("Proceed")).click();
	
		WebElement from=driver.findElement(By.className("ui-draggable"));	
		WebElement to=driver.findElement(By.id("dropbox"));	
		Actions act=new Actions(driver);
		act.dragAndDrop(from,to).build().perform();
		driver.findElement(By.linkText("Proceed")).click();
		driver.findElement(By.linkText("Launch Popup Window")).click();
		String winHandleBefore = driver.getWindowHandle();

		for(String winHandle : driver.getWindowHandles())
		    driver.switchTo().window(winHandle);
		driver.findElement(By.id("name")).sendKeys("sx");
		 driver.findElement(By.id("submit")).click();
		 driver.switchTo().window(winHandleBefore);
		 driver.findElement(By.linkText("Proceed")).click();
		 driver.findElement(By.linkText("Generate Token")).click();
		 String Token = driver.findElement(By.id("token")).getText();
	
		 System.out.println(Token);
		 String substring1=Token.substring(7);
		 System.out.println(substring1);
		 Cookie name = new Cookie("Token", substring1);
		 driver.manage().addCookie(name);
		 driver.findElement(By.linkText("Proceed")).click(); 
	}
}
