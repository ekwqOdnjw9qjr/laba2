package ru.edu.penzgtu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Schema(description = "Информация о поваре")
public class CookDto {

    @JsonProperty("id")
    @Schema(description = "ID повара в БД", example = "123")
    private Long id;

    @JsonProperty("name")
    @NotBlank
    @Schema(description = "Имя повара", example = "Виктор")
    private String name;

    @JsonProperty("restaurant")
    @Schema(description = "Название ресторана где работает повар")
    private List<String> restaurant;
}
