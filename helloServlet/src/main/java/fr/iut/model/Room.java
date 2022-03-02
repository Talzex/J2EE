package fr.iut.model;

public class Room {
    public String name;
    public String occupation;
    public String capacity;

    public Room(String name, String occupation, String capacity) {
        this.name = name;
        this.occupation = occupation;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
