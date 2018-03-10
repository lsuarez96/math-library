/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcuationDefinition;

/**
 * Represents a token used to work with regular expressions
 *
 * @author Luisito Suarez
 */
public class Token {

    private TokenType type;
    private String text;

    public Token(TokenType type, String text) {
        this.type = type;
        this.text = text;
    }

    public Token(TokenType type) {
        this.type = type;
    }

    /**
     * @return the type
     */
    public TokenType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TokenType type) {
        this.type = type;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

}
