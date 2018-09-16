package sv.com.jvides.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import sv.com.jvides.models.dao.IIngresoDao;
import sv.com.jvides.models.entities.Ingresos;

public class IIngresosImpl {


	@Autowired
	private IIngresoDao ingresoDao;
	
	@Transactional(readOnly=true)
	public List<Ingresos> findAll() {		
		return (List<Ingresos>) ingresoDao.findAll();
	}
	
	@Transactional(readOnly=true)
	public Ingresos findOne(Long id) {		
		return ingresoDao.findById(id).orElse(null);
	}

	@Transactional
	public void save(Ingresos ingresos) {
		ingresoDao.save(ingresos);
	}

	@Transactional
	public void delete(Long id) {
		ingresoDao.deleteById(id);
	}

	

	
}
