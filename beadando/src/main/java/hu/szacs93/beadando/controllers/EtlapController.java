package hu.szacs93.beadando.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EtlapController {
   @RequestMapping(value =  {"/etlap"})
   public String index() {
      return "etlap";
   }
}