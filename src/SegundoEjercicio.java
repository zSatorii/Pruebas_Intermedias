import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SegundoEjercicio {
    public static void main(String[] args){
        WebDriver dr = new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(4));
        dr.manage().window().maximize();

        try{
            dr.get("https://practicetestautomation.com/practice-test-login/");

            WebElement name = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            WebElement contrasena = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            WebElement boton = wt.until(ExpectedConditions.elementToBeClickable(By.id("submit")));

            name.sendKeys("usuario_invalido");
            contrasena.sendKeys("Password123");
            boton.click();

            WebElement menError = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
            String texError = menError.getText();

            System.out.println("El mensaje error es: "+ texError);

            if (texError.contains("Your username is invalid")){
                System.out.println("La prueba es correcta");
            }else {
                System.out.println("La prueba fallo");
            }
        }finally {
            dr.quit();
        }
    }
}
