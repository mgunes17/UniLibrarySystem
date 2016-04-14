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
@Table(name = "officer")
@PrimaryKeyJoinColumn(name = "mail")
public class Officer extends User implements Serializable{
    @Column(name = "task_scope", nullable = false)
    private String taskScope;
    
    //private static int MAX_LIMIT;

    public String getTaskScope() {
        return taskScope;
    }

    public void setTaskScope(String taskScope) {
        this.taskScope = taskScope;
    }
    
}
