package lk.ijse.cmjd109.LibMgmt109.service.impl;

import lk.ijse.cmjd109.LibMgmt109.dto.LendingDTO;
import lk.ijse.cmjd109.LibMgmt109.service.LendingService;
import lk.ijse.cmjd109.LibMgmt109.util.UtilityData;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LendingServiceIMPL implements LendingService {
    @Override
    public void addLending(LendingDTO lendingDTO) {
       lendingDTO.setLendingId(UtilityData.generateLendingId());
    }

    @Override
    public void handOverLending(String lendingID) {

    }

    @Override
    public void deleteLending(String lendingID) {

    }

    @Override
    public LendingDTO getSpecificLending(String lendingID) {
        return null;
    }

    @Override
    public List<LendingDTO> getAllLendings() {
        return List.of();
    }
}
