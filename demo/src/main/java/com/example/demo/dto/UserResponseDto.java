package com.example.demo.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class UserResponseDto {
    private String fullName;
    private String email;
}
