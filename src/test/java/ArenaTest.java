import org.example.Arena;
import org.example.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {
    @Test
    public void testFight() {
        Player player1 = new Player(50, 5, 10);
        Player player2 = new Player(100, 10, 5);

        Arena arena = new Arena(player1, player2);
        arena.fight();

        assertTrue(!player1.isAlive() || !player2.isAlive());
    }
}
