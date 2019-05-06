package testonly;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllLinks {
	public static void main(String[] args) {
		WebDriver fd = new FirefoxDriver();
		fd.get("https://in.yahoo.com/");
		fd.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		fd.manage().window().maximize();
		fd.findElement(By.id("uh-search-box")).sendKeys("test");

		// WebElement allLink =
		// fd.findElement(By.xpath("//b[contains(text(),'test')]"));
		List<WebElement> links = fd.findElements(By.xpath("//b[contains(text(),'test')]"));
//		for (int i = 0; i <= links.size(); i++) {
//			System.out.println(links.);
//		}
		for (WebElement wb : links) {
			System.out.println(wb.getText());
		}
//		Iterator<WebElement> itr = links.iterator();
//		while (itr.hasNext()) {
//			System.out.println(itr.next());
//		}

	}
}
