package kodlamaio.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;


import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="job_advertisements")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="job__advertisement_id")
    private int jobAdvertisementId;

    @ManyToOne
    @JoinColumn(name="employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name="job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;

    @Column(name="job_description")
    private String jobDescription;

    @Column(name="salary_min")
    private int salaryMin;

    @Column(name="salary_max")
    private int salaryMax;

    @Column(name="recruit_numbers")
    private int recruitNumbers;

    @Column(name="deadline")
    private Date deadline;

    @Column(name="release_date")
    private Date releaseDate;

    @Column(name="is_active")
    private boolean statue;
}
