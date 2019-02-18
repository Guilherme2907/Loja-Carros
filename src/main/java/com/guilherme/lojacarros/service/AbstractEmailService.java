/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.service;

import com.guilherme.lojacarros.domain.User;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

/**
 *
 * @author Guilherme
 */
public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendNewPassword(User user, String newPassword) {
        SimpleMailMessage smm = prepareMailMessage(user, newPassword);
        sendEmail(smm);
    }

    private SimpleMailMessage prepareMailMessage(User user, String newPassword) {
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setTo(user.getEmail());
        smm.setFrom(sender);
        smm.setSubject("Nova Senha");
        smm.setSentDate(new Date(System.currentTimeMillis()));
        smm.setText(newPassword);
        return smm;
    }

}
