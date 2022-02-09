package bean;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String description;
    @NotNull
    private String name;
    @NotNull
    private String urlRepository;
    private List<Person> teachers = new ArrayList<Person>();
    private List<Person> students = new ArrayList<Person>();
    private List<Person> customers = new ArrayList<Person>();
    private List<Document> mesDocuments = new ArrayList<Document>();

    public String getDescription() {
        return description;
    }

    public List<Person> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Person> teachers) {
        this.teachers = teachers;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    public List<Person> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Person> customers) {
        this.customers = customers;
    }

    public List<Document> getMesDocuments() {
        return mesDocuments;
    }

    public void setMesDocuments(List<Document> mesDocuments) {
        this.mesDocuments = mesDocuments;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlRepository() {
        return urlRepository;
    }

    public void setUrlRepository(String urlRepository) {
        this.urlRepository = urlRepository;
    }
}
