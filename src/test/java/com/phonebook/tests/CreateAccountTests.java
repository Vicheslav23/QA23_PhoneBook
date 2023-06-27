package com.phonbook.tests;

import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

//  Предварительное условие: пользователь должен выйти из системы
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }

//      нажмите на ссылку «Войти»
//        driver.findElement(By.xpath("//a[.='LOGIN']")).click(); => optimiziruem
        app.getHeader().clickOnLoginLink();
    }

    @Test
    public void existedUserRegistrationNegativeTest(){

//        Введите поле электронной почты
//        Введите поле пароля
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("toto@gmai.com")
                .setPassword("Toto123$-_$"));

//       нажмите «Регистрация»
        app.getUser().clickOnRegistrationButton();

//       заявить о том, что пользователь вошел в систему (отображается кнопка «Выйти»)
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
