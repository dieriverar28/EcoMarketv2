import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.EcoMarketSPA.model.Venta;


@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
    @Query("SELECT v FROM Venta v")
    List<Venta> obtenerVentas();

    @Query("SELECT v FROM Venta v WHERE v.id_venta = :id_venta")
    Venta buscarVenta(int id_venta);

}
