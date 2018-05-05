package movies.spring.data.neo4j.services.impl;

import de.siegmar.fastcsv.reader.CsvParser;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import movies.spring.data.neo4j.services.ImportService;
import movies.spring.data.neo4j.domain.Domain;
import movies.spring.data.neo4j.domain.ProDomain;
import movies.spring.data.neo4j.domain.OrgPerson;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import com.fourthwave.connector.AuthRestTemplate;
import movies.spring.data.neo4j.domain.RealOrganization;
import movies.spring.data.neo4j.repositories.RealOrganizationRepository;
/**
 * Created by markangrish on 18/01/2017.
 */
@Service
public class FileBasedImportServiceImpl implements ImportService {

 
        @Autowired
	private Session session;

	@Autowired
	private RealOrganizationRepository instance;

    @Autowired
    public FileBasedImportServiceImpl(Session session) {
        this.session = session;
    }

    @Transactional
    public void clearDatabase() {
        session.purgeDatabase();
    }

    @Transactional
    public void load() {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("movies.cql")));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(" ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String cqlFile = sb.toString();
        session.query(cqlFile, Collections.EMPTY_MAP);
    }
        @Transactional
     public void checkDomains() {
         System.out.println("Opening data file reload");
        File file = new File("/Users/tedgamester/Downloads/Fortune_500_Corporate_Headquarters.csv");
        CsvReader csvReader = new CsvReader();
        StringBuilder sb = new StringBuilder();
        int notfound = 0;
       try (CsvParser csvParser = csvReader.parse(file, StandardCharsets.UTF_8)) {
            CsvRow row;
             try {
                 while ((row = csvParser.nextRow()) != null)
                 {
                     
                 
                     for(int i=1; i<20; i++){
                         try {
                               row = csvParser.nextRow();
                                System.out.println("Checking Domain "+row.getField(0));
                                
                                
                                String theDomain = domainAppend(row.getField(0),row.getField(3),row.getField(5),row.getField(6),row.getField(7),row.getField(1)+"-"+row.getField(2);
                               //sb.append(this.addCypherMergeOrganization(row.getField(1),resolveCompanyByDomain(row.getField(2)),"o"+String.valueOf(i))); 
                              System.out.println("Found Domain ="+theDomain);
                               
                              } catch (IOException ex) {
                                  System.out.println("IO Exception reading file ");
                                 Logger.getLogger(FileBasedImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                                 
                             }
                         
                     }
                     
                    System.out.println("!!! Firing Cypher " );
                  
                         this.exCypher(sb.toString());
                        System.out.println("!!! Finished Cypher " );
                        sb.delete(0, sb.length());
                 }    
             } catch (IOException ex) {
                 Logger.getLogger(FileBasedImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
             }
         
            
           
      
    }   catch (IOException ex) {
            Logger.getLogger(FileBasedImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
       
     
 @Transactional
    public void myload() {
         System.out.println("Opening data file reload");
        File file = new File("/Volumes/edge2/procMaster_Surge_123117.csv");
        CsvReader csvReader = new CsvReader();
        StringBuilder sb = new StringBuilder();
       try (CsvParser csvParser = csvReader.parse(file, StandardCharsets.UTF_8)) {
            CsvRow row;
             try {
                 while ((row = csvParser.nextRow()) != null)
                 {
                     
                 
                     for(int i=1; i<2; i++){
                         try {
                               row = csvParser.nextRow();
                               sb.append(this.addCypherMergeOrganization(row.getField(1),row.getField(2),"o"+String.valueOf(i))); 
                               
                              } catch (IOException ex) {
                                  System.out.println("IO Exception reading file ");
                                 Logger.getLogger(FileBasedImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                                 
                             }
                         
                     }
                     
                    // System.out.println("!!! Firing Cypher " );
                    //     this.exCypher(sb.toString());
                         
                    //     System.out.println("!!! Finished Cypher " );
                            System.out.println(".....Firing RealOrg Create " );
                         RealOrganization matrix = new RealOrganization(row.getField(1),1999);

                        instance.save(matrix);
                        
                          System.out.println(".....Complete Success RealOrg Create " );
                         sb.delete(0, sb.length());
                 }    
             } catch (IOException ex) {
                 Logger.getLogger(FileBasedImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
             }
         
            
           
      
    }   catch (IOException ex) {
            Logger.getLogger(FileBasedImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
       
      
  
  
    public String addCypherMergeOrganization(String inOrg,String inDomain,String inOrgVar) {
         try {
           //  System.out.println("Cypher fired... " + inOrg);
            return "MERGE ("+inOrgVar+":Organization {name : '"+inOrg+"', domain : '"+inDomain+"'}) ";
        
         }
          catch (Exception ex) 
            {
                  System.out.println("Error on " + inOrg);
                  return null;
            }
    }
    
     @Transactional
    public void exCypher(String inCypher) {
         try {
             System.out.println("!!!!Cypher fired !!!!" + inCypher.length());
            session.query(inCypher, Collections.EMPTY_MAP);
             System.out.println(" Success !!");
         }
          catch (Exception ex) 
            {
                  System.out.println("!!!!!!!!!!!! Error on " );
                Logger.getLogger(FileBasedImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @Transactional
    public void mergeOrganization(String inOrg,String inDomain) {
         try {
             System.out.println("Cypher fired... " + inOrg);
            session.query("MERGE (o:Organization {name : '"+inOrg+"', domain : '"+inDomain+"'});", Collections.EMPTY_MAP);
        
         }
          catch (Exception ex) 
            {
                  System.out.println("Error on " + inOrg);
                Logger.getLogger(FileBasedImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
   public void checkProfoundDomain(String inDomain){
       try {
            AuthRestTemplate restTemplate = new AuthRestTemplate("cisco-065ccfec619011e38f");
             
            ProDomain domain = restTemplate.getForObject("https://api2.profound.net/domain/"+inDomain+"?view=enterprise", ProDomain.class);
             System.out.println("Resolved Domain  " + domain.toString());
       }
        catch (RestClientException ex) 
            {
                  System.out.println("Checking Profound Error on " + ex);
                Logger.getLogger(FileBasedImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
       
   }
   
   public String getOrgPeople(String inDomain){
       try {
            AuthRestTemplate restTemplate = new AuthRestTemplate("");
              System.out.println("Checking Company for the following domain name=" + inDomain);
            OrgPerson orgPerson = restTemplate.getForObject("http://theodoregamester-eval-test.apigee.net/locator-service-api?domain="+inDomain, OrgPerson.class);
             System.out.println("Resolved Domain  " + orgPerson.toString());
               System.out.println("Resolved attribute Domain  " + orgPerson.getDomainname());
               return orgPerson.getFullName();
       }
        catch (RestClientException ex) 
            {
               
                 System.out.println("Domain not found Error  " + ex);
                  return "null";
               // Logger.getLogger(FileBasedImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
       
   }
   
    public String resolveCompanyByDomain(String inDomain){
       try {
           // AuthRestTemplate restTemplate = new AuthRestTemplate("cisco-065ccfec619011e38f");
            RestTemplate restTemplate = new RestTemplate();
              System.out.println("Checking Company for the following http://theodoregamester-eval-test.apigee.net/domain/" + inDomain);
            Domain domain = restTemplate.getForObject("'http://gnetworkinc-test.apigee.net/thedomainappender/rev"+inDomain, Domain.class);
             System.out.println("querying Gateway  for URL  " + domain.toString());
             System.out.println("Resolved Duns  " + domain.getDuns());
             System.out.println("Resolved Company =  " + domain.getCompany());
               return domain.getDuns();
       }
        catch (RestClientException ex) 
            {
               
                 System.out.println("Domain not found Error  " + ex);
                 
                  return "null";
               // Logger.getLogger(FileBasedImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
       
   }
  
     public String domainAppend(String inOrganization,String inAddress,String inCity,String inState,String inZip,String inPhone){
       try {
           // AuthRestTemplate restTemplate = new AuthRestTemplate("cisco-065ccfec619011e38f");
            RestTemplate restTemplate = new RestTemplate();
              System.out.println("Checking Gateway for the domain for " + inOrganization);
            Domain domain = restTemplate.getForObject("http://gnetworkinc-test.apigee.net/thedomainappender/seq"+"?apikey=Y7zSsnAUkssl1NacDVHgSNAkKTv1v9Zb"+"&organization="+inOrganization+"&address="+inAddress+"&city="+inCity+"&state="+inState+"&zip="+inZip+"&phone="+inPhone+"&country=US", Domain.class);
             System.out.println("querying Gateway  for URL  " + domain.toString());
             System.out.println("Resolved Duns  " + domain.getDuns());
             System.out.println("Resolved Company =  " + domain.getCompany());
               return domain.getDuns();
       }
        catch (RestClientException ex) 
            {
               
                 System.out.println("Domain not found Error  " + ex);
                 
                  return "null";
               // Logger.getLogger(FileBasedImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
       
   }
public void newload() throws Exception {
    
        Path path = Paths.get( ("csvfile"));
        if (Files.exists(path)){
            // use the new java 8 streams api to read the CSV column headings
            Stream<String> lines = Files.lines(path);
            List<String> columns;
        List<List<String>> values;
        try(BufferedReader br=Files.newBufferedReader(path)) {
            String firstLine=br.readLine();
            if(firstLine==null) throw new IOException("empty file");
            columns=Arrays.asList(firstLine.split(","));
            values = br.lines()
              .map(line -> Arrays.asList(line.split(",")))
              .collect(Collectors.toList());
        }

        }
            

              
}

}

