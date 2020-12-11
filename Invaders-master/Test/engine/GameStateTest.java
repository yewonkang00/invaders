package engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest{


    GameState gameState_easy;
    GameState gameState_normal = new GameState(1, "N", 0, 3 , 0, 0);


    @Test
    void getDifficulty() {
        assertEquals(gameState_normal.getDifficulty(), "N");

    }

    @Test
    void getLevel() {
        assertEquals(gameState_normal.getLevel(), 1);
    }


    @Test
    void getScore() {
    }


    @Test
    void getLivesRemaining() {
    }


    @Test
    void getBulletsShot() {
    }

    @Test
    void getShipsDestroyed() {
    }


}