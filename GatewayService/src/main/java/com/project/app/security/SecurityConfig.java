/**
 * 
 */
package com.project.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author Lahcen HAYANE <lahcenhayane@gmail.ma>
 * @Date 6 avr. 2022
 */
@EnableWebFluxSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityWebFilterChain filterChain(ServerHttpSecurity httpSecurity) {
		httpSecurity.authorizeExchange(ex->ex.anyExchange().authenticated())
					.oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
		httpSecurity.csrf().disable();
		return httpSecurity.build();
	}

	
//	 private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationConverter() {
//         JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
//         jwtConverter.setJwtGrantedAuthoritiesConverter(new RealmRoleConverter());
//         return jwtConverter;
//	 }

	
}


//public class RealmRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
//    @Override
//    public Collection<GrantedAuthority> convert(Jwt jwt) {
//        final Map<String, List<String>> realmAccess = (Map<String, List<String>>) jwt.getClaims().get("realm_access");
//        return realmAccess.get("roles")
//                .stream()
//                .map(roleName -> "ROLE_" + roleName) // prefix required by Spring Security for roles.
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//    }
//}
