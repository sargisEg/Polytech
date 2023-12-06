package main.java.org.polytech.wumpus.field;

public enum FieldType {
    DEFAULT("*") {
        @Override
        public FieldType setWumpus() {
            return FieldType.WUMPUS;
        }

        @Override
        public FieldType setStench() {
            return FieldType.STENCH;
        }

        @Override
        public FieldType setPit() {
            return FieldType.PIT;
        }

        @Override
        public FieldType setBreeze() {
            return FieldType.BREEZE;
        }

        @Override
        public FieldType setGold() {
            return FieldType.GOLD;
        }
    },
    WUMPUS("G") { //Գագո
        @Override
        public FieldType setWumpus() {
            throw new IllegalStateException();
        }

        @Override
        public FieldType setStench() {
            return FieldType.WUMPUS;
        }

        @Override
        public FieldType setPit() {
            throw new IllegalStateException();
        }

        @Override
        public FieldType setBreeze() {
            return FieldType.WUMPUS;
        }

        @Override
        public FieldType setGold() {
            throw new IllegalStateException();
        }
    },
    STENCH("!") { //Հոտ
        @Override
        public FieldType setWumpus() {
            return FieldType.WUMPUS;
        }

        @Override
        public FieldType setStench() {
            return FieldType.STENCH;
        }

        @Override
        public FieldType setPit() {
            return FieldType.PIT;
        }

        @Override
        public FieldType setBreeze() {
            return FieldType.STENCH_BREEZE;
        }

        @Override
        public FieldType setGold() {
            return FieldType.STENCH_GOLD;
        }
    },
    PIT("O") { //Փոս

        @Override
        public FieldType setWumpus() {
            throw new IllegalStateException();
        }

        @Override
        public FieldType setStench() {
            return FieldType.PIT;
        }

        @Override
        public FieldType setPit() {
            throw new IllegalStateException();
        }

        @Override
        public FieldType setBreeze() {
            return FieldType.PIT;
        }

        @Override
        public FieldType setGold() {
            throw new IllegalStateException();
        }
    },
    BREEZE("~") { //Քամի

        @Override
        public FieldType setWumpus() {
            return FieldType.WUMPUS;
        }

        @Override
        public FieldType setStench() {
            return FieldType.STENCH_BREEZE;
        }

        @Override
        public FieldType setPit() {
            return FieldType.PIT;
        }

        @Override
        public FieldType setBreeze() {
            return FieldType.BREEZE;
        }

        @Override
        public FieldType setGold() {
            return FieldType.BREEZE_GOLD;
        }
    },
    GOLD("$") { //Ոսկի

        @Override
        public FieldType setWumpus() {
            throw new IllegalStateException();
        }

        @Override
        public FieldType setStench() {
            return FieldType.STENCH_GOLD;
        }

        @Override
        public FieldType setPit() {
            throw new IllegalStateException();
        }

        @Override
        public FieldType setBreeze() {
            return FieldType.BREEZE_GOLD;
        }

        @Override
        public FieldType setGold() {
            return FieldType.GOLD;
        }
    },
    STENCH_BREEZE("!~") {
        @Override
        public FieldType setWumpus() {
            return FieldType.WUMPUS;
        }

        @Override
        public FieldType setStench() {
            return FieldType.STENCH_BREEZE;
        }

        @Override
        public FieldType setPit() {
            return FieldType.PIT;
        }

        @Override
        public FieldType setBreeze() {
            return FieldType.STENCH_BREEZE;
        }

        @Override
        public FieldType setGold() {
            return FieldType.STENCH_BREEZE_GOLD;
        }
    },
    STENCH_BREEZE_GOLD("!~$") {
        @Override
        public FieldType setWumpus() {
            throw new IllegalStateException();
        }

        @Override
        public FieldType setStench() {
            return FieldType.STENCH_BREEZE_GOLD;
        }

        @Override
        public FieldType setPit() {
            throw new IllegalStateException();
        }

        @Override
        public FieldType setBreeze() {
            return FieldType.STENCH_BREEZE_GOLD;
        }

        @Override
        public FieldType setGold() {
            return FieldType.STENCH_BREEZE_GOLD;
        }
    },
    BREEZE_GOLD("~$") {
        @Override
        public FieldType setWumpus() {
            throw new IllegalStateException();
        }

        @Override
        public FieldType setStench() {
            return FieldType.STENCH_BREEZE_GOLD;
        }

        @Override
        public FieldType setPit() {
            throw new IllegalStateException();
        }

        @Override
        public FieldType setBreeze() {
            return FieldType.BREEZE_GOLD;
        }

        @Override
        public FieldType setGold() {
            return FieldType.BREEZE_GOLD;
        }
    },
    STENCH_GOLD("!$") {
        @Override
        public FieldType setWumpus() {
            throw new IllegalStateException();
        }

        @Override
        public FieldType setStench() {
            return FieldType.STENCH_GOLD;
        }

        @Override
        public FieldType setPit() {
            throw new IllegalStateException();
        }

        @Override
        public FieldType setBreeze() {
            return FieldType.STENCH_BREEZE_GOLD;
        }

        @Override
        public FieldType setGold() {
            return FieldType.STENCH_GOLD;
        }
    };

    private final String symbol;

    FieldType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract FieldType setWumpus();
    public abstract FieldType setStench();
    public abstract FieldType setPit();
    public abstract FieldType setBreeze();
    public abstract FieldType setGold();
}
