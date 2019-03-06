/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.service.util;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class URL {

    public static List<String> decodeList(String s) {
        return Arrays.asList(s.split(","));
    }
}
