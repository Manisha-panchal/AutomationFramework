package tests;

import functionLibrary.CommonFunction;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class FavouritesTest extends CommonFunction {

    @Before
    public void beforeTest()
    {
        openBrowser();
    }

    @Test
    public void verifyProductsInFavourites()
    {
        driver.findElement(By.xpath("//div[@class='favourite-icon']")).click();

        String expectedFavText= "You have no saved items.";
        String actualFavText= driver.findElement(By.xpath("//div[@id='noItems']/p[2]")).getText();
        Assert.assertEquals(expectedFavText, actualFavText);
    }

    @Test
    public void verifyAddingProductInFavourites()
    {
        driver.findElement(By.name("w")).sendKeys("jeans");
        driver.findElement(By.xpath("//*[@id=\"newsearch\"]/input[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"gel-favourite-active\"]/use")).click();



    }
    @Test
    public void verifyAddingProductToBasket()
    {
        Actions actions= new Actions(driver);
        WebElement womenMenu= driver.findElement(By.xpath("//*[@id=\"NI1\"]/span"));
        actions.moveToElement(womenMenu).build().perform();
    }
    @After
    public void afterTest()
    {
        closeBrowser();
    }
}
