package me.rasztabiga.fridgy.productcatalog

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/conferences")
// # TODO: secure with keycloak, https://micronaut-projects.github.io/micronaut-security/latest/guide/#jwks
class ConferenceController(private val conferenceService: ConferenceService) {

    @Get("/random")
    fun randomConf(): Conference = conferenceService.randomConf()
}
