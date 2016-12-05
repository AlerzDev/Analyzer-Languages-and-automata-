package analyzer; /**
 * Created by lemuz on 4/12/16.
 */

import helpers.Message;
import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;
import java_cup.runtime.lr_parser;

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;

/** CUP v0.11a beta 20060608 generated parser.
 * @version Fri Apr 18 08:21:24 MDT 2014
 */
public class AnalizadorSintactico extends lr_parser {

    /** Default constructor. */
    public AnalizadorSintactico() {super();}

    /** Constructor which sets the default scanner. */
    public AnalizadorSintactico(Scanner s) {super(s);}

    /** Constructor which sets the default scanner. */
    public AnalizadorSintactico(Scanner s, SymbolFactory sf) {super(s,sf);}

    /** Production table. */
    protected static final short _production_table[][] =
            unpackFromStrings(new String[] {
                    "\000\014\000\002\002\004\000\002\002\004\000\002\002" +
                            "\003\000\002\007\002\000\002\003\005\000\002\004\005" +
                            "\000\002\004\005\000\002\004\003\000\002\005\005\000" +
                            "\002\005\003\000\002\006\005\000\002\006\003" });

    /** Access to production table. */
    public short[][] production_table() {return _production_table;}

    /** Parse-action table. */
    protected static final short[][] _action_table =
            unpackFromStrings(new String[] {
                    "\000\024\000\006\010\004\012\012\001\002\000\006\010" +
                            "\004\012\012\001\002\000\010\002\uffff\010\uffff\012\uffff" +
                            "\001\002\000\014\004\ufffa\005\ufffa\006\ufffa\007\017\011" +
                            "\ufffa\001\002\000\010\002\024\010\004\012\012\001\002" +
                            "\000\010\004\ufffe\005\015\006\014\001\002\000\014\004" +
                            "\ufff8\005\ufff8\006\ufff8\007\ufff8\011\ufff8\001\002\000\014" +
                            "\004\ufff6\005\ufff6\006\ufff6\007\ufff6\011\ufff6\001\002\000" +
                            "\004\004\022\001\002\000\006\010\004\012\012\001\002" +
                            "\000\006\010\004\012\012\001\002\000\014\004\ufffc\005" +
                            "\ufffc\006\ufffc\007\017\011\ufffc\001\002\000\006\010\004" +
                            "\012\012\001\002\000\014\004\ufff9\005\ufff9\006\ufff9\007" +
                            "\ufff9\011\ufff9\001\002\000\014\004\ufffb\005\ufffb\006\ufffb" +
                            "\007\017\011\ufffb\001\002\000\010\002\ufffd\010\ufffd\012" +
                            "\ufffd\001\002\000\010\002\001\010\001\012\001\001\002" +
                            "\000\004\002\000\001\002\000\010\005\015\006\014\011" +
                            "\026\001\002\000\014\004\ufff7\005\ufff7\006\ufff7\007\ufff7" +
                            "\011\ufff7\001\002" });

    /** Access to parse-action table. */
    public short[][] action_table() {return _action_table;}

    /** <code>reduce_goto</code> table. */
    protected static final short[][] _reduce_table =
            unpackFromStrings(new String[] {
                    "\000\024\000\014\002\006\003\004\004\007\005\005\006" +
                            "\010\001\001\000\010\004\024\005\005\006\010\001\001" +
                            "\000\002\001\001\000\002\001\001\000\012\003\022\004" +
                            "\007\005\005\006\010\001\001\000\004\007\012\001\001" +
                            "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
                            "\006\005\020\006\010\001\001\000\006\005\015\006\010" +
                            "\001\001\000\002\001\001\000\004\006\017\001\001\000" +
                            "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
                            "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
                            "\001" });

    /** Access to <code>reduce_goto</code> table. */
    public short[][] reduce_table() {return _reduce_table;}

    /** Instance of action encapsulation class. */
    protected CUP$AnalizadorSintactico$actions action_obj;

    /** Action encapsulation object initializer. */
    protected void init_actions()
    {
        action_obj = new CUP$AnalizadorSintactico$actions(this);
    }

    /** Invoke a user supplied parse action. */
    public Symbol do_action(
            int                        act_num,
            lr_parser parser,
            java.util.Stack            stack,
            int                        top)
            throws Exception
    {
    /* call code in generated class */
        return action_obj.CUP$AnalizadorSintactico$do_action(act_num, parser, stack, top);
    }

    /** Indicates start state. */
    public int start_state() {return 0;}
    /** Indicates start production. */
    public int start_production() {return 1;}

    /** <code>EOF</code> Symbol index. */
    public int EOF_sym() {return 0;}

    /** <code>error</code> Symbol index. */
    public int error_sym() {return 1;}




    /* Reporte de error encontrado. */
    public void report_error(String message, Object info) {
        StringBuilder m = new StringBuilder("Error");
        if (info instanceof Symbol) {
            Symbol s = ((Symbol) info);
            if (s.left >= 0) {
                m.append(" in line "+(s.left+1));
                if (s.right >= 0)
                    m.append(", column "+(s.right+1));
            }
        }
        m.append(" : "+message);
        Message helper = Message.getInstance();
        helper.setError(m.toString());
        //System.err.println(m);
    }

    /* Cuando se encuentra un error de donde el sistema no puede
        recuperarse, se lanza un error fatal. Se despliega el mensaje
        de error y se finaliza la ejecucion. */
    public void report_fatal_error(String message, Object info) {
        Message helper = Message.getInstance();
        helper.setError(message);
        //report_error(message, info);
        //System.exit(1);
    }

    /* Metodo main para garantizar la ejecucion del analizador
       lexico y sintactico, ademas que se pase como parametro la tabla
       de simbolos correspondiente. */
    public static void main(String[] args){
        try {
            AnalizadorLexico al = new AnalizadorLexico(new FileReader(args[0]));
            AnalizadorSintactico asin = new AnalizadorSintactico(al);
            Object result = asin.parse().value;
            asin.setMsg(al.getMsg());
            Message helper = Message.getInstance();
            helper.setMessage("*** Resultados finales ***\n"+asin.getMsg());

        } catch (Exception ex) {
            String a = getStackTrace(ex);
            Message helper = Message.getInstance();
            helper.setError(a);
            System.out.print(helper.getError());
        }
    }

    public static String getStackTrace(final Throwable throwable) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }

    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalizadorSintactico$actions {
    private final AnalizadorSintactico parser;

    /**
     * Constructor
     */
    CUP$AnalizadorSintactico$actions(AnalizadorSintactico parser) {
        this.parser = parser;
    }

    /**
     * Method with the actual generated action code.
     */
    public final Symbol CUP$AnalizadorSintactico$do_action(
            int CUP$AnalizadorSintactico$act_num,
            lr_parser CUP$AnalizadorSintactico$parser,
            java.util.Stack CUP$AnalizadorSintactico$stack,
            int CUP$AnalizadorSintactico$top)
            throws Exception {
      /* Symbol object for return from actions */
        Symbol CUP$AnalizadorSintactico$result;

      /* select the action based on the action number */
        switch (CUP$AnalizadorSintactico$act_num) {
          /*. . . . . . . . . . . . . . . . . . . .*/
            case 11: // termino ::= ENTERO
            {
                Integer RESULT = null;
                int eleft = ((Symbol) CUP$AnalizadorSintactico$stack.peek()).left;
                int eright = ((Symbol) CUP$AnalizadorSintactico$stack.peek()).right;
                Integer e = (Integer) ((Symbol) CUP$AnalizadorSintactico$stack.peek()).value;

                RESULT = e;

                CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("termino", 4, ((Symbol) CUP$AnalizadorSintactico$stack.peek()), ((Symbol) CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
            return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 10: // termino ::= PARENIZQ expr PARENDER
            {
                Integer RESULT = null;
                int eleft = ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 1)).left;
                int eright = ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 1)).right;
                Integer e = (Integer) ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 1)).value;

                RESULT = e;

                CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("termino", 4, ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)), ((Symbol) CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
            return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 9: // factor ::= termino
            {
                Integer RESULT = null;
                int tleft = ((Symbol) CUP$AnalizadorSintactico$stack.peek()).left;
                int tright = ((Symbol) CUP$AnalizadorSintactico$stack.peek()).right;
                Integer t = (Integer) ((Symbol) CUP$AnalizadorSintactico$stack.peek()).value;

                RESULT = t;

                CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("factor", 3, ((Symbol) CUP$AnalizadorSintactico$stack.peek()), ((Symbol) CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
            return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 8: // factor ::= factor OP_MULT termino
            {
                Integer RESULT = null;
                int fleft = ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)).left;
                int fright = ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)).right;
                Integer f = (Integer) ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)).value;
                int eleft = ((Symbol) CUP$AnalizadorSintactico$stack.peek()).left;
                int eright = ((Symbol) CUP$AnalizadorSintactico$stack.peek()).right;
                Integer e = (Integer) ((Symbol) CUP$AnalizadorSintactico$stack.peek()).value;

                RESULT = new Integer(f.intValue() * e.intValue());

                CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("factor", 3, ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)), ((Symbol) CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
            return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 7: // expr ::= factor
            {
                Integer RESULT = null;
                int nleft = ((Symbol) CUP$AnalizadorSintactico$stack.peek()).left;
                int nright = ((Symbol) CUP$AnalizadorSintactico$stack.peek()).right;
                Integer n = (Integer) ((Symbol) CUP$AnalizadorSintactico$stack.peek()).value;

                RESULT = n;

                CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expr", 2, ((Symbol) CUP$AnalizadorSintactico$stack.peek()), ((Symbol) CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
            return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 6: // expr ::= expr OP_RESTA factor
            {
                Integer RESULT = null;
                int eleft = ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)).left;
                int eright = ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)).right;
                Integer e = (Integer) ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)).value;
                int fleft = ((Symbol) CUP$AnalizadorSintactico$stack.peek()).left;
                int fright = ((Symbol) CUP$AnalizadorSintactico$stack.peek()).right;
                Integer f = (Integer) ((Symbol) CUP$AnalizadorSintactico$stack.peek()).value;

                RESULT = new Integer(e.intValue() - f.intValue());

                CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expr", 2, ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)), ((Symbol) CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
            return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 5: // expr ::= expr OP_SUMA factor
            {
                Integer RESULT = null;
                int eleft = ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)).left;
                int eright = ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)).right;
                Integer e = (Integer) ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)).value;
                int fleft = ((Symbol) CUP$AnalizadorSintactico$stack.peek()).left;
                int fright = ((Symbol) CUP$AnalizadorSintactico$stack.peek()).right;
                Integer f = (Integer) ((Symbol) CUP$AnalizadorSintactico$stack.peek()).value;

                RESULT = new Integer(e.intValue() + f.intValue());

                CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expr", 2, ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)), ((Symbol) CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
            return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 4: // expr_part ::= expr NT$0 SEMI
            {
                Object RESULT = null;
                // propagate RESULT from NT$0
                RESULT = (Object) ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 1)).value;
                int eleft = ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)).left;
                int eright = ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)).right;
                Integer e = (Integer) ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)).value;

                CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expr_part", 1, ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 2)), ((Symbol) CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
            return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 3: // NT$0 ::=
            {
                Object RESULT = null;
                int eleft = ((Symbol) CUP$AnalizadorSintactico$stack.peek()).left;
                int eright = ((Symbol) CUP$AnalizadorSintactico$stack.peek()).right;
                Integer e = (Integer) ((Symbol) CUP$AnalizadorSintactico$stack.peek()).value;

                System.out.println(" = " + e);
                Message helper = Message.getInstance();
                helper.setResult(" = "+e);

                CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("NT$0", 5, ((Symbol) CUP$AnalizadorSintactico$stack.peek()), ((Symbol) CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
            return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 2: // expr_list ::= expr_part
            {
                Object RESULT = null;

                CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expr_list", 0, ((Symbol) CUP$AnalizadorSintactico$stack.peek()), ((Symbol) CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
            return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 1: // $START ::= expr_list EOF
            {
                Object RESULT = null;
                int start_valleft = ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 1)).left;
                int start_valright = ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 1)).right;
                Object start_val = (Object) ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 1)).value;
                RESULT = start_val;
                CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("$START", 0, ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 1)), ((Symbol) CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
            CUP$AnalizadorSintactico$parser.done_parsing();
            return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 0: // expr_list ::= expr_list expr_part
            {
                Object RESULT = null;

                CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expr_list", 0, ((Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top - 1)), ((Symbol) CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
            return CUP$AnalizadorSintactico$result;

          /* . . . . . .*/
            default:
                throw new Exception(
                        "Invalid action number found in internal parse table");

        }
    }

}
