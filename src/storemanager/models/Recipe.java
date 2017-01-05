/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemanager.models;

import java.util.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author Haris
 */
public class Recipe {
    public SimpleIntegerProperty ID;
    public SimpleIntegerProperty numberOfItems;
    public float totallPrice;
    public Date dateOfCreating;
    public SimpleStringProperty date;
    public ObservableList<Item> items;
    
    public Recipe(int id,ObservableList<Item> articles){
        this.ID = new SimpleIntegerProperty(id);
        this.items = articles;
        this.numberOfItems = new SimpleIntegerProperty(articles.size());
        this.totallPrice = getTotal(articles);
        this.dateOfCreating = new Date();
        this.date = new SimpleStringProperty(dateOfCreating.toString());
    }
    public Recipe(int id,Date dt){
        this.ID = new SimpleIntegerProperty(id);
        this.dateOfCreating = dt;
        this.date = new SimpleStringProperty(dateOfCreating.toString());
    }
    
    public float getTotal(ObservableList<Item> items){
        float totall = 0;
        return totall = items.stream().map((i) -> i.getPrice()).reduce(totall, (accumulator, _item) -> accumulator + _item);
    }
    
    public void setPropertiesFromDb(ObservableList<Item> items){
        this.totallPrice = this.getTotal(items);
        this.numberOfItems = new SimpleIntegerProperty(items.size());
        this.items = items;
    }
    
    public ObservableList<Item> getItems(){
        return this.items;
    }
    public void setItems(ObservableList<Item> articles){
        this.items.addAll(articles);
    }
    public Date getDateOfCreating(){
        return this.dateOfCreating;
    }
    public void setDateOfCreating(Date now){
        this.dateOfCreating = now;
    }
    public float getTotallPrice(){
        return this.totallPrice;
    }
    public void setTotallPrice(float totall){
        this.totallPrice = totall;
    }
    public int getNumberOfItems(){
        return this.numberOfItems.get();
    }
    public void setNumberOfItems(int num){
        this.numberOfItems.set(num);
    }
    public int getID(){
        return this.ID.get();
    }
    public void setID(int id){
        this.ID.set(id);
    }
    public String getDate(){
        return this.date.get();
    }
    public void setDate(String date){
        this.date.set(date);
    }
    
    
}