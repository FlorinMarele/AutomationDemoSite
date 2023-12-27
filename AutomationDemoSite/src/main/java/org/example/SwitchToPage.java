package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Arrays;
import java.util.List;


public class SwitchToPage {
    private final WebDriver driver;


         public SwitchToPage(WebDriver driver){
            this.driver =driver;
            PageFactory.initElements(driver,this);


        }
    public void urlSwitchToPage(String url){driver.get(url);}

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div[2]/div[2]/button[2]")
    WebElement PersionalDatadecline;
    @FindBy(xpath = "/html/body")
    WebElement PersionalDatadeclineVerify;
    @FindBy(className="dropdown-toggle")
    WebElement SwitchTo;
    @FindBy(xpath ="/html/body/header/nav/div/div[2]/ul/li[4]/ul/li[1]/a")
    WebElement Alerts;
    @FindBy(xpath="/html/body/header/nav/div/div[2]/ul/li[4]/ul/li[2]/a")
    WebElement Windows;
    @FindBy(xpath="/html/body/header/nav/div/div[2]/ul/li[4]/ul/li[3]/a")
    WebElement Frames;

    public void selectPersionalDatadecline(){
        PersionalDatadecline.click();
    }
    public void VerifyselectPersionalDatadecline(){
        if (PersionalDatadeclineVerify.isDisplayed()){
            System.out.println("Decline button is pressed.");
        }
        else if (!PersionalDatadeclineVerify.isDisplayed()) {
            System.out.println("Decline button is not pressed.");
        }
    }


         public void clickSwitchTo(){

             SwitchTo.click();
    }
    public List<String> subMenuNames() {
        List<String> submeniuri;
        submeniuri = Arrays.asList(Alerts.getText(), Windows.getText(), Frames.getText());
        return submeniuri;

    }



}
