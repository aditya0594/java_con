package SeleniumTopic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practice {

   @DataProvider(name = "Login")
    public Object[] [] logindata(){

       return new Object[][]{
               {"Aditya","aditya"}
       };
   }


    }
