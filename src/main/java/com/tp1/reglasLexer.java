// Generated from c:\Users\USUARIO\Documents\TC-UBP\TP-FINAL\proyectofinal\src\main\java\app\reglas.g4 by ANTLR 4.8

package com.tp1;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class reglasLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PA=1, PC=2, CA=3, CC=4, LA=5, LC=6, PYC=7, COMA=8, EQ=9, MAY=10, MAYEQ=11, 
		MEN=12, MENEQ=13, EQL=14, DST=15, SUM=16, RES=17, MUL=18, DIV=19, MOD=20, 
		OR=21, AND=22, NOT=23, FOR=24, WHILE=25, IF=26, ELSE=27, INT=28, CHAR=29, 
		DOUBLE=30, VOID=31, RETURN=32, ID=33, INTEGER=34, DECIMAL=35, CHARACTER=36, 
		WS=37, OTRO=38;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LETRA", "DIGITO", "PA", "PC", "CA", "CC", "LA", "LC", "PYC", "COMA", 
			"EQ", "MAY", "MAYEQ", "MEN", "MENEQ", "EQL", "DST", "SUM", "RES", "MUL", 
			"DIV", "MOD", "OR", "AND", "NOT", "FOR", "WHILE", "IF", "ELSE", "INT", 
			"CHAR", "DOUBLE", "VOID", "RETURN", "ID", "INTEGER", "DECIMAL", "CHARACTER", 
			"WS", "OTRO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", "','", "'='", 
			"'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'||'", "'&&'", "'!'", "'for'", "'while'", "'if'", "'else'", "'int'", 
			"'char'", "'double'", "'void'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PA", "PC", "CA", "CC", "LA", "LC", "PYC", "COMA", "EQ", "MAY", 
			"MAYEQ", "MEN", "MENEQ", "EQL", "DST", "SUM", "RES", "MUL", "DIV", "MOD", 
			"OR", "AND", "NOT", "FOR", "WHILE", "IF", "ELSE", "INT", "CHAR", "DOUBLE", 
			"VOID", "RETURN", "ID", "INTEGER", "DECIMAL", "CHARACTER", "WS", "OTRO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public reglasLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "reglas.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u00dc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3"+
		"#\3#\3#\3#\3#\3$\3$\5$\u00bc\n$\3$\3$\3$\7$\u00c1\n$\f$\16$\u00c4\13$"+
		"\3%\6%\u00c7\n%\r%\16%\u00c8\3&\3&\3&\3&\3\'\3\'\3\'\3\'\5\'\u00d3\n\'"+
		"\3\'\3\'\3(\3(\3(\3(\3)\3)\2\2*\3\2\5\2\7\3\t\4\13\5\r\6\17\7\21\b\23"+
		"\t\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61"+
		"\30\63\31\65\32\67\339\34;\35=\36?\37A C!E\"G#I$K%M&O\'Q(\3\2\5\4\2C\\"+
		"c|\3\2\62;\4\2\13\f\"\"\2\u00e0\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3"+
		"\2\2\2\5U\3\2\2\2\7W\3\2\2\2\tY\3\2\2\2\13[\3\2\2\2\r]\3\2\2\2\17_\3\2"+
		"\2\2\21a\3\2\2\2\23c\3\2\2\2\25e\3\2\2\2\27g\3\2\2\2\31i\3\2\2\2\33k\3"+
		"\2\2\2\35n\3\2\2\2\37p\3\2\2\2!s\3\2\2\2#v\3\2\2\2%y\3\2\2\2\'{\3\2\2"+
		"\2)}\3\2\2\2+\177\3\2\2\2-\u0081\3\2\2\2/\u0083\3\2\2\2\61\u0086\3\2\2"+
		"\2\63\u0089\3\2\2\2\65\u008b\3\2\2\2\67\u008f\3\2\2\29\u0095\3\2\2\2;"+
		"\u0098\3\2\2\2=\u009d\3\2\2\2?\u00a1\3\2\2\2A\u00a6\3\2\2\2C\u00ad\3\2"+
		"\2\2E\u00b2\3\2\2\2G\u00bb\3\2\2\2I\u00c6\3\2\2\2K\u00ca\3\2\2\2M\u00ce"+
		"\3\2\2\2O\u00d6\3\2\2\2Q\u00da\3\2\2\2ST\t\2\2\2T\4\3\2\2\2UV\t\3\2\2"+
		"V\6\3\2\2\2WX\7*\2\2X\b\3\2\2\2YZ\7+\2\2Z\n\3\2\2\2[\\\7]\2\2\\\f\3\2"+
		"\2\2]^\7_\2\2^\16\3\2\2\2_`\7}\2\2`\20\3\2\2\2ab\7\177\2\2b\22\3\2\2\2"+
		"cd\7=\2\2d\24\3\2\2\2ef\7.\2\2f\26\3\2\2\2gh\7?\2\2h\30\3\2\2\2ij\7@\2"+
		"\2j\32\3\2\2\2kl\7@\2\2lm\7?\2\2m\34\3\2\2\2no\7>\2\2o\36\3\2\2\2pq\7"+
		">\2\2qr\7?\2\2r \3\2\2\2st\7?\2\2tu\7?\2\2u\"\3\2\2\2vw\7#\2\2wx\7?\2"+
		"\2x$\3\2\2\2yz\7-\2\2z&\3\2\2\2{|\7/\2\2|(\3\2\2\2}~\7,\2\2~*\3\2\2\2"+
		"\177\u0080\7\61\2\2\u0080,\3\2\2\2\u0081\u0082\7\'\2\2\u0082.\3\2\2\2"+
		"\u0083\u0084\7~\2\2\u0084\u0085\7~\2\2\u0085\60\3\2\2\2\u0086\u0087\7"+
		"(\2\2\u0087\u0088\7(\2\2\u0088\62\3\2\2\2\u0089\u008a\7#\2\2\u008a\64"+
		"\3\2\2\2\u008b\u008c\7h\2\2\u008c\u008d\7q\2\2\u008d\u008e\7t\2\2\u008e"+
		"\66\3\2\2\2\u008f\u0090\7y\2\2\u0090\u0091\7j\2\2\u0091\u0092\7k\2\2\u0092"+
		"\u0093\7n\2\2\u0093\u0094\7g\2\2\u00948\3\2\2\2\u0095\u0096\7k\2\2\u0096"+
		"\u0097\7h\2\2\u0097:\3\2\2\2\u0098\u0099\7g\2\2\u0099\u009a\7n\2\2\u009a"+
		"\u009b\7u\2\2\u009b\u009c\7g\2\2\u009c<\3\2\2\2\u009d\u009e\7k\2\2\u009e"+
		"\u009f\7p\2\2\u009f\u00a0\7v\2\2\u00a0>\3\2\2\2\u00a1\u00a2\7e\2\2\u00a2"+
		"\u00a3\7j\2\2\u00a3\u00a4\7c\2\2\u00a4\u00a5\7t\2\2\u00a5@\3\2\2\2\u00a6"+
		"\u00a7\7f\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9\7w\2\2\u00a9\u00aa\7d\2\2"+
		"\u00aa\u00ab\7n\2\2\u00ab\u00ac\7g\2\2\u00acB\3\2\2\2\u00ad\u00ae\7x\2"+
		"\2\u00ae\u00af\7q\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7f\2\2\u00b1D\3\2"+
		"\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7v\2\2\u00b5\u00b6"+
		"\7w\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8\7p\2\2\u00b8F\3\2\2\2\u00b9\u00bc"+
		"\5\3\2\2\u00ba\u00bc\7a\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc"+
		"\u00c2\3\2\2\2\u00bd\u00c1\5\3\2\2\u00be\u00c1\5\5\3\2\u00bf\u00c1\7a"+
		"\2\2\u00c0\u00bd\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1"+
		"\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3H\3\2\2\2"+
		"\u00c4\u00c2\3\2\2\2\u00c5\u00c7\5\5\3\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8"+
		"\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9J\3\2\2\2\u00ca"+
		"\u00cb\5I%\2\u00cb\u00cc\7\60\2\2\u00cc\u00cd\5I%\2\u00cdL\3\2\2\2\u00ce"+
		"\u00d2\7)\2\2\u00cf\u00d3\5\3\2\2\u00d0\u00d3\5Q)\2\u00d1\u00d3\5\5\3"+
		"\2\u00d2\u00cf\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d4"+
		"\3\2\2\2\u00d4\u00d5\7)\2\2\u00d5N\3\2\2\2\u00d6\u00d7\t\4\2\2\u00d7\u00d8"+
		"\3\2\2\2\u00d8\u00d9\b(\2\2\u00d9P\3\2\2\2\u00da\u00db\13\2\2\2\u00db"+
		"R\3\2\2\2\b\2\u00bb\u00c0\u00c2\u00c8\u00d2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}