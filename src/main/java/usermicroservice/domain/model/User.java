package usermicroservice.domain.model;

import java.util.Objects;

public class User {
    private final Long id;
    private final String name;
    private final String lastName;
    private final Long document;
    private final String cellphone;
    private final String email;
    private final Role role;
    private final String password;
    private final String country;
    private final String city;
    private final String academicLevel;
    private final String gitUrl;
    private final String linkedinUrl;
    private final String instagramUrl;

    public User(Long id, String name, String lastName, Long document, String cellphone, String email, Role role, String password, String country, String city, String academicLevel, String gitUrl, String linkedinUrl, String instagramUrl) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.cellphone = cellphone;
        this.email = email;
        this.role = role;
        this.password = password;
        this.country = country;
        this.city = city;
        this.academicLevel = academicLevel;
        this.gitUrl = gitUrl;
        this.linkedinUrl = linkedinUrl;
        this.instagramUrl = instagramUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getDocument() {
        return document;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName) && Objects.equals(document, user.document) && Objects.equals(cellphone, user.cellphone) && Objects.equals(email, user.email) && Objects.equals(role, user.role) && Objects.equals(password, user.password) && Objects.equals(country, user.country) && Objects.equals(city, user.city) && Objects.equals(academicLevel, user.academicLevel) && Objects.equals(gitUrl, user.gitUrl) && Objects.equals(linkedinUrl, user.linkedinUrl) && Objects.equals(instagramUrl, user.instagramUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, document, cellphone, email, role, password, country, city, academicLevel, gitUrl, linkedinUrl, instagramUrl);
    }
}
