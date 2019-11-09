package com.blink.repository;

import com.blink.model.GenericObject;
import it.snam.pimos.common.logger.Logp;
import it.snam.pimos.common.logger.LogpLevel;
import it.snam.pimos.common.model.Job;
import it.snam.pimos.common.model.JobState;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class GenericObjectRepository {

	private final MongoTemplate mongoTemplate;
	private Logp logger = new Logp();
	
	
	public GenericObjectRepository(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
		this.logger.setFlow("Data Gateway").setOperator("Message Writer");
	}
	
	public Optional<Job> findById(String id, String collection) {
		return Optional.ofNullable(mongoTemplate.find(new Query(Criteria.where("_id").is(id)),
                Job.class, collection).get(0));
	}

	public Iterable<GenericObject> findAll(String collection) {
		return mongoTemplate.findAll(GenericObject.class, collection);
	}

	public Iterable<GenericObject> findAllById(List<String> asList, String collection) {
		return mongoTemplate.find(new Query(Criteria.where("flowId").is(asList)),
                GenericObject.class, collection);
	}
	
	public GenericObject saveGenericObject(GenericObject data, String collection) {
		logger.setAction("Saving object: {}").setLogpLevel(LogpLevel.DEBUG).build(data);
		return mongoTemplate.save(data, collection);
	}
	public Job saveJob(Job data, String collection) {
		logger.setAction("Saving object: {}").setLogpLevel(LogpLevel.DEBUG).build(data);
		return mongoTemplate.save(data, collection);
	}

	public Job updateJob(String id, Job job) {
		logger.setAction("Saving object: {}").setLogpLevel(LogpLevel.DEBUG).build(id);

		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		query.fields().include("_id");

		Job userTest3 = mongoTemplate.findOne(query, Job.class, "alarmManager");
		System.out.println("userTest3 - " + userTest3);

		Update update = new Update();
		update.set("state", JobState.LOCALIZED);

		Job ret = mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), Job.class, "alarmManager");

		return ret;
	}

	public Object saveObj(Object data, String collection) {
		logger.setAction("Saving object: {}").setLogpLevel(LogpLevel.DEBUG).build(data);
		return mongoTemplate.save(data, collection);
	}
}
