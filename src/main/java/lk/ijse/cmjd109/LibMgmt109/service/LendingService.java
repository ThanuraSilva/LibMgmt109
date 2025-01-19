package lk.ijse.cmjd109.LibMgmt109.service;

import lk.ijse.cmjd109.LibMgmt109.dto.LendingDTO;

import java.util.List;

public interface LendingService {
    void addLending(LendingDTO lendingDTO);
    void handOverLending(String lendingID);
    void deleteLending(String lendingID);
    LendingDTO getSpecificLending(String lendingID);
    List<LendingDTO> getAllLendings();
}



