package com.SeventhGroup.CollegeSearchJob.service.inner;

import java.util.List;
import java.util.Objects;

public class CominformationBodyContent {
    private List<CominformationContent> cominformation;
    public CominformationBodyContent(){

    }

    public CominformationBodyContent(List<CominformationContent> cominformation) {
        this.cominformation = cominformation;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CominformationBodyContent)) return false;
        CominformationBodyContent that = (CominformationBodyContent) o;
        return Objects.equals(cominformation, that.cominformation);
    }

    @Override
    public String toString() {
        return "CominformationBodyContent{" +
                ", cominformation=" + cominformation +
                '}';
    }

    public List<CominformationContent> getCominformation() {
        return cominformation;
    }

    public void setCominformation(List<CominformationContent> cominformation) {
        this.cominformation = cominformation;
    }
    public int hashCode() {
        return Objects.hash(cominformation);
    }
}
