import it.elia.db.DbSettings
import it.elia.model.AvailableServices
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object AvailableServiceProvider {
    fun data() : List<AvailableServicesDto> {
        DbSettings.db
        return transaction {
            addLogger(StdOutSqlLogger)
            AvailableServices.selectAll().map { it -> AvailableServicesDto(it[AvailableServices.service],it[AvailableServices.selector]) }
        }
    }
}

data class AvailableServicesDto(val service : String, val selector : String)

