/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.service.validators;

import com.guilherme.lojacarros.domain.User;
import com.guilherme.lojacarros.dto.UserNewDTO;
import com.guilherme.lojacarros.repository.UserRepository;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.HandlerMapping;

/**
 *
 * @author Guilherme
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public boolean supports(Class<?> type) {
        return UserNewDTO.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserNewDTO userDto = (UserNewDTO) o;
        Optional<User> userEmail = userRepository.findByEmail(userDto.getEmail());
        Optional<User> userCpf = userRepository.findByCpf(userDto.getCpf());

        //Retorna o id presente na uri da requisição
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        if (map.get("id") != null) {
            Long id = Long.parseLong(map.get("id"));
            if (userEmail.isPresent() && !userEmail.get().getId().equals(id)) {
                errors.rejectValue("email", "", "Email ja existente");
            }

            if (userCpf.isPresent() && !userCpf.get().getId().equals(id)) {
                errors.rejectValue("cpf", "", "CPF ja existente");
            }
        } else {
            if (userEmail.isPresent()) {
                errors.rejectValue("email", "", "Email ja existente");
            }

            if (userCpf.isPresent()) {
                errors.rejectValue("cpf", "", "CPF ja existente");
            }
        }
    }
}
