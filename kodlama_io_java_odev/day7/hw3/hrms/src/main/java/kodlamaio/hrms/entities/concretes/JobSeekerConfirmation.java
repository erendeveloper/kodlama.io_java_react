package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@Table(name="job_seeker_confirmation")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerConfirmation extends JobSeeker{

    @Column(name="email_confirmed")
    private boolean emailConfirmed;

}
