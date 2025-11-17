package com.example.demo.provider_cases.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.example.demo.provider_cases.CafeService;
import com.example.demo.provider_cases.Cafes;

@Controller
public class CafesController {
    
@Autowired
private CafeService cafeService;

@GetMapping("/cafes")
public Object getAllCafes(Model model) {
    //return cafeService.getAllCafes();
    model.addAttribute("cafesList", cafeService.getAllCafes());
    return "cafe_dashboard"; //returns cafe_dashboard.ftlh 
}

@GetMapping("/cafes/{cafeId}")
public Object getCafeById(@PathVariable Long cafeId) {
    return cafeService.getCafeById(cafeId);
}
@GetMapping("/cafes/cafeName")
public Object getCafeByName(@RequestParam String cafeName) {
    if (cafeName != null) {
        return cafeService.getCafeByName(cafeName);
    } else {
        return cafeService.getAllCafes();
    }
}


@GetMapping("/cafes/createForm")
public String showAddCafeForm(Model model) {
    model.addAttribute("cafe", new Cafes());
    System.out.println("showAddCafeForm called"); //sanity check in terminal
    return "create_cafe_form"; 
}
@PostMapping("/cafes")
public Object addCafe (Cafes cafe) {
    Cafes newCafe = cafeService.addCafe(cafe);
    System.out.println("New cafe received: " + newCafe.getCafeName()); //sanity check in terminal 
    return "redirect:/cafes";
}

@GetMapping("/cafes/delete/{cafeId}")
public Object deleteCafe(@PathVariable Long cafeId) {
    cafeService.deleteCafe(cafeId);
    return "redirect:/cafes";
}
}