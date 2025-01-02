package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import setup.Main;

public class Textboxes extends Main {

  public static void main(String[] args) {
    driver.get("https://www.selenium.dev/selenium/web/formPage.html");

    // TO INTERACT WITH ELEMENTS
    WebElement textbox = driver.findElement(By.name("id-name1"));
    textbox.getText(); // to read the text in this text box
    System.out.println(textbox.getText());
    textbox.clear(); // to clear the text in the text box
    textbox.sendKeys("Hello!"); // to write text into the text box

    //driver.quit();
  }
}
