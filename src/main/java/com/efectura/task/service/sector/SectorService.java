package com.efectura.task.service.sector;

import com.efectura.task.model.Sector;

import java.util.List;

public interface SectorService {
    Sector update(Sector sector);

    Sector save(Sector sector);

    Sector findOne(Integer sectorId);

    List<Sector> findAll();

    List<Sector> findAllByParentId(Integer parentId);
}
