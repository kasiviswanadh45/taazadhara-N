package com.example.taazadhara.N.Service;

import com.example.taazadhara.N.Entity.StagingVegetable2;
import com.example.taazadhara.N.exception.StagingVegetable2NotFoundException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface StagingVegetable2Service {
    StagingVegetable2 createStagingVegetable2(StagingVegetable2 stagingVegetable2);
    Optional<StagingVegetable2> updateStagingVegetable2ById(Long id, StagingVegetable2 stagingVegetable2Details) throws StagingVegetable2NotFoundException;
    Optional<StagingVegetable2> getStagingVegetable2ById(Long id);
    List<StagingVegetable2> getAllStagingVegetable2();
    void deleteStagingVegetable2ById(Long id) throws StagingVegetable2NotFoundException;

    void deleteAllStagingVegetable2() throws  StagingVegetable2NotFoundException;

    void importStagingVegetable2FromCsv(String filePath) throws IOException;

    void exportStagingVegetable2ToCsv(String filePath) throws IOException;
}

