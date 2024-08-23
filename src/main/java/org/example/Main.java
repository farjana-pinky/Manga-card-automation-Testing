package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\ChromeDriver\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://myalice-automation-test.netlify.app/");
        driver.manage().window().maximize();

//login page functionality..................................................................................................
//..........................................................................................................................
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id = \"username\"]")).sendKeys("testuser");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("password");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id = \"login-btn\"]")).click();

        Thread.sleep(2000);
        //validation the loginpage

        String actualUrl = "https://myalice-automation-test.netlify.app/";
        String expectedUrl = driver.getCurrentUrl();
        //(Assert.assertEquals(expectedUrl,actualUrl);
        if (actualUrl.equals(expectedUrl)) {

            System.out.println("This is valid login page");

        } else {

            System.out.println("invalid login page");
        }


        //Manga Search and Display.........................................................................................
        //..................................................................................................................

       //Enter Naruto input in the searchbox and click on search bar......
        driver.findElement(By.xpath("//input[@id = \"manga-search\"]")).sendKeys("Naruto");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains (text() , \"Search\")]")).click();

       //varity the Naruto is displayed or not.............
        System.out.println("The Naruto is displayed = " + driver.findElement(By.xpath("//h3[contains (text() , \"Naruto\")]")).isDisplayed());

        //clear the search box data
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id = \"manga-search\"]")).clear();

        //Enter One piece input in the searchbox and click on search bar......
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id = 'manga-search']")).sendKeys("One Piece");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains (text() , \"Search\")]")).click();

        //varity the one piece manga card is displayed or not.............
        System.out.println("The One piece is displayed = " + driver.findElement(By.xpath("//h3[contains (text() , \"One Piece\")]")).isDisplayed());

       //clear the data from search box....
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id = 'manga-search']")).clear();

        //Enter Seven Deadly Sins input in the searchbox and click on search bar......
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id = 'manga-search']")).sendKeys("Seven Deadly Sins");
        driver.findElement(By.xpath("//button[contains (text() , \"Search\")]")).click();

        // verify the Seven Deadly Sins manga card is displayed or not
        String actualTitle = "Seven Deadly Sins";
        String expectedTitle = driver.getTitle();
        //(Assert.assertEquals(expectedUrl,actualUrl);
        if (actualTitle.equals(expectedTitle)) {

            System.out.println("The  Seven Deadly Sins manga card is shwong");

        } else {

            System.out.println("There are no Seven Deadly Sins manga card");
        }

        // clear the data from search box....
        driver.findElement(By.xpath("//input[@id = 'manga-search']")).clear();

        //Enter random input in the searchbox and click on search bar......
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id = 'manga-search']")).sendKeys("ABC");
        driver.findElement(By.xpath("//button[contains (text() , \"Search\")]")).click();

        //verfity the no manga found msg is displayed or not.....
        System.out.println("The no manga found msg is displayed = " + driver.findElement(By.xpath("//div[@id = \"root\"]/descendant::p[1]")).isDisplayed());

        //Manga Details Modal..........................................................................................
        //.............................................................................................................
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id = 'manga-search']")).clear();

         // Enter Attack on Titan input in the search box and click on search bar .....
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id = 'manga-search']")).sendKeys("Attack on Titan");
        driver.findElement(By.xpath("//button[contains (text() , \"Search\")]")).click();

        //click on details option of Attack on Titan manga card....
        driver.findElement(By.xpath("//div[@id = \"root\"]/child::div[1]/child::div[2]/child::div/child::p[1]/child::span")).click();

        // verify the information of the Attack on Titan manga card like image,name and summary are displayed or not....
        //Title name of the card
        System.out.println("The name titile is displayed = " + driver.findElement(By.xpath("//div[@id = \"root\"]/child::div[1]/child::div[3]/child::div[1]/child::h3")).isDisplayed());

        //The image of manga card
        Thread.sleep(3000);
      WebElement imgage = driver.findElement(By.xpath("//div[@id = \"root\"]/child::div[1]/child::div[3]/child::div[1]/child::img"));
      String img= imgage.getAttribute("src");
      System.out.println(img);
      if(imgage.isDisplayed())
      {

          System.out.println("The image of Attack on Titan manga card is display");
      }
      else
      {
          System.out.println("The image of Attack on Titan manga card is not display");

      }

     // the summary of manga card
      WebElement text = driver.findElement(By.xpath("//div[@id = \"root\"]/child::div[1]/child::div[3]/child::div[1]/child::p[1]"));
      if(text.isDisplayed())
      {
          System.out.println("The summary of Attack on Titan manga card is display");
      }

      System.out.println(text.getText());

      // close the manga card
        driver.findElement(By.xpath("//div[@id = \"root\"]/child::div[1]/child::div[3]/child::div[1]/child::button[1]")).click();

        Thread.sleep(1000);
        driver.close();
    }

}