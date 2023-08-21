package barber.project.barber.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BarberDTO(
     Long id,
      @NotNull @NotEmpty String firstName, 
      @NotNull @NotEmpty String lastName) {
     
}
