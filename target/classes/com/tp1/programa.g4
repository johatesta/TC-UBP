grammar programa;

@header {
package com.tp1;
}

fragment LETRA : [A-Za-z] ;
fragment DIGITO : [0-9] ;

LLAVEA : '{' ;
LLAVEC : '}' ;

PARENA : '(' ;
PARENC : ')' ;



INT : 'int' ;
DOUBLE : 'double' ;
VOID : 'void' ;
FLOAT : 'float' ;

WHILE : 'while' ;
IIF : 'if' ;
IFOR : 'for' ;

MAS : '+' ;
MENOS : '-' ;
MULT: '*' ;
DIV : '/' ;


MENOR : '<' ; 
MAYOR : '>' ;
MENORIGUAL : '<=' ;
MAYORIGUAL : '>=' ;
IGUALES: '==' ;
DISTINTO : '!=' ;


ASIG : '=' ;
PYQ : ';' ;
COMA : ',' ;

OR : '||' ;
AND : '&&' ;

RETURN : 'return' ;

ENTERO : DIGITO+ ;

ID : (LETRA | '_')(LETRA | DIGITO | '_')* ;


WS : [ \n\t\r]+ -> skip;


programa :  instrucciones;


instrucciones :  instruccion instrucciones
              |  bloque instrucciones
              |
              ;


bloque : LLAVEA instrucciones LLAVEC ;

puntocoma: PYQ;

instruccion : declaracion puntocoma
            | asignacion puntocoma
            | iwhile
            | iif
            | ifor
            | funcion puntocoma
            | declaracion_funcion puntocoma
            | definicion_funcion
            | finalizar_con_return puntocoma
            ;

verificador : ID | ENTERO ;


/*  INICIO DECLARACION  */
declaracion :  tipo_de_datos asignacion_simple;

tipo_de_datos : INT 
              | DOUBLE 
              | FLOAT
              ;

asignacion_simple : ID ASIG verificador
                  | ID ASIG COMA asignacion_simple
                  | ID
                  | ID COMA asignacion_simple
                  ;

/* FIN DECLARACION */

/* INICIO ASIGNACION */
asignacion : ID ASIG opal ;

opal : exp ;

exp : term e ;

e : MAS   term e
  | MENOS term e
  |
  ;

term : factor t ;

t : MULT factor t
  | DIV  factor t
  |
  ;

factor : ID
       | ENTERO
       | PARENA exp PARENC
       ;

/* FIN ASIGNACION */


/* INICIO ESTRUCTURAS DE CONTROL */

logico_comp : OR 
            | AND
            ;

comparacion : MAYOR
            | MENOR 
            | MAYORIGUAL 
            | MENORIGUAL 
            | IGUALES 
            | DISTINTO 
            ;

comp : verificador logico_comp comp
     | verificador
     ;

bloque_estructuras_de_control : verificador comparacion verificador bloque_estructuras_de_control
                              | PARENA comp comparacion verificador  bloque_estructuras_de_control
                              | PARENA comp bloque_estructuras_de_control
                              | PARENC comparacion verificador bloque_estructuras_de_control
                              | PARENC logico_comp bloque_estructuras_de_control
                              | PARENC
                              | logico_comp bloque_estructuras_de_control
                              |
                              ; 

pos_pre_incremento : verificador MAS MAS 
                   | verificador MENOS MENOS
                   | MAS MAS verificador
                   | MENOS MENOS verificador
                   ;


bloque_for : PARENA ( (declaracion | asignacion) puntocoma bloque_estructuras_de_control  puntocoma pos_pre_incremento ) PARENC ;


iwhile : WHILE PARENA bloque_estructuras_de_control PARENC bloque ;
  

iif : IIF PARENA bloque_estructuras_de_control  PARENC bloque  ;


ifor : IFOR bloque_for bloque ;

/* FIN ESTRUCTURAS DE CONTROL */


/* INICIO ACEPTAR FUNCIONES Y LLAMADAS DE FUNCIONES */


una_o_mas_variables : declaracion una_o_mas_variables
                    | declaracion
                    |
                    ; 

tipo_de_funcion : VOID ;

funcion : tipo_de_datos ID PARENA una_o_mas_variables PARENC
        | ID PARENA PARENC
        ;


declaracion_funcion : tipo_de_datos ID PARENA param_declaracion PARENC;
                    
definicion_funcion: tipo_de_datos ID PARENA param_definicion PARENC bloque;

param_declaracion : tipo_de_datos(ID | )
		              | tipo_de_datos (ID | ) COMA param_declaracion
                  |
		              ;

param_definicion : tipo_de_datos ID
		             | tipo_de_datos ID COMA param_definicion
                 |
	            	 ; 

/* FIN ACEPTAR FUNCIONES Y LLAMADAS DE FUNCIONES */

finalizar_con_return : RETURN ( term | )  ;
 
