package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User{

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="nationalty_id")
    private String nationaltyId;

    @Column(name="birth_year")
    private int birthYear;

}
