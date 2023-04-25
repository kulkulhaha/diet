package actual.rediet.exception;

public class NoSuchMember extends RuntimeException{
    public NoSuchMember() {
        super("존재하지 않는 회원입니다");
    }

    public NoSuchMember(Throwable cause) {
        super("존재하지 않는 회원입니다", cause);
    }
}
