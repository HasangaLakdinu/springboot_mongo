package com.example.multi_mongo_proj;

import com.example.multi_mongo_proj.repository.modelRepo1.Model1;
import com.example.multi_mongo_proj.repository.modelRepo1.Model1Repository;
import com.example.multi_mongo_proj.repository.modelRepo2.Model2;
import com.example.multi_mongo_proj.repository.modelRepo2.Model2Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class MultiMongoProjApplication implements CommandLineRunner {

    @Autowired
    private Model1Repository model1Repository;

    @Autowired
    private Model2Repository model2Repository;

    public static void main(String[] args) {
        SpringApplication.run(MultiMongoProjApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("************************************************************");
        log.info("Start creating and printing mongo objects");
        log.info("************************************************************");

        this.model1Repository.save(new Model1(null,"Model 1 obj"));
        this.model2Repository.save(new Model2(null,"Model 2 Obj"));

        List<Model1> model1s = this.model1Repository.findAll();
        for (Model1 model1obj : model1s) {
            log.info(model1obj.toString());
        }


        List<Model2> model2s = this.model2Repository.findAll();
        for (Model2 model2obj : model2s) {
            log.info(model2obj.toString());
        }

        log.info("************************************************************");
        log.info("Ended printing mongo objects");
        log.info("************************************************************");

    }
}
