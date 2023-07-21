package tests.day02;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_Raporlama extends TestBaseRapor {
    @Test
    public void test01() {

        extentTest = extentReports.createTest("Batch151", "Amazonu test edebilmeli");
        // extentTest'e testName ve description degerlerini atamaliyiz

        // 'https://www.amazon.com' adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon sayfasina gidildi");

        // arama kutusuna "Java" yazip aratın
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Java", Keys.ENTER);
        extentTest.info("arama kutusuna \"Java\" yazip aratıldi");

        // sonuc yazisinin "Java" icerdigini test edin
        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("Java"));
        extentTest.pass("sonuc yazisinin \"Java\" icerdigi test edildi");

        // kontrollu olarak yeni bir sayfa acın
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        extentTest.info("kontrollu olarak yeni bir sayfa acıldi");

        // yeni acılan sayfada "Kitap" aratın
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        amazonPage.aramaKutusu.sendKeys("Kitap", Keys.ENTER);
        extentTest.info("yeni acılan sayfada \"Kitap\" aratıldi");

        // sonuc yazisinin Kitap icerdigini test edin
        String sonucYazisi = amazonPage.sonucYazisi.getText();
        Assert.assertTrue(sonucYazisi.contains("Kitap"));
        extentTest.pass("sonuc yazisinin Kitap icerdigini test edildi");

        // sayfayı kapatınız
        Driver.quitDriver();

        // test raporu alınız
    }
}
