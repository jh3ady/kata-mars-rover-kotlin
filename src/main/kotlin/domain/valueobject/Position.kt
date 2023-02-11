package domain.valueobject

data class Position(val x: Int, val y: Int) {
    fun moveForward(direction: Direction): Position {
        return when (direction) {
            Direction.NORTH -> Position(x, y + 1)
            Direction.WEST -> Position(x - 1, y)
            Direction.SOUTH -> Position(x, y - 1)
            Direction.EAST -> Position(x + 1, y)
        }
    }

    fun moveBackward(direction: Direction): Position {
        return when (direction) {
            Direction.NORTH -> Position(x, y - 1)
            Direction.WEST -> Position(x + 1, y)
            Direction.SOUTH -> Position(x, y + 1)
            Direction.EAST -> Position(x - 1, y)
        }
    }
}
