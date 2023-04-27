package com.co.mobile_banking.api.user;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class User {
    private Integer id;
    private String name;
    private String gender;
    private String oneSignalId;
    private String studentCardId;
    private Boolean isDeleted;
    private Boolean isStudent;

}
