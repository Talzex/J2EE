package fr.iut.rm.web.api.model;

import fr.iut.rm.persistence.domain.EventType;

public class AccessEventVO {
    private String name;
    private EventType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
