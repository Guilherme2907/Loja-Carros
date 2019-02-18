/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.service;

import com.guilherme.lojacarros.domain.User;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author Guilherme
 */


public interface EmailService {
    
    void sendEmail(SimpleMailMessage smm);
    
    void sendNewPassword(User user,String newpassword);
}
