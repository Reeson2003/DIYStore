package ru.reeson2003.diystore.model.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Date: 13.05.2017.
 * Time: 9:28.
 *
 * @author Pavel Gavrilov.
 */
@Entity
@Table(name = "artisan_params")
@Access(AccessType.FIELD)
public class ArtisanParams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private Date birthDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "artisanParams")
    private Artisan artisan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Artisan getArtisan() {
        return artisan;
    }

    public void setArtisan(Artisan artisan) {
        this.artisan = artisan;
    }
}
