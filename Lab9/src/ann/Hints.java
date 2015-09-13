package ann;

public @interface Hints {
    Hint[] value();
}

@Repeatable(Hint.class)
@interface Hint {
    String value();
}

@Hint("hint1")
@Hint("hint2")
class Person {}