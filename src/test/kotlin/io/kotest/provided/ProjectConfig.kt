package io.kotest.provided

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.extensions.Extension
import io.kotest.core.spec.IsolationMode
import io.kotest.extensions.spring.SpringExtension

object ProjectConfig : AbstractProjectConfig() {
    override val isolationMode = IsolationMode.InstancePerTest

    override fun extensions() = listOf<Extension>(MongoListener, SpringExtension)
}
