package barber.project.barber.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import barber.project.barber.Service.BarberService;
import barber.project.barber.dto.BarberDTO;


@RestController
@RequestMapping("/barber")
public class BarberController {

    private final BarberService barberService;

    public BarberController(BarberService barberService){
        this.barberService = barberService;
    }

    @GetMapping
    public @ResponseBody List<BarberDTO> list(){
        return barberService.list();
    }

    @GetMapping("/{id}")
    public BarberDTO findById(Long id){
        return barberService.findById(id);
    
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public BarberDTO create(@RequestBody BarberDTO barberDTO){
        return barberService.create(barberDTO);
    }

    @PutMapping("update/{id}")
    public BarberDTO update(Long id, BarberDTO barberDTO){
        return barberService.update(id, barberDTO);
      
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(Long id){
        barberService.delete(id);
       
    }
    
}
