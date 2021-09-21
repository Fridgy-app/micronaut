package me.rasztabiga.fridgy

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class FridgySpecIT extends Specification {

    @Inject
    EmbeddedApplication<?> application

    void 'test application instance is running'() {
        expect:
        application.running
    }

}
