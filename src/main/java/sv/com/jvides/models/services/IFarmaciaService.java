package sv.com.jvides.models.services;

import java.util.List;
import sv.com.jvides.models.entities.farmacia;

public interface IFarmaciaService {

	public List<farmacia> findAll();
	
	public void save(farmacia farmacia);
	
	public farmacia findOne(Long id);
	
	public void delete(Long id);
}
