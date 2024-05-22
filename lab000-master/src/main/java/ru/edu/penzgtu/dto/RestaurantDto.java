package ru.edu.penzgtu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Schema(description = "Информация о ресторане")
public class RestaurantDto {

    @JsonProperty("id")
    @Schema(description = "ID ресторана в БД", example = "123")
    private Long id;

    @JsonProperty("name")
    @NotBlank
    @Schema(description = "Название ресторана", example = "Claude Monet")
    private String name;

    @JsonProperty("cook")
    @Schema(description = "Имя повара который работает в ресторане")
    private List<String> cooks;
}
