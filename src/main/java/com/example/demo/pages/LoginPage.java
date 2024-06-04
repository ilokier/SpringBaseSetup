package com.example.demo.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Component
@Scope("prototype")
public class LoginPage extends Base {
    private static final Logger log = LoggerFactory.getLogger("LoginPage.class");

    @FindBy(css = "#user-name")
    private WebElement username;
    @FindBy(css = "#password")
    private WebElement password;
    @FindBy(css = "#login-button")
    private WebElement loginBtn;
    @FindBy(css = ".header_label .app_logo")
    private WebElement pageTitle;

    public LoginPage goTo() {
        log.info("going to page: {}", properties.getUrl());
        driver.get(properties.getUrl());

        return this;
    }

    public LoginPage logIn(String name, String password) {
        log.info("Logging with credentials: \n name: {} \n password: {}", name, password);

        fillInput(username, name);
        fillInput(this.password, password);
        waitAndClick(loginBtn);

        return this;
    }
}
