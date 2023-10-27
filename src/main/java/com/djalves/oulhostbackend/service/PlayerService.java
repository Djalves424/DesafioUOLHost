package com.djalves.oulhostbackend.service;

import com.djalves.oulhostbackend.dtos.PlayerDTO;
import com.djalves.oulhostbackend.model.Player;
import com.djalves.oulhostbackend.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public Player createPlayer(PlayerDTO dto) {
        Player newPlayer = new Player(dto);
        return repository.save(newPlayer);
    }
}
