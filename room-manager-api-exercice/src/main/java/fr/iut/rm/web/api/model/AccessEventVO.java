package fr.iut.rm.web.api.model;

import fr.iut.rm.persistence.domain.EventType;

public class AccessEventVO {
    private String UserName;

    private EventType type;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
