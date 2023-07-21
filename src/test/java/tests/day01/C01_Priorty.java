package tests.day01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_Priorty extends TestBase {

    // amazon isimli bir test methodu olusturunuz. Ve amazona gidiniz

    @Test(priority = 2)
    public void testamazon() {
        driver.get("https://www.amazon.com/");
    }

    // bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz

    @Test(priority = 3)
    public void testbestbuy() {
        driver.get("https://www.bestbuy.com");
    }

    // techproeducation isimli bir test methodu olusturunuz. Ve techproeducation'a gidiniz

    @Test(priority = 1)
    public void testtechproeducation() {
        driver.get("https://www.techproeducation.com");
    }


    // once techproeducation, sonra amazon, sonra bestbuy test methodu calısacak sekilde sıralama yapınız



}
