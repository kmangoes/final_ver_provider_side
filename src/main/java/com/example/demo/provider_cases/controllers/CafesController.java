package com.example.demo.provider_cases.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@GetMapping("/cafes/addCafeForm")
public String showAddCafeForm() {
    return "add_cafe_form"; // returns the name of the view (e.g., add_cafe_form.ftlh) NOT YET MADE
}
@PostMapping("/cafes")
public Cafes addCafe (@RequestBody Cafes cafe) {
    return cafeService.addCafe(cafe);
}
@DeleteMapping("/cafes/delete/{cafeId}")
public Object deleteCafe(@PathVariable Long cafeId) {
    cafeService.deleteCafe(cafeId);
    return "redirect:/cafes";
}
}