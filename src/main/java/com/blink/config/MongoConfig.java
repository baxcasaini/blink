package com.blink.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	@Value(value = "${spring.data.mongodb.database}")
	private String db;
	@Value(value = "${spring.data.mongodb.host}")
	private String host;
	@Value(value = "${spring.data.mongodb.port}")
	private String port;
	@Value(value = "${spring.data.mongodb.uri}")
	private String uriString;

	@Override
	public MongoClient mongoClient() {
//		MongoCredential credential = MongoCredential.createCredential(user, db, password.toCharArray());
		MongoClientURI uri = new MongoClientURI(uriString);
		return new MongoClient(uri);
//		return new MongoClient(new ServerAddress(host, Integer.parseInt(port)), Arrays.asList(credential));
//		return new MongoClient(host, Integer.parseInt(port));
	}

	@Override
	protected String getDatabaseName() {
		return db;
	}
}
