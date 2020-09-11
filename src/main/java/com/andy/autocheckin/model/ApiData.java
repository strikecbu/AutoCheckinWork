package com.andy.autocheckin.model;

import com.iisigroup.colabase.json.model.ResponseContent;
import com.iisigroup.colabase.ssl.model.PostFormData;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/9/11 AndyChen,new
 * </ul>
 * @since 2020/9/11
 */
public class ApiData extends PostFormData {

    private String PunchLng;
    private String PunchLat;
    private String EmpID;
    private String WorkOff;

    @Override
    public void afterSendRequest(ResponseContent responseContent) {

    }

    public String getPunchLng() {
        return PunchLng;
    }

    public void setPunchLng(String punchLng) {
        PunchLng = punchLng;
    }

    public String getPunchLat() {
        return PunchLat;
    }

    public void setPunchLat(String punchLat) {
        PunchLat = punchLat;
    }

    public String getEmpID() {
        return EmpID;
    }

    public void setEmpID(String empID) {
        EmpID = empID;
    }

    public String getWorkOff() {
        return WorkOff;
    }

    public void setWorkOff(String workOff) {
        WorkOff = workOff;
    }
}
