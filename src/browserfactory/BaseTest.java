package browserfactory;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
* Verify that six products are displayed
on page
Project-5 - ProjectName : com-utimateqa-sw-2
BaseUrl = https://courses.ultimateqa.com/
1. Create the package ‘browserfactory’ and create the
class with the name ‘BaseTest’ inside the
‘browserfactory’ package. And write the browser setup
code inside the class ‘Base Test’.
 */
public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl) {

        driver = new ChromeDriver();
        // Launch the Url
        driver.get(baseUrl);
        // Maximise the window
        driver.manage().window().maximize();
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void closeBrowser() {
        driver.quit();
    }

}
