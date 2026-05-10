import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoMarketSPA.model.Comuna;
import com.example.EcoMarketSPA.repository.ComunaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComunaService {
    @Autowired
//SE LLAMA AL REPOSITORIO PARA PODER USAR SUS FUNCIONES
    private ComunaRepository comunaRepository; 

//OBTENER COMUNAS
    public List<Comuna> getComunas() {
        return comunaRepository.obtenerComunas();
    }
//OBTENER COMUNA POR ID
    public Comuna getComunaById(int id_comuna) {
        Comuna comunas = comunaRepository.buscarComuna(id_comuna);
        if (comunas!=null) {    
        return comunas;
        }else
        return new Comuna();
    }
//CREAR comuna
    public Comuna saveComunas(Comuna comuna) {
        return comunaRepository.save(comuna);
    }
//ACTUALIZAR comuna
    public int updateComuna(Comuna comuna) {
         comunaRepository.save(comuna);
        return 1;
    }
//ELIMINAR comuna
    public int deleteComuna(int id_comuna) {
        comunaRepository.delete(getComunaById(id_comuna));
        return 1;
    }

}
