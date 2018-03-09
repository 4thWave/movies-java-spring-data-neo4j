/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movies.spring.data.neo4j;
import org.springframework.context.annotation.*;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import com.fourthwave.connector.XUserAgentInterceptor;
/**
 *
 * @author tedgamester
 */
@Configuration
public class SampleMovieConfig {
     @Bean 
   public SampleMovieApplication sampleMovie(){
      return new SampleMovieApplication();
   }
   
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new XUserAgentInterceptor()));
        return restTemplate;
    }
}





 