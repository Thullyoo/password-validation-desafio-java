package br.thullyo.passwordvalidation.controller;

import br.thullyo.passwordvalidation.DTO.PassRequest;
import br.thullyo.passwordvalidation.service.ValidatePassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/validate-password")
public class ValidateController {


    private final ValidatePassService validatePassService;

    public ValidateController(ValidatePassService validatePassService){
        this.validatePassService = validatePassService;
    }

    @PostMapping
    public ResponseEntity<?> validatePassword(@RequestBody PassRequest request){
        List<String> listValidated = validatePassService.validatePass(request.password());
        if (listValidated.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().body(listValidated);
        }
    }
}
