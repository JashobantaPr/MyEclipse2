import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Humsafar_WebApplication {
    public static void main(String[] args) throws Throwable {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://13.126.121.168/#/walkthrough_screen_five_screen");
        
        
        try {
            
            // Add a sleep to wait for the element to be available
            Thread.sleep(5000);
            String jsScript = "document.querySelector('flt-glass-pane').shadowRoot.querySelector('flt-semantics-placeholder').click();";
            ((JavascriptExecutor) driver).executeScript(jsScript);
            WebElement mobileTextField = driver.findElement(By.xpath("//input[@aria-label='Email / Phone number']"));
            // Check if the element is enabled
            if (mobileTextField.isEnabled()) {
                mobileTextField.click();
                mobileTextField.sendKeys("8310049221");
            } else {
                System.out.println("Mobile text field is not enabled.");
            }
            driver.findElement(By.xpath("//flt-semantics[@id='flt-semantic-node-11']")).click();
            Thread.sleep(5000);
            //WebElement otpfield = driver.findElement(By.xpath("//*[@id=\"flt-semantic-node-26\"]"));
            System.out.println(driver.findElement(By.xpath("//*[@id=\"flt-semantic-node-28\"]")).isEnabled());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //driver.quit();
        }
    }
}
