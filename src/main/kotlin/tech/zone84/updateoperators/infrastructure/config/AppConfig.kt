package tech.zone84.updateoperators.infrastructure.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import tech.zone84.updateoperators.domain.Domain
import tech.zone84.updateoperators.domain.grant.RewardSettings
import tech.zone84.updateoperators.domain.repository.RewardRepository
import tech.zone84.updateoperators.domain.repository.TimeProvider
import tech.zone84.updateoperators.infrastructure.settings.ConfigurationRewardSettings
import java.time.Clock
import java.time.Instant

@Configuration
class AppConfig {
    @Bean
    fun domain(rewardRepository: RewardRepository, rewardSettings: RewardSettings, timeProvider: TimeProvider) =
        Domain.build(rewardRepository, rewardSettings, timeProvider)

    @Bean
    fun timeProvider() = object : TimeProvider {
        override fun now(): Instant = Clock.systemDefaultZone().instant()
    }

    @Bean
    fun rewardSettings(configurationRewardSettings: ConfigurationRewardSettings): RewardSettings = configurationRewardSettings
}
