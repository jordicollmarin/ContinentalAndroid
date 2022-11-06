package cat.continental.data.datasource.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Player(
    @PrimaryKey val uid: Long,
    val name: String,
    val lastName: String
)

@Entity
data class Game(
    @PrimaryKey val uid: Long,
    @ColumnInfo(name = "number_of_cards") val nCards: Int,
    @ColumnInfo(name = "number_of_trios") val nTrios: Int,
    @ColumnInfo(name = "number_of_runs") val nRuns: Int
)

@Entity
data class Place(
    @PrimaryKey val uid: Long,
    val name: String
)

@Entity
data class Continental(
    @PrimaryKey val uid: Long,
    val date: Date,
    val finished: Boolean,
    @ColumnInfo(name = "place_id") val placeId: Long
)
