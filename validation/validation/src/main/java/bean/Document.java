package bean;

import java.util.Date;

public class Document {
    Person  creator = new Person();
    Person lastModifier;

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public Person getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(Person lastModifier) {
        this.lastModifier = lastModifier;
    }

    private String title;
    private String content;
    private Date creationDate;
    private Date lastModification;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModification() {
        return lastModification;
    }

    public void setLastModification(Date lastModification) {
        this.lastModification = lastModification;
    }
}
