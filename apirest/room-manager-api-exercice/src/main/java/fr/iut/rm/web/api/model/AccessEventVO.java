package fr.iut.rm.web.api.model;

import fr.iut.rm.persistence.domain.EventType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class AccessEventVO {
    @Column
    private String userName;
    @Column
    @Enumerated(EnumType.STRING)
    private EventType type;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
