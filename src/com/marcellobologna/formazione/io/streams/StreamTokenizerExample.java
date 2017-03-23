package com.marcellobologna.formazione.io.streams;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 * Created by Marcello Bologna on 23/03/17.
 * <p>
 * The Java StreamTokenizer class (java.io.StreamTokenizer) can tokenize the characters read from a Reader into tokens.
 * For instance, in the string "Mary had a little lamb" each word is a separate token.
 * <p>
 * When you are parsing files or computer languages it is normal to break the input into tokens, before further
 * processing them. This process is also called "lexing" or "tokenizing".
 * <p>
 * Using a Java StreamTokenizer you can move through the tokens in the underlying Reader. You do so by calling the
 * nextToken() method of the StreamTokenizer inside a loop. After each call to nextToken() the StreamTokenizer has
 * several fields you can read to see what kind of token was read, it's value etc. These fields are:
 * <p>
 * ttype	The type of token read (word, number, end of line) sval	The string value of the token, if the token was a
 * string (word) nval	The number value of the token, if the token was a number.
 */
public class StreamTokenizerExample {

    public static void main(String[] args) {

        Reader r = new StringReader("Un testo di prova con degli spazi");

        StreamTokenizer st = new StreamTokenizer(r);

        try {
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if (st.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println(st.sval);
                } else if (st.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println(st.nval);
                } else if (st.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println(" #EOL");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
