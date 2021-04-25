package com.katia.crudMicroService.exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ErrorDetails {
	private long code;
    private String message;
    private String details;
}