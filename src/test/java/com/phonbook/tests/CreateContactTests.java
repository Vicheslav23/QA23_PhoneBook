package com.phonbook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContactTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.isLoginLinkPresent()) {
            app.clickOnRegistrationButton();
        }
//      нажмите на ссылку «Войти»
        app.clickOnLoginLink();
//        Введите поле электронной почты
        app.fillLoginRegistrationForm(new User().setEmail("toto@gmai.com").setPassword("Toto123$-_$"));
//       нажмите «Login»
        app.clickOnLoginButton();
//

    }

    @Test
    public void addContactPositiveTest(){
// click on the ADD link
        app.clickOnAddLink();

//        full in the add contact form (zapolhyem formy)
        app.fillAddContactForm("Karl", "Adam", "1234567898", "adam@gm.com", "Koblenz", "goalkeeper");

//click on the Save button
        app.clickOnSaveButton();

// assert the contact is added
        Assert.assertTrue(app.isContactCreated("Karl"));
    }

    @AfterMethod
    public void deleteContact(){
        app.searchNewContact();
        app.deleteContact();
    }
}
