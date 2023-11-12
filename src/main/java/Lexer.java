import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lexer {
    private final static String DELIMITERS = " +-*/()";

    public List<Token> getTokens(String source) {
        List<Token> tokens = new ArrayList<>();
        var tokenizer = new StringTokenizer(source, DELIMITERS, true);
        while (tokenizer.hasMoreTokens()) {
            var token = tokenizer.nextToken();
            if (token.isBlank()) {
                continue;
            } else if (isNumber(token)) {
                tokens.add(new NumberToken(Integer.parseInt(token)));
            } else {
                tokens.add(
                        switch (token) {
                            case "+" -> new BinaryOperationToken(OperationType.PLUS);
                            case "-" -> new BinaryOperationToken(OperationType.MINUS);
                            case "*" -> new BinaryOperationToken(OperationType.MULTIPLY);
                            case "/" -> new BinaryOperationToken(OperationType.DIVIDE);
                            case "(" -> new OtherToken(TokenType.OPEN_BRACKET);
                            case ")" -> new OtherToken(TokenType.CLOSE_BRACKET);
                            default -> throw new RuntimeException("Unexpected token: " + token);
                        }
                );
            }
        }
        return tokens;
    }

    private boolean isNumber(String token) {
        for (int i = 0; i < token.length(); ++i) {
            if (!Character.isDigit(token.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
