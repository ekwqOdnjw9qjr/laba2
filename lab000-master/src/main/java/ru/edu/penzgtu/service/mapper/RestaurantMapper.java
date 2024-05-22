package ru.edu.penzgtu.service.mapper;

import org.springframework.stereotype.Service;
import ru.edu.penzgtu.dto.RestaurantDto;
import ru.edu.penzgtu.entity.Cook;
import ru.edu.penzgtu.entity.Restaurant;

import java.util.List;
@Service
public class RestaurantMapper {
    public List<RestaurantDto> toListDto(List<Restaurant> restaurants) {
        return restaurants.stream().map(this::toDto).toList();
    }

    public RestaurantDto toDto(Restaurant restaurant) {
        return RestaurantDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .cooks(restaurant.getCooks().stream()
                        .map(Cook::getName)
                        .toList())
                .build();
    }

    public Restaurant toEntity(RestaurantDto restaurantDto) {
       Restaurant restaurant = new Restaurant();

        restaurant.setId(restaurantDto.getId());
        restaurant.setName(restaurantDto.getName());

        return restaurant;
    }
}
