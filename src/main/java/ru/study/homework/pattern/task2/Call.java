package ru.study.homework.pattern.task2;

public class Call {
    String phone;
    String caller;
    String dateAndTime;
    String description;

    public Call(String phone, String caller, String dateAndTime, String description) {
        this.phone = phone;
        this.caller = caller;
        this.dateAndTime = dateAndTime;
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Call{" +
                "phone='" + phone + '\'' +
                ", caller='" + caller + '\'' +
                ", dateAndTime='" + dateAndTime + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
