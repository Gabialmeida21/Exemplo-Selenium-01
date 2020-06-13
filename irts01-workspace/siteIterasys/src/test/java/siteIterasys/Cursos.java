// 1 - Pacote
package siteIterasys;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

//2 - Bibliotecas
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// 3 - Classe
public class Cursos {
	// 3.1 Atributos / Caracter�stica
	String url;     // endere�o do site alvo
	WebDriver driver;   // objeto do Selenium WebDriver
	
	// 3.2 M�todos ou Fun��es
	@Before
	public void iniciar() {
		url = "https://www.iterasys.com.br";
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\gaalm\\irts01-workspace\\siteIterasys\\drivers\\chromer\\83\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}
	
	@Test
	public void consultarCurso() {
		// Home - P�gina Inicial
		driver.get(url);      // Abrir o navegador na p�gina indicada na url
		driver.findElement(By.id("searchtext")).clear();
		driver.findElement(By.id("searchtext")).sendKeys(Keys.chord("Mantis"));
		// Tirar o screenshot
		driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
		
		// P�gina que lista os cursos
		driver.findElement(By.cssSelector("span.comprar")).click();
		
		//P�gina do Carrinho de Compra
		// Resultados Esperados
		String titulo = "Mantis";
		String preco = "R$ 49,99";
		
		//assertEquals(resultadoEsperado, resultadoAtual)
		assertEquals(titulo, driver.findElement(By.cssSelector("span.item-title")).getText());
		assertEquals(preco, driver.findElement(By.cssSelector("span.new-price")).getText());	
	}
}
