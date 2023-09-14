import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaWebpageTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        //1. Open your chrome browse
        driver = new ChromeDriver();
        //2. Input your Konga Page URL
        driver.get("https://www.konga.com/");
        //3. Verify that the correct url is correct and user is on the right webpage
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong webpage");
        Thread.sleep(10000);
        //4. Maximize the browser driver
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void SignIn() throws InterruptedException {
        //5. Click on Login button to open Login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(4000);
        //6. Input your email on the email field
        driver.findElement(By.id("username")).sendKeys("eliasagor@gmail.com");
        //7. Input your password on the password field
        driver.findElement(By.id("password")).sendKeys("Elorm1991");
        Thread.sleep(5000);
        //8. Click Login
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
        System.out.println("Successfully signed in to konga");
    }


    @Test (priority = 1)
    public void AddToCart() throws InterruptedException {
        //Finding and Adding a Macbook to the cart
        //9. Click on the "Computers and Accessories"
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(10000);
        //10. Click on the Laptop SubCategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(5000);
        //11. Click on the Apple MacBooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(7000);
        System.out.println("Located categories for Laptops");
        //12. Add an item to the cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[3]/form/div[4]/button")).click();
        Thread.sleep(5000);
        System.out.println("Added a mac laptop to cart");

    }

    @Test (priority = 2)

    public void Checkout() throws InterruptedException {
        //Proceed to checkout
        //13. Click on the cart icon
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        Thread.sleep(10000);
        //14. Click on checkout
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(10000);
        System.out.println("Checked out");

    }
    @Test (priority = 3)

    public void selectAddress() throws InterruptedException {
        //Select Address
        //15. Click on change
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        Thread.sleep(5000);
        //16. Click on add delivery address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(5000);
        //17. Click on the address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[1]/form/button")).click();
        Thread.sleep(5000);
        //18. Click on Use this Address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);
        System.out.println("Selected Payment Address");
    }

    @Test (priority = 4)

    public void makePayment() throws InterruptedException {
        //Continue to make payment
        //19. Click on pay now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(5000);
        //20. Click on continue to payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(7000);
        System.out.println("Make Payment");

    }

    @Test(priority = 5)

    public void SelectCard() throws InterruptedException {
        //21. Select Card as payment method on the iFrame
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        //22. Switch to iframe
        driver.switchTo().frame("kpg-frame-component");
        //23. Locate the card button
        WebElement Cardbutton = driver.findElement(By.className("Card"));
        Cardbutton.click();
        Thread.sleep(3000);
        System.out.println("Opened card payment modal");

        //Enter card details
        //24.Locate the card number field and enter an invalid card number
        WebElement CardNumberField = driver.findElement(By.id("card-number"));
        CardNumberField.sendKeys("5199567841055888");
        Thread.sleep(5000);
        //25. Locate the date field and enter an invalid date
        WebElement DateField = driver.findElement(By.id("expiry"));
        DateField.sendKeys("0652");
        Thread.sleep(5000);
        //26. Locate the CVV field and enter an invalid CVV
        WebElement CVVField = driver.findElement(By.id("cvv"));
        CVVField.sendKeys("052");
        Thread.sleep(5000);
        System.out.println("Enter invalid card details");

        //Print Out the error message: Invalid Card Number
        //27. Locate the error message
        WebElement ErrorMessage = driver.findElement(By.id("card-number_unhappy"));
        Thread.sleep(5000);
        System.out.println("Print the error message");

        //28. Print out the error message
        System.out.println(ErrorMessage.getText());
        Thread.sleep(3000);

        //29. Close the iFrame that displays the input card Modal
        WebElement CloseiFrame = driver.findElement(By.className("data-card__close"));
        CloseiFrame.click();
        System.out.println("Switch out of iframe");
        //30. Switch out of iFrame
        driver.switchTo().defaultContent();
        Thread.sleep(3000);


    }

    @AfterTest
    public void closeBrowser() {

        //31. Close the browser
        System.out.println("Close the browser");
        driver.quit();


    }


}