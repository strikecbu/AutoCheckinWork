package com.andy.autocheckin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/9/24 AndyChen,new
 * </ul>
 * @since 2020/9/24
 */
@Entity
@Table(name = "HOLIDAY")
public class Holiday {

    @Id
    private String oid;

    private Timestamp holiday;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Timestamp getHoliday() {
        return holiday;
    }

    public void setHoliday(Timestamp holiday) {
        this.holiday = holiday;
    }
}
