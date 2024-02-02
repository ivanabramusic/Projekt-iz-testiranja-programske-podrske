import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;


public class GoodAndBadAgainst {
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

        WebElement searchTextBox = driver.findElement(By.xpath("//*[@id=\"searchChampion\"]"));
        Thread.sleep(5000);
        searchTextBox.click();
        Thread.sleep(5000);
        searchTextBox.sendKeys("Kayle");
        Thread.sleep(5000);
        searchTextBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        WebElement countersButton = driver.findElement(By.xpath("//*[@id=\"content-header\"]/div[2]/div/a[1]/span"));
        countersButton.click();
        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        Thread.sleep(5000);

        WebElement winrateButton = driver.findElement(By.xpath("//*[@id=\"content-container\"]/aside/div[1]/div[2]/table/thead/tr/th[3]"));
        winrateButton.click();
        Thread.sleep(5000);

        WebElement champName = driver.findElement(By.xpath("//*[@id=\"content-header\"]/div[1]/div[3]/div[1]/div[1]/div[2]/h1/strong"));
        WebElement goodAgainst = driver.findElement(By.xpath("//*[@id=\"content-container\"]/aside/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/div"));
        WebElement goodWinrate = driver.findElement(By.xpath("//*[@id=\"content-container\"]/aside/div[1]/div[2]/table/tbody/tr[1]/td[3]"));
        System.out.println(champName.getText() + " is best against " + goodAgainst.getText() + ", and have " + goodWinrate.getText() + " winrate.");
        Thread.sleep(5000);

        winrateButton.click();
        Thread.sleep(5000);

        WebElement badAgainst = driver.findElement(By.xpath("//*[@id=\"content-container\"]/aside/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/div"));
        WebElement badWinrate = driver.findElement(By.xpath("//*[@id=\"content-container\"]/aside/div[1]/div[2]/table/tbody/tr[1]/td[3]"));
        System.out.println(champName.getText() + " is worst against " + badAgainst.getText() + ", and have " + badWinrate.getText() + " winrate.");
        Thread.sleep(5000);




    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}