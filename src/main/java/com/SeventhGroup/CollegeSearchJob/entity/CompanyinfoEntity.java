package com.SeventhGroup.CollegeSearchJob.entity;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "company")
@NoArgsConstructor
public class CompanyinfoEntity {

    @Id
    private String company_id;
    private String company_password;
    private String company_email;
    private String company_phone_number;
    private String company_nature;
    private String company_date_of_establishment;
    private String company_brief_introduce;
    private String company_address;
    private String company_homepage;
    private String company_legal_persion;
    private String company_type;
    private String company_name;

    public CompanyinfoEntity(String company_id, String company_password, String company_email, String company_phone_number, String company_nature, String company_date_of_establishment, String company_brief_introduce, String company_address, String company_homepage, String company_legal_persion, String company_type, String company_name) {
        this.company_id = company_id;
        this.company_password = company_password;
        this.company_email = company_email;
        this.company_phone_number = company_phone_number;
        this.company_nature = company_nature;
        this.company_date_of_establishment = company_date_of_establishment;
        this.company_brief_introduce = company_brief_introduce;
        this.company_address = company_address;
        this.company_homepage = company_homepage;
        this.company_legal_persion = company_legal_persion;
        this.company_type = company_type;
        this.company_name = company_name;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getCompany_password() {
        return company_password;
    }

    public void setCompany_password(String company_password) {
        this.company_password = company_password;
    }

    public String getCompany_email() {
        return company_email;
    }

    public void setCompany_email(String company_email) {
        this.company_email = company_email;
    }

    public String getCompany_phone_number() {
        return company_phone_number;
    }

    public void setCompany_phone_number(String company_phone_number) {
        this.company_phone_number = company_phone_number;
    }

    public String getCompany_nature() {
        return company_nature;
    }

    public void setCompany_nature(String company_nature) {
        this.company_nature = company_nature;
    }

    public String getCompany_date_of_establishment() {
        return company_date_of_establishment;
    }

    public void setCompany_date_of_establishment(String company_date_of_establishment) {
        this.company_date_of_establishment = company_date_of_establishment;
    }

    public String getCompany_brief_introduce() {
        return company_brief_introduce;
    }

    public void setCompany_brief_introduce(String company_brief_introduce) {
        this.company_brief_introduce = company_brief_introduce;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public String getCompany_homepage() {
        return company_homepage;
    }

    public void setCompany_homepage(String company_homepage) {
        this.company_homepage = company_homepage;
    }

    public String getCompany_legal_persion() {
        return company_legal_persion;
    }

    public void setCompany_legal_persion(String company_legal_persion) {
        this.company_legal_persion = company_legal_persion;
    }

    public String getCompany_type() {
        return company_type;
    }

    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
