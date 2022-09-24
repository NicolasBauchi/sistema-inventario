package com.inventario.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EquipoControler {

    @RequestMapping("/brian")
    @ResponseBody
    public String hacerHuevo(){

        return "<h1>BRIAN SE LA COME</h1> <br> <h2>nico capo</h2>";
    }
}
