package com.phonebook.tests;

import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    //  Предварительное условие: пользователь должен выйти из системы
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }

//      нажмите на ссылку «Войти»
        app.getHeader().clickOnLoginLink();
    }
    @Test(priority = 1)
    public void loginPositiveTest(){

//        Введите поле электронной почты
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("toto@gmai.com")
                .setPassword("Toto123$-_$"));

//       нажмите «Login»
        app.getUser().clickOnLoginButton();

//       заявить о том, что пользователь вошел в систему (отображается кнопка «Выйти»)
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }
    @Test(priority = 2)
    public void loginNegativeWithoutPasswordTest(){

//        Введите поле электронной почты
        app.getUser().fillLoginRegistrationForm(new User().setEmail("toto@gmai.com"));

//       нажмите «Login»
        app.getUser().clickOnLoginButton();

//       заявить о том, что пользователь вошел в систему (отображается кнопка «Выйти»)
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
