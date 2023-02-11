package domain.valueobject

abstract class Shape(val width: Int, val height: Int) {
    abstract fun isInside(position: Position): Boolean
}
