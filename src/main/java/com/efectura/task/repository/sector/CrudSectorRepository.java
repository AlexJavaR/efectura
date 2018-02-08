package com.efectura.task.repository.sector;

import com.efectura.task.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrudSectorRepository extends JpaRepository<Sector, Integer> {
    List<Sector> getByParentId(Integer parentId);
}
