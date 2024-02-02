import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CheckRank {
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

        WebElement regionButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/form/div[1]/div[2]/div/button"));
        regionButton.click();
        Thread.sleep(5000);

        WebElement EUNEButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/form/div[1]/div[2]/div/div/button[3]"));
        EUNEButton.click();
        Thread.sleep(5000);

        WebElement searchTextBox = driver.findElement(By.xpath("//*[@id=\"searchHome\"]"));
        searchTextBox.sendKeys("Abram#0310");
        searchTextBox.submit();
        Thread.sleep(5000);

        WebElement acceptButton = driver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]"));
        acceptButton.click();
        Thread.sleep(5000);

        WebElement updateButton = driver.findElement(By.xpath("//*[@id=\"content-header\"]/div[1]/div/div[1]/div[2]/div[5]/button"));
        updateButton.click();
        Thread.sleep(10000);

        WebElement rank = driver.findElement(By.xpath("//*[@id=\"content-container\"]/div[1]/div[2]/div[2]/div[2]/div[1]"));
        System.out.print(rank.getText());
        Thread.sleep(5000);




    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}