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
/**
 * Created by markangrish on 18/01/2017.
 */
@Service
public class FileBasedImportServiceImpl implements ImportService {

    private Session session;

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
    
 
    public void myload() {
         System.out.println("Opening data file reload");
        File file = new File("/Volumes/edge2/procMaster_Surge_123117.csv");
        CsvReader csvReader = new CsvReader();
        // session.query("USING PERIODIC COMMIT 100 ;",Collections.EMPTY_MAP);
        try (CsvParser csvParser = csvReader.parse(file, StandardCharsets.UTF_8)) {
            CsvRow row;
            try {
                while ((row = csvParser.nextRow()) != null) {
                
                    System.out.println("Reading line " + row.getField(0));
                  //  session.query("MERGE (ou:Organization {name : '"+row.getField(0)+"'})", Collections.EMPTY_MAP);
                 
                    this.addOrganization(row.getField(1),row.getField(2));
                    System.out.println("Checking profound domain...");
                    this.checkProfoundDomain(row.getField(2));
                    System.out.println("returned...");
                }   
            } 
            
            catch (IOException ex) 
            {
                 System.out.println("Exception caught");
                Logger.getLogger(FileBasedImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) 
        {
            Logger.getLogger(FileBasedImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Transactional
    public void addOrganization(String inOrg,String inDomain) {
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
             
            Domain domain = restTemplate.getForObject("https://api2.profound.net/domain/"+inDomain+"?view=enterprise", Domain.class);
             System.out.println("Resolved Domain  " + domain.toString());
       }
        catch (RestClientException ex) 
            {
                  System.out.println("Checking Profound Error on " + ex);
                Logger.getLogger(FileBasedImportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
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

