package ru.edu.penzgtu.service;

import ru.edu.penzgtu.dto.RestaurantDto;
import ru.edu.penzgtu.entity.Restaurant;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import ru.edu.penzgtu.exception.ErrorType;
import ru.edu.penzgtu.exception.PenzGtuException;
import ru.edu.penzgtu.repo.RestaurantRepository;
import ru.edu.penzgtu.service.mapper.RestaurantMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public List<RestaurantDto> findAllRestaurants(){
        return restaurantMapper.toListDto(restaurantRepository.findAll());
    }

    public RestaurantDto findRestaurantById(Long id ) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new PenzGtuException(ErrorType.NOT_FOUND,"Restaurant with id " + id + " not found"));
        return restaurantMapper.toDto(restaurant);
    }

    public void  saveRestaurant(RestaurantDto restaurantDto){
        Restaurant restaurant = restaurantMapper.toEntity(restaurantDto);
        restaurantRepository.save(restaurant);
    }

    public void updateRestaurant(RestaurantDto newRestaurant) {
        Restaurant oldRestaurant = restaurantRepository.findById(newRestaurant.getId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        oldRestaurant.setName(newRestaurant.getName());
        restaurantRepository.save(oldRestaurant);
    }

    public void deleteRestaurantById(Long id ){
        restaurantRepository.deleteById(id);
    }
}