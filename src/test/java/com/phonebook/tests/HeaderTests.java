package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase{

        @Test
        public void searchHeader(){
            Assert.assertTrue(app.getHeader().isLogoPresent());
        }

        @Test
        public void searchHome(){
            Assert.assertTrue(app.getHeader().isHomeLinkPresent());
        }

        @Test
        public void searchAbout(){
            Assert.assertTrue(app.getHeader().isAboutLinkPresent());
        }

        @Test
        public void searchLogin(){
            Assert.assertTrue(app.getHeader().isLoginLinkPresent());
        }
    }