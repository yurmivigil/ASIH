package sv.com.jvides.models.services;

import java.util.List;
import sv.com.jvides.models.entities.personal;

public interface IPersonalService {

	public List<personal> findAll();
	
	public void save(personal personal);
	
	public personal findOne(Long id);
	
	public void delete(Long id);
}
