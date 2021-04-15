package femr.data.models.mysql;
import femr.data.models.core.IRankedPatientMatch;
import io.ebean.annotation.Sql;
import javax.persistence.*;

@Entity
@Sql
public class RankedPatientMatch implements IRankedPatientMatch {

    // doesn't crash when one to many for some reason
    @OneToMany //(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "patient.patientKey.patientId", nullable = false, referencedColumnName = "id"),
            @JoinColumn(name = "patient.patientKey.kitId", nullable = false, referencedColumnName = "kit_id")
    })
    Patient patient;
    Integer rank;

    public RankedPatientMatch(Patient patient, int rank) {
        this.patient = patient;
        this.rank = rank;
    }

    public RankedPatientMatch() {
        this.patient = new Patient();
    }

    @Override
    public Integer getRank() {
        return rank;
    }

    @Override
    public Patient getPatient() {
        return patient;
    }

    @Override
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void setRank(int rank) {
        this.rank = rank;
    }
}
