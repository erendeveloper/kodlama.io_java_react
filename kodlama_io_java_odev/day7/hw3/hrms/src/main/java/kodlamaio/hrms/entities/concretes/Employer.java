package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User{

    @Column(name="company_name")
    private String companyName;

    @Column(name="website_address")
    private String websiteAddress;

    @Column(name="phoneNumber")
    private String phoneNumber;

}
