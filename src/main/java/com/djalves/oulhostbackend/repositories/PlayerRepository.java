package com.djalves.oulhostbackend.repositories;

import com.djalves.oulhostbackend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
