package org.example.MDMInterFaceError;

public abstract class ErrorAbstract {
    private String mpartDescription;
    private String transTime;
    private String mess;
    private String chechOutPerson;

    public abstract void showMessage();

    public ErrorAbstract() {
    }

    public ErrorAbstract(String mpartDescription, String transTime, String mess, String chechOutPerson) {
        this.mpartDescription = mpartDescription;
        this.transTime = transTime;
        this.mess = mess;
        this.chechOutPerson = chechOutPerson;
    }

    public String getMpartDescription() {
        return mpartDescription;
    }

    public void setMpartDescription(String mpartDescription) {
        this.mpartDescription = mpartDescription;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public String getChechOutPerson() {
        return chechOutPerson;
    }

    public void setChechOutPerson(String chechOutPerson) {
        this.chechOutPerson = chechOutPerson;
    }
}
