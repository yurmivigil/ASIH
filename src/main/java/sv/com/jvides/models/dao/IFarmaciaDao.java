package sv.com.jvides.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.jvides.models.entities.farmacia;

public interface IFarmaciaDao extends CrudRepository<farmacia, Long>  {

}
