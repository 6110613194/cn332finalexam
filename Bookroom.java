/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn332finalproject;

import java.util.ArrayList;

/**
 *
 * @author pong
 */
public class Bookroom {
    private ArrayList<Room> listroom = new ArrayList<Room>();

    public Bookroom() {
        this.listroom.add(new Room(1,"normal",500));
        this.listroom.add(new Room(2,"vip",1000));
        this.listroom.add(new Room(3,"paradize",300));
    }
    
     public ArrayList<Room> getListroom() {
        return listroom;
    }

}
