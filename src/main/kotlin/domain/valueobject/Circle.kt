package domain.valueobject

class Circle(size: Int): Shape(size, size) {
    override fun isInside(position: Position): Boolean {
        return position.x < width && position.y < height
    }
}