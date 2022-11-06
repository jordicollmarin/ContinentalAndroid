package cat.continental.data.datasource.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Relation

@Entity
data class PlaceWithContinentalMatches(
    @Embedded
    val place: Place,

    @Relation(parentColumn = "uid", entityColumn = "place_id")
    @ColumnInfo(name = "continental_matches")
    val continentalMatches: List<Continental>
)

@Entity(primaryKeys = ["game_id", "player_id", "continental_id"])
data class GamePlayerContinentalCrossReference(
    @ColumnInfo(name = "game_id") val gameId: Long,
    @ColumnInfo(name = "player_id") val playerId: Long,
    @ColumnInfo(name = "continental_id") val continentalId: Long,
    val points: Long
)

@Entity(
    primaryKeys = ["game_id", "continental_id"],
    foreignKeys = [
        ForeignKey(
            entity = Player::class,
            parentColumns = ["uid"],
            childColumns = ["dealer"],
            onDelete = ForeignKey.SET_NULL,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Player::class,
            parentColumns = ["uid"],
            childColumns = ["winner"],
            onDelete = ForeignKey.SET_NULL,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class GameContinentalCrossReference(
    @ColumnInfo(name = "game_id") val gameId: Long,
    @ColumnInfo(name = "continental_id") val continentalId: Long,
    val dealer: Long,
    val winner: Long,
    val finished: Boolean
)

@Entity(primaryKeys = ["continental_id", "player_id"])
data class ContinentalPlayerCrossReference(
    @ColumnInfo(name = "continental_id") val continentalId: Long,
    @ColumnInfo(name = "player_id") val playerId: Long,
    @ColumnInfo(name = "total_points") val totalPoints: Long,
    val winner: Boolean
)
