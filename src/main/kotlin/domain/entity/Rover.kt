package domain.entity

import domain.valueobject.Direction
import domain.valueobject.Position

class Rover(private var position: Position, private var direction: Direction, private val planet: Planet) {
    fun getPosition(): Position {
        return position
    }

    fun getDirection(): Direction {
        return direction
    }

    fun moveForward(): Boolean {
        return move() { position.moveForward(direction) }
    }

    fun moveBackward(): Boolean {
        return move() { position.moveBackward(direction) }
    }

    fun turnLeft(): Boolean {
        direction = direction.turnLeft()

        return true
    }

    fun turnRight(): Boolean {
        direction = direction.turnRight()

        return true
    }

    private fun move(moveFunction: () -> Position): Boolean {
        val newPosition = wrap(moveFunction())
        if (planet.isPositionValid(newPosition)) {
            position = newPosition
            return true
        }
        return false
    }

    private fun wrap(position: Position): Position {
        val x =
            if (position.x < 0)
                planet.shape.width + position.x
            else
                position.x % planet.shape.width

        val y =
            if (position.y < 0)
                planet.shape.height + position.y
            else
                position.y % planet.shape.height

        return Position(x, y)
    }
}
