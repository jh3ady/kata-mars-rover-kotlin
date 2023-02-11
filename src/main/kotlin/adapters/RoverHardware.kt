package adapters

import domain.entity.Planet
import domain.entity.Rover
import domain.valueobject.Direction
import domain.valueobject.Position
import ports.RoverDriverInterface

class RoverHardware(initialPosition: Position, initialDirection: Direction, planet: Planet) : RoverDriverInterface {
    private var rover = Rover(initialPosition, initialDirection, planet)

    override fun getPosition(): Position {
        return rover.getPosition()
    }

    override fun getDirection(): Direction {
        return rover.getDirection()
    }

    override fun execute(commands: ArrayList<Char>) {
        commands.forEach { command ->
            val succeed = when (command) {
                'f' -> rover.moveForward()
                'b' -> rover.moveBackward()
                'l' -> rover.turnLeft()
                'r' -> rover.turnRight()
                else -> false
            }

            if (!succeed) {
                return
            }
        }
    }
}
