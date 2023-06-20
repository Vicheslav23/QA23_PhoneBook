package com.phonbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    //  Предварительное условие: пользователь должен выйти из системы
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignOutButton();
        }

//      нажмите на ссылку «Войти»
        app.clickOnLoginLink();
    }
    @Test
    public void loginPositiveTest(){

//        Введите поле электронной почты
        app.fillLoginRegistrationForm(new User()
                .setEmail("toto@gmai.com")
                .setPassword("Toto123$-_$"));

//       нажмите «Login»
        app.clickOnLoginButton();

//       заявить о том, что пользователь вошел в систему (отображается кнопка «Выйти»)
        Assert.assertTrue(app.isSignOutButtonPresent());
    }
    @Test
    public void loginNegativeWithoutPasswordTest(){

//        Введите поле электронной почты
        app.fillLoginRegistrationForm(new User().setEmail("toto@gmai.com"));

//       нажмите «Login»
        app.clickOnLoginButton();

//       заявить о том, что пользователь вошел в систему (отображается кнопка «Выйти»)
        Assert.assertTrue(app.isAlertPresent());
    }

}
