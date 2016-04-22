package jadesmond.move;

import ks.common.games.Solitaire;
import ks.common.model.Card;
import ks.common.model.Move;
import ks.common.model.Pile;
import ks.common.model.Stack;

public class CardToFoundationMove extends Move {

    Stack source;
    Pile target;
    Card card;

    public CardToFoundationMove(Stack source, Pile target, Card card) {
        super();
        this.source = source;
        this.target = target;
        this.card = card;
    }

    @Override
    public boolean doMove(Solitaire game) {
        if (!valid(game)) {
            return false;
        }

        target.add(card);
        return true;
    }

    @Override
    public boolean undo(Solitaire game) {
        source.add(target.get());
        return true;
    }

    @Override
    public boolean valid(Solitaire game) {
        if (source.empty()) {
            return false;
        }
        return true;
    }

}