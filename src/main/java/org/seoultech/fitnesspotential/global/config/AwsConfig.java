package org.seoultech.fitnesspotential.global.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("aws")
public class AwsConfig {

    private Map<String, String> credentials;
    private Map<String, String> s3;
    private Map<String, String> region;
    private Map<String, String> stack;

    @Bean
    public AmazonS3 amazonS3() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(getAccessKey(), getSecretKey());
        return AmazonS3ClientBuilder.standard()
                .withRegion(getRegionStatic())
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

    public Map<String, String> getCredentials() {
        return credentials;
    }

    public String getAccessKey() {
        return credentials.get("accessKey");
    }

    public String getSecretKey() {
        return credentials.get("secretKey");
    }

    public String getBucket() {
        return s3.get("bucket");
    }

    public String getDir() {
        return s3.get("dir");
    }

    public String getRegionStatic() {
        return region.get("static");
    }

    public boolean isStackAuto() {
        return Boolean.parseBoolean(stack.get("auto"));
    }

    public void setCredentials(Map<String, String> credentials) {
        this.credentials = credentials;
    }

    public Map<String, String> getS3() {
        return s3;
    }

    public void setS3(Map<String, String> s3) {
        this.s3 = s3;
    }

    public Map<String, String> getRegion() {
        return region;
    }

    public void setRegion(Map<String, String> region) {
        this.region = region;
    }

    public Map<String, String> getStack() {
        return stack;
    }

    public void setStack(Map<String, String> stack) {
        this.stack = stack;
    }
}
