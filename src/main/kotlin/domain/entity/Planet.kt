package domain.entity

import domain.valueobject.Position
import domain.valueobject.Shape

abstract class Planet(val shape: Shape) {
    var obstacles: ArrayList<Position> = ArrayList()
        protected set

    fun isPositionValid(position: Position): Boolean {
        return shape.isInside(position) && !obstacles.contains(position)
    }

    fun addObstacle(position: Position) {
        if (!shape.isInside(position)) {
            return;
        }

        obstacles.add(position)
    }
}
