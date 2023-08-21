package barber.project.barber.Service;


import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import barber.project.barber.dto.BarberDTO;
import barber.project.barber.exception.RecordNotFundExecption;
import barber.project.barber.repository.BarberRepository;
import barber.project.barber.dto.mapper.BarberMapper;

@Service
public class BarberService {

    private final BarberRepository barberRepository;
    private BarberMapper barberMapper;


    public BarberService(BarberRepository barberRepository, BarberMapper barberMapper){
        this.barberRepository = barberRepository;
        this.barberMapper = barberMapper;
    }
    
    public List<BarberDTO> list(){
        return barberRepository.findAll()
        .stream()
        .map(barberMapper::toDTO)
        .collect(Collectors.toList());
    }

    public BarberDTO findById(Long id){
        return barberRepository.findById(id).map(barberMapper::toDTO).orElseThrow(() -> new RecordNotFundExecption(id));
    }

    public BarberDTO create(BarberDTO barberDTO){
        return barberMapper.toDTO(barberRepository.save(barberMapper.toEntity(barberDTO)));
    }

    public BarberDTO update(Long id, BarberDTO barberDTO){
        return barberRepository.findById(id)
        .map(recordFound -> {
            recordFound.setFirstName(barberDTO.firstName());
            recordFound.setLastName(barberDTO.lastName());
            return barberMapper.toDTO(barberRepository.save(recordFound));
        }).orElseThrow(() -> new RecordNotFundExecption(id));
    }

    public void delete(Long id){

        barberRepository.delete(barberRepository.findById(id).orElseThrow(() -> new RecordNotFundExecption(id)));
        
    }

    

}
