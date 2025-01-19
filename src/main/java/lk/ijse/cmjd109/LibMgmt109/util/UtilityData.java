package lk.ijse.cmjd109.LibMgmt109.util;

import java.util.UUID;

public class UtilityData {
    public static String generateBookId(){
        return "B/"+UUID.randomUUID();
    }
    public static String generateMemberId(){
        return "M/"+UUID.randomUUID();
    }
    public static String generateLendingId(){
        return "L/"+UUID.randomUUID();
    }
    public static String generateStaffId(){
        return "S/"+UUID.randomUUID();
    }


}
