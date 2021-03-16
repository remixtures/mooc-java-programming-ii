/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */
public class LiteracyRates {
    
    private String gender;
    private String countryName;
    private int year;
    private double literacyLevel;
    
    public LiteracyRates(String gender, String countryName, int year, double literacyLevel) {
        this.gender = gender;
        this.countryName = countryName;
        this.year = year;
        this.literacyLevel = literacyLevel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getLiteracyLevel() {
        return literacyLevel;
    }

    public void setLiteracyLevel(double literacyLevel) {
        this.literacyLevel = literacyLevel;
    }

    @Override
    public String toString() {
        return this.getCountryName() + " (" + this.getYear() + "), " + this.getGender() + ", " + this.getLiteracyLevel();
    }
}
