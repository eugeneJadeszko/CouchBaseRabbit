package by.intexsoft.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories
public class CouchBaseConfig extends AbstractCouchbaseConfiguration {

	@Override
	protected List<String> getBootstrapHosts() {
		return Arrays.asList("couchbase://127.0.0.1");
	}

	@Override
	protected String getBucketName() {
		return "default";
	}

	@Override
	protected String getBucketPassword() {
		return "";
	}

}
