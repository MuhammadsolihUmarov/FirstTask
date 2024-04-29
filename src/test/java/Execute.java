import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Execute {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.manage().window().maximize();
            driver.get("https://pastebin.com/");

            PastebinPage pastebinPage = new PastebinPage(driver, wait);
            pastebinPage.enterText("Hello from WebDriver");
            pastebinPage.setExpiration();
            pastebinPage.enterTitle("helloweb");
            pastebinPage.createPaste();
        } catch (Exception e) {
            System.out.println("Error encountered: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}

