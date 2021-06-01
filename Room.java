/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn332finalproject;

/**
 *
 * @author pong
 */
public class Room implements Pay{
    private int id;
    private String roomtype;
    private int cost;
    private boolean ispay = false;

    public Room(int id, String roomtype, int cost) {
        this.id = id;
        this.roomtype = roomtype;
        this.cost = cost;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public int getCost() {
        return cost;
    }
 
    public int getId() {
        return id;
    }

    public boolean isIspay() {
        return ispay;
    }

    public void setIspay(boolean ispay) {
        this.ispay = ispay;
    }
    
    
    @Override
    public void paycash() {
        //รอรับการใช้งานจริงๆ
        setIspay(true);
    }

    @Override
    public void paycredit() {
        //รอรับการใช้งานจริงๆ
        setIspay(true);
    }
    
    
}
