package tech.zone84.updateoperators.infrastructure.database

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.repository.Repository
import org.springframework.stereotype.Component
import tech.zone84.updateoperators.infrastructure.InfrastructureConstants.Database.PURCHASE_DAYS_FIELD
import tech.zone84.updateoperators.infrastructure.InfrastructureConstants.Database.SPENT_AMOUNT_FIELD
import tech.zone84.updateoperators.infrastructure.InfrastructureConstants.Database.USER_ID_FIELD
import java.math.BigDecimal

interface RewardMongoRepository : Repository<RewardDocument, ObjectId>, CustomRewardMongoRepository {
    fun findByUserId(userId: String): RewardDocument?
}

interface CustomRewardMongoRepository {
    fun update(userId: String, spentAmountIncrement: BigDecimal, newPurchaseDays: Set<String>): Long
}

@Component
class CustomRewardMongoRepositoryImpl(private val client: MongoTemplate) : CustomRewardMongoRepository {
    override fun update(userId: String, spentAmountIncrement: BigDecimal, newPurchaseDays: Set<String>): Long {
        val result = client.upsert(
            Query.query(Criteria.where(USER_ID_FIELD).`is`(userId)),
            Update()
                .setOnInsert(USER_ID_FIELD, userId)
                .inc(SPENT_AMOUNT_FIELD, spentAmountIncrement)
                .addToSet(PURCHASE_DAYS_FIELD).each(newPurchaseDays),
            RewardDocument::class.java
        )
        return result.matchedCount
    }
}
