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
