package com.bridgelabz.page;

import com.bridgelabz.base.BaseClass;
import com.bridgelabz.util.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseClass {
    RegistrationPage registrationPage;
    HomePage homePage;
    @BeforeMethod
    public void setup(){
        launchBrowser();
        registrationPage = new RegistrationPage();
    }
    @Test
    public void verifyRegistrationPageTitleTest(){
        String registationPageTitle = registrationPage.verifyRegistretionPageTitle();
        Assert.assertEquals(registationPageTitle,"Sign Up for Meesho | Meesho");
    }
    @DataProvider
    public Object[][] getRegistrationTestData(){return Utility.getTestData("registration");
    }
    @Test(dataProvider = "getRegistrationTestData")
    public void loginTest(String firstname,String lastName,String phonenum,String passwors){
        homePage = registrationPage.registation(firstname,lastName,phonenum,passwors);

    }
    @AfterMethod
    public void tearDpwn() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }

}
