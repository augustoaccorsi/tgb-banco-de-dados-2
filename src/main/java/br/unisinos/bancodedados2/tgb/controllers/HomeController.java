package br.unisinos.bancodedados2.tgb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController{
	
   @GetMapping("/")
   public String index(){
      return "home/index";
   }
}
