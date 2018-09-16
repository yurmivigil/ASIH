package sv.com.jvides.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.jvides.models.entities.personal;

public interface IPersonalDao extends CrudRepository<personal, Long> {

	
}
