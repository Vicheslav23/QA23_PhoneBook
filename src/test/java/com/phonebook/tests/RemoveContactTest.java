package com.phonebook.tests;

import com.phonebook.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;

public class RemoveContactTest extends TestBase {
    @BeforeMethod
    public void beforeCheckingRemovesContact(){
        app.getHeader().clickOnLoginLink();
        app.getUser().fillLoginRegistrationForm(new User().setEmail("toto@gmai.com")
                .setPassword("Toto123$-_$"));
        app.getUser().clickOnLoginButton();
                //checkRemoveContact(); // dly strok 30-33
        removeContactTest();
    }
    //        ili
//    public void ensurePreconditions(){
//        if (app.getHeader().isLoginLinkPresent()){
//            app.getHeader().clickOnLoginLink();
//            app.getUser().login();
//            app.getHeader().clickOnAddLink();
//            app.getContact().addContact();
//        } else {
//            app.getHeader().clickOnSignOutButton();
//        }
//    }
//    @Test
//    public void checkRemoveContact(){
//        Assert.assertTrue(app.getContact().isContactListEmpty());
//    }
//    ili do strok 19-28
    @Test
    public void removeContactTest(){

        int sizeBefore = app.getContact().sizeOfContacts();

        app.getContact().removeContact();

        app.getContact().pause(1000);

        int sizeAfter = app.getContact().sizeOfContacts();

        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }
}

