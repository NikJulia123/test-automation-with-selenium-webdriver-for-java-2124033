package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

import java.util.List;

public class Main {

  static protected WebDriver driver;

  static {
    chromedriver().setup();
    var options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    driver = new ChromeDriver(options); // will open Chrome browser with options we specified
  }

  public static void main(String[] args) {
    driver.get("https://selenium.dev/selenium/web/formPage.html"); // opens the url in the browser

    // TO LOCATE ELEMENTS

    WebElement emailTextBox = driver.findElement(By.id("email")); // to locate one element by id
    List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));// to locate several
                                                                                               // elements at once
    System.out.println(radioButtons.size());

    WebElement bottomButton = driver.findElement(RelativeLocator.with(By.name("submit")).below(By.id("submit")));
    System.out.println(bottomButton);

    // Code Challenge
    // 1st element
    WebElement imageButton = driver.findElement(By.id("imageButton"));

    // 2nd element
    WebElement clickButton = driver.findElement(
        RelativeLocator.with(By.cssSelector("input[type='submit']")).toLeftOf(By.id("lone_disabled_selected_radio")));
    // or by css seceltor only
    WebElement clickButton2 = driver.findElement(By.cssSelector("input[value='Click']"));

    // 3rd element
    WebElement inputName = driver.findElement(RelativeLocator.with(By.name("id-name1")).above(By.id("id-name1")));
    // or by name only
    WebElement inputName2 = driver.findElement(By.name("id-name1"));

    driver.quit(); // closes the browser and WebDriver instance
  }
}