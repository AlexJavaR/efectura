package com.efectura.task.repository.sector;

import com.efectura.task.model.Sector;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SectorRepository {
    Sector update(Sector sector);

    Sector save(Sector sector);

    Sector findOne(Integer sectorId);

    List<Sector> findAll();

    List<Sector> findAllByParentId(Integer parentId);
}
