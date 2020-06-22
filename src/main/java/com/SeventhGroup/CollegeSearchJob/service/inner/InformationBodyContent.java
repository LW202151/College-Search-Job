package com.SeventhGroup.CollegeSearchJob.service.inner;

import java.util.List;
import java.util.Objects;

public class InformationBodyContent {

    //private String email;

   // private String realname;


    private List<InformationContent> information;


    public InformationBodyContent() {
    }


    public InformationBodyContent(List<InformationContent> information) {
        this.information = information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InformationBodyContent)) return false;
        InformationBodyContent that = (InformationBodyContent) o;
        return Objects.equals(information, that.information);
    }

    @Override
    public String toString() {
        return "InformationBodyContent{" +
                ", information=" + information +
                '}';
    }

    public List<InformationContent> getInformation() {
        return information;
    }

    public void setInformation(List<InformationContent> information) {
        this.information = information;
    }

    @Override
    public int hashCode() {
        return Objects.hash(information);
    }

}

