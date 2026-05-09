import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.EcoMarketSPA.model.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Integer> {
    @Query("SELECT t FROM Tienda t")
    List<Tienda> obtenerTienda();

    @Query("SELECT t FROM Tienda t WHERE t.id_tienda = :id_tienda")
    Tienda buscarTienda(int id_tienda);

}
