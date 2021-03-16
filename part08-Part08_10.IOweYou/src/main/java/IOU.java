/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */
import java.util.HashMap;

public class IOU {
    
    private HashMap<String, Double> letterOfCredit;
    
    public IOU() {
        letterOfCredit = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount) {
        this.letterOfCredit.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        double debt = this.letterOfCredit.getOrDefault(toWhom, 0.0);
        return debt;
    }
}
