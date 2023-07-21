package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // facebook anasayfaya gidin
    // kullanıcı email kutusuna rastgele bir isim yazın
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailKutusu;

    // kullanıcı sifre kutusuna rastgele bir password yazın
    @FindBy(xpath = "//input[@id='pass']")
    public WebElement sifreKutusu;

    // giris yap butonuna tıklayın
    @FindBy(xpath = "//button[@name='login']")
    public WebElement girisYapButonu;

    // is this your account yazı elementinin, gorunur oldugunu test edin
    @FindBy(xpath = "//div[text()='Is this your account?']")
    public WebElement isThisYourAccountYaziElementi;

    // sayfayı kaptın
}
