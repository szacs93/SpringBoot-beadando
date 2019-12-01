package hu.szacs93.beadando.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {
   @RequestMapping(value =  {"/index", "/"})
   public String index() {
      return "index";
   }
   
   @RequestMapping(value =  {"/etlap"})
   public String etlap() {
      return "etlap";
   }
   
   @RequestMapping(value =  {"/editor"})
   public String editor() {
      return "editor";
   }
}