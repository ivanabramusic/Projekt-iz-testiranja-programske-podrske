import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HighestWinrate {
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

        WebElement championsButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div[2]/nav/ul/li[2]/a/div"));
        championsButton.click();
        Thread.sleep(5000);

        WebElement acceptButton = driver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]"));
        acceptButton.click();
        Thread.sleep(5000);

        WebElement winrateButton = driver.findElement(By.xpath("//*[@id=\"content-container\"]/div[2]/main/div/table/thead/tr/th[5]"));
        winrateButton.click();
        Thread.sleep(5000);

        WebElement champion = driver.findElement(By.xpath("//*[@id=\"content-container\"]/div[2]/main/div/table/tbody/tr[1]/td[2]/a"));
        System.out.println(champion.getText());
        WebElement winrate = driver.findElement(By.xpath("//*[@id=\"content-container\"]/div[2]/main/div/table/tbody/tr[1]/td[5]"));
        System.out.print(winrate.getText());
        Thread.sleep(5000);

    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}
