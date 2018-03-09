/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fourthwave.connector;



import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.*;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import org.springframework.http.HttpHeaders;

public class AuthRestTemplate extends RestTemplate {

	public AuthRestTemplate(String inKey) {
		addAuthentication(inKey);
	}

	private void addAuthentication(String inKey) {
		if (inKey == null) {
			return;
		}
		List<ClientHttpRequestInterceptor> interceptors = Collections
				.<ClientHttpRequestInterceptor> singletonList(
						new BasicAuthorizationInterceptor(inKey));
		setRequestFactory(new InterceptingClientHttpRequestFactory(getRequestFactory(),
				interceptors));
	}

	private static class BasicAuthorizationInterceptor implements
			ClientHttpRequestInterceptor {

		private final String key;

		public BasicAuthorizationInterceptor(String inKey) {
			this.key = inKey;
		}

		@Override
		public ClientHttpResponse intercept(HttpRequest request, byte[] body,
											ClientHttpRequestExecution execution) throws IOException {
			//byte[] token = Base64.getEncoder().encode(
			//		(this.username + ":" + this.password).getBytes());
			request.getHeaders().add("Authorization", "ProfoundAuth apikey="+this.key);
			return execution.execute(request, body);
		}

	}
	
}