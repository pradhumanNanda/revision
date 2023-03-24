package com.activity.revision.caching;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.aerospike.cache.AerospikeCacheManager;
import org.springframework.data.aerospike.convert.AerospikeTypeAliasAccessor;
import org.springframework.data.aerospike.convert.MappingAerospikeConverter;
import org.springframework.data.aerospike.mapping.AerospikeMappingContext;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mapping.model.SimpleTypeHolder;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Key;
import com.aerospike.client.policy.WritePolicy;

@EnableAutoConfiguration
@SuppressWarnings("unused")
@Import({MappingAerospikeConverter.class,AerospikeMappingContext.class,AerospikeTypeAliasAccessor.class,CustomConversions.class,SimpleTypeHolder.class})
public class AreospikeConfig {
	
	@Autowired MappingAerospikeConverter mappingAerospikeConverter;
		 
	@Bean(destroyMethod = "close")
	public AerospikeClient configAreospike(){
		String hostString = "0.0.0.0";
		Integer portInteger = 3000;
		String ns = "test";
		String list_set = "list_set";
		String pkString = "mydata";
		Key key = new Key(ns, list_set, pkString);
		AerospikeClient client = new AerospikeClient(hostString, portInteger);
		WritePolicy policy = client.getWritePolicyDefault();
		policy.sendKey = true;
		return client;
	}
	
	@Bean
	public AerospikeCacheManager cacheManager(AerospikeClient aerospikeClient) {
		return new AerospikeCacheManager(aerospikeClient, mappingAerospikeConverter, null, null);
	}
	
}
