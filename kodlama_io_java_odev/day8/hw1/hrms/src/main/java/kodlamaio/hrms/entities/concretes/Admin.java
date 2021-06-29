package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="admins")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy= InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="admin_id", referencedColumnName = "user_id")
public class Admin extends User{

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;


}
