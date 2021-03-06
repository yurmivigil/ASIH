package sv.com.jvides.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import sv.com.jvides.models.entities.Customer;
import sv.com.jvides.models.entities.Invoice;

public interface IInvoiceDao extends CrudRepository<Invoice, Long> {
	
	@Query(value="SELECT * FROM Invoice sw JOIN Customer w ON (sw.customer_id = w.id) WHERE w.id=?1", nativeQuery = true)
	public Invoice findByCustomerId(Long id);
}
