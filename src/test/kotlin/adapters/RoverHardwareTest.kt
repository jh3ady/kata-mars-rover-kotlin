package adapters

import data.builder.RoverHardwareBuilder
import domain.entity.Mars
import domain.valueobject.Circle
import domain.valueobject.Direction
import domain.valueobject.Position
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RoverHardwareTest {
    private lateinit var planet: Mars

    @BeforeEach
    fun setUp() {
        planet = Mars(Circle(10))
    }

    @Test
    fun testRoverShouldBeInitializedAtAGivenPosition() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.NORTH)
            .withPlanet(planet)
            .build()

        assertPosition(Position(0, 0), driver.getPosition())
    }

    @Test
    fun testRoverShouldBeInitializedInNorthDirection() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.NORTH)
            .withPlanet(planet)
            .build()

        assertDirection(Direction.NORTH, driver.getDirection())
    }

    @Test
    fun testRoverShouldBeInitializedInWestDirection() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.WEST)
            .withPlanet(planet)
            .build()

        assertDirection(Direction.WEST, driver.getDirection())
    }

    @Test
    fun testRoverShouldBeInitializedInSouthDirection() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.SOUTH)
            .withPlanet(planet)
            .build()

        assertDirection(Direction.SOUTH, driver.getDirection())
    }

    @Test
    fun testRoverShouldBeInitializedInEastDirection() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.EAST)
            .withPlanet(planet)
            .build()

        assertDirection(Direction.EAST, driver.getDirection())
    }

    @Test
    fun testRoverShouldMoveForwardToPositionX0Y1WhenFacingNorth() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.NORTH)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('f'))

        assertPosition(Position(0, 1), driver.getPosition())
    }

    @Test
    fun testRoverShouldMoveForwardToPositionX0Y1WhenFacingWest() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(1, 1))
            .withDirection(Direction.WEST)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('f'))

        assertPosition(Position(0, 1), driver.getPosition())
    }

    @Test
    fun testRoverShouldMoveForwardToPositionX0Y0WhenFacingSouth() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 1))
            .withDirection(Direction.SOUTH)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('f'))

        assertPosition(Position(0, 0), driver.getPosition())
    }

    @Test
    fun testRoverShouldMoveForwardToPositionX1Y0WhenFacingEast() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.EAST)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('f'))

        assertPosition(Position(1, 0), driver.getPosition())
    }

    @Test
    fun testRoverShouldMoveBackwardToPositionX0Y1WhenFacingNorth() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 1))
            .withDirection(Direction.NORTH)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('b'))

        assertPosition(Position(0, 0), driver.getPosition())
    }

    @Test
    fun testRoverShouldMoveBackwardToPositionX0Y1WhenFacingWest() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 1))
            .withDirection(Direction.WEST)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('b'))

        assertPosition(Position(1, 1), driver.getPosition())
    }

    @Test
    fun testRoverShouldMoveBackwardToPositionX0Y0WhenFacingSouth() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.SOUTH)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('b'))

        assertPosition(Position(0, 1), driver.getPosition())
    }

    @Test
    fun testRoverShouldMoveBackwardToPositionX1Y0WhenFacingEast() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(1, 0))
            .withDirection(Direction.EAST)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('b'))

        assertPosition(Position(0, 0), driver.getPosition())
    }

    @Test
    fun testRoverShouldRotateLeftFromNorthToWest() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.NORTH)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('l'))

        assertDirection(Direction.WEST, driver.getDirection())
    }

    @Test
    fun testRoverShouldRotateLeftFromWestToSouth() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.WEST)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('l'))

        assertDirection(Direction.SOUTH, driver.getDirection())
    }

    @Test
    fun testRoverShouldRotateLeftFromSouthToEast() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.SOUTH)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('l'))

        assertDirection(Direction.EAST, driver.getDirection())
    }

    @Test
    fun testRoverShouldRotateLeftFromEastToNorth() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.EAST)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('l'))

        assertDirection(Direction.NORTH, driver.getDirection())
    }

    @Test
    fun testRoverShouldRotateRightFromNorthToEast() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.NORTH)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('r'))

        assertDirection(Direction.EAST, driver.getDirection())
    }

    @Test
    fun testRoverShouldRotateRightFromEastToSouth() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.EAST)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('r'))

        assertDirection(Direction.SOUTH, driver.getDirection())
    }

    @Test
    fun testRoverShouldRotateRightFromSouthToWest() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.SOUTH)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('r'))

        assertDirection(Direction.WEST, driver.getDirection())
    }

    @Test
    fun testRoverShouldRotateRightFromWestToNorth() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.WEST)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('r'))

        assertDirection(Direction.NORTH, driver.getDirection())
    }

    @Test
    fun testRoverShouldBeWrappedOnTopLeftCornerWhenFacingSouthAtPositionX0Y0AndMovingForward() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.SOUTH)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('f'))

        assertPosition(Position(0, 9), driver.getPosition())
        assertDirection(Direction.SOUTH, driver.getDirection())
    }

    @Test
    fun testRoverShouldBeWrappedOnTopRightCornerWhenFacingWestAtPositionX0Y9() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 9))
            .withDirection(Direction.WEST)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('f'))

        assertPosition(Position(9, 9), driver.getPosition())
        assertDirection(Direction.WEST, driver.getDirection())
    }

    @Test
    fun testRoverShouldBeWrappedOnBottomRightCornerWhenFacingNorthAtPositionX9Y9() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(9, 9))
            .withDirection(Direction.NORTH)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('f'))

        assertPosition(Position(9, 0), driver.getPosition())
        assertDirection(Direction.NORTH, driver.getDirection())
    }

    @Test
    fun testRoverShouldBeWrappedOnBottomLeftCornerWhenFacingEastAtPositionX9Y0() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(9, 0))
            .withDirection(Direction.EAST)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('f'))

        assertPosition(Position(0, 0), driver.getPosition())
        assertDirection(Direction.EAST, driver.getDirection())
    }

    @Test
    fun testRoverShouldBeWrappedOnTopLeftCornerWhenFacingNorthAtPositionX0Y0AndMovingBackward() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.NORTH)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('b'))

        assertPosition(Position(0, 9), driver.getPosition())
        assertDirection(Direction.NORTH, driver.getDirection())
    }

    @Test
    fun testRoverShouldBeWrappedOnTopRightCornerWhenFacingEastAtPositionX0Y9AndMovingBackward() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 9))
            .withDirection(Direction.EAST)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('b'))

        assertPosition(Position(9, 9), driver.getPosition())
        assertDirection(Direction.EAST, driver.getDirection())
    }

    @Test
    fun testRoverShouldBeWrappedOnBottomRightCornerWhenFacingSouthAtPositionX9Y9AndMovingBackward() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(9, 9))
            .withDirection(Direction.SOUTH)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('b'))

        assertPosition(Position(9, 0), driver.getPosition())
        assertDirection(Direction.SOUTH, driver.getDirection())
    }

    @Test
    fun testRoverShouldMoveForwardAndBeWrapped() {
        val driver = RoverHardwareBuilder()
            .withPosition(Position(1, 1))
            .withDirection(Direction.SOUTH)
            .withPlanet(planet)
            .build()

        driver.execute(arrayListOf('f', 'r', 'f', 'f', 'l', 'f', 'f', 'r', 'f', 'f'))

        assertPosition(Position(7, 8), driver.getPosition())
        assertDirection(Direction.WEST, driver.getDirection())
    }

    @Test
    fun testRoverShouldStopBecauseOfObstacle() {
        planet.addObstacle(Position(1, 1))

        val driver = RoverHardwareBuilder()
            .withPosition(Position(0, 0))
            .withDirection(Direction.NORTH)
            .withPlanet(planet)
            .build();

        driver.execute(arrayListOf('f', 'r', 'f', 'f'))

        assertPosition(Position(0, 1), driver.getPosition())
    }

    private fun assertPosition(expected: Position, actual: Position) {
        assertTrue(expected == actual, "Expected position $expected but was $actual")
    }
    
    private fun assertDirection(expected: Direction, actual: Direction) {
        assertTrue(expected == actual, "Expected direction $expected but was $actual")
    }
}
