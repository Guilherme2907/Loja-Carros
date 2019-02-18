/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.service.util;

import java.util.Random;

/**
 *
 * @author Guilherme
 */
public class PasswordUtil {

    public static Random random = new Random();

    public static String generateNewPassowrd() {
        char[] newPass = new char[10];
        for (int i = 0; i < newPass.length; i++) {
            newPass[i] = randomDigit();
        }
        return newPass.toString();
    }

    private static char randomDigit() {
        int num = random.nextInt(3);
        
        switch (num) {
            case 0:
                return (char) (random.nextInt(10) + 48);
            case 1:
                return (char) (random.nextInt(25) + 95);
            default:
                return (char) (random.nextInt(25) + 65);
        }
    }
}
