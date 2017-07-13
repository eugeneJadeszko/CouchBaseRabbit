package by.intexsoft.billing.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@EnableCouchbaseRepositories(basePackages = {"by.intexsoft.billing.repository"})
@PropertySource(value={"classpath:application.properties"})
@Configuration
public class CouchBaseConfig extends AbstractCouchbaseConfiguration {

	@Value("${couchbase.host}")
	private String hostName;

	@Value("${couchbase.bucket}")
	private String bucketName;

	@Value("${couchbase.password}")
	private String bucketPassword;

	@Override
	protected List<String> getBootstrapHosts() {
		return Arrays.asList(hostName);
	}

	@Override
	protected String getBucketName() {
		return bucketName;
	}

	@Override
	protected String getBucketPassword() {
		return bucketPassword;
	}

}