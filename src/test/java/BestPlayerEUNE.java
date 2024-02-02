import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BestPlayerEUNE {
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

        WebElement leaderboardsButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[2]/nav/ul/li[5]/a/div"));
        leaderboardsButton.click();
        Thread.sleep(5000);

        WebElement regionButton = driver.findElement(By.xpath("//*[@id=\"content-container\"]/div[2]/div[1]/div[1]/div[2]/div/button"));
        regionButton.click();
        Thread.sleep(5000);

        WebElement euneButton = driver.findElement(By.xpath("//*[@id=\"content-container\"]/div[2]/div[1]/div[1]/div[2]/div/div/button[3]"));
        euneButton.click();
        Thread.sleep(5000);

        WebElement playerName = driver.findElement(By.xpath("//*[@id=\"content-container\"]/div[3]/table/tbody/tr[1]/td[2]/a/div/span[1]"));
        System.out.print(playerName.getText());

        WebElement playerTag = driver.findElement(By.xpath("//*[@id=\"content-container\"]/div[3]/table/tbody/tr[1]/td[2]/a/div/span[2]"));
        System.out.println(playerTag.getText());

        WebElement lp = driver.findElement(By.xpath("//*[@id=\"content-container\"]/div[3]/table/tbody/tr[1]/td[4]"));
        System.out.print(lp.getText());

        Thread.sleep(5000);








    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}