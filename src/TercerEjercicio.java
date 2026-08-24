import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TercerEjercicio {
    public static void main(String[] args) {
        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(4));
        dr.manage().window().maximize();

        try{
        dr.get("https://the-internet.herokuapp.com/dropdown");
        WebElement lista = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));

        Select listaSel = new Select(lista);
        listaSel.selectByVisibleText("Option 2");
        String textoSeleccionado = listaSel.getFirstSelectedOption().getText();

        System.out.println("El texto seleccionado fue " + textoSeleccionado );

        if (textoSeleccionado.contains("Option 2")){
            System.out.println("Paso la prueba");
        }else {
            System.out.println("Fallo la prueba");
        }



        }finally {
            dr.quit();
        }


    }
}