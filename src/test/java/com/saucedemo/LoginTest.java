package com.saucedemo;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        getBaseUrl();
        assertTitle();
        input_userName();
        input_userPassword();
        clickButtonLogin();
        assertTitleProductPage();
    }
}
