package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import entity.Entities;
@Repository
public interface Db extends JpaRepository<Entities,Integer>{
	@Query(value="select * from Entities where snAme=?1",nativeQuery=true)
	public Entities findBySnameIgnoreCas(String name);
}
