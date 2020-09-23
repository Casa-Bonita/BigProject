package ru.study.homework.inputoutput;

import java.util.Date;
import java.text.SimpleDateFormat;

public class PresidentsInfo {
    private String name;
    private Date start;
    private Date end;
    String party;

    public PresidentsInfo(){

    }

    public PresidentsInfo(String name, Date start, Date end, String party){
        this.name = name;
        this.start = start;
        this.end = end;
        this.party = party;
    }

    public String getName() {
        return name;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getParty() {
        return party;
    }
}
