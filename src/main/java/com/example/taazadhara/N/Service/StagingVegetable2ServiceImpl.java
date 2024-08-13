package com.example.taazadhara.N.Service;

import com.example.taazadhara.N.Entity.StagingVegetable2;
import com.example.taazadhara.N.Repo.StagingVegetable2Repository;
import com.example.taazadhara.N.exception.StagingVegetable2NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StagingVegetable2ServiceImpl implements StagingVegetable2Service {

    @Autowired
    private StagingVegetable2Repository stagingVegetable2Repository;

    @Override
    public StagingVegetable2 createStagingVegetable2(StagingVegetable2 stagingVegetable2) {
        return stagingVegetable2Repository.save(stagingVegetable2);
    }

    @Override
    public Optional<StagingVegetable2> getStagingVegetable2ById(Long id) {
        return stagingVegetable2Repository.findById(id);
    }

    @Override
    public List<StagingVegetable2> getAllStagingVegetable2() {
        return stagingVegetable2Repository.findAll();
    }

    @Override
    public Optional<StagingVegetable2> updateStagingVegetable2ById(Long id, StagingVegetable2 stagingVegetable2Details) throws StagingVegetable2NotFoundException {
        return Optional.ofNullable(stagingVegetable2Repository.findById(id).map(existingStagingVegetable2 -> {
            existingStagingVegetable2.setVegetableId(stagingVegetable2Details.getVegetableId());
            existingStagingVegetable2.setLocationPriceId(stagingVegetable2Details.getLocationPriceId());
            existingStagingVegetable2.setState(stagingVegetable2Details.getState());
            existingStagingVegetable2.setDistrict(stagingVegetable2Details.getDistrict());
            existingStagingVegetable2.setArea(stagingVegetable2Details.getArea());
            existingStagingVegetable2.setVegetableName(stagingVegetable2Details.getVegetableName());
            existingStagingVegetable2.setPrice(stagingVegetable2Details.getPrice());
            existingStagingVegetable2.setUnits(stagingVegetable2Details.getUnits());
            existingStagingVegetable2.setLocationName(stagingVegetable2Details.getLocationName());
            return stagingVegetable2Repository.save(existingStagingVegetable2);
        }).orElseThrow(() -> new StagingVegetable2NotFoundException("StagingVegetable2 with id " + id + " not found")));
    }

    @Override
    public void deleteStagingVegetable2ById(Long id) throws StagingVegetable2NotFoundException {
        try {
            stagingVegetable2Repository.deleteById(id);
        } catch (Exception e) {
            throw new StagingVegetable2NotFoundException("StagingVegetable not found for this id: " + id);
        }
    }
    @Override
    public void deleteAllStagingVegetable2() throws StagingVegetable2NotFoundException {
        try {
            if (stagingVegetable2Repository.count() == 0) {
                throw new StagingVegetable2NotFoundException("No StagingVegetable2 records found to delete");
            }
            stagingVegetable2Repository.deleteAll();
        } catch (StagingVegetable2NotFoundException e) {
            throw e; // Re-throw the custom exception
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while deleting all StagingVegetable2 records", e);
        }
    }
    @Override
    public void importStagingVegetable2FromCsv(String filePath) throws IOException {
        List<StagingVegetable2> vegetables = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                StagingVegetable2 veg = new StagingVegetable2();
                veg.setVegetableId(Long.parseLong(values[0]));
                veg.setLocationPriceId(Long.parseLong(values[1]));
                veg.setState(values[2]);
                veg.setDistrict(values[3]);
                veg.setArea(values[4]);
                veg.setVegetableName(values[5]);
                veg.setPrice(new BigDecimal(values[6])); // Convert to BigDecimal
                veg.setUnits(values[7]);
                veg.setLocationName(values[8]);
                vegetables.add(veg);
            }
        }
        stagingVegetable2Repository.saveAll(vegetables);
    }

    @Override
    public void exportStagingVegetable2ToCsv(String filePath) throws IOException {
        List<StagingVegetable2> vegetables = stagingVegetable2Repository.findAll();
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("VegetableId,LocationPriceId,State,District,Area,VegetableName,Price,Units,LocationName\n");
            for (StagingVegetable2 veg : vegetables) {
                writer.append(String.join(",",
                        String.valueOf(veg.getVegetableId()),
                        String.valueOf(veg.getLocationPriceId()),
                        veg.getState(),
                        veg.getDistrict(),
                        veg.getArea(),
                        veg.getVegetableName(),
                        veg.getPrice().toString(), // Convert BigDecimal to String
                        veg.getUnits(),
                        veg.getLocationName()
                )).append("\n");
            }
        } catch (IOException e) {
            // Log the exception (consider using a logging framework like SLF4J)
            System.err.println("Error writing to CSV file: " + e.getMessage());
            throw e; // Rethrow the exception to notify the caller
        }
    }
}








