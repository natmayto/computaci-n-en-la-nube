package com.taller.taller.mapper;

import com.taller.taller.persistence.entity.Backlog;
import com.taller.taller.service.dto.BacklogInDTO;
import org.springframework.stereotype.Component;

@Component
public class BacklogInDTOToBacklog implements IMapper<BacklogInDTO, Backlog> {
    @Override
    public Backlog map(BacklogInDTO in) {
        Backlog backlog = new Backlog();
        backlog.setId(in.getId());
        backlog.setProjectIdentifier(in.getProjectIdentifier());
        return backlog;
    }
}
