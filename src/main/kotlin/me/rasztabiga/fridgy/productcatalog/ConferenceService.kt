package me.rasztabiga.fridgy.productcatalog

import jakarta.inject.Singleton

@Singleton
class ConferenceService {

    fun randomConf(): Conference = CONFERENCES.random()

    companion object {
        private val CONFERENCES = listOf(
            Conference("Greach"),
            Conference("GR8Conf EU"),
            Conference("Micronaut Summit"),
            Conference("Devoxx Belgium"),
            Conference("Oracle Code One"),
            Conference("CommitConf"),
            Conference("Codemotion Madrid")
        )
    }
}
