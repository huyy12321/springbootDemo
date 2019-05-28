package com.springboot.demo.PO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPO {
    private Long id;

    private String name;

    private Long roleId;

    private String password;
}
