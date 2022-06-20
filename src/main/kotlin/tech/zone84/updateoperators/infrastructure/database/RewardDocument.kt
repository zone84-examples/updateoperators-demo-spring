package tech.zone84.updateoperators.infrastructure.database

import org.bson.BsonType
import org.bson.codecs.pojo.annotations.BsonRepresentation
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.FieldType
import java.math.BigDecimal

@Document("rewards")
data class RewardDocument(
    @field:Id
    var id: ObjectId,
    @field:BsonRepresentation(BsonType.STRING)
    @field:Indexed(unique = true)
    var userId: String,
    @field:Field(targetType = FieldType.DECIMAL128)
    var spentAmount: BigDecimal,
    var purchaseDays: Set<String>
)
