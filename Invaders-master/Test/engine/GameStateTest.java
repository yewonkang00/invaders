package engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest{


    GameState gameState_normal = new GameState(1, "N", 0, 3 , 0, 0);
    GameState gameState_easy = new GameState(1, "E", 0, 5, 0, 0);
    GameState gameState_hard = new GameState(1, "H", 0,  3, 0, 0);


    @Test
    void getLevel() {
        assertEquals(gameState_normal.getLevel(), 1);
        assertEquals(gameState_easy.getLevel(), 1);
        assertEquals(gameState_hard.getLevel(), 1);
    }


    @Test
    void getScore() {
        assertEquals(gameState_normal.getScore(), 0);
        assertEquals(gameState_easy.getScore(), 0);
        assertEquals(gameState_hard.getScore(), 0);
    }


    @Test
    void getLivesRemaining() {
        assertEquals(gameState_normal.getLivesRemaining(), 3);
        assertEquals(gameState_easy.getLivesRemaining(), 5);
        assertEquals(gameState_hard.getLivesRemaining(), 3);
    }


    @Test
    void getBulletsShot() {
        assertEquals(gameState_normal.getBulletsShot(), 0);
        assertEquals(gameState_easy.getBulletsShot(), 0);
        assertEquals(gameState_hard.getBulletsShot(), 0);
    }

    @Test
    void getShipsDestroyed() {
        assertEquals(gameState_normal.getShipsDestroyed(), 0);
        assertEquals(gameState_easy.getShipsDestroyed(), 0);
        assertEquals(gameState_hard.getShipsDestroyed(), 0);
    }


    @Test
    void getDifficulty() {
        assertEquals(gameState_normal.getDifficulty(), "N");
        assertEquals(gameState_easy.getDifficulty(), "E");
        assertEquals(gameState_hard.getDifficulty(), "H");

    }

}