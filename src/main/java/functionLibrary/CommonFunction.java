package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonFunction {

    public static WebDriver driver;
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

    }
    public void closeBrowser()
    {
        driver.quit();
    }
}
