/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author miguel
 */
public class Employees {
    
    private List<Person> listOfPersons;
    
    public Employees() {
        this.listOfPersons = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        this.listOfPersons.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd) {
        this.listOfPersons.addAll(peopleToAdd);
    }
    
    public void print() {        
        this.listOfPersons.stream()
            .forEach(person -> {
            System.out.println(person);
        });
    }
    
    public void print(Education education) {
        Iterator<Person> iterator = this.listOfPersons.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getEducation().equals(education)) {
                System.out.println(person);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = this.listOfPersons.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getEducation().equals(education)) {
                // removing from the list the element returned by the previous next-method call
                iterator.remove();
            }
        }
    }
}
