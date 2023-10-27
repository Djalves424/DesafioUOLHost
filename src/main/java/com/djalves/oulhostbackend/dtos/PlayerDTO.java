package com.djalves.oulhostbackend.dtos;

import com.djalves.oulhostbackend.model.GroupType;

public record PlayerDTO(String name, String email, String phoneNumber, GroupType groupType) {
}
