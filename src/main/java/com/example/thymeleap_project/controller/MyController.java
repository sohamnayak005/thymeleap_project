package com.example.thymeleap_project.controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class MyController {
   @GetMapping("/")
   public String getHome() {
       return "Home";
   }
   @GetMapping("/otp")
   public String getOtp(ModelMap map) {
      int otp=new Random().nextInt(10000,100000);
       map.put("otp", otp);
       return "Home";
   }
   
   @GetMapping("/toss")
   public String getToss(ModelMap map) {
       String [] arr={"HEAD","TELL"};
       map.put("toss",arr[new Random().nextInt(0,2)]);
       return "Home";
   }

   @GetMapping("/random")
   public String getRendomColor(ModelMap map) {
       ArrayList<Integer>ali=new ArrayList<>();
       ali.add(new Random().nextInt(0,256));
       ali.add(new Random().nextInt(0,256));
       ali.add(new Random().nextInt(0,256));
       map.put("rcolor",ali);
       return "Home";
   }
   
   @GetMapping("/textcolor")
   public String getColorText(@RequestParam("text") String text,@RequestParam("color") String color,ModelMap map) {
    map.put("text",text);
    map.put("color",color);
    return "Home";
   }

   @GetMapping("/calculator")
   public String getCal(@RequestParam("input1") int n1,@RequestParam("input2") int n2,@RequestParam("btn") String btn,ModelMap map) {
    map.put("n1",n1);
    map.put("n2",n2);
  switch (btn) {
    case "add":
        map.put("data",n1+n2);
        break;
    case "sub":
        map.put("data",n1-n2);
        break;
    case "mul":
        map.put("data",n1*n2);
        break;
    case "div":
        map.put("data",n1/n2);
        break;
  
    default:
        break;
  }
    return "Home";
   }
   
   
}
