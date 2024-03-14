package feedmysheep.feedmysheepapi.common.models;

import lombok.Data;

@Data
public class SMSSendRequest {
    private String destinationSMSNumber;
    private String smsMessages;


}
