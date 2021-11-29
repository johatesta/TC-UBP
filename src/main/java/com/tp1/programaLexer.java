// Generated from c:\Users\USUARIO\Documents\TC-UBP\src\main\java\com\tp1\programa.g4 by ANTLR 4.8

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
public class programaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LLAVEA=1, LLAVEC=2, PARENA=3, PARENC=4, INT=5, DOUBLE=6, VOID=7, FLOAT=8, 
		WHILE=9, IIF=10, IFOR=11, MAS=12, MENOS=13, MULT=14, DIV=15, MENOR=16, 
		MAYOR=17, MENORIGUAL=18, MAYORIGUAL=19, IGUALES=20, DISTINTO=21, ASIG=22, 
		PYQ=23, COMA=24, OR=25, AND=26, RETURN=27, ENTERO=28, ID=29, WS=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LETRA", "DIGITO", "LLAVEA", "LLAVEC", "PARENA", "PARENC", "INT", "DOUBLE", 
			"VOID", "FLOAT", "WHILE", "IIF", "IFOR", "MAS", "MENOS", "MULT", "DIV", 
			"MENOR", "MAYOR", "MENORIGUAL", "MAYORIGUAL", "IGUALES", "DISTINTO", 
			"ASIG", "PYQ", "COMA", "OR", "AND", "RETURN", "ENTERO", "ID", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "'int'", "'double'", "'void'", "'float'", 
			"'while'", "'if'", "'for'", "'+'", "'-'", "'*'", "'/'", "'<'", "'>'", 
			"'<='", "'>='", "'=='", "'!='", "'='", "';'", "','", "'||'", "'&&'", 
			"'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LLAVEA", "LLAVEC", "PARENA", "PARENC", "INT", "DOUBLE", "VOID", 
			"FLOAT", "WHILE", "IIF", "IFOR", "MAS", "MENOS", "MULT", "DIV", "MENOR", 
			"MAYOR", "MENORIGUAL", "MAYORIGUAL", "IGUALES", "DISTINTO", "ASIG", "PYQ", 
			"COMA", "OR", "AND", "RETURN", "ENTERO", "ID", "WS"
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


	public programaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "programa.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2 \u00b5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37"+
		"\6\37\u009f\n\37\r\37\16\37\u00a0\3 \3 \5 \u00a5\n \3 \3 \3 \7 \u00aa"+
		"\n \f \16 \u00ad\13 \3!\6!\u00b0\n!\r!\16!\u00b1\3!\3!\2\2\"\3\2\5\2\7"+
		"\3\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21"+
		"%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37A \3"+
		"\2\5\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u00b8\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2"+
		"\2\5E\3\2\2\2\7G\3\2\2\2\tI\3\2\2\2\13K\3\2\2\2\rM\3\2\2\2\17O\3\2\2\2"+
		"\21S\3\2\2\2\23Z\3\2\2\2\25_\3\2\2\2\27e\3\2\2\2\31k\3\2\2\2\33n\3\2\2"+
		"\2\35r\3\2\2\2\37t\3\2\2\2!v\3\2\2\2#x\3\2\2\2%z\3\2\2\2\'|\3\2\2\2)~"+
		"\3\2\2\2+\u0081\3\2\2\2-\u0084\3\2\2\2/\u0087\3\2\2\2\61\u008a\3\2\2\2"+
		"\63\u008c\3\2\2\2\65\u008e\3\2\2\2\67\u0090\3\2\2\29\u0093\3\2\2\2;\u0096"+
		"\3\2\2\2=\u009e\3\2\2\2?\u00a4\3\2\2\2A\u00af\3\2\2\2CD\t\2\2\2D\4\3\2"+
		"\2\2EF\t\3\2\2F\6\3\2\2\2GH\7}\2\2H\b\3\2\2\2IJ\7\177\2\2J\n\3\2\2\2K"+
		"L\7*\2\2L\f\3\2\2\2MN\7+\2\2N\16\3\2\2\2OP\7k\2\2PQ\7p\2\2QR\7v\2\2R\20"+
		"\3\2\2\2ST\7f\2\2TU\7q\2\2UV\7w\2\2VW\7d\2\2WX\7n\2\2XY\7g\2\2Y\22\3\2"+
		"\2\2Z[\7x\2\2[\\\7q\2\2\\]\7k\2\2]^\7f\2\2^\24\3\2\2\2_`\7h\2\2`a\7n\2"+
		"\2ab\7q\2\2bc\7c\2\2cd\7v\2\2d\26\3\2\2\2ef\7y\2\2fg\7j\2\2gh\7k\2\2h"+
		"i\7n\2\2ij\7g\2\2j\30\3\2\2\2kl\7k\2\2lm\7h\2\2m\32\3\2\2\2no\7h\2\2o"+
		"p\7q\2\2pq\7t\2\2q\34\3\2\2\2rs\7-\2\2s\36\3\2\2\2tu\7/\2\2u \3\2\2\2"+
		"vw\7,\2\2w\"\3\2\2\2xy\7\61\2\2y$\3\2\2\2z{\7>\2\2{&\3\2\2\2|}\7@\2\2"+
		"}(\3\2\2\2~\177\7>\2\2\177\u0080\7?\2\2\u0080*\3\2\2\2\u0081\u0082\7@"+
		"\2\2\u0082\u0083\7?\2\2\u0083,\3\2\2\2\u0084\u0085\7?\2\2\u0085\u0086"+
		"\7?\2\2\u0086.\3\2\2\2\u0087\u0088\7#\2\2\u0088\u0089\7?\2\2\u0089\60"+
		"\3\2\2\2\u008a\u008b\7?\2\2\u008b\62\3\2\2\2\u008c\u008d\7=\2\2\u008d"+
		"\64\3\2\2\2\u008e\u008f\7.\2\2\u008f\66\3\2\2\2\u0090\u0091\7~\2\2\u0091"+
		"\u0092\7~\2\2\u00928\3\2\2\2\u0093\u0094\7(\2\2\u0094\u0095\7(\2\2\u0095"+
		":\3\2\2\2\u0096\u0097\7t\2\2\u0097\u0098\7g\2\2\u0098\u0099\7v\2\2\u0099"+
		"\u009a\7w\2\2\u009a\u009b\7t\2\2\u009b\u009c\7p\2\2\u009c<\3\2\2\2\u009d"+
		"\u009f\5\5\3\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1>\3\2\2\2\u00a2\u00a5\5\3\2\2\u00a3\u00a5"+
		"\7a\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00ab\3\2\2\2\u00a6"+
		"\u00aa\5\3\2\2\u00a7\u00aa\5\5\3\2\u00a8\u00aa\7a\2\2\u00a9\u00a6\3\2"+
		"\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac@\3\2\2\2\u00ad\u00ab\3\2\2\2"+
		"\u00ae\u00b0\t\4\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\b!\2\2\u00b4"+
		"B\3\2\2\2\b\2\u00a0\u00a4\u00a9\u00ab\u00b1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}