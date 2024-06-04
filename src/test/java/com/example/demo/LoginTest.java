package com.example.demo;

import com.example.demo.pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest extends SpringBaseTestNGTest {

    @Autowired
    LoginPage loginPage;

    @Test
    void canLogInWithCorrectCredentials() {

        loginPage
                .goTo()
                .logIn("standard_user", "secret_sauce");

        Assertions.assertThat(loginPage.getPageTitle().getText()).isEqualTo("Swag Labs");
    }


    @Test(dataProvider = "invalidPortNumbers2")
    void cannotLoginWithIncorrectCredentials(String name, String password) {

        loginPage
                .goTo()
                .logIn(name, password);

        Assertions.assertThat(loginPage.getLoginBtn()).matches(WebElement::isDisplayed);
    }

    @DataProvider
    private Object[][] invalidPortNumbers2() {
        return new Object[][]{
                {"aaa", "secret_sauce"},
                {"standard_user", "aaa"}
        };
    }
}
