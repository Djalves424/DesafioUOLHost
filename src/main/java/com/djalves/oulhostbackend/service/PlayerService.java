package com.djalves.oulhostbackend.service;

import com.djalves.oulhostbackend.dtos.PlayerDTO;
import com.djalves.oulhostbackend.infra.CodinameHandler;
import com.djalves.oulhostbackend.model.GroupType;
import com.djalves.oulhostbackend.model.Player;
import com.djalves.oulhostbackend.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Autowired
    private CodinameHandler handler;

    public Player createPlayer(PlayerDTO dto) {
        Player newPlayer = new Player(dto);
        String codiname = getCodiname(dto.groupType());
        newPlayer.setCodiname(codiname);
        return repository.save(newPlayer);
    }

    private String getCodiname(GroupType groupType) {
        return handler.findCodiname(groupType);
    }

    public List<Player> getAllPlayers() {
        return repository.findAll();
    }
}
