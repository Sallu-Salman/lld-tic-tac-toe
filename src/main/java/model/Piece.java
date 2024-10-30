package model;

import constants.PieceType;
import lombok.Getter;

@Getter
public abstract class Piece {
    private PieceType type;

    public Piece(PieceType type) {
        this.type = type;
    }
}
