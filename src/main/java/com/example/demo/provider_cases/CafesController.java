package com.example.demo.provider_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CafesController {
    
@Autowired
private CafeService cafeService;

@GetMapping("/cafes")
public Object getAllCafes() {
    return cafeService.getAllCafes();
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
@PostMapping("/cafes")
public Cafes addCafe (@RequestBody Cafes cafe) {
    return cafeService.addCafe(cafe);
}
@DeleteMapping("/cafes/{cafeId}")
public void deleteCafe(@PathVariable Long cafeId) {
    cafeService.deleteCafe(cafeId);
}
}