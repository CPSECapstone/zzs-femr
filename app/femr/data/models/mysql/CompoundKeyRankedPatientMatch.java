package femr.data.models.mysql;

import femr.data.models.core.ICompoundKeyRankedPatientMatch;
import femr.data.models.core.IPhoto;
import femr.data.models.mysql.keys.PatientKey;
import io.ebean.annotation.Sql;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Sql
public class CompoundKeyRankedPatientMatch implements ICompoundKeyRankedPatientMatch {

//    private PatientKey patientKey;

    private int patientId;

//    private Patient patient;

    private int kitId;

    private int userId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Date age;

    private String sex;

    private String address;

    private String city;

    private Photo photo;

    private List<PatientEncounter> patientEncounters;

    private DateTime isDeleted;

    private Integer deletedByUserId;

    private String reasonDeleted;

    Integer rank;

    public CompoundKeyRankedPatientMatch(int rank) {
        this.rank = rank;
    }

    @Override
    public int getId() {
        return this.patientId;
//        return patientKey.getPatientId();
    }

    @Override
    public int getKitId() {
        return this.kitId;
//        return patientKey.getKitId();
    }

    @Override
    public void setKitId(int kitId) {
        this.kitId = kitId;
//        this.patientKey.setKitId(kitId);
    }

//    @Override
//    public void setPatientKey(PatientKey patientKey){
//        this.patientKey = new PatientKey(0, 1);
//    }

//    @Override
//    public PatientKey getPatientKey()
//    {
//        return this.patientKey;
//    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Date getAge() {
        return age;
    }

    @Override
    public void setAge(Date age) {
        this.age = age;
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setId(int id) {
        this.patientId = id;
//        patientKey.setPatientId(id);
    }

    @Override
    public IPhoto getPhoto() {
        return photo;
    }

    @Override
    public void setPhoto(IPhoto photo) {
        this.photo = (Photo) photo;
    }

    @Override
    public List<PatientEncounter> getPatientEncounters() {
        return patientEncounters;
    }

    @Override
    public void setPatientEncounters(List<PatientEncounter> patientEncounters) {
        this.patientEncounters = patientEncounters;
    }

    @Override
    public DateTime getIsDeleted() {
        return isDeleted;
    }

    @Override
    public void setIsDeleted(DateTime isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public Integer getDeletedByUserId() {
        return deletedByUserId;
    }

    @Override
    public void setDeletedByUserId(Integer userId) {
        this.deletedByUserId= userId;
    }

    @Override
    public String getReasonDeleted() { return reasonDeleted; }

    @Override
    public void setReasonDeleted(String reason) { this.reasonDeleted = reason; }

    @Override
    public Integer getRank() {
        return rank;
    }

    @Override
    public void setRank(int rank) {
        this.rank = rank;
    }

}
