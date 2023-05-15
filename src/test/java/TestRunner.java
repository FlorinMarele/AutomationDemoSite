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
    public void regiterPage(){
        RegisterForm registerpage = new RegisterForm(driver);
        registerpage.HomePage();
        registerpage.setFirstName("Florin");
        registerpage.setlastName("Marele");
        registerpage.setadress("Iasi");
        registerpage.setemailAdress("mlorflor34@gmail.com");
        registerpage.setphoneNumber("0743936235");
        registerpage.selectGender("Male");
        registerpage.selectHobies();
        registerpage.selectlanguage();
        registerpage.selectSkills("Java");
        registerpage.selectCountry("United States of America");
        registerpage.setDateOfBirth("2003", "February", "26");
        registerpage.setPassword("AvadaKadavra","AvadaKadavra");
        registerpage.clickSubmit();
    }
    @Test
    public void SwitchToTests()
    {   driver.get("https://demo.automationtesting.in/Register.html");
        SwitchToPage switchToPage = new SwitchToPage(driver);
        switchToPage.clickSwitchTo();
        List<String> expectedSubMenuNames;
        expectedSubMenuNames = Arrays.asList("Alerts", "Windows", "Frames");
        List<String> actualresultSubNames;
        actualresultSubNames = switchToPage.subMenuNames();
        Assert.assertEquals( "Submeniurile nu sunt as expected",actualresultSubNames, expectedSubMenuNames);
        if (actualresultSubNames.equals(expectedSubMenuNames))
        {
            System.out.println("Submeniurile sunt as expected");
        }
        else
        {
            System.out.println("Submeniurile nu sunt as expected");
        }

    }

}
