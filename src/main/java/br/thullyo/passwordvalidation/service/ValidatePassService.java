package br.thullyo.passwordvalidation.service;

import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

@Service
public class ValidatePassService {

    private List<String> listOfValidates = new ArrayList<>();

    public List<String> validatePass(String password){
        listOfValidates.clear();
        if (!(password.length() >=8)){
            listOfValidates.add("A senha deve possuir pelo menos 08 caracteres.");
        }
        if (!(password.matches(".*[A-Z].*"))){
            listOfValidates.add("A senha deve conter pelo menos uma letra maiúscula.");
        }
        if (!(password.matches(".*[a-z].*"))){
            listOfValidates.add("A senha deve conter pelo menos uma letra minúscula.");
        }
        if (!(password.matches(".*[0-9].*"))){
            listOfValidates.add("A senha deve conter pelo menos um dígito numérico.");
        }
        if (!(password.matches(".*[!@#$%].*"))){
            listOfValidates.add("A senha deve conter pelo menos um caractere especial (e.g, !@#$%).");
        }
        return listOfValidates;
    }

}
