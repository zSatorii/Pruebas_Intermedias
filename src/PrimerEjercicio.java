import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PrimerEjercicio {
    public static void main (String[] args){
        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(2));

        try{
            dr.get("https://practicetestautomation.com/practice-test-login/");
            dr.manage().window().maximize();

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            WebElement contrasena = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

            name.sendKeys("student");
            contrasena.sendKeys("Password123");

            WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
            boton.click();

            wait.until(ExpectedConditions.urlContains("logged-in-successfully"));

            WebElement mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

            String men = mensaje.getText();

            System.out.println("El mensaje es " + mensaje);
            System.out.println("El mensaje es " + men);

            if (men.contains("Logged In Successfully")){
                System.out.println("Paso la prueba");
            }else {
                System.out.println("No paso la prueba");
            }

        }finally {
            dr.quit();
        }
    }
}
