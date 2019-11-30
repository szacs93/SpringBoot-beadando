package hu.szacs93.beadando.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EditorController {
   @RequestMapping(value =  {"/editor"})
   public String index() {
      return "editor";
   }
}