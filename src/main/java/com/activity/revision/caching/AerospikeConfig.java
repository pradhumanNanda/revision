package com.activity.revision.caching;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.aerospike.cache.AerospikeCacheConfiguration;
import org.springframework.data.aerospike.cache.AerospikeCacheManager;
import org.springframework.data.aerospike.convert.AerospikeCustomConversions;
import org.springframework.data.aerospike.convert.AerospikeTypeAliasAccessor;
import org.springframework.data.aerospike.convert.MappingAerospikeConverter;
import org.springframework.data.aerospike.mapping.AerospikeMappingContext;
import org.springframework.data.mapping.model.SimpleTypeHolder;

@Configuration
@Import(value = {MappingAerospikeConverter.class, AerospikeMappingContext.class, AerospikeTypeAliasAccessor.class,AerospikeCustomConversions.class, SimpleTypeHolder.class})
public class AerospikeConfig {

    @Autowired
    private MappingAerospikeConverter mappingAerospikeConverter;

    @Bean(destroyMethod = "close")
    public AerospikeClient aerospikeClient() {
        ClientPolicy clientPolicy = new ClientPolicy();
        clientPolicy.failIfNotConnected = true;
        return new AerospikeClient(clientPolicy,"0.0.0.0", 3000);
    }

    @Bean
    public AerospikeCacheManager cacheManager(AerospikeClient aerospikeClient) {
        AerospikeCacheConfiguration aerospikeCacheConfiguration = new AerospikeCacheConfiguration("test");
        return new AerospikeCacheManager(aerospikeClient, mappingAerospikeConverter, aerospikeCacheConfiguration);
    }
}
