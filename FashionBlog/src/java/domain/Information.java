package domain;
// Generated Oct 7, 2020 8:41:29 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Information generated by hbm2java
 */
@Entity
@Table(name = "Information",
         catalog = "FashionBlog"
)
public class Information implements java.io.Serializable {

    private int id;
    private String name;
    private int age;
    private String img;
    private String description;

    public Information() {
    }

    public Information(int id, String name, int age, String img, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.img = img;
        this.description = description;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age", nullable = false)
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "img", nullable = false, length = 50)
    public String getImg() {
        return "img/" + this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}