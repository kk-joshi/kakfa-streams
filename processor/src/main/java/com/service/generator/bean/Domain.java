package com.service.generator.bean;

import java.util.Date;
import java.util.List;

public class Domain {
    public String domain;
    public Date create_date;
    public Date update_date;
    public Object country;
    public boolean isDead;
    public Object a;


    public List<String> nS;

    public Object cNAME;

    public Object mX;

    public Object tXT;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public boolean getIsDead() {
        return isDead;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    public Object getA() {
        return a;
    }

    public void setA(Object a) {
        this.a = a;
    }

    public Object getnS() {
        return nS;
    }

    public void setcNAME(Object cNAME) {
        this.cNAME = cNAME;
    }

    public Object getmX() {
        return mX;
    }

    public void setmX(Object mX) {
        this.mX = mX;
    }

    public Object gettXT() {
        return tXT;
    }

    public void settXT(Object tXT) {
        this.tXT = tXT;
    }

    public void setnS(List<String> nS) {
        this.nS = nS;
    }

    public Object getcNAME() {
        return cNAME;
    }

}

