package com.cydeo.runners.java_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class week6 {

    public static void main(String[] args) {

        //false samples
        System.out.println("passwordValidation(\"lollipop\") = " + passwordValidation("lollipop"));
        System.out.println("passwordValidation(\"(jayjaypay\") = " + passwordValidation("(jayjaypay"));
        System.out.println("passwordValidation(\"pro76Yh2f\") = " + passwordValidation("pro76Yh2f"));
        System.out.println("passwordValidation(\"123q\") = " + passwordValidation("123q"));
        //true sampples
        System.out.println("passwordValidation(\"(Jiopp2456\") = " + passwordValidation("(Jiopp2456"));
        System.out.println("passwordValidation(\"5525)(*Ikkfsd\") = " + passwordValidation("5525)(*Ikkfsd"));
        System.out.println("passwordValidation(\"345hjgHH@\") = " + passwordValidation("345hjgHH@"));
        System.out.println("passwordValidation(\"HaveNoPass1@\") = " + passwordValidation("HaveNoPass1@"));

    }

    //TASK1
    /*
    //    TASK1_______________________________
    //    String -- Password Validation Task 1.
    //    Write a return method that can verify if a password is valid or not.
    //    requirements:
    //    1. Password MUST be at least have 6 characters and should not contain space
    //    2. PassWord should at least contain one upper case letter
    //    3. PassWord should at least contain one lowercase letter
    //    4. Password should at least contain one special characters
    //    5. Password should at least contain a digit if all requirements above are met,
    //            the method returns true, otherwise returns false
    //     */
    public static boolean passwordValidation(String password){
        boolean passwordValidation = true;
        if(password.contains(" ") || password.length()<5){
            passwordValidation = false;
        }
        if(!Pattern.compile("[A-Z]").matcher(password).find()){
            passwordValidation = false;
        }
        if(!Pattern.compile("[a-z]").matcher(password).find()){
            passwordValidation = false;
        }
        if(!Pattern.compile("[0-9]").matcher(password).find()){
            passwordValidation = false;
        }
        if (!Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find()) {
            return false;
        }
        return passwordValidation;
    }



}
