/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Domain {

    private String type;

    private String company;
    private String domainname;
    private String duns;
    private String org;
    private String domain;
    private String address1;
    private String address2;
    private String city;
    private String region;
    private String postalcode;
    private String matchgrade;
    private String inquery;
    private String inaddress;
    private String inlocality;
    private String instate;
    private String inzip;
    private String incountry;
    private String inphone;

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getMatchgrade() {
        return matchgrade;
    }

    public void setMatchgrade(String matchgrade) {
        this.matchgrade = matchgrade;
    }

    public String getInquery() {
        return inquery;
    }

    public void setInquery(String inquery) {
        this.inquery = inquery;
    }

    public String getInaddress() {
        return inaddress;
    }

    public void setInaddress(String inaddress) {
        this.inaddress = inaddress;
    }

    public String getInlocality() {
        return inlocality;
    }

    public void setInlocality(String inlocality) {
        this.inlocality = inlocality;
    }

    public String getInstate() {
        return instate;
    }

    public void setInstate(String instate) {
        this.instate = instate;
    }

    public String getInzip() {
        return inzip;
    }

    public void setInzip(String inzip) {
        this.inzip = inzip;
    }

    public String getIncountry() {
        return incountry;
    }

    public void setIncountry(String incountry) {
        this.incountry = incountry;
    }

    public String getInphone() {
        return inphone;
    }

    public void setInphone(String inphone) {
        this.inphone = inphone;
    }
 

    public String getDuns() {
        return duns;
    }

    public void setDuns(String duns) {
        this.duns = duns;
    }


     public Domain() {
       System.out.println("Instance created");
    }

   
   
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDomainname() {
        return domainname;
    }

    public void setDomainname(String domainname) {
        this.domainname = domainname;
    }
    public String getCompany() {
        return company;
    }
    

    public void setCompany(String company_name) {
        this.company = company_name;
    }

    @Override
    public String toString() {
        return "Domain{" +
                "domainname='" + domainname + '\'' +
                ", company=" + company +
                '}';
    }
}
