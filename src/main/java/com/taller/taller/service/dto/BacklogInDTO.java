package com.taller.taller.service.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data

public class BacklogInDTO {
    private Long id;
    private String ProjectIdentifier;
}
