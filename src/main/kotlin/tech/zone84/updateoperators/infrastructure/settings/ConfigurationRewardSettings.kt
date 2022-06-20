package tech.zone84.updateoperators.infrastructure.settings

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import tech.zone84.updateoperators.domain.grant.RewardSettings
import tech.zone84.updateoperators.domain.shared.Money
import java.math.BigDecimal

@ConfigurationProperties(prefix = "rewards", ignoreInvalidFields = true)
@ConstructorBinding
data class ConfigurationRewardSettings(
    val minimumAmountRaw: BigDecimal,
    override val minimumPurchaseDays: Int
) : RewardSettings {
    override val minimumAmount: Money
        get() = Money(minimumAmountRaw)
}
