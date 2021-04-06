package femr.data.models.mysql;
import femr.data.models.core.IRankedPatientMatch;
import io.ebean.annotation.Sql;
import javax.persistence.*;

@Entity
@Sql
public class RankedPatientMatch implements IRankedPatientMatch {

    // doesn't crash when one to many for some reason
    @OneToMany (fetch = FetchType.EAGER)
//    @JoinColumns({
//            @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "id"),
//            @JoinColumn(name = "kit_id", nullable = false, referencedColumnName = "kit_id")
//    })
    Patient patient;
    Integer rank;

    public RankedPatientMatch(Patient patient, int rank) {
        this.patient = patient;
        this.rank = rank;
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
