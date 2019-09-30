package com.hc21cloud.security.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * The class Rest client details service.
 *
 * @author shaofeng
 */
@Component("restClientDetailsService")
public class RestClientDetailsServiceImpl extends JdbcClientDetailsService {

    private static final Logger log = LoggerFactory.getLogger(RestClientDetailsServiceImpl.class);

    public RestClientDetailsServiceImpl(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * Load client by client id client details.
     *
     * @param clientId the client id
     * @return the client details
     * @throws ClientRegistrationException the client registration exception
     */
    @Override
    public ClientDetails loadClientByClientId(String clientId) {
        return super.loadClientByClientId(clientId);
    }
}
