package com.jmmd.hroauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;

@Configuration
public class AppConfig {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
	    tokenConverter.setSigningKey("My-SECRET-KEY");
	    return tokenConverter;
	}

	@Bean
	//Object that read a token information.
	public JwtTokenStore tokenStore() {
		
		return new JwtTokenStore(accessTokenConverter());
	}

	
}
