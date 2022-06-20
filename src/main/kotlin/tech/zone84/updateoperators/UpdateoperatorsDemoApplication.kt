package tech.zone84.updateoperators

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import tech.zone84.updateoperators.infrastructure.settings.ConfigurationRewardSettings

@SpringBootApplication
@ComponentScan
@EnableConfigurationProperties(ConfigurationRewardSettings::class)
class UpdateoperatorsDemoApplication

fun main(args: Array<String>) {
	runApplication<UpdateoperatorsDemoApplication>(*args)
}
