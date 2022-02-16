package fr.iut.rm.persistence.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/**
 * A classic room
 */
@Entity
@Table(name = "room")
public class Room {
    /**
     * sequence generated id
     */
    @Id
    @GeneratedValue
    private long id;

    /**
     * desc limitée à 10 caractères
     */
    @Column(nullable = true)
    @Length(max = 10)
    private String description;

    /**
     * Room's name
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Default constructor (do nothing)
     */
    public Room() {
        // do nothing
    }

    /**
     * anemic getter
     *
     * @return the room's id
     */
    public long getId() {
        return id;
    }

    /**
     * anemic setter
     *
     * @param id the new id
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * anemic getter
     *
     * @return the calling number
     */
    public String getName() {
        return name;
    }

    /**
     * anemic setter
     *
     * @param name the new calling number to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
