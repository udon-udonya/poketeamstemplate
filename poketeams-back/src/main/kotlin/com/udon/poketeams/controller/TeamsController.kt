package com.udon.poketeams.controller

import com.udon.poketeams.model.Teams
import com.udon.poketeams.repository.TeamsRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class TeamsController(private val teamsRepository: TeamsRepository) {

    @GetMapping("/teams")
    fun getAllTeams(): List<Teams> =
        teamsRepository.findAll()
    //curl -i -H 'Accept: application/json' http://localhost:8080/api/teams

    @PostMapping("/teams")
    fun createNewTeam(@Valid @RequestBody teams: Teams): Teams =
        teamsRepository.save(teams)
    //curl -i -H "Content-Type: application/json" -X POST -d '{"title": "hoge", "content": "fuga"}' http://localhost:8080/api/teams

    @GetMapping("/teams/{id}")
    fun getTeamBiId(@PathVariable(value = "id") teamed: Long): ResponseEntity<Teams> {
        return teamsRepository.findById(teamed).map { team ->
            ResponseEntity.ok(team)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/teams/{id}")
    fun updateTeamById(@PathVariable(value = "id") teamed: Long,
                        @Valid @RequestBody newTeams: Teams): ResponseEntity<Teams> {

        return teamsRepository.findById(teamed).map { existingTeam ->
            val updateTeams: Teams = existingTeam
                .copy(title = newTeams.title, content = newTeams.content)
            ResponseEntity.ok().body(teamsRepository.save(updateTeams))
        }.orElse(ResponseEntity.notFound().build())
    //curl -i -H "Content-Type: application/json" -X PUT -d '{"title": "foo", "content": "bar"}' http://localhost:8080/api/teams/1

    }

    @DeleteMapping("/teams/{id}")
    fun deleteTeamById(@PathVariable(value = "id") teamed: Long): ResponseEntity<Void> {

        return teamsRepository.findById(teamed).map { team ->
            teamsRepository.delete(team)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
    //curl -i -X DELETE http://localhost:8080/api/teams/1

}