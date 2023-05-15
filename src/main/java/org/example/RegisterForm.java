package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import java.util.Objects;



public class RegisterForm {
    private WebDriver driver;
    private static final String LIMBA_ROMANA_LOCATOR ="/html/body/section/div/div/div[2]/form/div[7]/div/multi-select/div[2]/ul/li[30]/a";
    @FindBy(xpath = "/html/body/section/div/div/div[2]/form/div[1]/div[1]/input")
    WebElement FirstName;
    @FindBy(xpath = "/html/body/section/div/div/div[2]/form/div[1]/div[2]/input")
    WebElement lastName;
    @FindBy(xpath ="/html/body/section/div/div/div[2]/form/div[2]/div/textarea")
    WebElement adress;
    @FindBy(css="input[type='email'][ng-model='EmailAdress']" )
    WebElement emailAdress;
    @FindBy(css="input[type='tel'][ng-model='Phone']" )
    WebElement phoneNumber;
    @FindBy(css="input[type='radio'][value=Male]" )
    WebElement maleGender;
    @FindBy(css="input[type='radio'][value=FeMale]" )
    WebElement feamleGender;
    @FindBy(id="checkbox1")
    WebElement cricket;
    @FindBy(id = "checkbox2")
    WebElement movies;
    @FindBy(id = "checkbox3")
    WebElement hockey;
    @FindBy(id = "msdd")
    WebElement languageList;
    @FindBy (css ="ul.ui-autocomplete li")
    WebElement listaLanguage;
    @FindBy(id= "Skills" )
    WebElement Skills;
    @FindBy (id ="country")
    WebElement selectCountry;
    @FindBy (id="yearbox")
    WebElement year;
    @FindBy (xpath = "/html/body/section/div/div/div[2]/form/div[11]/div[2]/select")
    WebElement month;
    @FindBy (id ="daybox")
    WebElement day;
    @FindBy (id="firstpassword")
    WebElement firstPassword;
    @FindBy (id="secondpassword")
    WebElement secondPassword;
    @FindBy (id="submitbtn")
    WebElement Submit;

    public RegisterForm(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void setFirstName(String FirstNameToBeCompleted) {
        FirstName.sendKeys(FirstNameToBeCompleted);
    }
    public void setlastName(String lastNameToBeCompleted) {
        lastName.sendKeys(lastNameToBeCompleted);
    }
    public void setadress(String adressToBeCompleted) {
        adress.sendKeys(adressToBeCompleted);
    }
    public void setemailAdress(String emailAdressToBeCompleted) {
        emailAdress.sendKeys(emailAdressToBeCompleted);
    }
    public void setphoneNumber(String phoneNumberToBeCompleted) {
        phoneNumber.sendKeys(phoneNumberToBeCompleted);
    }
    public  void selectGender(String gender) {
        if (Objects.equals(gender, "FeMale")) {
            feamleGender.click();
        }
        else if (Objects.equals(gender, "Male")) {
            maleGender.click();
        }
    }
    public void HomePage () {
        driver.get("https://demo.automationtesting.in/Register.html");
    }
    public void selectHobies(){
        movies.click();
        cricket.click();
    }

    public  void selectlanguage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        languageList.click();
        WebElement el = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[7]/div/multi-select/div[2]/ul/li[30]/a"));
        el.click();
    }
    public  void selectSkills(String skill) {
    Select selectSkills = new Select(Skills);
        selectSkills.selectByVisibleText(skill);
    }
    public void selectCountry (String country){
    Select selectCountries = new Select(selectCountry);
    selectCountries.selectByValue(country);
    }
    public  void  setDateOfBirth(String years,String months,String days){
    Select selectyear = new Select(year);
    selectyear.selectByVisibleText(years);
    Select selectmonth = new Select(month);
    selectmonth.selectByVisibleText(months);
    Select selectday =new Select(day);
    selectday.selectByVisibleText(days);
    }
    public void setPassword(String parola, String confirmParola ){
        firstPassword.sendKeys(parola);
        secondPassword.sendKeys(confirmParola);
    }
    public void clickSubmit(){
        Submit.click();
    }
}




