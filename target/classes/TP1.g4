/* Alumno: JOHANA TESTA
 * Trabajo Practico 1 - TC
* El programa a desarrollar tiene como objetivo tomar un archivo de código
* fuente en una versión reducida del lenguaje C y generar como salida el Árbol Sintáctico (ANTLR).
 */

grammar TP1;

//TOKENS//
WS : [\t\r\n ] -> skip; //limpia espacios en blanco y saltos de linea 
COMMENT : '//' .+? ('\n'|EOF) -> skip ;

//Parentesis, corchetes y llaves
PA : '(' ; //Parentesis de apertura
PC : ')' ; //Parentesis de cierre
CA : '[' ; //Corchete de apertura
CC : ']' ; //Corchete de cierre
LA : '{' ; //Llave de apertura
LC : '}' ; //Lave de cierre

//OPERACIONES MATEMATICAS 
MAS : '+';
MENOS : '-';
ASTERISCO : '*';
DIVISION : '/';
MODULO : '%';
MASMAS : '++';
MENOSMENOS : '--';

//ASIGNACIONES
MASIGUAL : '+=';
MENOSIGUAL : '-=';
PORIGUAL : '*=';
BARRAIGUAL : '/=';
MODULOIGUAL : '%=';
IGUAL : '=';

//OPERACIONES LOGICAS
AND : '&&';
OR : '||';
NOT : '!';
TRUE : 'true';
FALSE : 'false';

//COMPARADORES
MAYOR : '>';
MENOR: '<';
IGUALIGUAL : '==';
DISTINTOIGUAL : '!='; 
MAYORIGUAL : '>=';
MENORIGUAL : '<=';

//Tipos de datos
INT : 'int';
CHAR : 'char';
DOUBLE : 'double';
VOID : 'void';

//Condiciones
IF : 'if';
FOR : 'for';
WHILE : 'while';

//VARIOS
COMILLAS : '"';
PUNTO : '.';
COMA : ',';
PUNTOYCOMA : ';';
RETURN : 'return';
THEN : 'then';
ELSE : 'else';

//IDENTIFICADORES Y NUMEROS 
ID : [_A-Za-z] [_A-Za-z0-9]*;
NUMINT :   [0-9]+ ;   
CARACTER : '\u0000'..'\uFFFE' ;
VALORCHAR: '\'' CARACTER '\''  ;
NUMDOUBLE: [-+]? NUMINT '.' NUMINT; 


