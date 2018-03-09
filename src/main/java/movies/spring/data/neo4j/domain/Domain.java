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

    private String company_name;
    private String mail_server_provider;
    private String domain_classification;

     public Domain() {
    }

    public void setMail_server_provider(String mail_server_provider) {
        this.mail_server_provider = mail_server_provider;
    }

    public void setDomain_classification(String domain_classification) {
        this.domain_classification = domain_classification;
    }

    public String getMail_server_provider() {
        return mail_server_provider;
    }

    public String getDomain_classification() {
        return domain_classification;
    }

   
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany_name() {
        return company_name;
    }
    

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    @Override
    public String toString() {
        return "Domain{" +
                "type='" + type + '\'' +
                ", company_name=" + company_name +
                '}';
    }
}
