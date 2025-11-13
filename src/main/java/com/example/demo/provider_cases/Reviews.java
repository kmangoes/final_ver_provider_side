package com.example.demo.provider_cases;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String reviewText;
    @Column(nullable = false) 
    private int starRating;
    @Column(nullable = false)
    private String cafeName; 
    @Column 
    private String reviewDate;

    public Reviews() { } //empty constructor for JPA

    public Reviews(String userName, String reviewText, int starRating, String reviewDate, String cafeName) {
        this.userName = userName;
        this.reviewText = reviewText;
        this.starRating = starRating;
        this.reviewDate = reviewDate;
        this.cafeName = cafeName;
    }
    public Reviews(Long reviewId, String userName, String reviewText, int starRating, String reviewDate, String cafeName) {
        this.reviewId = reviewId;
        this.userName = userName;
        this.reviewText = reviewText;
        this.starRating = starRating;
        this.reviewDate = reviewDate;
        this.cafeName = cafeName; 
    }

    public Long getReviewId(Long reviewId) {
        return reviewId;
    }
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
    public String getUserName(String userName) {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getReviewText(String reviewText) {
        return reviewText;
    }
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
    public int getStarRating(int starRating) {
        return starRating;
    }
    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }
    public String getReviewDate(String reviewDate) {
        return reviewDate;
    }
    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }
    public String getCafeName(String cafeName) {
        return cafeName; 
    }
    public void setCafeName(String cafeName) {
        this.cafeName = cafeName; 
    }
    
}
