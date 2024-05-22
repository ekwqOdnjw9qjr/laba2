package ru.edu.penzgtu.service.mapper;

import org.springframework.stereotype.Service;
import ru.edu.penzgtu.dto.CookDto;
import ru.edu.penzgtu.entity.Cook;
import ru.edu.penzgtu.entity.Restaurant;

import java.util.List;

@Service
public class CookMapper {

    public List<CookDto> toListDto(List<Cook> cooks) {
        return cooks.stream().map(this::toDto).toList();
    }

    public CookDto toDto(Cook cook) {
        return CookDto.builder()
                .id(cook.getId())
                .name(cook.getName())
                .restaurant(cook.getRestaurants().stream()
                        .map(Restaurant::getName)
                        .toList())
                .build();
    }

    public Cook toEntity(CookDto cookDto) {
        Cook cook = new Cook();

        cook.setId(cookDto.getId());
        cook.setName(cookDto.getName());

        return cook;
    }
}
