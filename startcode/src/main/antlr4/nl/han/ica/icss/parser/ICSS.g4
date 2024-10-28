grammar ICSS;

//--- LEXER: ---

// IF support:
IF: 'if' | 'IF' | 'If';
ELSE: 'else' | 'ELSE' | 'Else';
BOX_BRACKET_OPEN: '[';
BOX_BRACKET_CLOSE: ']';

//Literals
TRUE: 'TRUE' | 'True' | 'true';
FALSE: 'FALSE' | 'False' | 'false';
PIXELSIZE: [0-9]+ 'px';
PERCENTAGE: [0-9]+ '%';
SCALAR: [0-9]+;

//Color value takes precedence over id idents
COLOR: '#' [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f];

//Specific identifiers for id's and css classes
ID_IDENT: '#' [a-z0-9\-]+;
CLASS_IDENT: '.' [a-z0-9\-]+;

//General identifiers
LOWER_IDENT: [a-z] [a-z0-9\-]*;
CAPITAL_IDENT: [A-Z] [A-Za-z0-9_]*;

//All whitespaces are skipped
WS: [ \t\r\n]+ -> skip;

//
OPEN_BRACE: '{';
CLOSE_BRACE: '}';
SEMICOLON: ';';
COLON: ':';
PLUS: '+';
MIN: '-';
MUL: '*';
ASSIGNMENT_OPERATOR: ':=';




//--- PARSER: ---
stylesheet: variableAssignment* styleRule* EOF;

variableAssignment: variableReference ASSIGNMENT_OPERATOR expression SEMICOLON;

variableReference: CAPITAL_IDENT;
propertyName: LOWER_IDENT;

// Operations
expression: expression (MUL) expression | expression (PLUS | MIN) expression | (variableReference | literal);

// Literals
literal: boolLiteral | colorLiteral | percentageLiteral | pixelLiteral | scalarLiteral;
boolLiteral: TRUE | FALSE;
colorLiteral: COLOR;
pixelLiteral: PIXELSIZE;
percentageLiteral: PERCENTAGE;
scalarLiteral: SCALAR;

// Selectors
selector: tagSelector | classSelector | idSelector;
tagSelector: LOWER_IDENT;
classSelector: CLASS_IDENT;
idSelector: ID_IDENT;

styleRule: selector OPEN_BRACE ruleBody CLOSE_BRACE;

ruleBody: (declaration | ifClause | variableAssignment)*;
declaration: propertyName COLON expression SEMICOLON;
ifClause: IF BOX_BRACKET_OPEN (variableReference | boolLiteral) BOX_BRACKET_CLOSE OPEN_BRACE ruleBody CLOSE_BRACE elseClause?;
elseClause: ELSE OPEN_BRACE ruleBody CLOSE_BRACE;