package engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameState2Test {

    GameState2 gameState2_normal = new GameState2(1, "N", 0,  3, 0, 0);
    GameState2 gameState2_easy = new GameState2(1, "E", 0,  3, 0, 0);
    GameState2 gameState2_hard = new GameState2(1, "H", 0,  3, 0, 0);


    @Test
    void getLevel() {
        assertEquals(gameState2_normal.getLevel(), 1);
        assertEquals(gameState2_easy.getLevel(), 1);
        assertEquals(gameState2_hard.getLevel(), 1);
    }

    @Test
    void getScore() {
        assertEquals(gameState2_normal.getScore(), 0);
        assertEquals(gameState2_easy.getScore(), 0);
        assertEquals(gameState2_hard.getScore(), 0);
    }

    @Test
    void getLivesRemaining() {
        assertEquals(gameState2_normal.getLivesRemaining(), 3);
        assertEquals(gameState2_easy.getLivesRemaining(), 3);
        assertEquals(gameState2_hard.getLivesRemaining(), 3);
    }

    @Test
    void getBulletsShot() {
        assertEquals(gameState2_normal.getBulletsShot(), 0);
        assertEquals(gameState2_easy.getBulletsShot(), 0);
        assertEquals(gameState2_hard.getBulletsShot(), 0);
    }

    @Test
    void getShipsDestroyed() {
        assertEquals(gameState2_normal.getShipsDestroyed(), 0);
        assertEquals(gameState2_easy.getShipsDestroyed(), 0);
        assertEquals(gameState2_hard.getShipsDestroyed(), 0);
    }


}