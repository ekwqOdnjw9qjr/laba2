package ru.edu.penzgtu.repo;

import ru.edu.penzgtu.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
}