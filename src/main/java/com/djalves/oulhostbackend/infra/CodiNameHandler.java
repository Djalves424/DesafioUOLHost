package com.djalves.oulhostbackend.infra;

import com.djalves.oulhostbackend.model.GroupType;
import com.djalves.oulhostbackend.service.CodinameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CodiNameHandler {

    @Autowired
    private CodinameService service;

    public String findCodename(GroupType groupType) {

        if (groupType == GroupType.AVANGERS) {
            String firstMatch = service.getAvangersCodenameList().stream().findFirst().orElseThrow();
            this.service.getAvangersCodenameList().remove(firstMatch);
            return firstMatch;
        }

        String firstMatch = service.getJusticeLeagueList().stream().findFirst().orElseThrow();
        this.service.getJusticeLeagueList().remove(firstMatch);
        return firstMatch;
    }
}
