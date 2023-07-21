package tests.day01;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_PageClassKullanimi {
    @Test
    public void test01() {
        // facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        // kullanıcı email kutusuna rastgele bir isim yazın
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.emailKutusu.sendKeys("Emre");

        // kullanıcı sifre kutusuna rastgele bir password yazın
        facebookPage.sifreKutusu.sendKeys("Password");

        // giris yap butonuna tıklayın
        facebookPage.girisYapButonu.click();

        // is this your account yazı elementinin, gorunur oldugunu test edin
        Assert.assertTrue(facebookPage.isThisYourAccountYaziElementi.isDisplayed());

        // sayfayı kaptın
        Driver.closeDriver();
    }

}
