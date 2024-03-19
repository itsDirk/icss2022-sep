// Generated from C:/Users/vanro/OneDrive/Documenten/Leerjaar 3 HBO/ASD APP/Compiler opdracht/icss2022-sep/startcode/src/main/antlr4/nl/han/ica/icss/parser/ICSS.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ICSSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, ELSE=2, BOX_BRACKET_OPEN=3, BOX_BRACKET_CLOSE=4, TRUE=5, FALSE=6, 
		PIXELSIZE=7, PERCENTAGE=8, SCALAR=9, COLOR=10, ID_IDENT=11, CLASS_IDENT=12, 
		LOWER_IDENT=13, CAPITAL_IDENT=14, WS=15, OPEN_BRACE=16, CLOSE_BRACE=17, 
		SEMICOLON=18, COLON=19, PLUS=20, MIN=21, MUL=22, ASSIGNMENT_OPERATOR=23;
	public static final int
		RULE_stylesheet = 0, RULE_variableAssignment = 1, RULE_variableName = 2, 
		RULE_propertyName = 3, RULE_expression = 4, RULE_literal = 5, RULE_boolLiteral = 6, 
		RULE_colorLiteral = 7, RULE_pixelLiteral = 8, RULE_percentageLiteral = 9, 
		RULE_scalarLiteral = 10, RULE_selector = 11, RULE_ruleAssignement = 12, 
		RULE_ruleBody = 13, RULE_declaration = 14, RULE_ifClause = 15, RULE_elseClause = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"stylesheet", "variableAssignment", "variableName", "propertyName", "expression", 
			"literal", "boolLiteral", "colorLiteral", "pixelLiteral", "percentageLiteral", 
			"scalarLiteral", "selector", "ruleAssignement", "ruleBody", "declaration", 
			"ifClause", "elseClause"
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

	@Override
	public String getGrammarFileName() { return "ICSS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ICSSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StylesheetContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ICSSParser.EOF, 0); }
		public List<VariableAssignmentContext> variableAssignment() {
			return getRuleContexts(VariableAssignmentContext.class);
		}
		public VariableAssignmentContext variableAssignment(int i) {
			return getRuleContext(VariableAssignmentContext.class,i);
		}
		public List<RuleAssignementContext> ruleAssignement() {
			return getRuleContexts(RuleAssignementContext.class);
		}
		public RuleAssignementContext ruleAssignement(int i) {
			return getRuleContext(RuleAssignementContext.class,i);
		}
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStylesheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStylesheet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitStylesheet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CAPITAL_IDENT) {
				{
				{
				setState(34);
				variableAssignment();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14336L) != 0)) {
				{
				{
				setState(40);
				ruleAssignement();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableAssignmentContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TerminalNode ASSIGNMENT_OPERATOR() { return getToken(ICSSParser.ASSIGNMENT_OPERATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ICSSParser.SEMICOLON, 0); }
		public VariableAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterVariableAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitVariableAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitVariableAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssignmentContext variableAssignment() throws RecognitionException {
		VariableAssignmentContext _localctx = new VariableAssignmentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variableAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			variableName();
			setState(49);
			match(ASSIGNMENT_OPERATOR);
			setState(50);
			expression(0);
			setState(51);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableNameContext extends ParserRuleContext {
		public TerminalNode CAPITAL_IDENT() { return getToken(ICSSParser.CAPITAL_IDENT, 0); }
		public VariableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterVariableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitVariableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitVariableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableNameContext variableName() throws RecognitionException {
		VariableNameContext _localctx = new VariableNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(CAPITAL_IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyNameContext extends ParserRuleContext {
		public TerminalNode LOWER_IDENT() { return getToken(ICSSParser.LOWER_IDENT, 0); }
		public PropertyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterPropertyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitPropertyName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitPropertyName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyNameContext propertyName() throws RecognitionException {
		PropertyNameContext _localctx = new PropertyNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_propertyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(LOWER_IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ICSSParser.MUL, 0); }
		public TerminalNode PLUS() { return getToken(ICSSParser.PLUS, 0); }
		public TerminalNode MIN() { return getToken(ICSSParser.MIN, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(58);
			literal();
			}
			_ctx.stop = _input.LT(-1);
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(66);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(60);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(61);
						match(MUL);
						setState(62);
						expression(3);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(63);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(64);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MIN) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(65);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public BoolLiteralContext boolLiteral() {
			return getRuleContext(BoolLiteralContext.class,0);
		}
		public ColorLiteralContext colorLiteral() {
			return getRuleContext(ColorLiteralContext.class,0);
		}
		public PercentageLiteralContext percentageLiteral() {
			return getRuleContext(PercentageLiteralContext.class,0);
		}
		public PixelLiteralContext pixelLiteral() {
			return getRuleContext(PixelLiteralContext.class,0);
		}
		public ScalarLiteralContext scalarLiteral() {
			return getRuleContext(ScalarLiteralContext.class,0);
		}
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_literal);
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				boolLiteral();
				}
				break;
			case COLOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				colorLiteral();
				}
				break;
			case PERCENTAGE:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				percentageLiteral();
				}
				break;
			case PIXELSIZE:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				pixelLiteral();
				}
				break;
			case SCALAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				scalarLiteral();
				}
				break;
			case CAPITAL_IDENT:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				variableName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolLiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(ICSSParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ICSSParser.FALSE, 0); }
		public BoolLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitBoolLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolLiteralContext boolLiteral() throws RecognitionException {
		BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_boolLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColorLiteralContext extends ParserRuleContext {
		public TerminalNode COLOR() { return getToken(ICSSParser.COLOR, 0); }
		public ColorLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colorLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterColorLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitColorLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitColorLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorLiteralContext colorLiteral() throws RecognitionException {
		ColorLiteralContext _localctx = new ColorLiteralContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_colorLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(COLOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PixelLiteralContext extends ParserRuleContext {
		public TerminalNode PIXELSIZE() { return getToken(ICSSParser.PIXELSIZE, 0); }
		public PixelLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pixelLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterPixelLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitPixelLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitPixelLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PixelLiteralContext pixelLiteral() throws RecognitionException {
		PixelLiteralContext _localctx = new PixelLiteralContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pixelLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(PIXELSIZE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PercentageLiteralContext extends ParserRuleContext {
		public TerminalNode PERCENTAGE() { return getToken(ICSSParser.PERCENTAGE, 0); }
		public PercentageLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_percentageLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterPercentageLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitPercentageLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitPercentageLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PercentageLiteralContext percentageLiteral() throws RecognitionException {
		PercentageLiteralContext _localctx = new PercentageLiteralContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_percentageLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(PERCENTAGE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScalarLiteralContext extends ParserRuleContext {
		public TerminalNode SCALAR() { return getToken(ICSSParser.SCALAR, 0); }
		public ScalarLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalarLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterScalarLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitScalarLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitScalarLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScalarLiteralContext scalarLiteral() throws RecognitionException {
		ScalarLiteralContext _localctx = new ScalarLiteralContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_scalarLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(SCALAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectorContext extends ParserRuleContext {
		public TerminalNode LOWER_IDENT() { return getToken(ICSSParser.LOWER_IDENT, 0); }
		public TerminalNode CLASS_IDENT() { return getToken(ICSSParser.CLASS_IDENT, 0); }
		public TerminalNode ID_IDENT() { return getToken(ICSSParser.ID_IDENT, 0); }
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_selector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14336L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleAssignementContext extends ParserRuleContext {
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public TerminalNode OPEN_BRACE() { return getToken(ICSSParser.OPEN_BRACE, 0); }
		public RuleBodyContext ruleBody() {
			return getRuleContext(RuleBodyContext.class,0);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(ICSSParser.CLOSE_BRACE, 0); }
		public RuleAssignementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleAssignement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterRuleAssignement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitRuleAssignement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitRuleAssignement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleAssignementContext ruleAssignement() throws RecognitionException {
		RuleAssignementContext _localctx = new RuleAssignementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ruleAssignement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			selector();
			setState(92);
			match(OPEN_BRACE);
			setState(93);
			ruleBody();
			setState(94);
			match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleBodyContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<IfClauseContext> ifClause() {
			return getRuleContexts(IfClauseContext.class);
		}
		public IfClauseContext ifClause(int i) {
			return getRuleContext(IfClauseContext.class,i);
		}
		public List<VariableAssignmentContext> variableAssignment() {
			return getRuleContexts(VariableAssignmentContext.class);
		}
		public VariableAssignmentContext variableAssignment(int i) {
			return getRuleContext(VariableAssignmentContext.class,i);
		}
		public RuleBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterRuleBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitRuleBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitRuleBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleBodyContext ruleBody() throws RecognitionException {
		RuleBodyContext _localctx = new RuleBodyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ruleBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 24578L) != 0)) {
				{
				setState(99);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LOWER_IDENT:
					{
					setState(96);
					declaration();
					}
					break;
				case IF:
					{
					setState(97);
					ifClause();
					}
					break;
				case CAPITAL_IDENT:
					{
					setState(98);
					variableAssignment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ICSSParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ICSSParser.SEMICOLON, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			propertyName();
			setState(105);
			match(COLON);
			setState(106);
			expression(0);
			setState(107);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfClauseContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ICSSParser.IF, 0); }
		public TerminalNode BOX_BRACKET_OPEN() { return getToken(ICSSParser.BOX_BRACKET_OPEN, 0); }
		public TerminalNode BOX_BRACKET_CLOSE() { return getToken(ICSSParser.BOX_BRACKET_CLOSE, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(ICSSParser.OPEN_BRACE, 0); }
		public RuleBodyContext ruleBody() {
			return getRuleContext(RuleBodyContext.class,0);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(ICSSParser.CLOSE_BRACE, 0); }
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public BoolLiteralContext boolLiteral() {
			return getRuleContext(BoolLiteralContext.class,0);
		}
		public ElseClauseContext elseClause() {
			return getRuleContext(ElseClauseContext.class,0);
		}
		public IfClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterIfClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitIfClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitIfClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfClauseContext ifClause() throws RecognitionException {
		IfClauseContext _localctx = new IfClauseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(IF);
			setState(110);
			match(BOX_BRACKET_OPEN);
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CAPITAL_IDENT:
				{
				setState(111);
				variableName();
				}
				break;
			case TRUE:
			case FALSE:
				{
				setState(112);
				boolLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(115);
			match(BOX_BRACKET_CLOSE);
			setState(116);
			match(OPEN_BRACE);
			setState(117);
			ruleBody();
			setState(118);
			match(CLOSE_BRACE);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(119);
				elseClause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseClauseContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(ICSSParser.ELSE, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(ICSSParser.OPEN_BRACE, 0); }
		public RuleBodyContext ruleBody() {
			return getRuleContext(RuleBodyContext.class,0);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(ICSSParser.CLOSE_BRACE, 0); }
		public ElseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterElseClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitElseClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ICSSVisitor ) return ((ICSSVisitor<? extends T>)visitor).visitElseClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseClauseContext elseClause() throws RecognitionException {
		ElseClauseContext _localctx = new ElseClauseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_elseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(ELSE);
			setState(123);
			match(OPEN_BRACE);
			setState(124);
			ruleBody();
			setState(125);
			match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0017\u0080\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0005\u0000$\b\u0000\n\u0000"+
		"\f\u0000\'\t\u0000\u0001\u0000\u0005\u0000*\b\u0000\n\u0000\f\u0000-\t"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004C\b\u0004\n\u0004\f\u0004F\t"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005N\b\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r"+
		"\u0005\rd\b\r\n\r\f\rg\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"r\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000fy\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0000\u0001\b\u0011\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0003"+
		"\u0001\u0000\u0014\u0015\u0001\u0000\u0005\u0006\u0001\u0000\u000b\r|"+
		"\u0000%\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000\u0000\u00045"+
		"\u0001\u0000\u0000\u0000\u00067\u0001\u0000\u0000\u0000\b9\u0001\u0000"+
		"\u0000\u0000\nM\u0001\u0000\u0000\u0000\fO\u0001\u0000\u0000\u0000\u000e"+
		"Q\u0001\u0000\u0000\u0000\u0010S\u0001\u0000\u0000\u0000\u0012U\u0001"+
		"\u0000\u0000\u0000\u0014W\u0001\u0000\u0000\u0000\u0016Y\u0001\u0000\u0000"+
		"\u0000\u0018[\u0001\u0000\u0000\u0000\u001ae\u0001\u0000\u0000\u0000\u001c"+
		"h\u0001\u0000\u0000\u0000\u001em\u0001\u0000\u0000\u0000 z\u0001\u0000"+
		"\u0000\u0000\"$\u0003\u0002\u0001\u0000#\"\u0001\u0000\u0000\u0000$\'"+
		"\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000"+
		"\u0000&+\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000(*\u0003\u0018"+
		"\f\u0000)(\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001\u0000"+
		"\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001\u0000\u0000\u0000-+\u0001"+
		"\u0000\u0000\u0000./\u0005\u0000\u0000\u0001/\u0001\u0001\u0000\u0000"+
		"\u000001\u0003\u0004\u0002\u000012\u0005\u0017\u0000\u000023\u0003\b\u0004"+
		"\u000034\u0005\u0012\u0000\u00004\u0003\u0001\u0000\u0000\u000056\u0005"+
		"\u000e\u0000\u00006\u0005\u0001\u0000\u0000\u000078\u0005\r\u0000\u0000"+
		"8\u0007\u0001\u0000\u0000\u00009:\u0006\u0004\uffff\uffff\u0000:;\u0003"+
		"\n\u0005\u0000;D\u0001\u0000\u0000\u0000<=\n\u0002\u0000\u0000=>\u0005"+
		"\u0016\u0000\u0000>C\u0003\b\u0004\u0003?@\n\u0001\u0000\u0000@A\u0007"+
		"\u0000\u0000\u0000AC\u0003\b\u0004\u0002B<\u0001\u0000\u0000\u0000B?\u0001"+
		"\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000"+
		"DE\u0001\u0000\u0000\u0000E\t\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000"+
		"\u0000GN\u0003\f\u0006\u0000HN\u0003\u000e\u0007\u0000IN\u0003\u0012\t"+
		"\u0000JN\u0003\u0010\b\u0000KN\u0003\u0014\n\u0000LN\u0003\u0004\u0002"+
		"\u0000MG\u0001\u0000\u0000\u0000MH\u0001\u0000\u0000\u0000MI\u0001\u0000"+
		"\u0000\u0000MJ\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000ML\u0001"+
		"\u0000\u0000\u0000N\u000b\u0001\u0000\u0000\u0000OP\u0007\u0001\u0000"+
		"\u0000P\r\u0001\u0000\u0000\u0000QR\u0005\n\u0000\u0000R\u000f\u0001\u0000"+
		"\u0000\u0000ST\u0005\u0007\u0000\u0000T\u0011\u0001\u0000\u0000\u0000"+
		"UV\u0005\b\u0000\u0000V\u0013\u0001\u0000\u0000\u0000WX\u0005\t\u0000"+
		"\u0000X\u0015\u0001\u0000\u0000\u0000YZ\u0007\u0002\u0000\u0000Z\u0017"+
		"\u0001\u0000\u0000\u0000[\\\u0003\u0016\u000b\u0000\\]\u0005\u0010\u0000"+
		"\u0000]^\u0003\u001a\r\u0000^_\u0005\u0011\u0000\u0000_\u0019\u0001\u0000"+
		"\u0000\u0000`d\u0003\u001c\u000e\u0000ad\u0003\u001e\u000f\u0000bd\u0003"+
		"\u0002\u0001\u0000c`\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000"+
		"cb\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000"+
		"\u0000ef\u0001\u0000\u0000\u0000f\u001b\u0001\u0000\u0000\u0000ge\u0001"+
		"\u0000\u0000\u0000hi\u0003\u0006\u0003\u0000ij\u0005\u0013\u0000\u0000"+
		"jk\u0003\b\u0004\u0000kl\u0005\u0012\u0000\u0000l\u001d\u0001\u0000\u0000"+
		"\u0000mn\u0005\u0001\u0000\u0000nq\u0005\u0003\u0000\u0000or\u0003\u0004"+
		"\u0002\u0000pr\u0003\f\u0006\u0000qo\u0001\u0000\u0000\u0000qp\u0001\u0000"+
		"\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0005\u0004\u0000\u0000tu\u0005"+
		"\u0010\u0000\u0000uv\u0003\u001a\r\u0000vx\u0005\u0011\u0000\u0000wy\u0003"+
		" \u0010\u0000xw\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y\u001f"+
		"\u0001\u0000\u0000\u0000z{\u0005\u0002\u0000\u0000{|\u0005\u0010\u0000"+
		"\u0000|}\u0003\u001a\r\u0000}~\u0005\u0011\u0000\u0000~!\u0001\u0000\u0000"+
		"\u0000\t%+BDMceqx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}