package com.djalves.oulhostbackend.service;

import com.djalves.oulhostbackend.dtos.PlayerDTO;
import com.djalves.oulhostbackend.infra.CodiNameHandler;
import com.djalves.oulhostbackend.model.GroupType;
import com.djalves.oulhostbackend.model.Player;
import com.djalves.oulhostbackend.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Autowired
    private CodiNameHandler handler;

    public Player createPlayer(PlayerDTO dto) {
        Player newPlayer = new Player(dto);
        String codiname = getCodename(dto.groupType());
        newPlayer.setCodeName(codiname);
        return repository.save(newPlayer);
    }

    private String getCodename(GroupType groupType) {
        return handler.findCodename(groupType);
    }
}
