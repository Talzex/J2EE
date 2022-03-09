package fr.iut.rm.web.api.model;

import fr.iut.rm.persistence.domain.EventType;

public class AccessEventVO {
    private String userName;
    private EventType type;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
