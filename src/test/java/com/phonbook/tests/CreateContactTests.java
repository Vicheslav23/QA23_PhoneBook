package com.phonbook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContactTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
//      нажмите на ссылку «Войти»
        app.getHeader().clickOnLoginLink();
//        Введите поле электронной почты
        app.getUser().fillLoginRegistrationForm(new User().setEmail("toto@gmai.com").setPassword("Toto123$-_$"));
//       нажмите «Login»
        app.getUser().clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){
// click on the ADD link
        app.getHeader().clickOnAddLink();

//        full in the add contact form (zapolhyem formy)
        app.getContact().fillAddContactForm(new Contact()
                .setName("Karl")
                .setLastname("Adam")
                .setPhone("1234567898")
                .setEmail("adam@gm.com")
                .setAddress("Koblenz")
                .setDescription("goalkeeper"));

//click on the Save button
        app.getContact().clickOnSaveButton();

// assert the contact is added
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
    }

    @AfterMethod
    public void deleteContact(){
        app.getContact().searchNewContact();
        app.getContact().deleteContact();
    }

//    ili

//    @AfterMethod
//    public void postCondition() {
//        app.getContact().removeContact();
//    }
}
