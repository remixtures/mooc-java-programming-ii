/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */
public class CD implements Packable {
    
    private String artist;
    private String recordTitle;
    private int publicationYear;
    
    public CD(String artist, String recordTitle, int publicationYear) {
        this.artist = artist;
        this.recordTitle = recordTitle;
        this.publicationYear = publicationYear;
    }

    @Override
    public double weight() {
        return 0.1;
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.recordTitle + " (" + this.publicationYear + ")";
    }
    
    
    
}
