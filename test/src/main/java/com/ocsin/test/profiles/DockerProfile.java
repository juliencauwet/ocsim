package com.ocsin.test.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("docker")
public class DockerProfile implements DataSourceConfiguration{

    @Value("valeur:")
    private String valeur;

    @Override
    @PostConstruct
    public void setup() {
        System.out.println("Lancement de la configuration du profile " + valeur);
    }
}
