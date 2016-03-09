package Design.Practice.Chess;

import java.util.List;

/**
 * Created by prashantgolash on 27/01/16.
 */
public class Chess {
}

class Game {
    private Player p1;
    private Player p2;
    private Board board;

    public boolean isWinning() {
        // read board and find if its a winning config
        return true;
    }

    public void initGame() {
       // p1 = new Player();
       // p2 = new Player();
        // Initialize board and put
    }

    public void startGame() {
        while (true) {
            Move m = p1.getNextMove();

        }

    }


    public boolean canMove(Element e, Position prev, Position next) {
        return true;
    }

}

// pending thing : where will be the movement of particular element be stored


class Board {
    private List<Position> freePositions;

    public boolean isPositionFree(Position p) {
        return true;
    }

    public void removeElement(Position p) {

    }

    public Element getElement(Position p) {
        return null;
    }


}

interface Element {
    ElementType getType();
    ElementColor getColor();


}

enum ElementType {
    PAWN,
    HORSE,
    ELEPHANT;
}

enum ElementColor {
    BLACK,
    WHITE;
}


interface Player {
    public Move getNextMove();
}

class Move {
    private Element e;
    private Position newPosition;
}

class Position {
    int x;
    int y;
}
