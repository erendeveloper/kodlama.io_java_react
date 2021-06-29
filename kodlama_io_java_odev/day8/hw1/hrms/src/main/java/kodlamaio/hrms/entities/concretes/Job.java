package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="jobs")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Job{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="job_id")
    private
    int jobId;

    @Column(name="job_name")
    private
    String jobName;

    @OneToMany(mappedBy = "job")
    private List<JobAdvertisement> jobAdvertisements;

}
