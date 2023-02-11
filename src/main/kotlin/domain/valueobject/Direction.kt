package domain.valueobject

enum class Direction(val value: Char) {
    NORTH('N'),
    WEST('W'),
    SOUTH('S'),
    EAST('E');

    fun turnLeft(): Direction {
        return when (this) {
            NORTH -> WEST
            WEST -> SOUTH
            SOUTH -> EAST
            EAST -> NORTH
        }
    }

    fun turnRight(): Direction {
        return when (this) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
        }
    }
}
