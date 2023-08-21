package barber.project.barber.dto.mapper;

import org.springframework.stereotype.Component;

import barber.project.barber.dto.BarberDTO;
import barber.project.barber.model.Barber;

@Component
public class BarberMapper {

    public BarberDTO toDTO(Barber barber){
        if(barber == null){
            return null;
        }
        return new BarberDTO(barber.getId(), barber.getFirstName(), barber.getLastName());
        
    }

    public Barber toEntity(BarberDTO barberDTO){
        if(barberDTO == null){
            return null;
        }

        Barber barber = new Barber();
        if(barberDTO.id() != null){
            barber.setId(barberDTO.id());
        }
        barber.setFirstName(barberDTO.firstName());
        barber.setLastName(barberDTO.lastName());
        return barber;
    }
}
