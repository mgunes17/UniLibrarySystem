package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author ercan
 */
@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "mail")
public class Student extends User implements Serializable{
    @Column(name = "school_no", nullable = false, unique = true)
    private String schoolNo;
    @Column(name = "department", nullable = false)
    private String department;
    
    //private static int MAX_LIMIT;

    public String getSchoolNo() {
        return schoolNo;
    }

    public void setSchoolNo(String schoolNo) {
        this.schoolNo = schoolNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
}
