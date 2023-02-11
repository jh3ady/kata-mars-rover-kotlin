package ports

import domain.valueobject.Direction
import domain.valueobject.Position

interface RoverDriverInterface {
    fun getPosition(): Position
    fun getDirection(): Direction
    fun execute(commands: ArrayList<Char>)
}
