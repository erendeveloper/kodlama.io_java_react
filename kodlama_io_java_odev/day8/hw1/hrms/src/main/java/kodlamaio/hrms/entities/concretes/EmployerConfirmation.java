package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//@Data
//@Entity
//@Table(name="employer_confirmation")
//@AllArgsConstructor
//@NoArgsConstructor
public class EmployerConfirmation{  //su an kullanmiyorum

    //@Column(name="email_confirmed")
    private boolean emailConfirmed;

    //@Column(name="admin_confirmed")
    private boolean adminConfirmed;

}
