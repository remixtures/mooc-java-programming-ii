/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */
public class Book {
    
    private String title;
    private int ageRecommendation;
    
    public Book(String title, int ageRecommendation) {
        this.title = title;
        this.ageRecommendation = ageRecommendation;
    }

    public String getTitle() {
        return title;
    }

    public int getAgeRecommendation() {
        return ageRecommendation;
    }

    @Override
    public String toString() {
        return this.getTitle() + " (recommended for " + this.getAgeRecommendation() + " year-olds or older)";
    }
    
    
    
}
