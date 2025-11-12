package com.example.demo.provider_cases;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cafes")
public class Cafes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cafeId;

    @Column(nullable = false)
    private String cafeName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int rating;

    public Cafes() {} //empty constructor

    public Cafes (Long cafeId, String cafeName, String address, String description, int rating) {
        this.cafeId = cafeId;
        this.cafeName = cafeName;
        this.address = address;
        this.description = description;
        this.rating = rating; 
    }
    public Cafes (String cafeName, String address, String description, int rating) {
        this.cafeName = cafeName;
        this.address = address;
        this.description = description;
        this.rating = rating; 
    }

    public Long getCafeId() {
        return cafeId;
    }
    public void setCafeId(Long cafeId) {
        this.cafeId = cafeId;
    }
    public String getCafeName() {
        return cafeName;
    }
    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress (String address) {
        this.address = address;
    }
    public String getDescription() {
        return description; 
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
}
