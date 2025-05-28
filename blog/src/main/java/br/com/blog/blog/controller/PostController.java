package br.com.blog.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @GetMapping("/mensagem")
    public String mensagem(){
        return "Meu primeiro post";
    }
    
}
