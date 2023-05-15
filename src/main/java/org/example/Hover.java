package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Hover {
    public Hover(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver driver;
    public void urlHover(String url){driver.get(url);}
    @FindBy(className="dropdown-toggle")
    WebElement SwitchTo;
    Actions actions =new Actions(driver);
    public void actions(){
        actions.moveToElement(SwitchTo);
    }

}
