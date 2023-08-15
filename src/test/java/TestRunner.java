import org.example.RegisterForm;
import org.example.SwitchToPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Arrays;
import java.util.List;


public class TestRunner {

    private static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chome.driver","C://Program Files//ChromeDriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void regiterPage()  {
        RegisterForm registerpage = new RegisterForm(driver);
        registerpage.urlRegisterForm("https://demo.automationtesting.in/Register.html");
        registerpage.setFirstName("Florin");
        registerpage.VerifyFirstName();
        registerpage.setlastName("Marele");
        registerpage.VerifylastName();
        registerpage.setadress("Iasi");
        registerpage.Verifyadress();
        registerpage.setemailAdress("mlorflor34@gmail.com");
        registerpage.VerifysetemailAdress();
        registerpage.setphoneNumber("0768373748");
        registerpage.VerifysetphoneNumber();
        registerpage.selectGender("Male");
        registerpage.VerifyGender();
        registerpage.selectHobies();
        registerpage.VerifyselectHobies();
        registerpage.selectlanguage();
        registerpage.Verifyselectlanguage();
        registerpage.selectSkills("Java");
        registerpage.selectCountry("United States of America");
        registerpage.VerifyselectCountry();
        registerpage.setDateOfBirth("2003", "February", "28");
        registerpage.VerifyDateOfBirth();
        registerpage.setPassword("AvadaKadavra","AvadaKadavra");
        registerpage.VerifyfirstPassword();
        registerpage.VerifysecondPassword();
        registerpage.clickSubmit();
        registerpage.VerifyclickSubmit();
        driver.quit();
    }
    @Test
    public void SwitchToPage() {
        SwitchToPage switchToPage = new SwitchToPage(driver);
        switchToPage.urlSwitchToPage("https://demo.automationtesting.in/Register.html");
        switchToPage.clickSwitchTo();
        List<String> expectedSubMenuNames;
        expectedSubMenuNames = Arrays.asList("Alerts", "Windows", "Frames");
        List<String> actualresultSubNames;
        actualresultSubNames = switchToPage.subMenuNames();
        Assert.assertEquals( "Submeniurile aren't as expected",actualresultSubNames, expectedSubMenuNames);
        if (actualresultSubNames.equals(expectedSubMenuNames))
        {
            System.out.println("Submeniurile are as expected");
        }
        else
        {
            System.out.println("Submeniurile aren't as expected");
        }
        driver.quit();

    }

}