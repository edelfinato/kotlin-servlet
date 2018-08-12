package it.elia.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column

object AvailableServices : IntIdTable("avaiable_services") {
    val service: Column<String> = AvailableServices.varchar("service", 50)
    val selector: Column<String> = AvailableServices.varchar("selector", 4096)
}
