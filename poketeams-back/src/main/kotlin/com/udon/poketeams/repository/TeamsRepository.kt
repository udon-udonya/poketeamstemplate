package com.udon.poketeams.repository

import com.udon.poketeams.model.Teams
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamsRepository: JpaRepository<Teams, Long>