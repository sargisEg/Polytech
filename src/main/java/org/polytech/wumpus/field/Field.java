package main.java.org.polytech.wumpus.field;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private final int number;
    private final FieldPosition position;
    private FieldType type;
    private final List<Field> nextFields;
    private FieldStatus status;
    private boolean isChecked;

    public Field(FieldPosition position, int number) {
        this.number = number;
        this.position = position;
        this.type = FieldType.DEFAULT;
        this.nextFields = new ArrayList<>(position.getNextFieldsCount());
    }

    public void setNextField(Field field) {
        if (nextFields.size() == position.getNextFieldsCount()) {
            throw new IllegalStateException("Next fields count cannot be grater than - " + position.getNextFieldsCount());
        }
        this.nextFields.add(field);
    }

    public FieldPosition getPosition() {
        return position;
    }

    public FieldType getType() {
        return type;
    }

    public List<Field> getNextFields() {
        return nextFields;
    }

    public FieldStatus getStatus() {
        return status;
    }

    public int getNumber() {
        return number;
    }

    public void setStatus(FieldStatus status) {
        this.status = status;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return String.valueOf(type.getSymbol());
    }

    public void setType(FieldType type) {
        if (type == FieldType.GOLD) {
            this.type = this.type.setGold();
        }
        if (type == FieldType.BREEZE) {
            this.type = this.type.setBreeze();
        }
        if (type == FieldType.STENCH) {
            this.type = this.type.setStench();
        }
        if (type == FieldType.PIT) {
            this.type = this.type.setPit();
            this.getNextFields().forEach(nextField -> nextField.setType(FieldType.BREEZE));
        }
        if (type == FieldType.WUMPUS) {
            this.type = this.type.setWumpus();
            this.getNextFields().forEach(nextField -> nextField.setType(FieldType.STENCH));
        }
    }
}
