package com.efectura.task.repository.sector;

import com.efectura.task.model.Sector;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudSectorRepository extends CrudRepository<Sector, Integer> {
    List<Sector> getByParentId(Integer parentId);
}
