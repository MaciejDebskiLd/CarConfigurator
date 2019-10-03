package com.example.carconfigurator.creator;

import com.example.carconfigurator.car.Car;
import com.example.carconfigurator.engine.EEngineType;
import com.example.carconfigurator.engine.Engine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CarOfferCreatorImpl implements CarOfferCreator {

    private static final String EMPTY_VALUE = "-";

    @Value("${offer.header:#{null}}")
    private String offerHeader;

    @Value("${offer.footer:#{null}}")
    private String offerFooter;

    @Override
    public String createCarOffer(Car car){

        StringBuilder sb = new StringBuilder();

        if (offerHeader != null){
            sb.append("\n");
            sb.append(offerHeader);
        }

        sb.append("\nNazwa: ");
        sb.append(car.getName());

        sb.append("\nKolor: ");
        sb.append(car.getColor());

        sb.append("\nKoła: ");
        sb.append(car.getWheelsSize());

        sb.append("\nSilnik: ");
        sb.append(createEngineDescription(car.getEngine()));

        if (offerFooter != null){
            sb.append("\n");
            sb.append(offerFooter);
        }
        return  sb.toString();
    }

    private String createEngineDescription(Engine engine){

        if (engine==null){
            return EMPTY_VALUE;
        }

        StringBuilder sb = new StringBuilder();

        sb.append("\n Typ: ");
        sb.append(mapEngineType(engine.getType()));

        sb.append("\n Nazwa: ");
        sb.append(engine.getName());

        sb.append("\n Moc (KM): ");
        sb.append(engine.getHorsepower());

        sb.append("\n Skrzynia biegów: ");
        sb.append(engine.getTransmission());

        sb.append("\n Pojemność: ");
        sb.append(engine.getCC());

        return sb.toString();
    }

    private String mapEngineType(EEngineType type){

        if (type == null){
            return  EMPTY_VALUE;
        }

        switch (type){
            case DIESEL: return "Diesel";
            case PETROL: return "Petrol";
        }
        return EMPTY_VALUE;
    }

}
