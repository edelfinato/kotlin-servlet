
import it.elia.db.DbSettings
import it.elia.model.AvailableServices
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.BeforeClass
import org.junit.Test
import kotlin.test.assertEquals

class AvailableServicesProviderTest{
    companion object {
        @BeforeClass @JvmStatic fun start(){
            DbSettings.db
            transaction {
                addLogger(StdOutSqlLogger)
                AvailableServices.deleteAll()
            }
        }
    }

    @Test fun a_001(){
        assertEquals(0, AvailableServiceProvider.data().size)
    }
    @Test fun a_002(){
        DbSettings.db
        transaction {
            AvailableServices.insert {
                it[AvailableServices.service] = "INVOICE"
                it[AvailableServices.selector] = "ALL"
            }
        }
        assertEquals("ALL", AvailableServiceProvider.data().find { it.selector == "ALL" }?.selector)
    }
}