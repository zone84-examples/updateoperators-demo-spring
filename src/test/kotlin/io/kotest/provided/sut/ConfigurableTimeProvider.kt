package io.kotest.provided.sut

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import tech.zone84.updateoperators.domain.repository.TimeProvider
import java.time.Clock
import java.time.Instant

@Service
@Primary
class ConfigurableTimeProvider : TimeProvider {
    @field:Volatile
    private var now: Instant = Clock.systemDefaultZone().instant()

    fun nowIs(time: Instant) {
        now = time
    }

    override fun now(): Instant = now
}
