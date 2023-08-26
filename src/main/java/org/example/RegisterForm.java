package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Objects;


public class RegisterForm {
    private WebDriver driver;
    public RegisterForm(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
    public void urlRegisterForm(String url){driver.get(url);}
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
    @FindBy(xpath = "/html/body/section/div/div/div[2]/form/div[7]/div/multi-select/div[2]/ul")
    WebElement ListOfLanguages;
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

    public void setFirstName(String FirstNameToBeCompleted) {
        FirstName.sendKeys(FirstNameToBeCompleted);
    }
    public void VerifyFirstName(){
        if(FirstName.getAttribute("value").isEmpty()){
            System.out.println("First name was not inserted.");
        }
        else {String imputValue=FirstName.getAttribute("value");
        System.out.println("First name was inserted.");
        }
    }
    public void setlastName(String lastNameToBeCompleted) {
        lastName.sendKeys(lastNameToBeCompleted);
    }
    public void VerifylastName(){
        if(lastName.getAttribute("value").isEmpty()){
            System.out.println("Last name was not inserted.");
        }
        else {String imputValue=lastName.getAttribute("value");
            System.out.println("Last name was inserted.");
        }
    }
    public void setadress(String adressToBeCompleted) {
        adress.sendKeys(adressToBeCompleted);
    }
    public void Verifyadress(){
        if(adress.getAttribute("value").isEmpty()){
            System.out.println("Adress was not inserted.");
        }
        else {String imputValue=adress.getAttribute("value");
            System.out.println("Adress was inserted.");
        }
    }
    public void setemailAdress(String emailAdressToBeCompleted) {
        emailAdress.sendKeys(emailAdressToBeCompleted);
    }
    public void VerifysetemailAdress() {
        if (emailAdress.getAttribute("value").isEmpty()) {
            System.out.println("Email Adress was not inserted.");
        }
        else {
            String imputValue = emailAdress.getAttribute("value");
            System.out.println("Email Adress was inserted.");
        }
    }
    public void setphoneNumber(String phoneNumberToBeCompleted) {
        phoneNumber.sendKeys(phoneNumberToBeCompleted);
    }
    public void VerifysetphoneNumber() {
        if (phoneNumber.getAttribute("value").isEmpty()) {
            System.out.println("Phone number was not inserted.");
        } else {
            String imputValue = phoneNumber.getAttribute("value");
            System.out.println("Phone number was inserted.");
        }
    }
    public  void selectGender(String gender) {
        if (Objects.equals(gender, "FeMale")) {
            feamleGender.click();
        }
        else if (Objects.equals(gender, "Male")) {
            maleGender.click();
        }
    }
    public void VerifyGender() {
        if (maleGender.isSelected()) {
            System.out.println("Gender Male is selected.");
        } else if (feamleGender.isSelected()) {
            System.out.println("Gender Female is selected.");
        }
    }
   
    public void selectHobies(){
        movies.click();
        cricket.click();
    }
    public void VerifyselectHobies(){
        if (movies.isSelected()){
            System.out.println("Movies hobbie is selected.");
        }
        else{
            System.out.println("Movies hobbie is not selected.");
        }
        if (cricket.isSelected()){
            System.out.println("Cricket hobbie is selected.");}
        else {
            System.out.println("Cricket hobbie is not selected.");
        }
         if (hockey.isSelected()) {
            System.out.println("Hockey hobbie is selected.");
        }
         else { System.out.println("Hockey hobbie is not selected.");}
    }
    public  void selectlanguage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        languageList.click();
        WebElement el = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[7]/div/multi-select/div[2]/ul/li[30]/a"));
        el.click();
    }
    public void Verifyselectlanguage(){
        if(languageList.isEnabled()){
            System.out.println("Language is selected.");
        }
        else {
            System.out.println("Language is not selected.");
        }
    }

    public  void selectSkills(String skill) {
    Select selectSkills = new Select(Skills);
        selectSkills.selectByVisibleText(skill);
    }
    public void VerifyselectSkills(){
        if(Skills.isSelected()){
            System.out.println("Skills are displayed.");
        }
        else{
            System.out.println("Skills are not displayed.");
        }
    }

    public void selectCountry (String country){
    Select selectCountries = new Select(selectCountry);
    selectCountries.selectByValue(country);
    }
    public void VerifyselectCountry(){
        if(selectCountry.isDisplayed()){
            System.out.println("Selected country is displayed.");
        }
        else{
            System.out.println("Selected country is not displayed.");
        }
    }
    public  void  setDateOfBirth(String years,String months,String days){
    Select selectyear = new Select(year);
    selectyear.selectByVisibleText(years);
    Select selectmonth = new Select(month);
    selectmonth.selectByVisibleText(months);
    Select selectday =new Select(day);
    selectday.selectByVisibleText(days);
    }
    public void VerifyDateOfBirth(){
        if(year.isDisplayed()){
            System.out.println("Year is displayed.");
        }
        else{
            System.out.println("Year is not displayed.");
        }
        if(month.isDisplayed()){
            System.out.println("Month is displayed.");
        }
        else{
            System.out.println("Month is not displayed.");
        }
        if(day.isDisplayed()){
            System.out.println("Day is displayed.");
        }
        else{
            System.out.println("Day is not displayed.");
        }
    }

    public void setPassword(String Password, String confirmPassword ){
        firstPassword.sendKeys(Password);
        secondPassword.sendKeys(confirmPassword);
    }
    public void VerifyfirstPassword(){
        if (firstPassword.getAttribute("value").isEmpty()) {
            System.out.println("First Password was not inserted.");
        } else {
            String imputValue = firstPassword.getAttribute("value");
            System.out.println("First Password was inserted.");
        }
    }
    public void VerifysecondPassword(){
        if (secondPassword.getAttribute("value").isEmpty()) {
            System.out.println("Second Password was not inserted.");
        } else {
            String imputValue = secondPassword.getAttribute("value");
            System.out.println("Second Password was inserted.");
        }
    }

    public void clickSubmit(){
        Submit.click();
    }
    public void VerifyclickSubmit(){
        if (Submit.isSelected()){
            System.out.println("Submit Button is pressed.");
        }
        else if (!Submit.isSelected()) {
            System.out.println("Submit button is not pressed.");
        }
    }

}
