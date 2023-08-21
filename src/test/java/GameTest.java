import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void player1Win() {
        Player Anna = new Player(1, "Анна", 200);
        Player Nina = new Player(2, "Нина", 150);
        Game game = new Game();
        game.register(Anna);
        game.register(Nina);
        int actual = game.round("Анна", "Нина");
        int expected = 1;

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void player2Win() {
        Player Anna = new Player(1, "Анна", 200);
        Player Nina = new Player(2, "Нина", 350);
        Game game = new Game();
        game.register(Anna);
        game.register(Nina);
        int actual = game.round("Анна", "Нина");
        int expected = 2;

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void playerNoWin() {
        Player Anna = new Player(1, "Анна", 200);
        Player Nina = new Player(2, "Нина", 200);
        Game game = new Game();
        game.register(Anna);
        game.register(Nina);
        int actual = game.round("Анна", "Нина");
        int expected = 0;

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void playerNoExist() {
        Player Anna = new Player(1, "Анна", 200);
        Player Nina = new Player(2, "Нина", 200);
        Game game = new Game();
        game.register(Anna);
        game.register(Nina);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Петр", "Нина")
        );
    }
}
