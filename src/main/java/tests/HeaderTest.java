package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HeaderTest {

    static WebDriver driver;

    @Before
    public void beforeTest()
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.next.co.uk/");
    }

    @Test
    public void verifyHelpLinkRedirection()
    {
        driver.findElement(By.id("helpsite")).click();
        String expectedHelpPageText="How can we help?";
        String actualHelpPageText= driver.findElement(By.xpath("//*[@id=\"ihelpTitle\"]/h1")).getText();
        Assert.assertEquals(expectedHelpPageText,actualHelpPageText);
    }

    @Test
    public void verifyStoreLocatorFunction()
    {
        driver.findElement(By.xpath("/html/body/header/div[2]/section/section[3]/ul/li[3]/a")).click();
        String expectedStoreLocatorPageTitle="Next: Official Site - Store Search | Find Your Nearest Store";
        String actualStoreLocatorPageTitle= driver.getTitle();
        Assert.assertEquals(expectedStoreLocatorPageTitle,actualStoreLocatorPageTitle);

        String expectedStoreUrl="https://www.next.co.uk/stores";
        String actualStoreUrl= driver.getCurrentUrl();

    }
    @After
    public void afterTest()
    {
        driver.quit();

    }
}
