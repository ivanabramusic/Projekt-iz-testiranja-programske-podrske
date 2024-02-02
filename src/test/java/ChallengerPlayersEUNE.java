import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;


public class ChallengerPlayersEUNE {
    //-------------------Global Variables-----------------------------------
//Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "https://www.op.gg/";
    //----------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver = new ChromeDriver();

        driver.navigate().to(testURL);
    }
    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement statsButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[2]/nav/ul/li[4]/a/div"));
        statsButton.click();
        Thread.sleep(5000);

        WebElement byTierButton = driver.findElement(By.xpath("//*[@id=\"content-header\"]/nav/a/span"));
        byTierButton.click();
        Thread.sleep(5000);

        WebElement euneButton = driver.findElement(By.xpath("//*[@id=\"content-container\"]/div[2]/div[2]/ul/li[3]/button"));
        euneButton.click();
        Thread.sleep(5000);

        WebElement challNumber = driver.findElement(By.xpath("//*[@id=\"content-container\"]/div[3]/aside/section/div/div/table/tbody/tr[1]/td[3]"));
        System.out.println("Challenger players in eune: " + challNumber.getText());
        Thread.sleep(5000);








    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}