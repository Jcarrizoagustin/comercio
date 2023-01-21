package com.project.comercio.repositories;

import com.project.comercio.entities.Client;
import com.project.comercio.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Repository
public interface SaleRepository extends JpaRepository<Sale, UUID> {
    //Lista de ordenes para una fecha determinada
    //Implementar para una fecha sin importar la hora
    //List<Sale> findSaleByDate(LocalDateTime date);

    //Lista de ordenes para un cliente en particular
    List<Sale> findSaleByClient(Client client);
}
