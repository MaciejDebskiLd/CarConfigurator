package com.example.carconfigurator.config;

import com.example.carconfigurator.car.Car;
import com.example.carconfigurator.car.CarImpl;
import com.example.carconfigurator.engine.EEngineType;
import com.example.carconfigurator.engine.Engine;
import com.example.carconfigurator.engine.EngineImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Value("${engine.petrol.20:}")
    private String enginePetrol20Name;

    @Value("${engine.petrol.25:}")
    private String enginePetrol25Name;

    @Value("${engine.diesel.22:}")
    private String engineDiesel22Name;

    @Value("${car.mazda.6}")
    private String carMazda6Name;

    @Value("${car.mazda.cx5}")
    private String carMazdaCx5Name;

    @Bean("enginePetrol20")
    public Engine enginepetrol20(){return new EngineImpl(EEngineType.PETROL,enginePetrol20Name,165,"6M",1988);}

    @Bean("enginePetrol25")
    public Engine enginepetrol25(){return new EngineImpl(EEngineType.PETROL,enginePetrol25Name,194,"6AT",2488);}

    @Bean("engineDiesel22")
    public Engine enginediesel22(){return new EngineImpl(EEngineType.DIESEL,engineDiesel22Name,184,"6AT",2191);}

    @Bean("mazda6Petrol20")
    @Scope("prototype")
    public Car mazda6Petrol20(){return new CarImpl(carMazda6Name, enginepetrol20());}

    @Bean("mazda6Petrol25")
    @Scope("prototype")
    public Car mazda6Petrol25(){return new CarImpl(carMazda6Name, enginepetrol25());}

    @Bean("mazda6Diesel22")
    @Scope("prototype")
    public Car mazda6Diesel22(){return new CarImpl(carMazda6Name, enginediesel22());}

    @Bean("mazdaCx5Petrol20")
    @Scope("prototype")
    public Car mazdaCx5Petrol20(){return new CarImpl(carMazdaCx5Name, enginepetrol20());}

    @Bean("mazdaCx5Petrol25")
    @Scope("prototype")
    public Car mazdaCx5Petrol25(){return new CarImpl(carMazdaCx5Name, enginepetrol25());}

    @Bean("mazdaCx5Diesel22")
    @Scope("prototype")
    public Car mazdaCx5Diesel22(){return new CarImpl(carMazdaCx5Name, enginediesel22());}
        

}


