package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="employer_id", referencedColumnName = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})

public class Employer extends User{

    @Column(name="company_name")
    private String companyName;

    @Column(name="website_address")
    private String websiteAddress;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="email_confirmed")
    private boolean emailConfirmed;

    @Column(name="admin_confirmed")
    private boolean adminConfirmed;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;

}
