package com.klef.fsad.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehicleDemoApplication implements CommandLineRunner
{
    @Autowired
    private VehicleRepository repo;

    public static void main(String[] args) 
    {
        SpringApplication.run(VehicleDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception 
    {
        // INSERT
        Vehicle v = new Vehicle();
        v.setName("Car");
        v.setStatus("Available");
        repo.save(v);

        // UPDATE
        Vehicle v2 = repo.findById(v.getId()).orElse(null);
        if (v2 != null) 
        {
            v2.setStatus("Sold");
            repo.save(v2);
        }

        System.out.println("DONE SUCCESSFULLY");
    }
}