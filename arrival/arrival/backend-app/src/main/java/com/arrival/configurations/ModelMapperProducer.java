package com.arrival.configurations;

import com.arrival.dto.TrackDTO;
import com.arrival.entities.cars.Car;
import com.arrival.entities.tracks.Track;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Model Mapper configuration
 * @author Victor Karetko.
 */
@Configuration
public class ModelMapperProducer {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        //map nested cars manually
        modelMapper.typeMap(TrackDTO.class, Track.class)
                .addMappings(mp -> mp.skip(Track::setCars))
                .setPostConverter(context -> {
                    Track track = context.getDestination();
                    track.getCars().clear();
                    List<Car> cars = context.getSource().getCars().stream()
                            .map(carDTO -> modelMapper.map(carDTO, Car.class))
                            .peek(car -> car.setTrack(track))
                            .collect(Collectors.toList());
                    track.getCars().addAll(cars);
                    return track;
        });

        return modelMapper;
    }
}
