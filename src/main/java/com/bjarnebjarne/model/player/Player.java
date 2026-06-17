package com.bjarnebjarne.model.player;

import java.util.ArrayList;
import java.util.List;

import com.bjarnebjarne.model.board.squares.PurchaseableSquare;

public class Player {
    private String name;
    private int balance;
    private int position;
    private boolean inJail;
    private final List<PurchaseableSquare> ownedProperties;

    public Player(String name) {
        this.name = name;
        this.balance = 0;
        this.position = 0;
        this.inJail = false;
        this.ownedProperties = new ArrayList<>();
    }

    public void move(int movement) {
        this.position += movement;
    }

    public void changeBalance(int change) {
        this.balance += change;
    }

    public void addProperty(PurchaseableSquare property) {
        ownedProperties.add(property);
    }

    public void removeProperty(PurchaseableSquare property) {
        boolean removed = ownedProperties.remove(property);
        if(!removed) throw new IllegalStateException("Could not remove property from player");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBalance() {
        return balance;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public boolean isInJail() {
        return inJail;
    }
    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }
    public List<PurchaseableSquare> getOwnedProperties() {
        return ownedProperties;
    }
}
