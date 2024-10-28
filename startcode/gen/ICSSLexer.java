// Generated from C:/Users/vanro/OneDrive/Documenten/Leerjaar 3 HBO/Semester 3/ASD APP/Compiler opdracht/icss2022-sep/startcode/src/main/antlr4/nl/han/ica/icss/parser/ICSS.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ICSSLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, ELSE=2, BOX_BRACKET_OPEN=3, BOX_BRACKET_CLOSE=4, TRUE=5, FALSE=6, 
		PIXELSIZE=7, PERCENTAGE=8, SCALAR=9, COLOR=10, ID_IDENT=11, CLASS_IDENT=12, 
		LOWER_IDENT=13, CAPITAL_IDENT=14, WS=15, OPEN_BRACE=16, CLOSE_BRACE=17, 
		SEMICOLON=18, COLON=19, PLUS=20, MIN=21, MUL=22, ASSIGNMENT_OPERATOR=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IF", "ELSE", "BOX_BRACKET_OPEN", "BOX_BRACKET_CLOSE", "TRUE", "FALSE", 
			"PIXELSIZE", "PERCENTAGE", "SCALAR", "COLOR", "ID_IDENT", "CLASS_IDENT", 
			"LOWER_IDENT", "CAPITAL_IDENT", "WS", "OPEN_BRACE", "CLOSE_BRACE", "SEMICOLON", 
			"COLON", "PLUS", "MIN", "MUL", "ASSIGNMENT_OPERATOR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'['", "']'", null, null, null, null, null, null, null, 
			null, null, null, null, "'{'", "'}'", "';'", "':'", "'+'", "'-'", "'*'", 
			"':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "ELSE", "BOX_BRACKET_OPEN", "BOX_BRACKET_CLOSE", "TRUE", 
			"FALSE", "PIXELSIZE", "PERCENTAGE", "SCALAR", "COLOR", "ID_IDENT", "CLASS_IDENT", 
			"LOWER_IDENT", "CAPITAL_IDENT", "WS", "OPEN_BRACE", "CLOSE_BRACE", "SEMICOLON", 
			"COLON", "PLUS", "MIN", "MUL", "ASSIGNMENT_OPERATOR"
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


	public ICSSLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ICSS.g4"; }

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
		"\u0004\u0000\u0017\u00b6\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u00006\b\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001D\b\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004V\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"g\b\u0005\u0001\u0006\u0004\u0006j\b\u0006\u000b\u0006\f\u0006k\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u0007r\b\u0007\u000b"+
		"\u0007\f\u0007s\u0001\u0007\u0001\u0007\u0001\b\u0004\by\b\b\u000b\b\f"+
		"\bz\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0004\n\u0087\b\n\u000b\n\f\n\u0088\u0001\u000b\u0001\u000b"+
		"\u0004\u000b\u008d\b\u000b\u000b\u000b\f\u000b\u008e\u0001\f\u0001\f\u0005"+
		"\f\u0093\b\f\n\f\f\f\u0096\t\f\u0001\r\u0001\r\u0005\r\u009a\b\r\n\r\f"+
		"\r\u009d\t\r\u0001\u000e\u0004\u000e\u00a0\b\u000e\u000b\u000e\f\u000e"+
		"\u00a1\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0000\u0000\u0017\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015+\u0016-\u0017\u0001\u0000\u0007\u0001\u000009\u0002"+
		"\u000009af\u0003\u0000--09az\u0001\u0000az\u0001\u0000AZ\u0004\u00000"+
		"9AZ__az\u0003\u0000\t\n\r\r  \u00c5\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u00015\u0001\u0000\u0000\u0000\u0003C\u0001"+
		"\u0000\u0000\u0000\u0005E\u0001\u0000\u0000\u0000\u0007G\u0001\u0000\u0000"+
		"\u0000\tU\u0001\u0000\u0000\u0000\u000bf\u0001\u0000\u0000\u0000\ri\u0001"+
		"\u0000\u0000\u0000\u000fq\u0001\u0000\u0000\u0000\u0011x\u0001\u0000\u0000"+
		"\u0000\u0013|\u0001\u0000\u0000\u0000\u0015\u0084\u0001\u0000\u0000\u0000"+
		"\u0017\u008a\u0001\u0000\u0000\u0000\u0019\u0090\u0001\u0000\u0000\u0000"+
		"\u001b\u0097\u0001\u0000\u0000\u0000\u001d\u009f\u0001\u0000\u0000\u0000"+
		"\u001f\u00a5\u0001\u0000\u0000\u0000!\u00a7\u0001\u0000\u0000\u0000#\u00a9"+
		"\u0001\u0000\u0000\u0000%\u00ab\u0001\u0000\u0000\u0000\'\u00ad\u0001"+
		"\u0000\u0000\u0000)\u00af\u0001\u0000\u0000\u0000+\u00b1\u0001\u0000\u0000"+
		"\u0000-\u00b3\u0001\u0000\u0000\u0000/0\u0005i\u0000\u000006\u0005f\u0000"+
		"\u000012\u0005I\u0000\u000026\u0005F\u0000\u000034\u0005I\u0000\u0000"+
		"46\u0005f\u0000\u00005/\u0001\u0000\u0000\u000051\u0001\u0000\u0000\u0000"+
		"53\u0001\u0000\u0000\u00006\u0002\u0001\u0000\u0000\u000078\u0005e\u0000"+
		"\u000089\u0005l\u0000\u00009:\u0005s\u0000\u0000:D\u0005e\u0000\u0000"+
		";<\u0005E\u0000\u0000<=\u0005L\u0000\u0000=>\u0005S\u0000\u0000>D\u0005"+
		"E\u0000\u0000?@\u0005E\u0000\u0000@A\u0005l\u0000\u0000AB\u0005s\u0000"+
		"\u0000BD\u0005e\u0000\u0000C7\u0001\u0000\u0000\u0000C;\u0001\u0000\u0000"+
		"\u0000C?\u0001\u0000\u0000\u0000D\u0004\u0001\u0000\u0000\u0000EF\u0005"+
		"[\u0000\u0000F\u0006\u0001\u0000\u0000\u0000GH\u0005]\u0000\u0000H\b\u0001"+
		"\u0000\u0000\u0000IJ\u0005T\u0000\u0000JK\u0005R\u0000\u0000KL\u0005U"+
		"\u0000\u0000LV\u0005E\u0000\u0000MN\u0005T\u0000\u0000NO\u0005r\u0000"+
		"\u0000OP\u0005u\u0000\u0000PV\u0005e\u0000\u0000QR\u0005t\u0000\u0000"+
		"RS\u0005r\u0000\u0000ST\u0005u\u0000\u0000TV\u0005e\u0000\u0000UI\u0001"+
		"\u0000\u0000\u0000UM\u0001\u0000\u0000\u0000UQ\u0001\u0000\u0000\u0000"+
		"V\n\u0001\u0000\u0000\u0000WX\u0005F\u0000\u0000XY\u0005A\u0000\u0000"+
		"YZ\u0005L\u0000\u0000Z[\u0005S\u0000\u0000[g\u0005E\u0000\u0000\\]\u0005"+
		"F\u0000\u0000]^\u0005a\u0000\u0000^_\u0005l\u0000\u0000_`\u0005s\u0000"+
		"\u0000`g\u0005e\u0000\u0000ab\u0005f\u0000\u0000bc\u0005a\u0000\u0000"+
		"cd\u0005l\u0000\u0000de\u0005s\u0000\u0000eg\u0005e\u0000\u0000fW\u0001"+
		"\u0000\u0000\u0000f\\\u0001\u0000\u0000\u0000fa\u0001\u0000\u0000\u0000"+
		"g\f\u0001\u0000\u0000\u0000hj\u0007\u0000\u0000\u0000ih\u0001\u0000\u0000"+
		"\u0000jk\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000"+
		"\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0005p\u0000\u0000no\u0005x\u0000"+
		"\u0000o\u000e\u0001\u0000\u0000\u0000pr\u0007\u0000\u0000\u0000qp\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000"+
		"st\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0005%\u0000\u0000"+
		"v\u0010\u0001\u0000\u0000\u0000wy\u0007\u0000\u0000\u0000xw\u0001\u0000"+
		"\u0000\u0000yz\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001"+
		"\u0000\u0000\u0000{\u0012\u0001\u0000\u0000\u0000|}\u0005#\u0000\u0000"+
		"}~\u0007\u0001\u0000\u0000~\u007f\u0007\u0001\u0000\u0000\u007f\u0080"+
		"\u0007\u0001\u0000\u0000\u0080\u0081\u0007\u0001\u0000\u0000\u0081\u0082"+
		"\u0007\u0001\u0000\u0000\u0082\u0083\u0007\u0001\u0000\u0000\u0083\u0014"+
		"\u0001\u0000\u0000\u0000\u0084\u0086\u0005#\u0000\u0000\u0085\u0087\u0007"+
		"\u0002\u0000\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001"+
		"\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001"+
		"\u0000\u0000\u0000\u0089\u0016\u0001\u0000\u0000\u0000\u008a\u008c\u0005"+
		".\u0000\u0000\u008b\u008d\u0007\u0002\u0000\u0000\u008c\u008b\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0018\u0001\u0000"+
		"\u0000\u0000\u0090\u0094\u0007\u0003\u0000\u0000\u0091\u0093\u0007\u0002"+
		"\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0096\u0001\u0000"+
		"\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000"+
		"\u0000\u0000\u0095\u001a\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000"+
		"\u0000\u0000\u0097\u009b\u0007\u0004\u0000\u0000\u0098\u009a\u0007\u0005"+
		"\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u009a\u009d\u0001\u0000"+
		"\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000"+
		"\u0000\u0000\u009c\u001c\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000"+
		"\u0000\u0000\u009e\u00a0\u0007\u0006\u0000\u0000\u009f\u009e\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0006\u000e\u0000\u0000\u00a4\u001e\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a6\u0005{\u0000\u0000\u00a6 \u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0005}\u0000\u0000\u00a8\"\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\u0005;\u0000\u0000\u00aa$\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005"+
		":\u0000\u0000\u00ac&\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005+\u0000"+
		"\u0000\u00ae(\u0001\u0000\u0000\u0000\u00af\u00b0\u0005-\u0000\u0000\u00b0"+
		"*\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005*\u0000\u0000\u00b2,\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0005:\u0000\u0000\u00b4\u00b5\u0005=\u0000"+
		"\u0000\u00b5.\u0001\u0000\u0000\u0000\r\u00005CUfksz\u0088\u008e\u0094"+
		"\u009b\u00a1\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}