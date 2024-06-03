package pe.edu.upc.finanzasv3.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.finanzasv3.dtos.CanceladoDTO;
import pe.edu.upc.finanzasv3.entities.Cancelado;
import pe.edu.upc.finanzasv3.repositories.ICanceladoRepository;
import pe.edu.upc.finanzasv3.serviceinterface.ICanceladoService;

@RestController
@RequestMapping("/Cancelaciones")
public class CanceladoController {
    @Autowired
    private ICanceladoService cR;
    
    @PostMapping
    public void registrar(@RequestBody CanceladoDTO dto) {
        ModelMapper m = new ModelMapper();
        Cancelado cp = m.map(dto, Cancelado.class);
        cR.insert(cp);
    }

}
