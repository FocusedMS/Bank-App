package com.bankingmanagementsystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    @Schema(description = "Account ID", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    
    @Schema(description = "Account Number", accessMode = Schema.AccessMode.READ_ONLY)
    private String accountNumber;
    
    @NotNull(message = "Account holder name is required")
    @Schema(description = "Account Holder Name", example = "string")
    private String accountHolderName;
    
    @NotNull(message = "Email is required")
    @Schema(description = "Email Address", example = "string")
    private String email;

    @NotNull(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits")
    @Size(min = 10, max = 10, message = "Mobile number must be exactly 10 digits")
    @Schema(description = "Mobile Number", example = "string")
    private String mobileNumber;
    
    @Schema(description = "Account Balance", accessMode = Schema.AccessMode.READ_ONLY)
    private double balance;
}
