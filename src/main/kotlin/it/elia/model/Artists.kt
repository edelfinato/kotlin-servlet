package it.elia.model

import it.elia.db.DbSettings
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection

object Artists : Table() {
    val artistId: Column<Int> = integer("ArtistId").uniqueIndex()
    val name: Column<String> = varchar("Name", 120 )
}
