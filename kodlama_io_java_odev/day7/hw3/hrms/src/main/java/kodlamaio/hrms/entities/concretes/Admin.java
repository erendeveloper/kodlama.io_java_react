package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="admins")
@AllArgsConstructor
@NoArgsConstructor

public class Admin extends User{

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;


}
