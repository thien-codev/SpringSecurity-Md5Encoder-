/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Demo webservice
 * @author XV
 */
@Controller
public class HelloController {

    /*
    Day khong phai la rest service
    */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(Model model) {
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z	");
	String formattedDate = dateFormat.format(date);
	model.addAttribute("serverTime", formattedDate);

	return "hello";
    }
    
    /**
     Day la rest service truoc spring 4.*
     */
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello1(Model model) {
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z	");
	String formattedDate = dateFormat.format(date);
	model.addAttribute("serverTime", formattedDate);

	return "hello";
    }
}
