package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="employer_id", referencedColumnName = "user_id")

public class Employer extends User{

    @Column(name="company_name")
    private String companyName;

    @Column(name="website_address")
    private String websiteAddress;

    @Column(name="phoneNumber")
    private String phoneNumber;

}
