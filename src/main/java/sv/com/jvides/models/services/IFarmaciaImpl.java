package sv.com.jvides.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.com.jvides.models.dao.IFarmaciaDao;

import sv.com.jvides.models.entities.farmacia;

@Service 
public class IFarmaciaImpl implements IFarmaciaService {
	@Autowired
	private IFarmaciaDao farmaciaDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<farmacia> findAll() {		
		return (List<farmacia>) farmaciaDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public farmacia findOne(Long id) {		
		return farmaciaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(farmacia farmacia) {
		farmaciaDao.save(farmacia);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		farmaciaDao.deleteById(id);
	}

	

	
}


