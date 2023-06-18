package com.phonbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

//  Предварительное условие: пользователь должен выйти из системы
    @BeforeMethod
    public void ensurePrecondition(){
        if (!isElementPresent(By.xpath("//a[.='LOGIN']"))) {
            click(By.xpath("//button[.='Sign Out']"));
        }

//      нажмите на ссылку «Войти»
//        driver.findElement(By.xpath("//a[.='LOGIN']")).click(); => optimiziruem
        click(By.xpath("//a[.='LOGIN']"));
    }
    @Test
    public void existedUserRegistrationNegativeTest(){

//        Введите поле электронной почты
        type(By.cssSelector("[placeholder='Email']"), "kan@gmai.com");

//        Введите поле пароля
        type(By.cssSelector("[placeholder='Password']"), "Kan123$-_$");

//       нажмите «Регистрация»
        click(By.name("registration"));

//       заявить о том, что пользователь вошел в систему (отображается кнопка «Выйти»)
        Assert.assertTrue(isAlertPresent());
    }



}
