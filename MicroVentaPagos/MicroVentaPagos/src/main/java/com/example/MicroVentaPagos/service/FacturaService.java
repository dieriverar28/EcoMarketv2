package com.example.MicroVentaPagos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroVentaPagos.modelo.Factura;
import com.example.MicroVentaPagos.repository.FacturaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FacturaService {
    @Autowired
//LLAMAR REPOSITORIO
    private FacturaRepository facturaRepository;
//OBTENER TODOS
    public List<Factura> getFacturas(){
        return facturaRepository.obtenerCuponDescuentos();
    }

    //BUSCAR X id_factura
    public Factura getFactura(int id_factura){
        Factura facturas = facturaRepository.buscarFactura(id_factura);
        if (facturas!=null) {
        return facturas;
        }else
        return new Factura();
    }

    // ELIMINAR POR ID
    public int deleteFactura(int id_factura) {
        facturaRepository.delete(getFactura(id_factura));
        return 1;
    }

    // GUARDAR factura
    public Factura saveFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    // MODIFICAR factura
    public int updateFactura(Factura factura) {
        facturaRepository.save(factura);
        return 1;
    }

}
