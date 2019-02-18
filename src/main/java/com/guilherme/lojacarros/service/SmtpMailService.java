/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author Guilherme
 */

@Service
public class SmtpMailService extends AbstractEmailService {

    @Autowired
    private MailSender mailSender;

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SmtpMailService.class);

    @Override
    public void sendEmail(SimpleMailMessage smm) {
        LOG.info("Enviando email");
        mailSender.send(smm);
        LOG.info("Email enviado");
    }
}
