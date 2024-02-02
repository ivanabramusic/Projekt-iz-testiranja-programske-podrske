import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MostPlayableChamp {
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

        WebElement todayButton = driver.findElement(By.xpath("//*[@id=\"content-container\"]/div[1]/table/tbody/tr[4]/td/div/label[3]/input"));
        todayButton.click();
        Thread.sleep(5000);


        WebElement champName = driver.findElement(By.xpath("//*[@id=\"content-container\"]/div[2]/table/tbody/tr[1]/td[2]/a/strong"));
        System.out.print(champName.getText() + " ");

        WebElement timesPlayed = driver.findElement(By.xpath("//*[@id=\"content-container\"]/div[2]/table/tbody/tr[1]/td[3]"));
        System.out.print(timesPlayed.getText());

        Thread.sleep(5000);






    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}