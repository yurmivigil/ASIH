package sv.com.jvides.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.com.jvides.models.dao.IPersonalDao;
import sv.com.jvides.models.entities.personal;


@Service
public class IPersonalimpl implements IPersonalService {


	@Autowired
	private IPersonalDao personalDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<personal> findAll() {		
		return (List<personal>) personalDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public personal findOne(Long id) {		
		return personalDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(personal personal) {
		personalDao.save(personal);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		personalDao.deleteById(id);
	}

	

	
}
