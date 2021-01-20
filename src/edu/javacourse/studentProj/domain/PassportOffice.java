package edu.javacourse.studentProj.domain;

public class PassportOffice {

    private long office_id;
    private String officeAreaId;
    private String officeName;

    public PassportOffice(long office_id, String officeAreaId, String officeName) {
        this.office_id = office_id;
        this.officeAreaId = officeAreaId;
        this.officeName = officeName;
    }

    public PassportOffice() {
    }

    public long getOffice_id() {
        return office_id;
    }

    public void setOffice_id(long office_id) {
        this.office_id = office_id;
    }

    public String getOfficeAreaId() {
        return officeAreaId;
    }

    public void setOfficeAreaId(String officeAreaId) {
        this.officeAreaId = officeAreaId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }
}
