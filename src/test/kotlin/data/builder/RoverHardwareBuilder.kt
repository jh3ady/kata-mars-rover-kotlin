package data.builder

import adapters.RoverHardware
import domain.entity.Planet
import domain.valueobject.Direction
import domain.valueobject.Position

class RoverHardwareBuilder {
    private lateinit var position: Position
    private lateinit var direction: Direction
    private lateinit var planet: Planet

    fun withPosition(position: Position): RoverHardwareBuilder {
        this.position = position
        return this
    }

    fun withDirection(direction: Direction): RoverHardwareBuilder {
        this.direction = direction
        return this
    }

    fun withPlanet(planet: Planet): RoverHardwareBuilder {
        this.planet = planet
        return this
    }

    fun build(): RoverHardware {
        return RoverHardware(position, direction, planet)
    }
}