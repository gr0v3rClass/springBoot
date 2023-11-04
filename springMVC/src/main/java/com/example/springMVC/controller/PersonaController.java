package com.example.springMVC.controller;

import com.example.springMVC.SpringMvcApplication;
import com.example.springMVC.entity.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonaController {

    private static Logger LOG = LoggerFactory.getLogger(SpringMvcApplication.class);
    @GetMapping("/persona")
    public String persona( @RequestParam(name="name",required = false,defaultValue = "favio") String name, Model model){
        model.addAttribute("name", name);
        return "persona";
    }

    @PostMapping("/save")
    public void savePersona(){
        LOG.info("registrar");
    }
}
