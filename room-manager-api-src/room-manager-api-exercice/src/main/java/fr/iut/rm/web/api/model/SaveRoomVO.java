package fr.iut.rm.web.api.model;

/**
 * Defines a room to create for the API layer (Room Visual Object)
 */
public class SaveRoomVO {
    // TODO add necessary fields
    /**
     * Room's name.
     */
    private String name;
    /**
     * Room's description
     */
    private String description;
    /**
     * Gets name.
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new name.
     *
     * @param name new value of name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets new description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
