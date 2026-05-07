import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcoMarketSPA.model.Tienda;
import com.example.EcoMarketSPA.service.TiendaService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@RestController
@RequestMapping ("api/v2/tiendas")
public class TiendaController {
    @Autowired
    private TiendaService tiendaService;

    @GetMapping
    public List<Tienda> listarTiendas(){
        return tiendaService.getTiendas();
    }
    //agregar
    @PostMapping
    public Tienda agregarTienda(@Valid @RequestBody Tienda tienda){
        return tiendaService.saveTienda(tienda);
     }
    //buscar
        @GetMapping("/{id_tienda}")
        public Tienda buscarTienda(@PathVariable int id_tienda){
            return tiendaService.getTienda(id_tienda);
        }
    //actualizar
    @PutMapping("/{id_tienda}")
    public Tienda actualizarTienda(@PathVariable int id_tienda, @Valid @RequestBody Tienda tienda){
        return tiendaService.updateTienda(id_tienda, tienda);
    }
    //eliminar
    @DeleteMapping("/{id_tienda}")
    public String eliminarTienda(@PathVariable int id_tienda){
        if (tiendaService.deleteTienda(id_tienda) == 1) {
            return "Tienda eliminada correctamente";
        }
        return "Error al eliminar la tienda";
    }

}
