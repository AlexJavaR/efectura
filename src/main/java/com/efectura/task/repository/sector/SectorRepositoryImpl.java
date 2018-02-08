package com.efectura.task.repository.sector;

import com.efectura.task.model.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SectorRepositoryImpl implements SectorRepository{

    private final CrudSectorRepository crudRepository;

    @Autowired
    public SectorRepositoryImpl(CrudSectorRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public Sector update(Sector sector) {
        return crudRepository.save(sector);
    }

    public Sector save(Sector sector) {
        return crudRepository.save(sector);
    }

    public Sector findOne(Integer sectorId) {
        return crudRepository.findOne(sectorId);
    }

    public List<Sector> findAll() {
        return crudRepository.findAll();
    }

    @Override
    public List<Sector> findAllByParentId(Integer parentId) {
        return crudRepository.getByParentId(parentId);
    }
}
