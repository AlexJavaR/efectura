package com.efectura.task.service.sector;

import com.efectura.task.model.Sector;
import com.efectura.task.repository.sector.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorServiceImpl implements SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public Sector update(Sector sector) {
        return sectorRepository.save(sector);
    }

    @Override
    public Sector save(Sector sector) {
        return sectorRepository.save(sector);
    }

    @Override
    public Sector findOne(Integer sectorId) {
        return sectorRepository.findOne(sectorId);
    }

    @Override
    public List<Sector> findAll() {
        return sectorRepository.findAll();
    }

    @Override
    public List<Sector> findAllByParentId(Integer parentId) {
        return sectorRepository.findAllByParentId(parentId);
    }
}
