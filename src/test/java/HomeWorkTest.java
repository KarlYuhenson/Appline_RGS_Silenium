import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class HomeWorkTest {
    WebDriver driver;
    WebDriverWait wait;



    @Before
    public void startUp ( ) {
        System.setProperty ( "webdriver.chrome.driver" , "driver/chromedriver" );
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability( CapabilityType.PAGE_LOAD_STRATEGY, "eager");

        driver = new ChromeDriver (capabilities );
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().pageLoadTimeout ( 20, SECONDS );
        wait = new WebDriverWait ( driver,20 );


    }

    @Test
    public void exampleTest ( ) {
        driver.get ( "https://www.rgs.ru" );

        String menuLinkXpath = "//li[contains(@class, 'dropdown adv-analytics-navigation')]//a[@data-toggle='dropdown']";
        WebElement menuLinkElement = driver.findElement ( By.xpath ( menuLinkXpath) );
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath (menuLinkXpath)));
        menuLinkElement.click ();

        String dmsLinkXpath = "//a[@href='https://www.rgs.ru/products/private_person/health/dms/generalinfo/index.wbp']";
        WebElement dmsLinkElement = driver.findElement ( By.xpath ( dmsLinkXpath) );
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath (dmsLinkXpath)));
        dmsLinkElement.click ();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath ( "//H1[@class='content-document-header']" )));

        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "ДМС — добровольное медицинское страхование",
               driver.findElement ( By.xpath ( "//H1[@class='content-document-header']" ) ).getText () );


        String sendRequestButtonXpath = "//a[@class='btn btn-default text-uppercase hidden-xs adv-analytics-navigation-desktop-floating-menu-button']";
        WebElement sendRequestButtonElement = driver.findElement ( By.xpath ( sendRequestButtonXpath) );
        wait.until(ExpectedConditions.elementToBeClickable ( sendRequestButtonElement ));
        sendRequestButtonElement.click ();


        wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath ( "//B[@data-bind='text: options.title']" )));

        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "Заявка на добровольное медицинское страхование",
                driver.findElement ( By.xpath ( "//B[@data-bind='text: options.title']" ) ).getText () );


        String firstNameFormXpath = "//input[contains(@data-bind, 'value:LastName')]";
        WebElement firstNameFormElement = driver.findElement ( By.xpath ( firstNameFormXpath) );
        wait.until(ExpectedConditions.elementToBeClickable ( firstNameFormElement ));
        firstNameFormElement.click ();
        firstNameFormElement.sendKeys("Иванов");
        firstNameFormElement.click ();


        String lastNameFormXpath = "//input[contains(@data-bind, 'value:FirstName')]";
        WebElement lastNameFormElement = driver.findElement ( By.xpath ( lastNameFormXpath) );
        lastNameFormElement.click ();
        lastNameFormElement.sendKeys("Иван");

        String regionXpath = "//select[@name='Region']";
        WebElement regionElement = driver.findElement ( By.xpath ( regionXpath) );
        regionElement.click ();

        String region77Xpath = "//option[contains(@value, '77')]";
        WebElement region77Element = driver.findElement ( By.xpath ( region77Xpath) );
        region77Element.click ();

        String numberPhoneFormXpath = "//input[contains(@data-bind, 'value: Phone')]";
        WebElement numberPhoneFormElement = driver.findElement ( By.xpath ( numberPhoneFormXpath) );
        numberPhoneFormElement.click ();
        numberPhoneFormElement.sendKeys("9257777777");

        String eMailPhoneFormXpath = "//input[contains(@data-bind, 'value: Email,')]";
        WebElement eMailPhoneFormElement = driver.findElement ( By.xpath ( eMailPhoneFormXpath) );
        eMailPhoneFormElement.click ();
        eMailPhoneFormElement.sendKeys("qwertyqwerty");

        String calendarFormXpath = "//input[@name='ContactDate']";
        WebElement calendarFormElement = driver.findElement ( By.xpath ( calendarFormXpath) );
        calendarFormElement.click ();

        wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "//TD[@class='datepicker-day'][text()=' 29 ']" ) ) )   ;

        String dateChangeXpath = "//TD[@class='datepicker-day'][text()=' 29 ']";
        WebElement dateChangeElement = driver.findElement ( By.xpath ( dateChangeXpath) );
        dateChangeElement.click ();

        String commentsFormXpath = "//TEXTAREA[contains(@data-bind, 'value: Comment')]";
        WebElement commentsFormElement = driver.findElement ( By.xpath ( commentsFormXpath) );
        commentsFormElement.click ();
        commentsFormElement.sendKeys("привет привет привет");

        String checkBoxXpath = "//input[@class='checkbox']";
        WebElement checkBoxElement = driver.findElement ( By.xpath ( checkBoxXpath) );
        checkBoxElement.click ();

//        String ssq = "//SPAN[@class='validation-error-text'][text()='Введите Фамилию']";
//        WebElement ssq1 = driver.findElement ( By.xpath ( ssq) );
//        Assert.assertFalse (  ssq1.isDisplayed ());


            Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "Иванов",
                    driver.findElement ( By.xpath ( "//input[contains(@data-bind, 'value:LastName')]") ).getText () );

            Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "Иван",
                    driver.findElement ( By.xpath ( "//input[contains(@data-bind, 'value:FirstName')]") ).getText () );

            Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "Москва",
                    driver.findElement ( By.xpath ( "//select[@name='Region']") ).getText () );

            Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "9257777777",
                         driver.findElement ( By.xpath ( "//input[contains(@data-bind, 'value: Phone')]") ).getText () );

            Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "qwertyqwerty",
                           driver.findElement ( By.xpath ( "//input[contains(@data-bind, 'value: Email,')]") ).getText () );

            Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "29.05.2020",
                           driver.findElement ( By.xpath ( "//input[@name='ContactDate']") ).getText () );

            Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "привет привет привет",
                           driver.findElement ( By.xpath ( "//TEXTAREA[contains(@data-bind, 'value: Comment')]") ).getText () );

            Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "29.05.2020",
                           driver.findElement ( By.xpath ( "//input[@name='ContactDate'], 'value: Email,')]") ).getText () );


        String buttonSendRequestXpath = "//BUTTON[@id='button-m']";
        WebElement buttonSendRequestElement = driver.findElement ( By.xpath ( buttonSendRequestXpath) );
        buttonSendRequestElement.click ();

        wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "//span[@class='validation-error-text']" ) ) )   ;

        Assert.assertEquals ( "Содержимое ссылки не соответствует ожиданию", "Введите адрес электронной почты",
                driver.findElement ( By.xpath ( "//span[@class='validation-error-text']" ) ).getText () );


    }


    @After
    public void tearDown ( ) {
        driver.quit ( );
    }
}

