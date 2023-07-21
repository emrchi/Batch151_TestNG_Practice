package tests.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C03_SoftAssert extends TestBase {

    @Test
    public void test01() {

        // "https://amazon.com" sayfasına gidiniz
        driver.get("https://amazon.com");

        /// Title'in "Amazon" icerdigini test edin
        String title = driver.getTitle();
        //softAssert instance Class oldugu icin ilk once obje olusturulur.
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(title.contains("R1Amazon"),"Title Amazon Icermiyor");

        /// Arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaMotoru = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaMotoru.isEnabled(), "Arama kutusuna erisilemiyor");

        // Arama kutusuna nutella yazıp aratın
        aramaMotoru.sendKeys("Nutella", Keys.ENTER);

        /// Sonuc yazısının gorunur oldugunu test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYazisi.isDisplayed(), "sonucYazisi gorunmuyor");


        /// Sonuc yazısının "Nutella" icerdigini test edin
        softAssert.assertTrue(sonucYazisi.getText().contains("Nutella"),"SonucYazisi Nutella Icermiyor");

        // test islemlerini softAssert ile yapınız ve hatalar icin mesaj versin
        softAssert.assertAll();

        System.out.println("EMRE YILMAZ");     // Yukarida eger fail olursa bu kod calismaz eger fail yok ise bu kod calisir.

        /*
        Junit de Assert kullandigimiz da assert fail oldugu anda test calismayi durduruyordu.
        Ve geri kalanini calistirmiyordu.
        testNg de hem Assert hem softAssert yapilari var. Test sonuna kadar calissin testin sonun da
        tum hatalari listelesin istiyorsak softAssert kullaniriz.
         */


        /*
        softAssert'un hata bulsa bile calısmaya devam etme ozelligi softAssert.assertAll()'a kadardır.
        eger softAssert.assertAll()'da hata bulunursa calısma durur.
        ve class'ın kalan kısmı calısmaz.

        System.out.println("EMRE YILMAZ");
         */

    }
}
